import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TreePanel extends JPanel {

	Controller c;
	Square[][] theSquares;

	public TreePanel(Controller c) {
		super();
		this.c = c;
		theSquares = c.m.returnSquares();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(1024, 768));
		this.addMouseListener(c);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < c.m.returnRowLength(); i++) {
			for (int k = 0; k < c.m.returnColLength(); k++) {
				theSquares[i][k].draw(g);
			}
		}
	

	}
	
	public Controller getController(){
		return c;
	}
	

}
