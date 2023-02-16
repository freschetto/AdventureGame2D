
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {
	
	// SCREEN SETTINGS
	public final int tileSize = 64; // 64x64 tile
	private final int maxScreenCol = 16; // how many tiles can be displayed on screen horizontally
	private final int maxScreenRow = 12; // how many tiles can be displayed on screen vertically
	
	// VARIABLE FOR CYCLE UPDATING AND DRAWING
	private Thread gameThread;
	private final int FPS = 60;
	private KeyHandler keyH = new KeyHandler();
	
	// WORLD SETTINGS
	private final int maxWorldCol = 50; // how many tiles can be draw on the map horizontally
	private final int maxWorldRow = 50; // how many tiles can be draw on the map vertically
	
	// ELEMENTS
	public Player player = new Player(this);
	private TileManager background = new TileManager(this);;
	
	// CONSTRUCTOR
	public GamePanel() {
		
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(maxScreenCol * tileSize, maxScreenRow * tileSize));
		this.setDoubleBuffered(true); // if enabled can improve game's rendering performance
		this.addKeyListener(keyH);
		this.setFocusable(true); // with this, panel can be focused to receive key input
	}
	
	// GETTER
	public KeyHandler getKeyH() {return keyH;}
	
	public int getMaxScreenCol() {return maxScreenCol;}

	public int getMaxScreenRow() {return maxScreenRow;}

	public int getMaxWorldCol() {return maxWorldCol;}

	public int getMaxWorldRow() {return maxWorldRow;}

	// METHOD START THREAD
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	// GAME LOOP
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS; // how much time pass before drawing in one second (0.016)
		long currentTime; long lastTime = System.nanoTime();
		double delta = 0; // variable that determinate when it can update and draw
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval; // every cycle of while add to delta 
			
			lastTime = currentTime;
			
			if(delta >= 1) {
				
				update(); // update information relative to position of elements
				
				repaint(); // draw the elements in relative positions
				
				delta = 0; // reset delta for the next cycle
			}

		}
	}
	
	// UPDATE METHOD
	public void update() {

		player.update(); // update player's coordinates and its image
		
	}
	
	// DRAW METHOD
	public void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics); // is a standard for superclass JPanel
		Graphics2D g = (Graphics2D) graphics; // Graphics2D is better for this type of program
		
		background.draw(g);
		
		player.draw(g); // draw player's image
		
		g.dispose();
	}
}
