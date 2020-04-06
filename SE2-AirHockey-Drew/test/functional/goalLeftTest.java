package functional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.*;
import main.*;

class goalLeftTest {

	private Goal goalLeft;
	Handler handler;
	private Puck puck1;
	private Puck puck2;
	private Puck puck3;
	private Puck puck4;
	private Puck puck5;
	@BeforeEach
	void setUp() throws Exception {
		
		System.out.println("Inside the setup..");
		goalLeft = new Goal(handler, 43, 212, 53,116,true);
		
		puck1 = new Puck(handler,72, 254,25,25);
		puck2 = new Puck(handler,84, 299,25,25);
		puck3 = new Puck(handler,45, 232,25,25);
		puck4 = new Puck(handler,104, 372,25,25);
		puck5 = new Puck(handler,165, 101,25,25);
		
	}

	@Test
	void goalLeftID1() {
		System.out.println("Puck is at postion: (72,254)");
		assertEquals(puck1.getHitBox().intersects(goalLeft.getHitBox()), true);
	}
	@Test
	void goalLeftID2() {
		System.out.println("Puck is at postion: (84,299)");
		assertEquals(puck2.getHitBox().intersects(goalLeft.getHitBox()), true);
	}
	@Test
	void goalLeftID3() {
		System.out.println("Puck is at postion: (45,232)");
		assertEquals(puck3.getHitBox().intersects(goalLeft.getHitBox()), true);
	}
	@Test
	void goalLeftID4() {
		System.out.println("Puck is at postion: (104,372)");
		assertEquals(puck4.getHitBox().intersects(goalLeft.getHitBox()), false);
	}
	@Test
	void goalLeftID5() {
		System.out.println("Puck is at postion: (165,101)");
		assertEquals(puck5.getHitBox().intersects(goalLeft.getHitBox()), false);
	}
}
