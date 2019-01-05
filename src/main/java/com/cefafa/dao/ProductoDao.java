package com.cefafa.dao;

import com.cefafa.model.Tblproductos;
import java.util.List;
import javax.persistence.Query;


public class ProductoDao extends GenericDao{
     //Metodo para obtener todos los clientes
    public List<Tblproductos> getAll(){
        String hql = "Select tp from Tblproductos tp";
        try{
          em = getEntityManager();
        Query q = em.createQuery(hql);
        List<Tblproductos> listProductos = q.getResultList();
        return listProductos;    
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    //metodo que obtiene una instancia de Tblclientes en base a si Id
    public Tblproductos findById(Integer idSucursal){
        em = getEntityManager();
        return em.find(Tblproductos.class, idSucursal);
    }
}
