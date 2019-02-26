import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Timer;

public class Controller implements ActionListener, MouseListener {
	Model m;
	View v;
	TreePanel treePanel;
	Timer timer;

	Square[][] theSquares;

	public Controller() {
		m = new Model();
		v = new View(this);
		treePanel = new TreePanel(this);
		timer = new Timer(50, this);
		theSquares = m.returnSquares();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		m.clicked(e.getX(), e.getY());
		v.repaint();
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("tick");

		m.checkFire();
		v.repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
