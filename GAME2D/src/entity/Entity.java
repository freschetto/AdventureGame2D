
package entity;

import java.awt.image.BufferedImage;

public class Entity {
	
	public int worldX, worldY; // coordinates of the object in the world (map)
	public int speed = 4; // how many pixels the object moves
	
	public BufferedImage[] up, down, left, right; // create an array for every frame of the action
	public String direction = "front"; // this string determinate the image of its
	public int frame = 0; public int frameCounter = 0; // variable that determinate which frame draw and how fast change frame
	
	// CONSTRUCTOR
	public Entity() {
		
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
}
