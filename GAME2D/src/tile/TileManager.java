
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
		this.file = new FileReader(panel, "world01");
		
		// SETTINGS TILES
		this.tiles = new Tile[10]; // how many different types of tile its can loads
		this.mapTileType = new int[panel.getMaxWorldCol()][panel.getMaxWorldRow()]; // set maximum of the load map (empty)
		this.mapTileType = file.loadMap();
		
		getTileImage(); // load image of all types of tile
	}
	
	//GETTER
	public int getMapTileType(int col, int row) {return mapTileType[col][row];}
	
	public Tile getTiles(int type) {return tiles[type];}
	
	// TILES IMAGES
	private void getTileImage() {
			
		try {
			
			// GRASS
			tiles[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/grass.png")));
			tiles[0].collision = false; // choose if this tile is physics
			
			// WALL
			tiles[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/wall.png")));
			tiles[1].collision = true; // choose if this tile is physics

			// WATER
			tiles[2] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/water.png")));
			tiles[2].collision = true; // choose if this tile is physics
				
			// EARTH
			tiles[3] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/earth.png")));
			tiles[3].collision = false; // choose if this tile is physics
			
			// TREE
			tiles[4] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/tree.png")));
			tiles[4].collision = true;
					; // choose if this tile is physics
			
			// SAND
			tiles[5] = new Tile(ImageIO.read(getClass().getResourceAsStream("/images_tiles/sand.png")));
			tiles[5].collision = false; // choose if this tile is physics
				
		} catch(IOException e) {e.printStackTrace();}
	}
	
	// DRAW METHOD
	public void draw(Graphics2D g) {
		
		int worldCol = 0; int worldRow = 0;
		
		while(worldRow < panel.getMaxWorldRow()) {
			
			// MAP LOCATION
			int worldX = worldCol * panel.tileSize; int worldY = worldRow * panel.tileSize; //coordinates of the objects in the map
			int screenX = worldX - panel.player.worldX + panel.player.screenX; // where on the screen the objects will be draw based on player,s position
			int screenY = worldY - panel.player.worldY + panel.player.screenY; // where on the screen the objects will be draw based on player,s position
			
			// RENDERING PERFORMANCE: draw only in limited area
			if(rendering(worldX, worldY)) {
				
				// DRAW BACKGROUND MAP
				g.drawImage(tiles[mapTileType[worldCol][worldRow]].image, screenX, screenY, panel.tileSize, panel.tileSize, null);
			}
			
			worldCol++; // change x position
			
			if(worldCol == panel.getMaxWorldCol()) {worldRow++; worldCol = 0;}
		}
	}
	
	// RENDERING METHOD
	public boolean rendering(int worldX, int worldY) {
		
		if (worldX + panel.tileSize > panel.player.worldX - panel.player.screenX && worldX - panel.tileSize < panel.player.worldX + panel.player.screenX &&
		    worldY + panel.tileSize > panel.player.worldY - panel.player.screenY && worldY - panel.tileSize < panel.player.worldY + panel.player.screenY) {
			
			return true;
		}
		
		return false;
	}
}
