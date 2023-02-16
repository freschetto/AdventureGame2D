
package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import file.FileReader;
import main.GamePanel;

public class TileManager {

	private GamePanel panel; private FileReader file;
	
	private Tile[] tiles; 
	private int mapTileType[][];
	
	// CONSTRUCTOR
	public TileManager(GamePanel panel) {
		
		this.panel = panel;
		this.file = new FileReader(panel, "test01");
		
		// SETTINGS TILES
		this.tiles = new Tile[10]; // how many different types of tile its can loads
		this.mapTileType = new int[panel.getMaxScreenCol()][panel.getMaxScreenRow()]; // set maximum of the load map (empty)
		this.mapTileType = file.loadMap();
		
		getTileImage(); // load image of all types of tile
	}
	
	// TILES IMAGES
	private void getTileImage() {
			
		try {
			
			// GRASS
			tiles[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/grass.png")));
			
			// WALL
			tiles[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/wall.png")));

			// WATER
			tiles[2] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/water.png")));
				
			// EARTH
			tiles[3] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/earth.png")));
			
			// TREE
			tiles[4] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/tree.png")));
			
			// SAND
			tiles[5] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/sand.png")));
				
		} catch(IOException e) {e.printStackTrace();}
	}
	
	// DRAW METHOD
	public void draw(Graphics2D g) {
		
		int col = 0; int row = 0;
		
		while(row < panel.getMaxScreenRow()) {
			
			g.drawImage(tiles[mapTileType[col][row]].image, col*panel.tileSize, row*panel.tileSize, panel.tileSize, panel.tileSize, null); col++;
			
			if(col == panel.getMaxScreenCol()) {row++; col = 0;}
		}
		
	}
}
