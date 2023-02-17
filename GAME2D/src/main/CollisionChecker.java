
package main;

import entity.Entity;

public class CollisionChecker {
	
	public GamePanel panel;
	
	// CONSTRUCTOR
	public CollisionChecker(GamePanel panel) {
			
		this.panel = panel;
	}

	// CHECK METHOD
	public void checkTile(Entity entity) {
		
		// VARIABLES THAT CONTROL THE TILE NEAR THE ENTITY
		int rectLeftCol = (entity.solidArea.x + entity.worldX)/panel.tileSize;
		int rectRightCol = (entity.solidArea.x + entity.worldX + entity.solidArea.width)/panel.tileSize;
		int rectTopRow = (entity.solidArea.y + entity.worldY)/panel.tileSize;
		int rectBottomRow = (entity.solidArea.y + entity.worldY + entity.solidArea.height)/panel.tileSize;
		
		// STOP THE MOOVMENT IF NEAR TILE
		switch(entity.direction) {
			
			// UP
			case"up":
				
				rectTopRow = (entity.solidArea.y + entity.worldY - entity.speed)/panel.tileSize;
				if(panel.background.getTiles(panel.background.getMapTileType(rectRightCol, rectTopRow)).collision || panel.background.getTiles(panel.background.getMapTileType(rectLeftCol, rectTopRow)).collision) 
					// if the entity touches physics tile
					{entity.collision = true;}
				
				else entity.collision = false;
				
				break;
			
			// DOWN
			case "down":
				
				rectBottomRow = (entity.solidArea.y + entity.worldY + entity.solidArea.height + entity.speed)/panel.tileSize;
				if(panel.background.getTiles(panel.background.getMapTileType(rectRightCol, rectBottomRow)).collision || panel.background.getTiles(panel.background.getMapTileType(rectLeftCol, rectBottomRow)).collision) 
					// if the entity touches physics tile
					{entity.collision = true;}
					
				else entity.collision = false;
				
				break;
			
			// LEFT
			case "left":
				
				rectLeftCol = (entity.solidArea.x + entity.worldX - entity.speed)/panel.tileSize;
				if(panel.background.getTiles(panel.background.getMapTileType(rectLeftCol, rectTopRow)).collision || panel.background.getTiles(panel.background.getMapTileType(rectLeftCol, rectBottomRow)).collision) 
					// if the entity touches physics tile
					{entity.collision = true;}
				
				else entity.collision = false;
	
				break;
			
			// RIGHT
			case "right":
				
				rectRightCol = (entity.solidArea.x + entity.worldX + entity.solidArea.width + entity.speed)/panel.tileSize;
				if(panel.background.getTiles(panel.background.getMapTileType(rectRightCol, rectTopRow)).collision || panel.background.getTiles(panel.background.getMapTileType(rectRightCol, rectBottomRow)).collision) 
					// if the entity touches physics tile
					{entity.collision = true;}
					
				else entity.collision = false;
				
				break;
		
		}
		
	}
}
