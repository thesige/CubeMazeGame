package logic;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import gui.DefaultView;

public class Tester {

	DefaultView v = null;
	
	@Before
	public void before() {
		v = new gui.DefaultView();
	}
	
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(1000);
		v.testmap1(1);
		v.testhelp(1);
		v.setVisible(true);
		Thread.sleep(800);
		assertTrue(v.getPlayerLocation().y == 2 && v.getPlayerLocation().x == 1);
	}
	
	@Test
	public void test2() throws InterruptedException {
		Thread.sleep(1000);
		v.testmap2(1);
		v.testhelp(3);
		Thread.sleep(800);
		assertTrue(v.getPlayerLocation().y == 0 && v.getPlayerLocation().x == 1);
	}
	
	@After
	public void after() {
		v = null;
	}

}
