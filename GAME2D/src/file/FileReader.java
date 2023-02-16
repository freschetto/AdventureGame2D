
package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.GamePanel;

public class FileReader {
	
	private GamePanel panel; private BufferedReader reader;
    
    // CONSTRUCTOR
    public FileReader(GamePanel panel, String string) {
        
    	this.panel = panel;
    	this.reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/file/" +string+ ".txt"))); // create directory of the file
    }
    
    // LOAD MAP METHOD
    public int[][] loadMap() {
    	
    	try {
    		// VARIABILES
    		int mapTileType[][] = new int[panel.getMaxScreenCol()][panel.getMaxScreenRow()]; // add the type of the tile in this matrix
        	int col = 0; int row = 0;
        	
        	// READ MAP
        	while(row < panel.getMaxScreenRow()) {
    			
        		// CREATE VARIABILES FOR READ FILE
        		String line = reader.readLine(); // read one line (row) of the map
        		String numbers[] = line.split(" "); // don't considerate space between numbers and add all numbers in an array
        		
        		// READ MAP ROW
        		while(col < panel.getMaxScreenCol()) {

        			mapTileType[col][row] = Integer.parseInt(numbers[col]); col++; // add all the numbers of the row to the matrix
        		}
        		
    			if(col == panel.getMaxScreenCol()) {row++; col = 0;} // increase rows for the next cycle and reset columns
    		}
        	
        	reader.close(); // close the file reader
        	
        	return mapTileType; // returns the map in a matrix
        	
    	} catch(IOException e) {e.printStackTrace(); return null;}
    	        
    }
    
}
