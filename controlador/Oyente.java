package controlador;
import prueba.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oyente implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre=e.getActionCommand();
		System.out.println("Se ha pulsado el botón 654 "+ nombre);


		

}
}