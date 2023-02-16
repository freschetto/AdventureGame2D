
package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.*;

public class Player extends Entity {
	
	private GamePanel panel;
	
	// CONSTRUCTOR
	public Player(GamePanel panel) {
		
		setDefaultValues(); getPlayerImage();
		this.panel = panel;
	}
	
	// PLAYER SETTINGS
	private void setDefaultValues() {
		
		this.worldX = 100;
		this.worldY = 100;
	}
	
	// PLAYER IMAGES
	private void getPlayerImage() {
		
		try {
			
			// UP
			for(int i = 0; i < this.up.length; i++) {
				
				this.up[i] = ImageIO.read(getClass().getResourceAsStream("/images_player/up" +i+ ".png"));
			}
			
			// DOWN
			for(int i = 0; i < this.down.length; i++) {
				
				this.down[i] = ImageIO.read(getClass().getResourceAsStream("/images_player/down" +i+ ".png"));
			}

			// LEFT
			for(int i = 0; i < this.left.length; i++) {
				
				this.left[i] = ImageIO.read(getClass().getResourceAsStream("/images_player/left" +i+ ".png"));
			}
			
			// RIGHT
			for(int i = 0; i < this.right.length; i++) {
				
				this.right[i] = ImageIO.read(getClass().getResourceAsStream("/images_player/right" +i+ ".png"));
			}
			
		} catch(IOException e) {e.printStackTrace();}
	}
	
	// UPDATE METHOD
	public void update() {
		
		if(panel.getKeyH().action) {
			
			// UP
			if(panel.getKeyH().upPressed) {
				this.direction = "up";
				this.worldY -= this.speed;
			}
			
			// DOWN
			if(panel.getKeyH().downPressed) {
				this.direction = "down";
				this.worldY += this.speed;
			}
			
			// LEFT
			if(panel.getKeyH().leftPressed) {
				this.direction = "left";
				this.worldX -= this.speed;
			}
			
			// RIGHT
			if(panel.getKeyH().rightPressed) {
				this.direction = "right";
				this.worldX += this.speed;
			}
			
			// FRAME IMAGE
			changeFrame();
		}
	}
	
	// DRAW METHOD
	public void draw(Graphics2D g) {		
		
		g.drawImage(getImageDirection(), worldX, worldY, panel.tileSize, panel.tileSize, null);
	}
	
	// METHOD THAT RETURN IMAGE BY PLAYER'S DIRECTION
	public BufferedImage getImageDirection() {
		
		BufferedImage image = null;
		
		switch (this.direction) {
			
			case "up":
				if(this.frame >= up.length) {this.frame = 0;} // every times change frame, if reaches max its reset
				image = this.up[this.frame];
			break;
			
			case "down":
				if(this.frame >= down.length) {this.frame = 0;} // every times change frame, if reaches max its reset
				image = this.down[this.frame];
			break;
			
			case "left":
				if(this.frame >= left.length) {this.frame = 0;} // every times change frame, if reaches max its reset
				image = this.left[this.frame];
			break;
			
			case "right":
				if(this.frame >= right.length) {this.frame = 0;} // every times change frame, if reaches max its reset
				image = this.right[this.frame];
			break;
			
			default: image = this.down[0];
		}
		
		return image;
	}
	
	// METHOD THAT CHANGHE IMAGE FRAME
	public void changeFrame() {
		
		this.frameCounter++; // change frame every 10 times
		
		if(this.frameCounter > 16) {
			
			this.frame++; // change the number of the frame
				
			this.frameCounter = 0; // reset the counter
		}
	}
}
