package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

public class VentanaDeOpciones extends JFrame implements ActionListener,ChangeListener,ItemListener
{
	private JLabel jugador2,ficha2,imagen,imagen2;
	private JTextField nombre1,nombre2;
	private JComboBox opcion1,opcion2;
	private JRadioButton computadora,persona;
	public  JButton btnAceptar;
	private JPanel panel;
	private ButtonGroup grupo;
	private String nombreJugador1;
	private String nombreJugador2;
	private int tipoJuego;// 0 si no se selecciono ningun vs. 1 si se selecciono vs computador. Y 2 si se selecciono jugador 2
	private String img[] = {"Ficha1","Ficha2","Ficha3","Ficha4"};
	private String img2[] = {"Ficha2","Ficha3","Ficha4"};
	/**Vector que contiene los iconos de las fichas
	 * y cambia de acuerdo al caso que se requiera 
	 * */
	private ImageIcon cursorImg;    
    private Cursor cursor;
    private Thread hiloFondo;
	//caso 0 todos completos
	private ImageIcon icono[] = 	
	{
			new ImageIcon(getClass().getResource("/imagenes/Bart.png")),
			new ImageIcon(getClass().getResource("/imagenes/Homero.png")),
			new ImageIcon(getClass().getResource("/imagenes/Maggie.png")),
			new ImageIcon(getClass().getResource("/imagenes/Marge.png"))
	};
	//Cuando eligen la Ficha1
	private ImageIcon icono1[] = 	
	{		
			new ImageIcon(getClass().getResource("/imagenes/Homero.png")),
			new ImageIcon(getClass().getResource("/imagenes/Maggie.png")),
			new ImageIcon(getClass().getResource("/imagenes/Marge.png"))
	};
	//Cuando eligen la Ficha2
	private ImageIcon icono2[] = 	
	{
			new ImageIcon(getClass().getResource("/imagenes/Bart.png")),
			new ImageIcon(getClass().getResource("/imagenes/Maggie.png")),
			new ImageIcon(getClass().getResource("/imagenes/Marge.png"))
	};
	//Cuando eligen la Ficha3
	private ImageIcon icono3[] = 	
	{
			new ImageIcon(getClass().getResource("/imagenes/Bart.png")),
			new ImageIcon(getClass().getResource("/imagenes/Homero.png")),			
			new ImageIcon(getClass().getResource("/imagenes/Marge.png"))
	};
	//Cuando eligen la Ficha4
	private ImageIcon icono4[] = 	
	{
			new ImageIcon(getClass().getResource("/imagenes/Bart.png")),
			new ImageIcon(getClass().getResource("/imagenes/Homero.png")),
			new ImageIcon(getClass().getResource("/imagenes/Maggie.png"))
	};
	
	public  VentanaDeOpciones() 
	{			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	  
		setSize(400,400);
		setLocation(200,100);
		getContentPane().setLayout(null);
		setTitle("OPCIONES DE PARTIDA");
		CargarPantalla();
	}
	/**
	 *  CargarPantalla: este metodo carga la pantalla inicial del juego 
	 */
	private void CargarPantalla()
	{
		panel = new JPanel();
		panel.setBounds(0,0,400,400);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		JLabel jugador1 = new JLabel("nombre Jugador 1 :");
		jugador1.setBounds(33,25,157,25);	
		panel.add(jugador1);
		
	    JLabel ficha1 = new JLabel("Escoga su ficha :");
	    ficha1.setBounds(33, 66, 130,25);
	    panel.add(ficha1);
	    
	    imagen = new JLabel(" ");
	    imagen.setBounds(290, 40, 100, 80);
	    panel.add(imagen);
		
	    opcion1 =new JComboBox(img);
	    imagen.setIcon(icono[0]);
	    opcion1.setBounds(173,61,100,30);
	    panel.add(opcion1);
			    
		JLabel vs = new JLabel("Jugar vs");
		vs.setBounds(155,115,110,25);	
		panel.add(vs);
		
		nombre1 = new JTextField();
		nombre1.setText("jugador1");
		nombre1.setBounds(208,25,120,25);
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
		
		imagen2 = new JLabel(" ");
	    imagen2.setBounds(300, 230, 100, 80);
	    imagen2.setVisible(false);
	    panel.add(imagen2);
		
	    opcion2 =new JComboBox();
	    //imagen2.setIcon(icono[0]);
	    opcion2.setBounds(173,254,100,30);
	    opcion2.setVisible(false);
	    panel.add(opcion2);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(228, 307,100,25);
		panel.add(btnAceptar);		
		
		jugador2 = new JLabel("nombre Jugador 2 :");
		jugador2.setBounds(33,218,146,25);
		jugador2.setVisible(false);
		panel.add(jugador2);
		
		nombre2 = new JTextField();
		nombre2.setBackground(Color.CYAN);
		nombre2.setText("jugador2");
		nombre2.setBounds(208,218,120,25);
		nombre2.setVisible(false);
		panel.add(nombre2);
		
		btnAceptar.addActionListener(this);		
		persona.addChangeListener(this);
		computadora.addChangeListener(this); 
		opcion1.addActionListener(this);
		opcion1.addItemListener(this);
		opcion2.addItemListener(this);
	
		cursorImg = new ImageIcon(getClass().getResource("/Cursores/cursor1.png"));
		Toolkit TK = Toolkit.getDefaultToolkit();		 
        cursor = TK.createCustomCursor(cursorImg.getImage(),new Point(2,2),"Cursor 01");
        setCursor(cursor);
	
	}
	/**
	 * Este metodo cambia el estado de la imagen del JLabel 
	 * cada vez que selecione una opcion del JComboBox(opcion1-opcion2) 
	 * */
	@Override
	public void itemStateChanged(ItemEvent a)
	{
		if(a.getSource().equals(opcion1))
		{
			if(opcion1.getSelectedIndex() == 1)
			{
				imagen.setIcon(icono[1]);
			}
			if(opcion1.getSelectedIndex() == 2)
			{
				imagen.setIcon(icono[2]);
			}
			if(opcion1.getSelectedIndex() == 3)
			{
				imagen.setIcon(icono[3]);
			}
			if(opcion1.getSelectedIndex() == 4)
			{
				imagen.setIcon(icono[4]);
			}
			if(opcion1.getSelectedIndex() == 0)
			{
				imagen.setIcon(icono[0]);
			}
		}
		if(a.getSource().equals(opcion2))
		{
			if(opcion1.getSelectedItem().toString()=="Ficha1")
			{				
				if(opcion2.getSelectedIndex() == 0)
				{
					imagen2.setIcon(icono1[0]);
				}
				if(opcion2.getSelectedIndex() == 1)
				{
					imagen2.setIcon(icono1[1]);
				}
				if(opcion2.getSelectedIndex() == 3)
				{
					imagen2.setIcon(icono1[3]);
				}
				if(opcion2.getSelectedIndex() == 2)
				{
					imagen2.setIcon(icono1[2]);
				}
			}
			if(opcion1.getSelectedItem().toString()=="Ficha2")
			{				
				if(opcion2.getSelectedIndex() == 0)
				{
					imagen2.setIcon(icono2[0]);
				}
				if(opcion2.getSelectedIndex() == 1)
				{
					imagen2.setIcon(icono2[1]);
				}
				if(opcion2.getSelectedIndex() == 3)
				{
					imagen2.setIcon(icono2[3]);
				}
				if(opcion2.getSelectedIndex() == 2)
				{
					imagen2.setIcon(icono2[2]);
				}
			}
			if(opcion1.getSelectedItem().toString()=="Ficha3")
			{				
				if(opcion2.getSelectedIndex() == 0)
				{
					imagen2.setIcon(icono3[0]);
				}
				if(opcion2.getSelectedIndex() == 1)
				{
					imagen2.setIcon(icono3[1]);
				}
				if(opcion2.getSelectedIndex() == 3)
				{
					imagen2.setIcon(icono3[3]);
				}
				if(opcion2.getSelectedIndex() == 2)
				{
					imagen2.setIcon(icono3[2]);
				}
			}
			if(opcion1.getSelectedItem().toString()=="Ficha4")
			{				
				if(opcion2.getSelectedIndex() == 0)
				{
					imagen2.setIcon(icono4[0]);
				}
				if(opcion2.getSelectedIndex() == 1)
				{
					imagen2.setIcon(icono4[1]);
				}
				if(opcion2.getSelectedIndex() == 3)
				{
					imagen2.setIcon(icono4[3]);
				}
				if(opcion2.getSelectedIndex() == 2)
				{
					imagen2.setIcon(icono4[2]);
				}
			}					
		}				
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
		imagen2.setVisible(true);
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
		imagen2.setVisible(false);
	}
	
	/*
	 * actionPerformed este metodo es para revisar que ficha selecciono el jugador1
	 * para que el jugador2 no pueda usar la misma ficha
	 * y tambien para darl funcion aceptar que es la que hae que empieze el juego
	 * 
	 */
    public void actionPerformed(ActionEvent e)
    {
    	if("Ficha1" == String.valueOf(opcion1.getSelectedItem()))
    	{
    		opcion2.setModel(new DefaultComboBoxModel(new String[] {"Ficha2","Ficha3","Ficha4"}));
    		imagen2.setIcon(icono1[0]);
    	}
    	if("Ficha2" == String.valueOf(opcion1.getSelectedItem()))
    	{
    		opcion2.setModel(new DefaultComboBoxModel(new String[] {"Ficha1","Ficha3","Ficha4"}));
    		imagen2.setIcon(icono2[0]);
    	}
    	if("Ficha3" == String.valueOf(opcion1.getSelectedItem()))
    	{
    		opcion2.setModel(new DefaultComboBoxModel(new String[] {"Ficha1","Ficha2","Ficha4"}));
    		imagen2.setIcon(icono3[0]);
    	}
    	if("Ficha4" == String.valueOf(opcion1.getSelectedItem()))
    	{
    		opcion2.setModel(new DefaultComboBoxModel(new String[] {"Ficha1","Ficha2","Ficha3"}));
    		imagen2.setIcon(icono4[0]);
    	}     	    	
    }      
    public String getNombreJugador1()
    {     
    	return nombreJugador1;
    }
    public String getNombreJugador2()
    {
    	return nombreJugador2;
    }    
    public String getFichaJugador1()
    {            	       	 	     
    	return "X";	       	          
    }
    public String getFichaJugador2()
    {    	       	 	     
    	return "O";
    }        
    /*
     * Verifica si se lleno los datos correctamente 
     * Retorna falso si falta algun campo por llenar en la ventana y muestra mensaje.
     * Retorna true si esta correctamente llenado los datos 
     * */
	public boolean venverificarllenado() 
	{		
		if(tipoJuego ==0)
		{
			JOptionPane.showMessageDialog(null,"Debe Seleccionar un modo de juego (vs)" );
			return false;
		}
		else		 
		{  						
			if (tipoJuego ==1 && (nombreJugador1.equals(" ")))
			{     	    	
			   JOptionPane.showMessageDialog(null,"Debe llenar el campo 'nombre jugador1'" );
			   return false;			
	     	}
			else
	     	{
	     		if(tipoJuego ==2 && (nombreJugador1.equals("")||nombreJugador2.equals("")))
	     		{	     		
	     			JOptionPane.showMessageDialog(null,"Debe llenar el campo 'nombre jugador 1' y 'nombre de jugador 2' " );
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
	public int getTipoDePartida() 
	{		
		return tipoJuego;
	}
	public String getNombreJugador(int turno) 
	{
		if (turno==1)
		
			return getNombreJugador1();
		else
			
			return getNombreJugador2();
	}
	public String getFichaJugador(int turno) 
	{
		if (turno==1)
		{			
			return getFichaJugador1();
		}
		else
		{		
			return getFichaJugador2();
		}
    }
	/*Retorna la opcion de la ficha(figura)del JComboBox(opcion1-opcion2)
	 * que el jugador eligio
	 * */
	public String getFigura(int turnojug) 
	{
		String opcionFicha="";
		if(turnojug==1)
		{
			opcionFicha=opcion1.getSelectedItem().toString();			
		}
		else
		{
			opcionFicha=opcion2.getSelectedItem().toString();
		}
		return opcionFicha;
	}
	
	public String getFiguraPC()
	{
		String figura="";
		if(opcion1.getSelectedItem().toString()=="Ficha1")
		{
			figura="Ficha2";
		}
		if(opcion1.getSelectedItem().toString()=="Ficha2")
		{
			figura="Ficha3";
		}
		if(opcion1.getSelectedItem().toString()=="Ficha3")
		{
			figura="Ficha4";
		}
		if(opcion1.getSelectedItem().toString()=="Ficha4")
		{
			figura="Ficha1";
		}
		return figura;
	}
}
