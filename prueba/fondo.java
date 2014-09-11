package prueba;

import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
//import javax.awt.Dimension;

public class fondo extends JPanel {
	ImageIcon imagen;
	private static final long serialVersionUID = 1L;

	
	public fondo(String nombre) {
		super ();
		initialize();
		
		imagen = new ImageIcon(getClass().getResource(nombre));

		setSize(imagen.getIconWidth(),imagen.getIconHeight());
		
	
	}
protected void paintComponet(Graphics g){
java.awt.Dimension d = getSize();
g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
this.setOpaque(false);
super.paint(g);
}
	private void initialize() {
	this.setSize(300,200);
	this.setLayout(new GridBagLayout());
}

}
