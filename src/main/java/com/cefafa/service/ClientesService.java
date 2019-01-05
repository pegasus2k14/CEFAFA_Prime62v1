package com.cefafa.service;

import com.cefafa.dao.ClientesDao;
import com.cefafa.model.Tblclientes;
import java.util.List;


public class ClientesService {
    ClientesDao clientesDao = new ClientesDao();
    
    public List<Tblclientes> getAll(){
        return clientesDao.getAll();
    }
    
    
    public Tblclientes findById(Integer idCliente){
        return clientesDao.findById(idCliente);
    }
}
