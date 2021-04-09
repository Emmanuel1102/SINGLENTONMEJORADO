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
     private  ModeloTabla mt ;
     private  ManejaDatosEst baseDatos;
     //ModeloTabla mt=modTabla;
    //ManipulaDatos MD;
     private JLabel title,numC, numCL,name,sexo,edad,semestre,creditos,carrera, CarreraC;
     private JButton registrar,terminar;
     private JRadioButton rbtn1,rbtn2;
     private JTextField nametxt;
     private JSpinner edadS,SemestreS,creditosS;
     private  SpinnerNumberModel edadM,SemestreM,creditoM ;
     private JTable tabla1;
     private ButtonGroup BG;
 
    public Interfaz( ModeloTabla modTabla ) throws ClassNotFoundException {
       
       setTitle("REGISTRO ACADEMICO");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JPanel panelContenido = new JPanel(new FlowLayout(FlowLayout.CENTER));
       panelContenido.setBackground(Color.WHITE);
      
       //añadiendo el panel al frame
    
       add(panelContenido );
        title= new JLabel("                                        "
                + "               AGREGA , VISUALIZA Y MODIFICA DATOS DE ESTUDIANTES:              "
                + "                                             ");
        title.setBounds(50,50,0,0);
        numC= new JLabel("Num de Control:");
        numCL= new JLabel("S.N");
        name= new JLabel("Nombre:");
        nametxt = new JTextField(15);
        sexo= new JLabel("Sexo:");
        
         rbtn1=new JRadioButton("Mujer",true);
         rbtn2=new JRadioButton("Hombre",false);
         BG = new ButtonGroup();
         BG.add(rbtn1);
         BG.add(rbtn2);
        
        edad= new JLabel("Edad:");
        edadS = new JSpinner();
        edadM = new   SpinnerNumberModel();
        edadM.setValue(18);
                 edadM.setMinimum(18);
                 edadM.setMaximum(30);
                 edadS.setModel(edadM);
                 
		
                 
         semestre= new JLabel("Semestre:");
         SemestreS = new JSpinner();
         SemestreM = new   SpinnerNumberModel();
		 SemestreM.setValue(1);
                 SemestreM.setMinimum(1);
                 SemestreM.setMaximum(13);
                 SemestreS.setModel(SemestreM);
                 
         creditos= new JLabel("Creditos:");
         creditosS = new JSpinner();
         creditoM = new   SpinnerNumberModel();
                 creditoM.setValue(1);
                 creditoM.setMinimum(1);
                 creditoM.setMaximum(200);
		 creditosS.setModel(creditoM);
                 
         carrera= new JLabel("Carrera ID:");
         CarreraC= new JLabel("3");
         
         
         registrar = new JButton("Registrar");
         terminar = new JButton("Terminar");
        
        String consulta = "SELECT *FROM ADMINISTRADOR.ESTUDIANTE";
        mt=modTabla;
        baseDatos = new ManejaDatosEst();
        mt.setDatos(baseDatos.consultaDatos(consulta),baseDatos);
        
        tabla1= new JTable();

        tabla1.setModel(mt);
      
 
        
        panelContenido.add(title);
    
     
        panelContenido.add(numC);
        panelContenido.add( numCL);
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
        

             
   
        
    registrar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	
            char sexo = ' ';
        
            
        if (rbtn1.isSelected() == true) {
            sexo = 'M';
        } else if (rbtn2.isSelected() == true) {
            sexo = 'H';
        }   
                
        String datos = "INSERT INTO ADMINISTRADOR.ESTUDIANTE "
        + "(nombre, edad, sexo,semestre,creditos,idCarrera) values"
        + "('" + nametxt.getText() + "'," + (int)edadS.getValue() + ",'" + sexo + "'," + (int)SemestreS.getValue() + "," + (int)creditosS.getValue()+ "," + 3 + ")";
        baseDatos.actualizaDatos(datos);
        mt.setDatos(baseDatos.consultaDatos("SELECT * FROM ADMINISTRADOR.ESTUDIANTE"), baseDatos);
        mt.fireTableDataChanged();
         
            
            
           }});
    
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