
package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		// CREATE A WINDOW
		JFrame window = new JFrame(); // create a new window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate the program when close window
		window.setResizable(false);
		window.setTitle("2D GAME");
		
		// CREATE AND ADD GAME PANEL
		GamePanel panel = new GamePanel();
		window.add(panel);
		
		window.pack(); // window size to fit the size of its subcomponents
		
		// ADD WINDOW
		window.setLocationRelativeTo(null); // set the location of the window at the center of the screen
		window.setVisible(true);
		
		// START THREAD
		panel.startGameThread();
	}

}