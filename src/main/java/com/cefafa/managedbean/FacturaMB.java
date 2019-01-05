package com.cefafa.managedbean;

import com.cefafa.conexion.ConexionDB;
import com.cefafa.jasper.AbstractJasper;
import com.cefafa.model.Tblclientes;
import com.cefafa.model.Tbldetfactura;
import com.cefafa.model.TbldetfacturaPK;
import com.cefafa.model.Tblexistencia;
import com.cefafa.model.TblexistenciaPK;
import com.cefafa.model.Tblfactura;
import com.cefafa.model.Tblproductos;
import com.cefafa.model.Tblsucursal;
import com.cefafa.model.Tblvendedores;
import com.cefafa.service.ClientesService;
import com.cefafa.service.EmpleadoService;
import com.cefafa.service.ExistenciaService;
import com.cefafa.service.FacturaService;
import com.cefafa.service.ProductoService;
import com.cefafa.service.sucursalService;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;

@ManagedBean(name = "facturaMB")
@SessionScoped
public class FacturaMB implements Serializable{
    java.util.Date date = new Date();
    
    //inyeccion de dependencias
    
    @Inject
    private ClientesService clienteSrvice;
    @Inject
    private EmpleadoService empleadoService;
    @Inject
    private sucursalService sucrslService;
    @Inject
    private ProductoService productoService;
    @Inject
    private FacturaService facturaService;
    @Inject
    private ExistenciaService existenciaService;
    
    
  private static ConexionDB conexionDB = null;
  private Integer tipoDoc;
          
  private List<Tblclientes> listClientes;
  private Integer idCliente; 
  
  private List<Tblvendedores> listVendedores;
  private Integer idVendedor;
  
  private List<Tblsucursal> listSucursal;
  private Integer idSucursal;
  
  private List<Tblproductos> listProductos;
  private Integer idProducto;
  
  private Tblproductos productoTemp;
  private List<Tbldetfactura> listDetalleFactura;
  
  private List<Tblfactura> listFacturas;
  
  private Tblfactura facturaTemp;
  
  
  private Integer cantidadProd;
  private Integer uDisponibles;

   
  //metodo inicializador
  @PostConstruct
  public void init(){
      listClientes = clienteSrvice.getAll();
      //listVendedores = empleadoService.getAll();
      listSucursal =sucrslService.getAll();
      listProductos = productoService.getAll();
      listDetalleFactura = new ArrayList<>();
  
      //listFacturas = facturaService.getAll();
  }
  
  //Metodo para Cargar todos los Empleados de acuerdo a su Sucursal
   public void cargarVendedores(){
       listVendedores = empleadoService.getAllBySucursal(idSucursal);
   }

    //Agregar Producto a Lista temporal
    public void addProductoToList() {
        if (validarExistencia()) {
            System.out.println("producto" + idProducto);
            if (addCantidad()) {
                productoTemp = productoService.findById(idProducto);
                TbldetfacturaPK detallefacturapk = new TbldetfacturaPK();
                detallefacturapk.setCodProducto(productoTemp.getCodProducto());

                Tbldetfactura detalleFactura = new Tbldetfactura();
                detalleFactura.setTblproductos(productoTemp);
                detalleFactura.setCantidad(cantidadProd);
                detalleFactura.setPrecioVenta(productoTemp.getPrecioVenta());
                detalleFactura.setTbldetfacturaPK(detallefacturapk);

                listDetalleFactura.add(detalleFactura);
            }

            cantidadProd = null;
            idProducto = null;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "No se puede Agregar producto", "Existencias insuficientes!"));
        }

    }
    
    //Metodo para adicionar cantidad de unidades a un detalle de Producto
    public boolean addCantidad(){
        boolean nuevo = true;
        for(int i=0; i < listDetalleFactura.size();i++){
            if(listDetalleFactura.get(i).getTblproductos().getCodProducto().equals(idProducto)){
                listDetalleFactura.get(i).setCantidad(listDetalleFactura.get(i).getCantidad() + cantidadProd);
                nuevo = false;
            }
        }
        return nuevo;
    }
    
    
    //Metodo que devuelve todas las facturas registradas
    public void obtenerFacturas(){
        try{
            listFacturas = facturaService.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
   public boolean validarExistencia(){
       TblexistenciaPK idExistencia = new TblexistenciaPK();
       idExistencia.setCodProducto(idProducto);
       idExistencia.setCodSucursal(idSucursal);
       
       int existencia = existenciaService.getExistenciaProd(idExistencia);
       if(cantidadProd < existencia){
           return true;
       }else{
           return false;
       }
   }
   
   
   public void registrarFactura(){
       try {
           Tblfactura tblFactura = new Tblfactura();
           tblFactura.setTipo(tipoDoc);
           tblFactura.setFecha(date);
           
           float subtotal = calculateSubTotal();
           
           double iva = subtotal * 0.13;
           
           tblFactura.setSubTotal(new BigDecimal(subtotal));
           tblFactura.setIva(new BigDecimal(iva));
           
           double total = subtotal + iva;
           
           tblFactura.setTotal(new BigDecimal(total));
           
           tblFactura.setCodVendedor(empleadoService.findById(idVendedor));
           tblFactura.setCodCliente(clienteSrvice.findById(idCliente));
           tblFactura.setCodSucursal(sucrslService.findById(idSucursal));
           //tblFactura.setTbldetfacturaList(listDetalleFactura);
          
           facturaService.insert(tblFactura);
           
           for( Tbldetfactura det :listDetalleFactura){
               det.getTbldetfacturaPK().setNofactura(tblFactura.getNoFactura());
           }
           tblFactura.setTbldetfacturaList(listDetalleFactura);
           facturaService.update(tblFactura);
            
           //Actualizando Stock
           actualizarExistencias();
           limpiarVariables();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Factura guardada", "Factura guardada con exito!"));
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
    
   
   public float calculateSubTotal(){
       float subtotal =0;
       for(Tbldetfactura det : listDetalleFactura){
           subtotal = subtotal + (det.getCantidad() * det.getPrecioVenta().floatValue());
       }
       return subtotal;
   }
   
   //Metodo para desplegar factura en pantalla
   public void DesplegarFactura(Integer idFactura) throws IOException{
       facturaTemp = facturaService.findById(idFactura);
       
       if(facturaTemp.getTipo() == 1){
           
           FacesContext.getCurrentInstance().getExternalContext().redirect("consumidorFinal.xhtml");
       }else if(facturaTemp.getTipo() == 2){
           FacesContext.getCurrentInstance().getExternalContext().redirect("creditoFiscal.xhtml");
       }
       
   }
   
   //Metodo que devuelve las unidades disponibles de un producto para una determinada sucursal
   public void getExistencia(){
       try{
           TblexistenciaPK idExistenciaPK = new TblexistenciaPK();
           idExistenciaPK.setCodProducto(idProducto);
           idExistenciaPK.setCodSucursal(idSucursal);
           uDisponibles = existenciaService.getExistenciaProd(idExistenciaPK);
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   //Metodo para actualizar las existencias de productos luego de una venta
    public void actualizarExistencias() {
        try {
            for (Tbldetfactura det : listDetalleFactura) {
                TblexistenciaPK tblExistenciaPK = new TblexistenciaPK();
                tblExistenciaPK.setCodProducto(det.getTblproductos().getCodProducto());
                tblExistenciaPK.setCodSucursal(idSucursal);

                //Obteniendo instancia de existencia
                Tblexistencia existencia = existenciaService.findByIdExistencias(tblExistenciaPK);
                Integer nuevaExistencia = existencia.getExistencia() - det.getCantidad();
                existencia.setExistencia(nuevaExistencia);
                existenciaService.update(existencia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para desplegar la factura como PDF en Web
    public void createReport(Integer idFactura){
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            Map<String, Object> parameters = new HashMap<>();
            String ruta = "";
            conexionDB = new ConexionDB();
            
            Tblfactura factura = facturaService.findById(idFactura);
            Integer tipoDocumento = factura.getTipo();
            //obtenemos la ruta del archivo .jasper a usar dependiendo del tipo de documento
            if (tipoDocumento == 1) { //Factura normal
                ruta = servletContext.getRealPath("/WEB-INF/reportes/consumidorFinal.jasper");
                parameters.put("prtIdFact", new Integer(idFactura));

            } else if (tipoDocumento == 2) {  //Credito fiscal
                ruta = servletContext.getRealPath("/WEB-INF/reportes/creditoFiscal.jasper");
                parameters.put("prtIdFactura", new Integer(idFactura));
            }

            Connection conn = conexionDB.getConexion();
            AbstractJasper.createReport(conn, ruta, parameters);
            AbstractJasper.exportToPdfWeb();
            FacesContext.getCurrentInstance().responseComplete(); 
            //conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public void cancelar() throws IOException{
        limpiarVariables();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    
    public void volverInicio() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

   
   //Metodo para limpiar variable
   public void limpiarVariables(){
           idSucursal = null;
           idCliente = null;
           idVendedor = null;
           tipoDoc = null;
           idProducto = null;
           cantidadProd = null;
           uDisponibles = null;
           listDetalleFactura = new ArrayList<>();
           
   }
   
  //Getters y Setter
  public List<Tblclientes> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Tblclientes> listClientes) {
        this.listClientes = listClientes;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<Tblvendedores> getListVendedores() {
        return listVendedores;
    }

    public void setListVendedores(List<Tblvendedores> listVendedores) {
        this.listVendedores = listVendedores;
    }

    public List<Tblsucursal> getListSucursal() {
        return listSucursal;
    }

    public void setListSucursal(List<Tblsucursal> listSucursal) {
        this.listSucursal = listSucursal;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public List<Tblproductos> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Tblproductos> listProductos) {
        this.listProductos = listProductos;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(Integer tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Integer getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(Integer cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public List<Tbldetfactura> getListDetalleFactura() {
        return listDetalleFactura;
    }

    public void setListDetalleFactura(List<Tbldetfactura> listDetalleFactura) {
        this.listDetalleFactura = listDetalleFactura;
    }

    public Tblfactura getFacturaTemp() {
        return facturaTemp;
    }

    public void setFacturaTemp(Tblfactura facturaTemp) {
        this.facturaTemp = facturaTemp;
    }

    public Integer getuDisponibles() {
        return uDisponibles;
    }

    public void setuDisponibles(Integer uDisponibles) {
        this.uDisponibles = uDisponibles;
    }
    
    
     public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public List<Tblfactura> getListFacturas() {
        return listFacturas;
    }

    public void setListFacturas(List<Tblfactura> listFacturas) {
        this.listFacturas = listFacturas;
    }
    
}
