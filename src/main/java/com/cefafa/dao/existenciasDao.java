package com.cefafa.dao;

import com.cefafa.model.Tblexistencia;
import com.cefafa.model.TblexistenciaPK;

public class existenciasDao extends GenericDao{
   // metodo que devuelve toas las instancias de Existencia en base a su Id
    public Tblexistencia findByIdExistencias(TblexistenciaPK idExistencia){
        em = getEntityManager();
        return em.find(Tblexistencia.class, idExistencia);
        
    }
    
    //metodo que devuelve las existencias de un producto para una
    //determinada sucursal
    public Integer getExistenciaProd(TblexistenciaPK idExistencia){
        em =getEntityManager();
        Tblexistencia existencia = em.find(Tblexistencia.class, idExistencia);
        
        return existencia.getExistencia();
    }
    
    //Metodo que actualiza una existencia
      public void update(Tblexistencia existencia){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(existencia);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al modificar Existencia");
        }
    }
}
