package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.ConexionCliente;
import Modelo.ConexionServidor;
import Modelo.Partida;
import Vista.VentanaDeJuego;
import Vista.VentanaRed;

public class ControladorRed implements ActionListener {
	
	VentanaRed ventanaDeRed;
	VentanaDeJuego ventanaDeJuego;
	
	int tipoDeVentana;// 1 Ventana de Red, 2 Ventana de Juego
	
	boolean servidor;
	boolean cliente;
	boolean coneccion;
	
	String Ip;//por si lo necesito
	String port;//por si lo necesito
	
	ConexionCliente conexionCliente;
	ConexionServidor conexionServidor;
	
	String datosDeCliente;//lo que el sevidor recibe del cliente
	String datosDeServidor;//lo que el cliente recibe del cervidor
	
	Partida partida;

	public ControladorRed(VentanaRed ventanaRed) {
		
		this.ventanaDeRed = ventanaRed;
		ventanaDeRed.btnConectar.addActionListener(this);
		ventanaDeRed.btnNewButton.addActionListener(this);
		ventanaDeRed.btnUnirseAPartida.addActionListener(this);
		coneccion=false;
		
	    	
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		Object boton = evento.getSource(); 
	 if(coneccion==false){	
		if(boton == ventanaDeRed.btnUnirseAPartida)
		{
			String nombreJugadpr = ventanaDeRed.txtJugadorCliente.getText();
		    String nomFich= ventanaDeRed.comboCliente.getSelectedItem().toString();
		    conexionCliente.EnviarDatos(""+2+" o "+nomFich+" "+nombreJugadpr);		    
		    datosDeServidor = conexionCliente.RecibirDatos();	
            cliente = true;  
            servidor=false;
            ventanaDeRed.setVisible(false); 
		    ventanaDeJuego = new VentanaDeJuego();
		    iniciarPartida(nombreJugadpr,nomFich);
		    coneccion=true;
		 
		    
		}
		if(boton == ventanaDeRed.btnConectar)
		{
		    conexionCliente = new ConexionCliente(ventanaDeRed.txtIp.getText());
			System.out.println("Se creo el cliente con la IP:" +ventanaDeRed.txtIp.getText() );
			conexionCliente.iniciarConexion();
					
			if(conexionCliente.getEstado()==true)
			{
				
				System.out.println(" Cliente se conecto con  el servidor : "+conexionCliente.getIP());

				
				ventanaDeRed.mensaje.setVisible(false);
				ventanaDeRed.direccion.setVisible(false);
				ventanaDeRed.txtIp.setVisible(false);
				ventanaDeRed.btnConectar.setVisible(false);
				
				ventanaDeRed.btnUnirseAPartida.setVisible(true);
				ventanaDeRed.imagen.setVisible(true);
				ventanaDeRed.txtJugadorCliente.setVisible(true);
				ventanaDeRed.comboCliente.setVisible(true);
				
				ventanaDeRed.btnNewButton.setVisible(false);
				
								
			}else
			{
				JOptionPane.showMessageDialog(null,"error al conectar, Intente de nuevo");		
			}		
		}
		
		if (boton==ventanaDeRed.btnNewButton){
			conexionServidor = new ConexionServidor();
            conexionServidor.iniciarsServicio();
        	ventanaDeRed.labelMsg.setText("Esperando contricante...");
            if(conexionServidor.esperarClienteyConectar()){
            
              ventanaDeRed.btnNewButton.setVisible(false);
              datosDeCliente = conexionServidor.RecibirDatos();
              servidor=true;
              cliente=false;
              coneccion=true;
  		    
              String nombreJugador = ventanaDeRed.textField.getText();
  		      String nomFich= ventanaDeRed.comboBox.getSelectedItem().toString();
              conexionServidor.EnviarDatos(""+1+" x "+nomFich+" "+nombreJugador);		    
             
             iniciarPartida(nombreJugador, nomFich);
            
            }else{
            	
            	JOptionPane.showMessageDialog(null,"error al conectar, con  cliente");		
    		 }
         
         			
		  }
	 }//fin si coneccion == true
	 else{
		 
		 contolarJugada(boton);
	 }
	
	}//fin metodo evento
	
	
	
    private void contolarJugada(Object boton) {

    	
		
    	
		
	
    }

	private void MarcarBoton(int pos,int turnojug) {

		if(partida.getFigura(turnojug)== "Ficha1")
		{
			switch(pos)
			{
				case 1:ventanaDeJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 2:ventanaDeJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 3:ventanaDeJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 4:ventanaDeJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 5:ventanaDeJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 6:ventanaDeJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 7:ventanaDeJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 8:ventanaDeJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
				case 9:ventanaDeJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Bart.png")));break;
			}
		}
		if(partida.getFigura(turnojug)=="Ficha2")
		{
			switch(pos)
			{
				case 1:ventanaDeJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 2:ventanaDeJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 3:ventanaDeJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 4:ventanaDeJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 5:ventanaDeJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 6:ventanaDeJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 7:ventanaDeJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 8:ventanaDeJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
				case 9:ventanaDeJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Homero.png")));break;
			}
		}
		if(partida.getFigura(turnojug)=="Ficha3")
		{
			switch(pos)
			{
				case 1:ventanaDeJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 2:ventanaDeJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 3:ventanaDeJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 4:ventanaDeJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 5:ventanaDeJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 6:ventanaDeJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 7:ventanaDeJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 8:ventanaDeJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
				case 9:ventanaDeJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Maggie.png")));break;
			}
		}
		if(partida.getFigura(turnojug)=="Ficha4")
		{
			switch(pos)
			{
				case 1:ventanaDeJuego.b1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 2:ventanaDeJuego.b2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 3:ventanaDeJuego.b3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 4:ventanaDeJuego.b4.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 5:ventanaDeJuego.b5.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 6:ventanaDeJuego.b6.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 7:ventanaDeJuego.b7.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 8:ventanaDeJuego.b8.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
				case 9:ventanaDeJuego.b9.setIcon(new ImageIcon(getClass().getResource("/imagenes/Marge.png")));break;
			}
		}
	
		
	}

	/**
     *Inicia Una Nueva Partida
     * @param fich 
     * @param nombre 
     * */
	private void iniciarPartida(String nombreJugador, String nomFich) 
	{		
		partida=new Partida(); 
		this.ventanaDeJuego.b1.addActionListener(this);
	    this.ventanaDeJuego.b2.addActionListener(this);
	    this.ventanaDeJuego.b3.addActionListener(this);
	    this.ventanaDeJuego.b4.addActionListener(this);
	    this.ventanaDeJuego.b5.addActionListener(this);
	    this.ventanaDeJuego.b6.addActionListener(this);
	    this.ventanaDeJuego.b7.addActionListener(this);
	    this.ventanaDeJuego.b8.addActionListener(this);
	    this.ventanaDeJuego.b9.addActionListener(this);
	     
	    this.ventanaDeJuego.menu_GuardarPartida.setVisible(false);
	    this.ventanaDeJuego.menu_Reiniciar.setVisible(false);
	    this.ventanaDeJuego.menu_volverAtras.setVisible(false);
	   
	    
	      if(cliente==true&&coneccion==true)//caso jugador1 vs jugador2 	   
	    { 	      		    		   
		        partida.CrearJugador(getnombreJugador(datosDeServidor),'x',getNombreFicha(datosDeServidor),1);//creamos al jugador cliente
                partida.CrearJugador(nombreJugador,'O',nomFich,2);//creamos al jugador cliente

	        ventanaDeJuego.lblMsg.setText("TURNO :"+nombreJugador+" ");
	    	ventanaDeJuego.setTitle("PARTIDA LAN");	     		    		    
	    }
	    else 	    
	    { 	 if(servidor==true&&coneccion==true) {
	    	

	        partida.CrearJugador(nombreJugador,'X',nomFich,1);//creamos al jugador cliente
	        partida.CrearJugador(getnombreJugador(datosDeCliente),'O',getNombreFicha(datosDeCliente),2);//creamos al jugador cliente

	        ventanaDeJuego.lblMsg.setText("TURNO :"+getnombreJugador(datosDeCliente));
	    	ventanaDeJuego.setTitle("PARTIDA LAN");	 
	    	datosDeCliente = conexionServidor.RecibirDatos();
	    	marcarPosicion();
	    	
	         }else{
	        	 JOptionPane.showMessageDialog(null,"PROBLEMAS CON LA CONEXION");
	        	 
	         }  	
	    	 	    	 	    
	    }	     	     	     	     	     	     		
	}

	
	
	
	
	
	
	
	
	private void marcarPosicion() {
		
	//marcar la posion en el tablero que el Jugador cliente envie primero
		
	
	}

	private String getNombreFicha(String datos) {
      return datos.substring(4,10);

	}

	private String getnombreJugador(String datos) {
      
		return  datos.substring(11,datosDeCliente.length());

	}

}
