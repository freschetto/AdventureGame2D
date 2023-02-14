
package main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	// SCREEN SETTINGS
	final int tileSize = 64; // 64x64 tile
	
	final int maxScreenCol = 16; // how many tiles can be displayed on screen horizontally
	final int maxScreenRow = 12; // how many tiles can be displayed on screen vertically
	
	// CONSTRUCTOR
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(maxScreenCol * tileSize, maxScreenRow * tileSize));
		this.setDoubleBuffered(true);
	}
}
