package com.cefafa.model;

import com.cefafa.model.Tblclientes;
import com.cefafa.model.Tbldetfactura;
import com.cefafa.model.Tblsucursal;
import com.cefafa.model.Tblvendedores;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-01-04T09:18:37")
@StaticMetamodel(Tblfactura.class)
public class Tblfactura_ { 

    public static volatile SingularAttribute<Tblfactura, Date> fecha;
    public static volatile SingularAttribute<Tblfactura, Integer> tipo;
    public static volatile SingularAttribute<Tblfactura, BigDecimal> total;
    public static volatile ListAttribute<Tblfactura, Tbldetfactura> tbldetfacturaList;
    public static volatile SingularAttribute<Tblfactura, BigDecimal> iva;
    public static volatile SingularAttribute<Tblfactura, Integer> noFactura;
    public static volatile SingularAttribute<Tblfactura, BigDecimal> subTotal;
    public static volatile SingularAttribute<Tblfactura, Tblvendedores> codVendedor;
    public static volatile SingularAttribute<Tblfactura, Tblsucursal> codSucursal;
    public static volatile SingularAttribute<Tblfactura, Tblclientes> codCliente;

}