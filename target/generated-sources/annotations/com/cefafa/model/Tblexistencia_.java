package com.cefafa.model;

import com.cefafa.model.TblexistenciaPK;
import com.cefafa.model.Tblproductos;
import com.cefafa.model.Tblsucursal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-01-04T09:18:37")
@StaticMetamodel(Tblexistencia.class)
public class Tblexistencia_ { 

    public static volatile SingularAttribute<Tblexistencia, Tblproductos> tblproductos;
    public static volatile SingularAttribute<Tblexistencia, Integer> existencia;
    public static volatile SingularAttribute<Tblexistencia, TblexistenciaPK> tblexistenciaPK;
    public static volatile SingularAttribute<Tblexistencia, Tblsucursal> tblsucursal;

}