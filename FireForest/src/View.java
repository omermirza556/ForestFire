import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	Controller c;
	JFrame theFrame;
	JPanel thePanel;
	TreePanel treePanel;
	
	public View(Controller c){
		this.c = c;
		theFrame = new JFrame("Space Dandy is a dandy guy in space");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thePanel = new JPanel();
		thePanel.setPreferredSize(new Dimension(1024,768));
		treePanel = new TreePanel(c);
		thePanel.add(treePanel);
		theFrame.getContentPane().add(thePanel);
		theFrame.pack();
		theFrame.setVisible(true);
	}
	
	public void repaint(){
		treePanel.repaint();
	}
	

}
