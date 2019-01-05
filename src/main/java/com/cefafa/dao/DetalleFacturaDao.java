package com.cefafa.dao;

import com.cefafa.model.Tbldetfactura;


public class DetalleFacturaDao extends GenericDao{
    //metodo para insertar instancias de Tblfactura
    public void insert(Tbldetfactura detFactura){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detFactura);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al insertar Detalle factura");
        }
    } 
}
