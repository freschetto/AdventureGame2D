
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean action, upPressed, downPressed, leftPressed, rightPressed;
	
	// WHEN A KEY TYPED
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	// WHEN A KEY PRESSED
	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
			
		// key 'W'
		if(code == KeyEvent.VK_W) { 
			upPressed = true;
		}
		
		// key 'S'
		if(code == KeyEvent.VK_S) { 
			downPressed = true;
		}
		
		// key 'A'
		if(code == KeyEvent.VK_A) { 
			leftPressed = true;
		}
		
		// key 'D'
		if(code == KeyEvent.VK_D) { 
			rightPressed = true;
		}
		
	}
	
	// WHEN A KEY RELEASED
	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
			
		// key 'W'
		if(code == KeyEvent.VK_W) { 
			upPressed = false;
		}
		
		// key 'S'
		if(code == KeyEvent.VK_S) { 
			downPressed = false;
		}
		
		// key 'A'
		if(code == KeyEvent.VK_A) { 
			leftPressed = false;
		}
		
		// key 'D'
		if(code == KeyEvent.VK_D) { 
			rightPressed = false;
		}
	}

}
