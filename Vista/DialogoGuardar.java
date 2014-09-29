package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Modelo.Serializador;
import Modelo.BaseDeDato;
import Modelo.Partida;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogoGuardar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreDePartida;
	private BaseDeDato datos;
	private Partida partida;
	private Serializador ser ;
	private JFrame venatana;
    /**
	 * Create the dialog.
	 */
	public DialogoGuardar(Partida partida,JFrame ventana) {
	
		this.venatana=ventana;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				cerrarDialogo();
				
			}
		});
		setBounds(100, 100, 450, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.partida=partida;
	    ser = new Serializador();
		datos= (BaseDeDato)ser.leerObjeto("Datos.a");
		
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la partida");
		lblNombreDeLa.setFont(new Font("Arial Black", Font.ITALIC, 12));
		lblNombreDeLa.setBounds(12, 12, 168, 15);
		contentPanel.add(lblNombreDeLa);
		
		txtNombreDePartida = new JTextField();
		txtNombreDePartida.setBounds(215, 10, 201, 19);
		contentPanel.add(txtNombreDePartida);
		txtNombreDePartida.setColumns(10);
		
		JLabel lblEscojaUnNombre = new JLabel("(Ingrese un nombre  que no exista ya en la base de datos)");
		lblEscojaUnNombre.setBounds(12, 30, 420, 15);
		contentPanel.add(lblEscojaUnNombre);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
				      if (!txtNombreDePartida.getText().equals("")){ 
						if(verificarNombre()){
							
						  guardarPartida();
				    	   
				          }
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	ventana.setVisible(false);
	}
	
	
	protected void cerrarDialogo() {
       venatana.setVisible(true);
       this.dispose();
		
	}


	protected void guardarPartida() {
		datos.addPartida(txtNombreDePartida.getText(),partida);
		ser.escribirObjeto(datos,"Datos.a");
		JOptionPane.showMessageDialog(null,"Se guardo la partida correctamete");
		this.dispose();
    	}
	
	protected boolean verificarNombre() {
		
	    if (datos.getPartida(txtNombreDePartida.getText())!=null){
	         JOptionPane.showMessageDialog(null,"El Nombre ya Existe. Ingrese otro nombre por favor");
	    	return false;
	    }
		return true;
	
	
	}


}
