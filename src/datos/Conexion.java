/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static Connection coneccion;
    private static String url,usuario,password;
    private static int numConexiones=0;
    //El siguiente atributo es crear una instancia del mismo objeto.
     private static Conexion conexion;
     
    private Conexion(String url,String usuario,String password) throws ClassNotFoundException{
        //this.url=url;
        //this.usuario=usuario;
        //this.password=password;     
    try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    try{
        coneccion=(Connection)DriverManager.getConnection(url,usuario,password);
    }catch(SQLException ex){
         Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
    } 
    }catch(ClassNotFoundException ex){
          Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
    }
}
     public static Conexion getConexion(String url,String usuario,String password) throws ClassNotFoundException{
      numConexiones++;
      
      if(conexion==null){
        conexion = new Conexion(url, usuario, password);
      }
     
      return conexion;
     }
     
     
     public static Connection getConeccion(){
     
      return coneccion;
     }
     
     public boolean cerrarConexion(){
   //Porque se debe cerrar la conexion         
         try{
           if(coneccion!=null)
             if(numConexiones==1)
                {
		   coneccion.close();
		   return true;
		}
                  else
		    numConexiones--;
		return false;
	}
	catch(SQLException e){
		System.err.println("Error a tratar de cerrar la conexion"+e);
	}
	return false;
	}
	}
     
    


