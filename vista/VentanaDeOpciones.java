package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaDeOpciones extends JFrame implements ActionListener,ChangeListener
{
	private JLabel jugador2,ficha2;
	private JTextField nombre1,nombre2;
	private JComboBox opcion1,opcion2;
	private JRadioButton computadora,persona;
	public  JButton btnAceptar;
	private JPanel panel;
	private ButtonGroup grupo;
	private String nombreJugador1;
	private String nombreJugador2;
	private int tipoJuego;   // 0 si no se selecciono ningun vs. 1 si se selecciono vs computador. Y 2 si se selecciono jugador 2
	
	public  VentanaDeOpciones() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setSize(400,400);
	  setLocation(200,100);
	  getContentPane().setLayout(null);
	  CargarPantalla();
	}
	/*
	 *  CargarPantalla: este metodo carga la pantalla inicial del juego 
	 */
	private void CargarPantalla()
	{
		panel = new JPanel();
		panel.setBounds(0,0,400,400);
		panel.setBackground(getBackground().WHITE);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		JLabel jugador1 = new JLabel("nombre Jugador 1 :");
		jugador1.setBounds(33,25,130,25);	
		panel.add(jugador1);
		
	    JLabel ficha1 = new JLabel("Escoga su ficha :");
	    ficha1.setBounds(33, 66, 130,25);
	    panel.add(ficha1);
		
		opcion1 = new JComboBox();
	    opcion1.setModel(new DefaultComboBoxModel(new String[] {"X", "O"}));
	    opcion1.setBounds(173,61,100,30);
	    panel.add(opcion1);
			    
		JLabel vs = new JLabel("Jugar vs");
		vs.setBounds(155,115,110,25);	
		panel.add(vs);
		
		nombre1 = new JTextField();
		nombre1.setText("jugador1");
		nombre1.setBounds(173,25,120,25);
		nombre1.setBackground(getBackground().cyan);
		panel.add(nombre1);		

		computadora = new JRadioButton("computadora");
		computadora.setBounds(49,156,130,25);
		panel.add(computadora);
		
		persona = new JRadioButton("Jugador 2");
		persona.setBounds(198,156,130,25);
		panel.add(persona);

		grupo = new ButtonGroup();
		grupo.add(persona);
		grupo.add(computadora);			
		
		ficha2 = new JLabel("Escoga su ficha :");
		ficha2.setBounds(49, 257, 110,25);
		ficha2.setVisible(false);
		panel.add(ficha2);
		
		opcion2 = new JComboBox();
	    opcion2.setModel(new DefaultComboBoxModel(new String[] {"X", "O"}));
	    opcion2.setBounds(173,254,100,30);
	    opcion2.setVisible(false);
	    panel.add(opcion2);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(228, 307,100,25);
		panel.add(btnAceptar);		
		
		jugador2 = new JLabel("Jugador 2");
		jugador2.setBounds(49,218,120,25);
		jugador2.setVisible(false);
		panel.add(jugador2);
		
		nombre2 = new JTextField();
		nombre2.setText("jugador2");
		nombre2.setBounds(173,218,120,25);
		nombre2.setVisible(false);
		panel.add(nombre2);
		
		btnAceptar.addActionListener(this);		
		persona.addChangeListener(this);
		computadora.addChangeListener(this); 
		opcion1.addActionListener(this);
	}
	/*
	 * el metodo stateChanged revisa que radio button presionaste
	 * si presionaste persona aparece un textfiel y un label diciendo jugador 2
	 * y si presionas computadora la opcion de jugador 2 desaparece 
	 */
	public void stateChanged(ChangeEvent e)
	{
		if(computadora.isSelected())
		{
			tipoJuego =1;
			nombreJugador1= nombre1.getText();
			OcultarOpcionJugador2();
		}
		if(persona.isSelected())
		{
			tipoJuego =2;
			nombreJugador1= nombre1.getText();
			nombreJugador2= nombre2.getText();
			OpcionJugador2();
		}		
	}
	/*
	 * OpcionJugador2 vuelve visible la opcion de jugador 2
	 * para que pueda escoger su ficha y clocar su nombre
	 */
	private void OpcionJugador2()
	{
		jugador2.setVisible(true);
		nombre2.setVisible(true);
		ficha2.setVisible(true);
		opcion2.setVisible(true);
	}
	/*
	 * OcultarOpcionJugador2 oculta la opcion de jugador dos este metodo es llamado
	 * cuando presionas el radico buton computadora
	 */
	private void OcultarOpcionJugador2()
	{
		jugador2.setVisible(false);
		nombre2.setVisible(false);
		ficha2.setVisible(false);
		opcion2.setVisible(false);
	}
	
	/*
	 * actionPerformed este metodo es para revisar que ficha selecciono el jugador1
	 * para que el jugador2 no pueda usar la misma ficha
	 * y tambien para darl funcion aceptar que es la que hae que empieze el juego
	 * 
	 */
    public void actionPerformed(ActionEvent e)
    {
    	if("X" == String.valueOf(opcion1.getSelectedItem()))
    	{
    		opcion2.setModel(new DefaultComboBoxModel(new String[] {"O"}));
    	}
    	else if("O" == String.valueOf(opcion1.getSelectedItem()))
    	{
    		opcion2.setModel(new DefaultComboBoxModel(new String[] {"X"}));
    	} 
    	
    	
    }
    
  
    public String getNombreJugador1(){
      
    	return nombreJugador1;
    }
    public String getNombreJugador2(){
    	return nombreJugador2;
    }
    
    public String getFichaJugador1(){
        
    	   Object e = opcion1.getSelectedItem();
	       String years = String.valueOf(e); 
	      // char cad= years.charAt(0); 
	     
	       return years;
	       
	      
    
    }
    public String getFichaJugador2(){
    	   Object e = opcion2.getSelectedItem();
	       String years = String.valueOf(e); 
	      // char cad= years.charAt(0); 
	       
	       return years;
    }
    
    
    /*
     * Verifica si se lleno los datos correctamente 
     * Retorna falso si falta algun campo por llenar en la ventana y muestra mesage.
     * Retorna true si esta correctamente llenado los datos 
     * */
	public boolean venverificarllenado() {
		if(tipoJuego ==0){
			JOptionPane.showMessageDialog(null,"debe Seleccionar un modo de juego (vs)" );
			return false;
		}else
		 {  
			if(tipoJuego == 2 && getFichaJugador1().equals(getFichaJugador2())){
	    		JOptionPane.showMessageDialog(null,"Se Deben escoger Diferentes Fichas" );
	    		return false;
	    	
	        }
			if (tipoJuego ==1 && nombreJugador1.equals(""))
			{

     	    	
			   JOptionPane.showMessageDialog(null,"debe llenar el campo 'nombre jugador1'" );
			   return false;
			
	     	}else
	     	{
	     		if(tipoJuego ==2 && (nombreJugador1.equals("")||nombreJugador2.equals(""))){
	     		JOptionPane.showMessageDialog(null,"debe llenar el campo 'nombre jugador 1' y 'nombre de jugadpr 2' " );
				return false;
	     	    }
	     	 }
			
			
		}
     
		
		 
	  return true;
	
	}
	/*
	 * Retorna 1: si el tipo de juego es Vs Computador
	 * Retorna 2: si el tipo de juego es Vs Jugador 2
	 *  */
	public int getTipoDePartida() {
		
		return tipoJuego;
	}
	public String getNombreJugador(int turno) {
		if (turno==1)
		return getNombreJugador1();
		else
			return getNombreJugador2();
	}
	public String getFichaJugador(int turno) {
		if (turno==1){
			
			return getFichaJugador1();
		}
		else{
			
			return getFichaJugador2();
		}
    }
    
    
	
}
