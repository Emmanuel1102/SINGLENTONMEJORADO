/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ManejaDatosEst;
import datos.ModeloTabla;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author emman
 */


public class Interfaz extends JFrame  implements ActionListener, Runnable{

     //ModeloTabla modTabla;
     private  ModeloTabla modTabla = new ModeloTabla();
     private  ManejaDatosEst baseDatos;
     //ModeloTabla mt=modTabla;
    //ManipulaDatos MD;

 
    public Interfaz( ModeloTabla modTabla ) throws ClassNotFoundException {
       
       setTitle("REGISTRO ACADEMICO");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JPanel panelContenido = new JPanel(new FlowLayout(FlowLayout.CENTER));
       panelContenido.setBackground(Color.WHITE);
      
       //añadiendo el panel al frame
    
       add(panelContenido );
        JLabel title= new JLabel("                                        "
                + "               AGREGA , VISUALIZA Y MODIFICA DATOS DE ESTUDIANTES:              "
                + "                                             ");
        title.setBounds(50,50,0,0);
        JLabel numC= new JLabel("Num de Control:");
        JLabel credits= new JLabel("200");
        JLabel name= new JLabel("Nombre:");
        JTextField nametxt = new JTextField(15);
        JLabel sexo= new JLabel("Sexo:");
        JRadioButton rbtn1=new JRadioButton("Mujer",true);
        JRadioButton rbtn2=new JRadioButton("Hombre",false);
        
        JLabel edad= new JLabel("Edad:");
        JSpinner edadS = new JSpinner();
        SpinnerNumberModel edadM = new   SpinnerNumberModel();
         edadM.setValue(18);
                 edadM.setMinimum(18);
                 edadM.setMaximum(30);
                 edadS.setModel(edadM);
                 
		
                 
        JLabel semestre= new JLabel("Semestre:");
         JSpinner SemestreS = new JSpinner();
        SpinnerNumberModel SemestreM = new   SpinnerNumberModel();
		 SemestreM.setValue(1);
                 SemestreM.setMinimum(1);
                 SemestreM.setMaximum(13);
                 SemestreS.setModel(SemestreM);
                 
        JLabel creditos= new JLabel("Creditos:");
        JSpinner creditosS = new JSpinner();
        SpinnerNumberModel creditoM = new   SpinnerNumberModel();
                 creditoM.setValue(1);
                 creditoM.setMinimum(1);
                 creditoM.setMaximum(200);
		 creditosS.setModel(creditoM);
                 
         JLabel carrera= new JLabel("Carrera:");
         JComboBox CarreraC= new JComboBox();
         CarreraC.addItem("CARRERAS");
         CarreraC.addItem("SISTEMAS");
         CarreraC.addItem("CIVIL");
         CarreraC.addItem("GESTION");
         CarreraC.addItem("ADMINISTRACION");
         CarreraC.addItem("ELECTRONICA");
         CarreraC.addItem("ELECTRICIDAD");
         
        JButton registrar = new JButton("Registrar");
        JButton terminar = new JButton("Terminar");
        
        String consulta = "SELECT *FROM ADMINISTRADOR.ESTUDIANTE";
        ModeloTabla mt=modTabla;
        ManejaDatosEst baseDatos = new ManejaDatosEst();
        mt.setDatos(baseDatos.consultaDatos(consulta),baseDatos);
        
        JTable tabla1= new JTable();

        tabla1.setModel(mt);
      
 
        
        panelContenido.add(title);
    
     
        panelContenido.add(numC);
        panelContenido.add(credits);
        panelContenido.add(name);
        panelContenido.add(nametxt);
        panelContenido.add(sexo);
        panelContenido.add(rbtn1);
        panelContenido.add(rbtn2);
        panelContenido.add(edad);
        panelContenido.add(edadS);
        panelContenido.add(semestre);
        panelContenido.add(SemestreS);
   
        panelContenido.add(creditos);
        panelContenido.add(creditosS);
        panelContenido.add(carrera);
        panelContenido.add(CarreraC);
        panelContenido.add(registrar);
        panelContenido.add(terminar);
        panelContenido.add(tabla1.getTableHeader());
        panelContenido.add(tabla1);   
        
        
    terminar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	 if(baseDatos.cerrarSesion()){
                   System.exit(0);
         }else{
               dispose();
         }
           }});

        }

    
     
  
     @Override
    public void run() {
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("REGISTRO ACADEMICO");
        this.setVisible(true);
        this.setSize(725, 500);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
