package com.cefafa.service;

import com.cefafa.dao.ProductoDao;
import com.cefafa.model.Tblproductos;
import java.util.List;


public class ProductoService {
    ProductoDao productoDao = new ProductoDao();
     
    public List<Tblproductos> getAll(){
      return productoDao.getAll();
     }
    
    public Tblproductos findById(Integer idSucursal){
        return productoDao.findById(idSucursal);
    }
}
