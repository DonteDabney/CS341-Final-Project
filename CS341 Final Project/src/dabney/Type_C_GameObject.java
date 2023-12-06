package dabney;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {

	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);
		
		imageList = new LinkedList<Icon>();
	    imageList.add(new ImageIcon("images/Type_C_Right.png"));
	    imageList.add(new ImageIcon("images/Type_C_Left.png"));
	    
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int)c.getSize().getWidth();
		
		//MOVE PURPLE GAME OBJECT AUTOMATICALLY
		if (!isSelected()) {
			if(getDirection() == Direction.LEFT) {
				setX(getX() + getVelocity());
				
				//CHECK FOR A COLLISION WITH RIGHT WALL
				if(getX() + iconWidth > canvasWidth) {
			          setX((int)(canvasWidth - iconWidth));
			          setDirection(Direction.RIGHT);
			    }
			} else {
				//MOVE PURPLE GAME OBJECT THE OPPOSITE DIRECTION
				setX(getX() - getVelocity());
		        if (getX() < 0) {
		          setX(0);
		          setDirection(Direction.LEFT);
		        }
			}
		} else {
			//HANDLE USER INPUT WHEN SELECTED
			switch (getDirection()) {
				case Direction.LEFT:
				 setX(getX() + getVelocity());
				 if (getX() + iconWidth > canvasWidth) {
					setX((int)(canvasWidth - iconWidth));
		        }
				break;
				case Direction.RIGHT:
				 setX(getX() - getVelocity());
				 if (getX() < 0) {
					setX(0);
		        }
				break;
			}
		}
		
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (isSelected()) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		    	setDirection(Direction.RIGHT);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		    	setDirection(Direction.LEFT);
		    }
		}
	}

	public void keyReleased(KeyEvent e) {
	}
	
	

	//SPECIFYING THE IMAGE TO DISPLAY
	// USED FOR ANIMATION
	public void setImage() {
		switch(getDirection()) {
			case Direction.NONE:
				break;
			case Direction.LEFT:
				currentImage = 0;
				break;
			case Direction.RIGHT:
				currentImage = 1;
				break;
		}
		
	}
	
	

}
