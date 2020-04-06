package functional;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;

import game.*;
import game.gfx.ImageLoader;
import main.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class rinkTest {
	
	private Table table;
	private Puck puck;
	Handler handler;
	private BufferedImage testImage;
	@BeforeEach
	void setUp() throws Exception {
		testImage = ImageLoader.loadImage("/texture/rink.png");
		table = new Table(handler, testImage.getWidth(), testImage.getHeight());
		puck = new Puck(handler, 0,0,25,25);
		
	}

	@Test
	void test() {
		assertEquals(puck.getHitBox().intersects(table.getHitBox()), false);
	}

}
