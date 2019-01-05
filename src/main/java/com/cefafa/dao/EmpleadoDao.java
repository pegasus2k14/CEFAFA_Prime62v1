package com.cefafa.dao;

import com.cefafa.model.Tblvendedores;
import java.util.List;
import javax.persistence.Query;


public class EmpleadoDao extends GenericDao{
    //Metodo para obtener todos los vendedores
    public List<Tblvendedores> getAll(){
        String hql = "Select tv from Tblvendedores tv";
        try{
          em = getEntityManager();
        Query q = em.createQuery(hql);
        List<Tblvendedores> listVendedor = q.getResultList();
        return listVendedor;    
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    //metodo que obtiene una instancia de TblVendedores en base a si Id
    public Tblvendedores findById(Integer idVendedor){
        em = getEntityManager();
        return em.find(Tblvendedores.class, idVendedor);
    }
    
    //metodo que trae los empleados de acuerdo a su sucursal
    public List<Tblvendedores> getAllBySucursal(Integer idSucursal){
         String hql = "Select tv from Tblvendedores tv where tv.codSucursal.codSucursal =:sucursal";
         try{
              em = getEntityManager();
              Query q = em.createQuery(hql);
              q.setParameter("sucursal",idSucursal);
              List<Tblvendedores> listVendedor = q.getResultList();
              return listVendedor;   
         }catch(Exception e){
             e.printStackTrace();
         }
         return null;
    }
}
