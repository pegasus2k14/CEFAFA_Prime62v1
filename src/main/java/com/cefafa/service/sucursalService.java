package com.cefafa.service;

import com.cefafa.dao.SucursalDao;
import com.cefafa.model.Tblsucursal;
import java.util.List;

public class sucursalService {
    SucursalDao sucursalDao = new SucursalDao();
    
     public List<Tblsucursal> getAll(){
         return sucursalDao.getAll();
     }
     
     public Tblsucursal findById(Integer idSucursal){
         return sucursalDao.findById(idSucursal);
     }
}


