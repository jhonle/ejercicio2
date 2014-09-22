package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Modelo.Partida;

import Vista.DialogoGuardar;
import Vista.VentanaDeIngreso;
import Vista.VentanaDeJuego;
import Vista.VentanaDeOpciones;

public class Controlador implements ActionListener {

private	VentanaDeIngreso  ventanaIngreso;
private VentanaDeOpciones ventanaOpciones;
private	VentanaDeJuego    ventanaJuego;
private Partida           partida;
private String            tituloVentana = "";
private int turno=1; //es para controlar que turno preciono el boton

private int tipoDeVentanaActual; // ventana que se muestra: 1 VentanaDeIngreso; 2 VentanaDeOpciones; 3 VentanaDeJuego; 4 Ventana GargarPartida
 /**
  * Metodo ContructorJuego    ventanaJuego;
private Partida           partida;
private String            tituloVentana = "";
private int turno=1; //es para controlar que turno preciono el boton
  * */	
  public Controlador() {
		ventanaIngreso = new VentanaDeIngreso();
	    iniciarVista();
	   
	}
	
  /**
   * Inicia LA Intefaz Grafica
   * */
	public void iniciarVista() {
	      ventanaIngreso.setLocationRelativeTo(null);
	      this.ventanaIngreso.btnIniciarPartida.addActionListener(this);
	      this.ventanaIngreso.btnCargarPartida.addActionListener(this);
	      ventanaIngreso.setVisible(true);
	      tipoDeVentanaActual =1;
	        
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object boton = e.getSource();

	    
	    

       
        if( tipoDeVentanaActual==1 )
        {
        	controlarV1(boton);
        	
        }
        else
        {
        	if (tipoDeVentanaActual==2)
        	{
        		controlarV2(boton);
        	}
        	else
        	{
        		controlarV3(boton);
        	}
        	  
          }
  } 
       
		
/**
 * este metodo controla los eventos de la Ventana de inicio
 * */
	private void controlarV1(Object boton) 
	{
		if (boton == this.ventanaIngreso.btnIniciarPartida)
		{   
			tipoDeVentanaActual=2;
			ventanaIngreso.setVisible(false);
		    ventanaOpciones = new VentanaDeOpciones();
		    ventanaOpciones.setVisible(true);
		    this.ventanaOpciones.btnAceptar.addActionListener(this);
		}else{
			 if(boton == this.ventanaIngreso.btnCargarPartida){
				
				
			}
			
		}  
		
		
	}
	/**
	 * este metodo controla los eventos de la Ventana de Opciones
	 * */
	private void controlarV2(Object boton) 
	{
		if (boton == this.ventanaOpciones.btnAceptar)
		{   
			if(ventanaOpciones.venverificarllenado())
			{   
		         
		  	     
		  	   
		  	    	 tipoDeVentanaActual=3;
				     ventanaOpciones.setVisible(false);
			         ventanaJuego = new VentanaDeJuego();
			         ventanaJuego.setVisible(true);
			         iniciarPartida();
			           
		  	  
		  	 }   
		}     
		
	
    }
	
	
     /**
      * Este metodo se encarga de realizar las operacion correspondiente cuando 
      * se inseta una ficha el la VentanaJuego o cuando se realiza alguna operacion 
      * dentro de esta
      * */
	private void controlarV3(Object boton) 
	{
	    
		if( boton == this.ventanaJuego.menu_volverAtras)
         {
      	    int ax = JOptionPane.showConfirmDialog(null, "Se perderan todos los datos de la partida actual");
            if(ax == JOptionPane.YES_OPTION)
            {
            	   ventanaIngreso.setVisible(true);
                   ventanaJuego.dispose();
                   ventanaOpciones.dispose();
                   tipoDeVentanaActual=1;
                   turno=1;
                
            }
         }
		else
        {  if( boton == this.ventanaJuego.menu_Reiniciar)
         {
      	    int ax = JOptionPane.showConfirmDialog(null, "Se perderan todos los datos de la partida actual");
            if(ax == JOptionPane.YES_OPTION)
            {      
            	   turno=1;
            	   ventanaJuego.dispose();
            	   ventanaJuego = new VentanaDeJuego();
		           ventanaJuego.setVisible(true);
		           iniciarPartida();
                   
                
            }
         }else
         {
        	 if(boton == this.ventanaJuego.menu_GuardarPartida){
              
        		 new DialogoGuardar(partida,ventanaJuego).setVisible(true);
        	     ventanaJuego.setVisible(false);																			
         
        }else{        	
			if(ventanaOpciones.getTipoDePartida()==1)//jugador vs pc
			{															
				if(partida.getGanador()==0)
				{
					if(partida.getTurno()==1)
					{
						if(boton==ventanaJuego.b1)
						{
							if(partida.RealizarJugada(1,1)==true)
							{
								MarcarBoton(1,1);
								turnoPC();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b2)
						{
							if(partida.RealizarJugada(2,1)==true)
							{
								MarcarBoton(2,1);
								turnoPC();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b3)
						{
							if(partida.RealizarJugada(3,1)==true)
							{
								MarcarBoton(3,1);
								turnoPC();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b4)
						{
							if(partida.RealizarJugada(4,1)==true)
							{
								MarcarBoton(4,1);
								turnoPC();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b5)
						{
							if(partida.RealizarJugada(5,1)==true)
							{
								MarcarBoton(5,1);
								turnoPC();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b6)
						{
							if(partida.RealizarJugada(6,1)==true)
							{
								MarcarBoton(6,1);
								turnoPC();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b7)
						{
							if(partida.RealizarJugada(7,1)==true)
							{
								MarcarBoton(7,1);
								turnoPC();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b8)
						{
							if(partida.RealizarJugada(8,1)==true)
							{
								MarcarBoton(8,1);
								turnoPC();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b9)
						{
							if(partida.RealizarJugada(9,1)==true)
							{
								MarcarBoton(9,1);
								turnoPC();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
					}
					/*else
					{							
						int pos=partida.realizarJugadaPc();
						MarcarBotonPc(pos);														
					}*/
				}					
			}
			if(ventanaOpciones.getTipoDePartida()==2)//partida jugador1 vs jugador2
			{
				if(partida.getGanador()==0)
				{
					if(partida.getTurno()==1)
					{
						if(boton==ventanaJuego.b1)
						{
							if(partida.RealizarJugada(1,1)==true)
							{
								MarcarBoton(1,1);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno())+" "+partida.getFigura(1));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla ya esta marcada");
							}
						}
						if(boton==ventanaJuego.b2)
						{
							if(partida.RealizarJugada(2,1)==true)
							{
								MarcarBoton(2,1);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b3)
						{
							if(partida.RealizarJugada(3,1)==true)
							{
								MarcarBoton(3,1);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b4)
						{
							if(partida.RealizarJugada(4,1)==true)
							{
								MarcarBoton(4,1);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b5)
						{
							if(partida.RealizarJugada(5,1)==true)
							{
								MarcarBoton(5,1);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b6)
						{
							if(partida.RealizarJugada(6,1)==true)
							{
								MarcarBoton(6,1);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b7)
						{
							if(partida.RealizarJugada(7,1)==true)
							{
								MarcarBoton(7,1);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b8)
						{
							if(partida.RealizarJugada(8,1)==true)
							{
								MarcarBoton(8,1);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b9)
						{
							if(partida.RealizarJugada(9,1)==true)
							{
								MarcarBoton(9,1);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
					}
					else//turno2
					{
						if(boton==ventanaJuego.b1)
						{
							if(partida.RealizarJugada(1,2)==true)
							{
								MarcarBoton(1,2);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla ya esta marcada");
							}
						}
						if(boton==ventanaJuego.b2)
						{
							if(partida.RealizarJugada(2,2)==true)
							{
								MarcarBoton(2,2);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b3)
						{
							if(partida.RealizarJugada(3,2)==true)
							{
								MarcarBoton(3,2);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b4)
						{
							if(partida.RealizarJugada(4,2)==true)
							{
								MarcarBoton(4,2);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b5)
						{
							if(partida.RealizarJugada(5,2)==true)
							{
								MarcarBoton(5,2);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b6)
						{
							if(partida.RealizarJugada(6,2)==true)
							{
								MarcarBoton(6,2);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b7)
						{
							if(partida.RealizarJugada(7,2)==true)
							{
								MarcarBoton(7,2);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b8)
						{
							if(partida.RealizarJugada(8,2)==true)
							{
								MarcarBoton(8,2);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
						if(boton==ventanaJuego.b9)
						{
							if(partida.RealizarJugada(9,2)==true)
							{
								MarcarBoton(9,2);
								ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(partida.getTurno()));
							}
							else
							{
								JOptionPane.showMessageDialog(null,"La casilla esta marcada");
							}
						}
					}
				}
			}
			if(partida.getGanador()!=3)					
			{						
				if(partida.getGanador()==1)							
				{								
					ventanaJuego.lblMsg.setText("GANADOR : "+ventanaOpciones.getNombreJugador1());								
					JOptionPane.showMessageDialog(null,"Gano el Jugador: "+ventanaOpciones.getNombreJugador1() );        	    									
				}																																					
				if(partida.getGanador()==2)													
				{															
					ventanaJuego.lblMsg.setText("GANADOR : "+ventanaOpciones.getNombreJugador2());
					JOptionPane.showMessageDialog(null,"Gano el Jugador: "+ventanaOpciones.getNombreJugador2() );							
				}							
				if(partida.getGanador()==4)							
				{								
					ventanaJuego.lblMsg.setText("GANADOR : PC");
					JOptionPane.showMessageDialog(null,"Gano la PC");							
				}																	
			}
			else
			{
				ventanaJuego.lblMsg.setText("EMPATE ");
				JOptionPane.showMessageDialog(null,"SE EMPATO EL JUEGO");
			}												        	            	    									
		
		partida.imrprimirTablero();
		}
        }
       }
}

	private void MarcarBoton(int pos, int turnojug) {

		if(partida.getFigura(turnojug)== "Ficha1")
		{
			switch(pos)
			{
				case 1:ventanaJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 2:ventanaJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 3:ventanaJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 4:ventanaJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 5:ventanaJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 6:ventanaJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 7:ventanaJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 8:ventanaJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 9:ventanaJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
			}
		}
		if(partida.getFigura(turnojug)=="Ficha2")
		{
			switch(pos)
			{
				case 1:ventanaJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 2:ventanaJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 3:ventanaJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 4:ventanaJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 5:ventanaJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 6:ventanaJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 7:ventanaJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 8:ventanaJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 9:ventanaJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
			}
		}
		if(partida.getFigura(turnojug)=="Ficha3")
		{
			switch(pos)
			{
				case 1:ventanaJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 2:ventanaJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 3:ventanaJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 4:ventanaJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 5:ventanaJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 6:ventanaJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 7:ventanaJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 8:ventanaJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 9:ventanaJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
			}
		}
		if(partida.getFigura(turnojug)=="Ficha4")
		{
			switch(pos)
			{
				case 1:ventanaJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 2:ventanaJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 3:ventanaJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 4:ventanaJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 5:ventanaJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 6:ventanaJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 7:ventanaJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 8:ventanaJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 9:ventanaJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
			}
		}
			
	}

	/**
	 * controla el turno de los jugadores
	 * cuando el juego es vs Jugador 2
	 * */
	private void cambiarturno() {
		if (turno ==1)
		{
			turno=2;
		}else
	    {
			turno =1;
	    }
	}

			
     /**
      *
      *Inicia Una Nueva Partida
      * */
	private void iniciarPartida() {
		 this.ventanaJuego.b1.addActionListener(this);
 	     this.ventanaJuego.b2.addActionListener(this);
 	     this.ventanaJuego.b3.addActionListener(this);
 	     this.ventanaJuego.b4.addActionListener(this);
 	     this.ventanaJuego.b5.addActionListener(this);
 	     this.ventanaJuego.b6.addActionListener(this);
 	     this.ventanaJuego.b7.addActionListener(this);
 	     this.ventanaJuego.b8.addActionListener(this);
 	     this.ventanaJuego.b9.addActionListener(this);
 	     
 	     this.ventanaJuego.menu_volverAtras.addActionListener(this);
 	     this.ventanaJuego.menu_Reiniciar.addActionListener(this);	
 	    this.ventanaJuego.menu_GuardarPartida.addActionListener(this);
	          
 	   if(ventanaOpciones.getTipoDePartida()==2)
 	   {
   		  String aux1 =ventanaOpciones.getFichaJugador1();
          char cad1= aux1.charAt(0);//convierte a  tipo char X 
          String aux2 =ventanaOpciones.getFichaJugador2();
          char cad2= aux2.charAt(0); //convierte a tipo char O 	
          /*System.out.println("inicio partida");
          System.out.println("nombre1 : "+ventanaOpciones.getNombreJugador1()+" ficha : "+cad1+" figura: "+ventanaOpciones.getFigura(1) );
          System.out.println("nombre2 : "+ventanaOpciones.getNombreJugador2()+" ficha : "+cad2+" figura: "+ventanaOpciones.getFigura(2) );*/ 	    	
          partida.CrearJugador(ventanaOpciones.getNombreJugador1(), cad1, ventanaOpciones.getFigura(1),1);
          partida.CrearJugador(ventanaOpciones.getNombreJugador2(),cad2,ventanaOpciones.getFigura(2),2);
          ventanaJuego.lblMsg.setText("TURNO :"+ventanaOpciones.getNombreJugador(partida.getTurno())+" "+partida.getFigura(1));
          ventanaJuego.setTitle("PARTIDA MULTIJUGADOR");	     		    		    

 	   }
 	    else
 	     {
 	    	if(ventanaOpciones.getTipoDePartida()==1)
 	    	{//ini
 	 	        
 	 	    		char fichaComp;  	    	
 	 	    		if (ventanaOpciones.getFichaJugador1().equals("X"))  	    		
 	 	    			fichaComp='O'; 	    	
 	 	    		else 
 	 	    			fichaComp='X'; 
 	 	    		//String fig=ventanaOpciones.getFiguraPC();
 	 	    		partida.FichaPc(fichaComp,ventanaOpciones.getFiguraPC()); 	    	  
 	 	    		String aux1 =ventanaOpciones.getFichaJugador1();
 	 	    		char cad1= aux1.charAt(0);//convierte a  tipo char  	    	 	    		
 	 	    		partida.CrearJugador(ventanaOpciones.getFichaJugador1(), cad1, ventanaOpciones.getFigura(1), 1);
 	 	    		ventanaJuego.lblMsg.setText("PARTIDA VS PC"); 	    		
 	 	    		ventanaJuego.setTitle("PARTIDA VS PC"); 		    	    	  
 	 	    		/* System.out.println("inicio partida");
 	 		     	System.out.println("computaroa : "+" ficha : "+fichaComp);
 	 		     	System.out.println("jugador 1: nombre : "+ventanaOpciones.getNombreJugador1()+" ficha : "+cad1 );
 	 	    		 */ 	    	 	    	
 	 	    	
 	    		
 	    		
 	    		
 	    	}//fin
 	    	
 	    }
	     
}

	private void turnoPC() 
	{
		if (partida.getGanador()==0)
		{
			int pos=partida.realizarJugadaPc();
			MarcarBotonPc(pos);
		} 							  
	}

	private void MarcarBotonPc(int pos) {
		if(partida.getFiguraPc()=="Ficha1")
		{
			switch(pos)
			{
				case 1:ventanaJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 2:ventanaJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 3:ventanaJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 4:ventanaJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 5:ventanaJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 6:ventanaJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 7:ventanaJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 8:ventanaJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 9:ventanaJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
			}					
		}
		if(partida.getFiguraPc()=="Ficha2")
		{
			switch(pos)
			{
				case 1:ventanaJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 2:ventanaJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 3:ventanaJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 4:ventanaJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 5:ventanaJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 6:ventanaJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 7:ventanaJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 8:ventanaJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 9:ventanaJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
			}					
		}
		if(partida.getFiguraPc()=="Ficha3")
		{
			switch(pos)
			{
				case 1:ventanaJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 2:ventanaJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 3:ventanaJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 4:ventanaJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 5:ventanaJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 6:ventanaJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 7:ventanaJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 8:ventanaJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 9:ventanaJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
			}					
		}
		if(partida.getFiguraPc()=="Ficha4")
		{
			switch(pos)
			{
				case 1:ventanaJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 2:ventanaJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 3:ventanaJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 4:ventanaJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 5:ventanaJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 6:ventanaJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 7:ventanaJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 8:ventanaJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 9:ventanaJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
			}					
		}
	
		
		
	}								



}