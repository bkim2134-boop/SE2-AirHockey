package functional;

import static org.junit.jupiter.api.Assertions.*;

import game.*;
import main.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class goalRightTest {
	
	private Goal goalRight;
	Handler handler;
	private Puck puck1;
	private Puck puck2;
	private Puck puck3;
	private Puck puck4;
	private Puck puck5;
	@BeforeEach
	void setUp() throws Exception {
		
		System.out.println("Inside the setup..");
		goalRight = new Goal(handler, 43, 212, 53,116,true);
		
		puck1 = new Puck(handler,891, 252,25,25);
		puck2 = new Puck(handler,865, 309,25,25);
		puck3 = new Puck(handler,899, 315,25,25);
		puck4 = new Puck(handler,100, 407,25,25);
		puck5 = new Puck(handler,700, 555,25,25);
		
	}

	@Test
	void goalLeftID1() {
		System.out.println("Puck is at postion: (891,252)");
		assertEquals(puck1.getHitBox().intersects(goalRight.getHitBox()), true);
	}
	@Test
	void goalLeftID2() {
		System.out.println("Puck is at postion: (865,309)");
		assertEquals(puck2.getHitBox().intersects(goalRight.getHitBox()), true);
	}
	@Test
	void goalLeftID3() {
		System.out.println("Puck is at postion: (899,315)");
		assertEquals(puck3.getHitBox().intersects(goalRight.getHitBox()), true);
	}
	@Test
	void goalLeftID4() {
		System.out.println("Puck is at postion: (100,407)");
		assertEquals(puck4.getHitBox().intersects(goalRight.getHitBox()), false);
	}
	@Test
	void goalLeftID5() {
		System.out.println("Puck is at postion: (700,555)");
		assertEquals(puck5.getHitBox().intersects(goalRight.getHitBox()), false);
	}
}