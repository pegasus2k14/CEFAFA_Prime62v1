package com.cefafa.service;

import com.cefafa.dao.EmpleadoDao;
import com.cefafa.model.Tblvendedores;
import java.util.List;


public class EmpleadoService {
    EmpleadoDao empleadoDao = new EmpleadoDao();
    public List<Tblvendedores> getAll(){
        return empleadoDao.getAll();
    }
    
    public Tblvendedores findById(Integer idVendedor){
        return empleadoDao.findById(idVendedor);
    }
    
     public List<Tblvendedores> getAllBySucursal(Integer idSucursal){
         return empleadoDao.getAllBySucursal(idSucursal);
     }
}
