package Tests;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.DefaultView;

public class Tester {
	DefaultView v = null;
	
	@BeforeEach
	public void before() {
		v = new gui.DefaultView(3, 1200);
		v.setPlayerLocation(new Point(1, 1));
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				v.getConf().SingleMap[i][j].replaceNoPlayer();
			}
		}
	}
	
	@Test
	public void GoUp() throws InterruptedException {
		v.createMapForTest2(2);
		v.getConf().SingleMap[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y].replaceWithPlayer();
		v.displayNewField(new Point(0, 0));
		Thread.sleep(1000);
		v.testhelp(4);
		Thread.sleep(800);
		assertTrue(v.getPlayerLocation().y == 1 && v.getPlayerLocation().x == 0);
	}
	
	@Test
	public void DontGoDown() throws InterruptedException {
		v.createMapForTest1(2);
		v.getConf().SingleMap[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y].replaceWithPlayer();
		v.displayNewField(new Point(0, 0));
		Thread.sleep(1000);
		v.testhelp(2);
		Thread.sleep(800);
		assertTrue(v.getPlayerLocation().y == 1 && v.getPlayerLocation().x == 1);
	}
	
	@Test
	public void ChangeMap() throws InterruptedException {
		v.createMapForTest3(1);
		v.setPlayerLocation(new Point(1, 2));
		v.getConf().SingleMap[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y].replaceWithPlayer();
		v.displayNewField(new Point(0, 0));
		Thread.sleep(1000);
		v.testhelp(1);
		Thread.sleep(800);
		System.out.println(v.getPlayerMap());
		System.out.println(v.getPlayerLocation());
		assertTrue(v.getPlayerLocation().x == 1 && v.getPlayerLocation().y == 0 && v.getPlayerMap().x == 0 && v.getPlayerMap().y == 1);
	}
	
	@After
	public void after() {
		v = null;
}
}
