package com.cefafa.service;

import com.cefafa.dao.DetalleFacturaDao;
import com.cefafa.model.Tbldetfactura;


public class DetalleFacturaService {
    DetalleFacturaDao detallefacturaDao = new DetalleFacturaDao();
    
     public void insert(Tbldetfactura detFactura){
         detallefacturaDao.insert(detFactura);
     }
    
}
