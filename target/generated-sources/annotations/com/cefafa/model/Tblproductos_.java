package com.cefafa.model;

import com.cefafa.model.Tbldetfactura;
import com.cefafa.model.Tblexistencia;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-01-04T09:18:37")
@StaticMetamodel(Tblproductos.class)
public class Tblproductos_ { 

    public static volatile SingularAttribute<Tblproductos, Integer> codProducto;
    public static volatile ListAttribute<Tblproductos, Tbldetfactura> tbldetfacturaList;
    public static volatile ListAttribute<Tblproductos, Tblexistencia> tblexistenciaList;
    public static volatile SingularAttribute<Tblproductos, String> nomProducto;
    public static volatile SingularAttribute<Tblproductos, BigDecimal> precioVenta;
    public static volatile SingularAttribute<Tblproductos, BigDecimal> costoUnitario;

}