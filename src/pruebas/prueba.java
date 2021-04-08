/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import datos.ModeloTabla;
import vista.Interfaz;

/**
 *
 * @author emman
 */
public class prueba {
      public static void main(String[] args) throws ClassNotFoundException {
       
                   // 
                 // new TestFrame().setVisible(true);
                 ModeloTabla tab = new ModeloTabla();
                  
                  Interfaz tf=new Interfaz(tab);
                 
                  Interfaz tf1 = new Interfaz(tab);
                  
                  Interfaz tf2 = new Interfaz(tab);  
                 
                  Interfaz tf3 = new Interfaz(tab);
                  
                  Thread h1 = new Thread(tf);
                  Thread h2 = new Thread( tf1);
                  Thread h3 = new Thread(tf2);
                  Thread h4 = new Thread(tf3);
                    h1.start();
                    h2.start();
                    h3.start();
                    h4.start();
                   
              
    }

}
