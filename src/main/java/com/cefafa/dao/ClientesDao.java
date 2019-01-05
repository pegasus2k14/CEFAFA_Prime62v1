package com.cefafa.dao;

import com.cefafa.model.Tblclientes;
import java.util.List;
import javax.persistence.Query;


public class ClientesDao extends GenericDao{
    
    //Metodo para obtener todos los clientes
    public List<Tblclientes> getAll(){
        String hql = "Select tc from Tblclientes tc";
        try{
          em = getEntityManager();
        Query q = em.createQuery(hql);
        List<Tblclientes> listCliente = q.getResultList();
        return listCliente;    
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    //metodo que obtiene una instancia de Tblclientes en base a si Id
    public Tblclientes findById(Integer idCliente){
        em = getEntityManager();
        return em.find(Tblclientes.class, idCliente);
    }
}
