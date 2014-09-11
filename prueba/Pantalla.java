package prueba;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
//import net.miginfocom.swing.MigLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.Font;

public class Pantalla extends JFrame {

	private fondo contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new fondo("../imagenes/3AB[1].jpg");
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//JButton btnNewButton = new JButton("New button");
		//contentPane.add(btnNewButton, BorderLayout.NORTH);
		 Container c =getContentPane();
		 contentPane.setLayout(null);
		 ImageIcon ii = new ImageIcon("3AB[1].JPG");
		 
		 JPanel panel = new JPanel();
		 panel.setBounds(1680, 5, 0, 297);
		 contentPane.setLayout(null);
		 
		 JButton btnNewButton = new JButton("New button");
		 btnNewButton.setBounds(1680, 142, 89, 23);
		 contentPane.add(btnNewButton);
		 
		 JButton btnInicio = new JButton("INICIA NUEVA PARTIDA");
		 btnInicio.setFont(new Font("Viner Hand ITC", Font.PLAIN, 11));
		 btnInicio.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		Figura nuevoFIGURA = new Figura();
			 	nuevoFIGURA.setVisible(true);
			 	Pantalla.this.dispose();
		 		
		 	}
		 });
		 btnInicio.setBounds(491, 364, 178, 67);
		 contentPane.add(btnInicio);
		 
		 JButton btnRegistrar = new JButton("REGISTRAR");
		 btnRegistrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		Inicio nuevoinicio = new Inicio();
		 	nuevoinicio.setVisible(true);
		 	Pantalla.this.dispose();
		 	}
		 	
		 });
		 btnRegistrar.setForeground(new Color(102, 0, 0));
		 btnRegistrar.setFont(new Font("Viner Hand ITC", Font.PLAIN, 11));
		 btnRegistrar.setBounds(491, 285, 178, 46);
		 contentPane.add(btnRegistrar);
		 
		 final JButton nome = new JButton("CONECTARSE A INTERNET");
		 nome.setFont(new Font("Viner Hand ITC", Font.PLAIN, 11));
		 nome.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog( null, ""+nome.getText());
		 	}
		 });
		 
		 JLabel lblTresEnRaya = new JLabel("   TRES EN RAYA ");
		 lblTresEnRaya.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 50));
		 lblTresEnRaya.setForeground(new Color(204, 51, 51));
		 lblTresEnRaya.setBounds(-24, -28, 375, 185);
		 contentPane.add(lblTresEnRaya);
		 nome.setBounds(488, 198, 181, 56);
		 contentPane.add(nome);
		 JLabel label = new JLabel("",new ImageIcon(Pantalla.class.getResource("../imagenes/3AB[1].jpg")),JLabel.CENTER);
		 label.setAlignmentX(Component.CENTER_ALIGNMENT);
		 label.setBounds(-328, 0, 1335, 563);
		 contentPane.add(label);
		 
		 JSplitPane splitPane = new JSplitPane();
		 splitPane.setBounds(1463, 153, 217, 149);
		 contentPane.add(splitPane);
		 contentPane.add(panel);
		 panel.setLayout(null);
		 setSize(695,597);
		 setVisible(true);
	}
}
