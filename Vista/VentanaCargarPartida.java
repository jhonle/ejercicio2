package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaCargarPartida extends JFrame implements ActionListener
{
	public JButton btnCargar;
	public JList list;
	public JScrollPane scrollLista;
	/**
	 * Create the frame.
	 */
	public VentanaCargarPartida() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(null);
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//getContentPane().add(list, BorderLayout.CENTER);
		scrollLista =new JScrollPane();
		scrollLista.setBounds(150, 50, 200, 200);
		scrollLista.setViewportView(list);
		//list.setBounds(150, 50,200 , 200);
		getContentPane().add(scrollLista,BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Partidas de Guardadas");
		lblNewLabel.setBounds(150, 11, 150, 14);
		getContentPane().add(lblNewLabel);
		
		btnCargar = new JButton("Cargar");
		btnCargar.setBounds(220, 280, 130, 40);
		getContentPane().add(btnCargar);
		btnCargar.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	{
		
		
	}
}
