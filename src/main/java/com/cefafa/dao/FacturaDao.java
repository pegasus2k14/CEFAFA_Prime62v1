package com.cefafa.dao;

import com.cefafa.model.Tblfactura;
import java.util.List;
import javax.persistence.Query;



public class FacturaDao extends GenericDao{
    
    //metodo para insertar instancias de Tblfactura
    public void insert(Tblfactura factura){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(factura);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al insertar factura");
        }
    }
    
    //metodo para modificar instancias de Tblfactura
    public void update(Tblfactura factura){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(factura);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al modificar factura");
        }
    }
    
    public Tblfactura findById(Integer idFactura){
        em = getEntityManager();
        return em.find(Tblfactura.class, idFactura);
    }
    
    public List<Tblfactura> getAll(){
        String hql ="select tf from Tblfactura tf order by tf.noFactura desc";
        try{
            em = getEntityManager();
            Query q = em.createQuery(hql);
            List<Tblfactura> listFacturas = q.getResultList();
            return listFacturas;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
