
package tile;

import java.awt.image.BufferedImage;

public class Tile {
	
	public BufferedImage image;
	public boolean collision;
	
	// CONSTRUCTOR
	public Tile(BufferedImage image) {
		
		this.image = image; // when create a new tile, add its image
	}
}
