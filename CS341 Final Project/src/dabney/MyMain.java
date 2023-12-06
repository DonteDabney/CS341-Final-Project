package dabney;

public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//TASK 2:  ADD A USER GAME OBJECT
		Type_D_GameObject user = new Type_D_GameObject(200, 100);
		user.setVelocity(10);
		canvas.addKeyListener(user);
		canvas.addGameObject(user);
		user.setSelected(true);
		
		Type_A_GameObject user2 = new Type_A_GameObject(500, 0);
		user2.setVelocity(10);
		canvas.addKeyListener(user2);
		canvas.addGameObject(user2);
		
		Type_C_GameObject user3 = new Type_C_GameObject(0, 400);
		user3.setVelocity(10);
		canvas.addKeyListener(user3);
		canvas.addGameObject(user3);
		
		Type_B_GameObject user4 = new Type_B_GameObject(0, 200);
		Type_B_Adapter user4Adapter = new Type_B_Adapter(user4);
		//ADD THE ADAPTER TO THE CANVAS
		user4Adapter.setVelocity(10);
		canvas.addKeyListener(user4Adapter);
		canvas.addGameObject(user4Adapter);

	}

}

