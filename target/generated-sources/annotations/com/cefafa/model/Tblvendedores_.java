package com.cefafa.model;

import com.cefafa.model.Tblfactura;
import com.cefafa.model.Tblsucursal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-01-04T09:18:37")
@StaticMetamodel(Tblvendedores.class)
public class Tblvendedores_ { 

    public static volatile ListAttribute<Tblvendedores, Tblfactura> tblfacturaList;
    public static volatile SingularAttribute<Tblvendedores, String> nomVendedor;
    public static volatile SingularAttribute<Tblvendedores, Integer> codVendedor;
    public static volatile SingularAttribute<Tblvendedores, Tblsucursal> codSucursal;

}