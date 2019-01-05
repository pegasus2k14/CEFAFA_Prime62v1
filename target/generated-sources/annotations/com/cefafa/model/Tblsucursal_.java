package com.cefafa.model;

import com.cefafa.model.Tblexistencia;
import com.cefafa.model.Tblfactura;
import com.cefafa.model.Tblvendedores;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-01-04T09:18:37")
@StaticMetamodel(Tblsucursal.class)
public class Tblsucursal_ { 

    public static volatile ListAttribute<Tblsucursal, Tblfactura> tblfacturaList;
    public static volatile ListAttribute<Tblsucursal, Tblvendedores> tblvendedoresList;
    public static volatile ListAttribute<Tblsucursal, Tblexistencia> tblexistenciaList;
    public static volatile SingularAttribute<Tblsucursal, String> nomSucursal;
    public static volatile SingularAttribute<Tblsucursal, Integer> codSucursal;

}