package com.cefafa.dao;

import com.cefafa.model.Tblsucursal;
import com.cefafa.model.Tblvendedores;
import java.util.List;
import javax.persistence.Query;


public class SucursalDao extends GenericDao{
     //Metodo para obtener todas las sucursales
    public List<Tblsucursal> getAll(){
        String hql = "Select ts from Tblsucursal ts";
        try{
          em = getEntityManager();
        Query q = em.createQuery(hql);
        List<Tblsucursal> listSucursal = q.getResultList();
        return listSucursal;    
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    //metodo que obtiene una instancia de Tblsucursales en base a si Id
    public Tblsucursal findById(Integer idSucursal){
        em = getEntityManager();
        return em.find(Tblsucursal.class, idSucursal);
    }
}
