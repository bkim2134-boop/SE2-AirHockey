package functional;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;

import game.*;
import game.gfx.ImageLoader;
import main.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class rinkTest {
	private BufferedImage testImage;
	private Puck puck,puck2,puck3,puck4,puck5,puck6;
	private Table table;
	private Table2 table2;
	private Table3 table3;
	private Table4 table4;
	Handler handler;
	@BeforeEach
	void setUp() throws Exception {
		testImage = ImageLoader.loadImage("/texture/rink.png");
		//GameState GameState = new GameState(handler);
		puck = new Puck(handler,0,256,25,25);
		puck2 = new Puck(handler,900,0,25,25);
		puck3 = new Puck(handler,645,testImage.getHeight(),25,25);
		puck4 = new Puck(handler,testImage.getWidth(),315,25,25);
		puck5 = new Puck(handler,-25,642,25,25);
		puck6 = new Puck(handler,1004,-42,25,25);

		//this.Box = new Rectangle(-1,-1,testImage.getWidth()+2,testImage.getHeight()+2);
		table = new Table(handler, testImage.getWidth(), testImage.getHeight());
		table2 = new Table2(handler,testImage.getWidth(), testImage.getHeight());
		table3 = new Table3(handler,testImage.getWidth(), testImage.getHeight());
		table4 = new Table4(handler, testImage.getWidth(), testImage.getHeight());
		
	}

	@Test
	void test() {

		assertEquals(puck.getHitBox().intersects(table.getHitBox()),true);
		assertEquals(puck.getHitBox().intersects(table2.getHitBox()),false);
		assertEquals(puck.getHitBox().intersects(table3.getHitBox()),false);
		assertEquals(puck.getHitBox().intersects(table4.getHitBox()),false);
		
		assertEquals(puck2.getHitBox().intersects(table.getHitBox()),false);
		assertEquals(puck2.getHitBox().intersects(table2.getHitBox()),true);
		assertEquals(puck2.getHitBox().intersects(table3.getHitBox()),false);
		assertEquals(puck2.getHitBox().intersects(table4.getHitBox()),false);
		
		assertEquals(puck3.getHitBox().intersects(table.getHitBox()),false);
		assertEquals(puck3.getHitBox().intersects(table2.getHitBox()),false);
		assertEquals(puck3.getHitBox().intersects(table3.getHitBox()),false);
		assertEquals(puck3.getHitBox().intersects(table4.getHitBox()),true);
		
		assertEquals(puck4.getHitBox().intersects(table.getHitBox()),false);
		assertEquals(puck4.getHitBox().intersects(table2.getHitBox()),false);
		assertEquals(puck4.getHitBox().intersects(table3.getHitBox()),true);
		assertEquals(puck4.getHitBox().intersects(table4.getHitBox()),false);
		
		assertEquals(puck5.getHitBox().intersects(table.getHitBox()),false);
		assertEquals(puck5.getHitBox().intersects(table2.getHitBox()),false);
		assertEquals(puck5.getHitBox().intersects(table3.getHitBox()),false);
		assertEquals(puck5.getHitBox().intersects(table4.getHitBox()),false);
		
		assertEquals(puck6.getHitBox().intersects(table.getHitBox()),false);
		assertEquals(puck6.getHitBox().intersects(table2.getHitBox()),false);
		assertEquals(puck6.getHitBox().intersects(table3.getHitBox()),false);
		assertEquals(puck6.getHitBox().intersects(table4.getHitBox()),false);

	}

}
