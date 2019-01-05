package com.cefafa.model;

import com.cefafa.model.TbldetfacturaPK;
import com.cefafa.model.Tblfactura;
import com.cefafa.model.Tblproductos;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-01-04T09:18:37")
@StaticMetamodel(Tbldetfactura.class)
public class Tbldetfactura_ { 

    public static volatile SingularAttribute<Tbldetfactura, Tblproductos> tblproductos;
    public static volatile SingularAttribute<Tbldetfactura, TbldetfacturaPK> tbldetfacturaPK;
    public static volatile SingularAttribute<Tbldetfactura, Tblfactura> tblfactura;
    public static volatile SingularAttribute<Tbldetfactura, Integer> cantidad;
    public static volatile SingularAttribute<Tbldetfactura, BigDecimal> precioVenta;

}