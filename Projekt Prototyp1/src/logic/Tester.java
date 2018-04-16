package logic;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import gui.DefaultView;

public class Tester {

	DefaultView v = null;
	
	@Before
	public void before() {
		v = new gui.DefaultView();
	}
	
	@Test
	public void test() {
		v.testmap1(2);
		v.testhelp(4);
		assertTrue(v.getPlayerLocationY() == 2);
	}
	
	@Test
	public void test2() {
		v.testmap2(1);
		v.testhelp(2);
		assertTrue(v.getPlayerLocationY() == 1);
	}
	
	@After
	public void after() {
		v = null;
	}

}
