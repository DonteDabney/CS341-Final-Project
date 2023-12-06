package dabney;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject extends GameObject implements KeyListener {

	boolean automaticMovement;
	
	public Type_B_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B_Up.png"));
	    imageList.add(new ImageIcon("images/Type_B_Down.png"));
	    imageList.add(new ImageIcon("images/Type_B_Left.png"));
	    imageList.add(new ImageIcon("images/Type_B_Right.png"));
	    
	}
	
	public void move(Canvas c) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (isSelected()) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			    setDirection(Direction.RIGHT);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
	}
	

	//SPECIFYING THE IMAGE TO DISPLAY
	// USED FOR ANIMATION
	public void setImage() {
	    switch (getDirection()) {
	      case Direction.NONE:
	        break;
	      case Direction.UP:
	        currentImage = 0;
	        break;
	      case Direction.DOWN:
	        currentImage = 1;
	        break;
	      case Direction.LEFT:
	        currentImage = 2;
	        break;
	      case Direction.RIGHT:
	        currentImage = 3;
	        break;
	    }
	  }
	
}