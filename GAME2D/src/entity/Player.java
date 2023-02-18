
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.*;

public class Player extends Entity {
		
	// CONSTRUCTOR
	public Player(GamePanel panel) {
		
		super(panel);
		setDefaultValues(); getPlayerImage();
	}
	
	// PLAYER SETTINGS
	private void setDefaultValues() {
		
		// SCREEN SETTINGS
		this.screenX =  panel.tileSize * (panel.getMaxScreenCol()/2) - (panel.tileSize/2); // in the middle of the screen (screenWidth - tile size/2)
		this.screenY = panel.tileSize * (panel.getMaxScreenRow()/2) - (panel.tileSize/2); // in the middle of the screen (screenHeight - tile size/2)
		
		// WORLD SETTINGS
		this.worldX = panel.tileSize*23; // where player starts in the world (map) horizontally
		this.worldY = panel.tileSize*21; // where player starts in the world (map) vertically
		this.solidArea = new Rectangle(panel.tileSize/4, panel.tileSize/2, panel.tileSize/2, panel.tileSize/2);
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
			
		// UP
		if(panel.getKeyH().upPressed) {
			this.direction = "up";
		}
			
		// DOWN
		else if(panel.getKeyH().downPressed) {
			this.direction = "down";
		}
			
		// LEFT
		else if(panel.getKeyH().leftPressed) {
			this.direction = "left";
		}
			
		// RIGHT
		else if(panel.getKeyH().rightPressed) {
			this.direction = "right";
		} 
			
		// NULL
		else {this.direction = "null";}
		
		// COLLISION
		panel.getCollisionChecker().checkTile(this);;
		if(!this.collision) {
			this.changePosition();
		}
			
		// FRAME IMAGE
		changeFrame();
	}
	
	// DRAW METHOD
	public void draw(Graphics2D g) {		
		
		g.drawImage(this.getImageDirection(), screenX, screenY, panel.tileSize, panel.tileSize, null);
		// g.fillRect(screenX+solidArea.x, screenY+solidArea.y, solidArea.width, solidArea.height);
	}
	
	// METHOD THAT CHANGHE IMAGE FRAME
	public void changeFrame() {
		
		this.frameCounter++; // change frame every 10 times
		
		if(this.frameCounter > 12) {
			
			this.frame++; // change the number of the frame
				
			this.frameCounter = 0; // reset the counter
		}
	}
}
