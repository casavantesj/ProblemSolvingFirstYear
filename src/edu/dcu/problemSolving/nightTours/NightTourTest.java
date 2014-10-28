package edu.dcu.problemSolving.nightTours;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class NightTourTest {

	@Test
	public void testGiveMePositionSouthEast() {
		NightTour game = new NightTour();
		assertEquals(14, game.getPositionSouthEast(1));
		assertEquals(18, game.getPositionSouthEast(5));
		assertEquals(0, game.getPositionSouthEast(36));
		assertEquals(0, game.getPositionSouthEast(35));
		assertEquals(0, game.getPositionSouthEast(12));
		assertEquals(29, game.getPositionSouthEast(16));
		assertEquals(0, game.getPositionSouthEast(24));
	}

	@Test
	public void testGetPositionSouthWest() {
		NightTour game = new NightTour();
		assertEquals(13, game.getPositionSouthWest(2));
		assertEquals(22, game.getPositionSouthWest(11));
		assertEquals(0, game.getPositionSouthWest(7));
		assertEquals(0, game.getPositionSouthWest(35));
		assertEquals(35, game.getPositionSouthWest(24));
	}

	@Test
	public void testGetPositionNorthEast() {
		NightTour game = new NightTour();
		assertEquals(2, game.getPositionNorthEast(13));
		assertEquals(3, game.getPositionNorthEast(14));
		assertEquals(10, game.getPositionNorthEast(21));
		assertEquals(0, game.getPositionNorthEast(1));
		assertEquals(0, game.getPositionNorthEast(2));
		assertEquals(0, game.getPositionNorthEast(12));
		assertEquals(0, game.getPositionNorthEast(36));
		assertEquals(0, game.getPositionNorthEast(24));
	}

	@Test
	public void testGetPositionNorthWest() {
		NightTour game = new NightTour();
		assertEquals(1, game.getPositionNorthWest(14));
		assertEquals(2, game.getPositionNorthWest(15));
		assertEquals(23, game.getPositionNorthWest(36));
		assertEquals(0, game.getPositionNorthWest(2));
		assertEquals(0, game.getPositionNorthWest(7));
		assertEquals(0, game.getPositionNorthWest(31));
		assertEquals(11, game.getPositionNorthWest(24));
	}

	@Test
	public void testGetPositionWestNorth() {
		NightTour game = new NightTour();
		assertEquals(0, game.getPositionWestNorth(14));
		assertEquals(21, game.getPositionWestNorth(29));
		assertEquals(0, game.getPositionWestNorth(1));
		assertEquals(28, game.getPositionWestNorth(36));
		assertEquals(16, game.getPositionWestNorth(24));
	}

	@Test
	public void testGetPositionWestSouth() {
		NightTour game = new NightTour();
		assertEquals(0, game.getPositionWestSouth(14));
		assertEquals(19, game.getPositionWestSouth(15));
		assertEquals(0, game.getPositionWestSouth(20));
		assertEquals(0, game.getPositionWestSouth(31));
		assertEquals(34, game.getPositionWestSouth(30));
	}

	@Test
	public void testGetPositionEastSouth() {
		NightTour game = new NightTour();
		assertEquals(17, game.getPositionEastSouth(9));
		assertEquals(16, game.getPositionEastSouth(8));
		assertEquals(0, game.getPositionEastSouth(32));
		assertEquals(9, game.getPositionEastSouth(1));
		assertEquals(0, game.getPositionEastSouth(6));
	}

	@Test
	public void testGetPositionEastNorth() {
		NightTour game = new NightTour();
		assertEquals(0, game.getPositionEastNorth(30));
		assertEquals(5, game.getPositionEastNorth(9));
		assertEquals(0, game.getPositionEastNorth(24));
		assertEquals(0, game.getPositionEastNorth(1));
		assertEquals(4, game.getPositionEastNorth(8));
		assertEquals(0, game.getPositionEastNorth(6));
		assertEquals(0, game.getPositionEastNorth(36));
	}
	
	@Test
	public void testIfIsOccupied(){
		NightTour game = new NightTour();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		positions.add(5);
		positions.add(7);
		positions.add(8);
		positions.add(9);
		assertEquals(true, game.isOccupied(positions,5));
		assertEquals(false, game.isOccupied(positions,6));
		assertEquals(true, game.isOccupied(positions,8));
		assertEquals(true, game.isOccupied(positions,9));	
	}

	@Test
	public void testIfIsTheLastRow() {
		NightTour game = new NightTour();
		assertEquals(false, game.isLastRow(14));
		assertEquals(true, game.isLastRow(31));
		assertEquals(false, game.isLastRow(30));
		assertEquals(true, game.isLastRow(36));
	}
	
	@Test
	public void testIfIsFull() {
		NightTour game = new NightTour();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		assertEquals(false, game.isFull(positions));
	}

	@Test
	public void testIfIsMultiplo() {
		NightTour game = new NightTour();
		assertEquals(true, game.isLastColumn(12));
		assertEquals(false, game.isLastColumn(14));
	}
	
	@Test
	public void testPosition() {
		NightTour game = new NightTour();
		assertTrue("game finished", game.findPosition(new ArrayList<Integer>(), 7));
	}

	@Test
	public void testOtherPosition() {
		NightTour game = new NightTour();
		assertTrue("game finished", game.findPosition(new ArrayList<Integer>(), 30));
	}
	
	
}
