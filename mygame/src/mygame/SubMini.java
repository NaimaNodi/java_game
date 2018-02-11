package mygame;

import java.awt.Graphics;
import javax.swing.JPanel;

public class SubMini extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/*THIS METHOD PAINTS THE SUPER CLASS "MinionsQuest's"
	 COMPONENTS AS WELL AS THE "minion" EACH TIME AND WORKS AS (non-Javadoc)
	 */
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		MinionsQuest.minionsquest.repaint(g);
	}

}
