package com.cefafa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GenericDao {
    protected static EntityManager em;
    private static EntityManagerFactory emf = null;
    
    public GenericDao(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("cefafaPU");
        }
    }
    
    public EntityManager getEntityManager(){
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
}
