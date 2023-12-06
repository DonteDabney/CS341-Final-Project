package dabney;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {

	public Type_A_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.DOWN);
		
		imageList = new LinkedList<Icon>();
	    imageList.add(new ImageIcon("images/Type_A_Up.png"));
	    imageList.add(new ImageIcon("images/Type_A_Down.png"));
	    
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
			
		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int)c.getSize().getHeight();
			
		//MOVE YELLOW GAME OBJECT AUTOMATICALLY
		if (!isSelected()) {
			if (getDirection() == Direction.UP) {
				setY(getY() - getVelocity());
				
				//CHECK FOR A COLLISION WITH CEILING
				if (getY() < 0) {
					setDirection(Direction.DOWN);
				}
			} else {
				//MOVE YELLOW GAME OBJECT THE OPPOSITE DIRECTION
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
			         setY((int)(canvasHeight - iconHeight));
			         setDirection(Direction.UP);
			   }
			}	
		} else {
			//HANDLE USER INPUT WHEN SELECTED
			switch (getDirection()) {
		      case Direction.UP:
		        setY(getY() - getVelocity());
		        if (getY() < 0) {
		          setY(0);
		        }
		        break;
		      case Direction.DOWN:
		        setY(getY() + getVelocity());
		        if (getY() + iconHeight > canvasHeight) {
		          setY((int)(canvasHeight - iconHeight));
		        }
		        break;
			}
		}
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
			case Direction.UP:
				currentImage = 0;
				break;
			case Direction.DOWN:
				currentImage = 1;
				break;
		}
		
	}
	

}
