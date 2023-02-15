
package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.*;

public class Player extends Entity {
	
	GamePanel panel; KeyHandler keyH;
	
	// CONSTRUCTOR
	public Player(GamePanel panel, KeyHandler keyH) {
		
		setDefaultValues(); getPlayerImage();
		this.panel = panel;
		this.keyH = keyH;
	}
	
	// PLAYER SETTINGS
	public void setDefaultValues() {
		
		this.worldX = 100;
		this.worldY = 100;
	}
	
	// PLAYER IMAGES
	public void getPlayerImage() {
		
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
		
		// UP
		if(keyH.upPressed) {
			this.direction = "up";
			this.worldY -= this.speed;
		}
		
		// DOWN
		if(keyH.downPressed) {
			this.direction = "down";
			this.worldY += this.speed;
		}
		
		// LEFT
		if(keyH.leftPressed) {
			this.direction = "left";
			this.worldX -= this.speed;
		}
		
		// RIGHT
		if(keyH.rightPressed) {
			this.direction = "right";
			this.worldX += this.speed;
		}
	}
	
	// DRAW METHOD
	public void draw(Graphics g) {		
		
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
		
		this.frameCounter++; // change frame every 10 times
		
		if(this.frameCounter > 10) {
			
				this.frame++; // change the number of the frame
				
				this.frameCounter = 0; // reset the counter
			}
		
		return image;
	}
}
