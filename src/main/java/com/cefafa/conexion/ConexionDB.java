package com.cefafa.conexion;

import com.cefafa.dao.GenericDao;
import java.sql.Connection;
import java.sql.DriverManager;
import org.hibernate.internal.SessionImpl;

public class ConexionDB extends GenericDao{
    private Connection conexion = null;
    
//    public Connection getConexion(){
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcefafa", "root", "admin");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return conexion;
//    }
//    
//    public void closeConnection(){
//        try{
//            if(conexion != null){
//                conexion.close();
//                conexion = null;
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    
    public Connection getConexion(){
       em = getEntityManager();
       //em.getTransaction().begin();
       conexion = em.unwrap(SessionImpl.class).connection();
       //em.getTransaction().commit();
       return conexion;
    }
}
