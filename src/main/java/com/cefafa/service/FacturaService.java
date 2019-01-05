package com.cefafa.service;

import com.cefafa.dao.FacturaDao;
import com.cefafa.model.Tblfactura;
import java.util.List;

public class FacturaService {
    FacturaDao facturaDao = new FacturaDao();
    
     public void insert(Tblfactura factura){
         facturaDao.insert(factura);
     }
     
     public void update(Tblfactura factura){
         facturaDao.update(factura);
     }
     
     public List<Tblfactura> getAll(){
         return facturaDao.getAll();
     }
     
     public Tblfactura findById(Integer idFactura){
         return facturaDao.findById(idFactura);
     }
}
