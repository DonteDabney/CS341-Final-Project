package dabney;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener, KeyListener {
	// DEFAULT SERIAL NUMBER
	private static final long serialVersionUID = 1L;

	//GAME LOOP USES A FRAME AND TIMER
	private JFrame frame;
	private Timer gameLoopTimer;
	
	private List<GameObject> gameObjectList;
	private int highlighted = 0;
	private GameObject s;
	

	public Canvas() {
		// TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
		gameObjectList = new LinkedList<GameObject>();

		// TASK 2: CREATE A WINDOW FOR THE APPLICATION
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		// TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();
		
		setFocusTraversalKeysEnabled(false);
	    addKeyListener(this);

		// TASK 4: MAKE THE WINDOW VISIBLE
		frame.setVisible(true);

	}
	
	/**
	 * Adds GameObjects to the List, which are latter added to the Canvas
	 */
	public synchronized void addGameObject(GameObject sprite) {
		gameObjectList.add(sprite);
	}

	/**
	 * Draws the GameObject graphic onto the Canvas
	 */
	public synchronized void paint(Graphics g) {
	    for (int i = 0; i < gameObjectList.size(); i++) {
	        GameObject s = gameObjectList.get(i);
	        s.draw(this, g);

	        // Check if the current GameObject is highlighted
	        if (i == highlighted) {
	            // Draw a red rectangle around the highlighted GameObject
	            g.setColor(Color.RED);
	            
	            g.draw3DRect(s.getX(), s.getY(), 150, 140, true);
	            
	        }
	    }
	}
	
	
	// ****************************************************
	// Canvas must implement the inherited abstract method
	// ActionListener.actionPerformed(ActionEvent)
	public synchronized void actionPerformed(ActionEvent e) {
		for (GameObject gameObject : gameObjectList) {
			gameObject.move(this);
			gameObject.setImage();
		}
		repaint();
	}


	
	
	// ****************************************************
	// Canvas must implement the inherited abstract methods
	// for KeyListener
	
	  public void keyTyped(KeyEvent e) {
	  }

	  public void keyPressed(KeyEvent e) {
	  }

	  public void keyReleased(KeyEvent e) {
		  if (e.getKeyCode() == KeyEvent.VK_TAB) {
		    //SET THE SELECTED STATUS FOR THE CURRENT HIGHLIGHTED OBJECT TO FALSE
		    s = gameObjectList.get(highlighted);
		    s.setSelected(false);

		    //MOVE TO THE NEXT HIGHLIGHTED OBJECT
		    highlighted = (highlighted + 1) % gameObjectList.size();
		    System.out.println("highlighted: " + highlighted);

		     //SET THE SELECTED STATUS FOR THE NEW HIGHLIGHTED OBJECT TO TRUE
		     GameObject newObject = gameObjectList.get(highlighted);
		     newObject.setSelected(true);
		     System.out.println("selected: " + newObject.toString());
		 }
	}
	  
}