package com.cefafa.service;

import com.cefafa.dao.existenciasDao;
import com.cefafa.model.Tblexistencia;
import com.cefafa.model.TblexistenciaPK;


public class ExistenciaService {
    existenciasDao existenciaDao = new existenciasDao();
    
    public Tblexistencia findByIdExistencias(TblexistenciaPK idExistencia){
        return existenciaDao.findByIdExistencias(idExistencia);
    }
    
     public Integer getExistenciaProd(TblexistenciaPK idExistencia){
         return existenciaDao.getExistenciaProd(idExistencia);
     }
     
      public void update(Tblexistencia existencia){
          existenciaDao.update(existencia);
      }
     
}
