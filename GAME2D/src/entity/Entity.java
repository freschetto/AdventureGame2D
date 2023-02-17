
package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
	
	public GamePanel panel;
	
	// WORLD SETTINGS
	public int worldX, worldY; // coordinates of the object in the world (map)
	public int speed = 4; // how many pixels the object moves
	
	// SCREEN SETTINGS
	public int screenX, screenY; // coordinates of the object on the screen
	public BufferedImage[] up, down, left, right; // create an array for every frame of the action
	public String direction = "front"; // this string determinate the image of its
	public int frame = 0; public int frameCounter = 0; // variable that determinate which frame draw and how fast change frame
	
	// COLLISION
	public Rectangle solidArea; // area of entity collision
	public boolean collision = false;
	
	// CONSTRUCTOR
	public Entity(GamePanel panel) {
		
		this.panel = panel;
		setDimensionFrames();
	}
	
	// SET STANDARD DIMENSION OF ACTION FRAME
	private void setDimensionFrames() {
		
		// UP
		up = new BufferedImage[3];
		
		// DOWN
		down = new BufferedImage[3];
		
		// LEFT
		left = new BufferedImage[3];
		
		// RIGHT
		right = new BufferedImage[3];
	}
	
	// METHOD THAT CHANGE WORLD ENTITY'S POSITION
	public void changePosition() {
			
		switch (direction) {
			
			case "up":
				this.worldY -= this.speed;
				break;
			
			case "down":
				this.worldY += this.speed;
				break;
			
			case "left":
				this.worldX -= this.speed;
				break;
			
			case "right":
				this.worldX += this.speed;
				break;
		}
	}
	
	// METHOD THAT RETURN IMAGE BY ENTITY'S DIRECTION
	public BufferedImage getImageDirection() {
			
		BufferedImage image = null;
			
		switch (direction) {
				
			case "up":
				if(frame >= up.length) {frame = 0;} // every times change frame, if reaches max its reset
				image = up[frame];
				break;
				
			case "down":
				if(frame >= down.length) {frame = 0;} // every times change frame, if reaches max its reset
				image = down[frame];
				break;
				
			case "left":
				if(frame >= left.length) {frame = 0;} // every times change frame, if reaches max its reset
				image = left[frame];
				break;
				
			case "right":
				if(frame >= right.length) {frame = 0;} // every times change frame, if reaches max its reset
				image = right[frame];
				break;
					
			default: image = down[0];
		}
			
		return image;
	}
}
