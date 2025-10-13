package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Write unit tests for the PositionImpl class here */
public class EnchanterPositionTests {

  @Test
  public void testConstructorStoresValues() {
    PositionImpl p = new PositionImpl(2, 5);
    assertEquals(2, p.getX());
    assertEquals(5, p.getY());
  }

  @Test
  public void testGetNeighborNorth() {
    PositionImpl p = new PositionImpl(3, 3);
    Position north = p.getNeighbor(Direction.NORTH);
    assertEquals(3, north.getX());
    assertEquals(4, north.getY()); // y + 1
  }

  @Test
  public void testGetNeighborSouth() {
    PositionImpl p = new PositionImpl(4, 1);
    Position south = p.getNeighbor(Direction.SOUTH);
    assertEquals(4, south.getX());
    assertEquals(0, south.getY()); // y - 1
  }

  @Test
  public void testGetNeighborEast() {
    PositionImpl p = new PositionImpl(0, 0);
    Position east = p.getNeighbor(Direction.EAST);
    assertEquals(1, east.getX());
    assertEquals(0, east.getY());
  }

  @Test
  public void testGetNeighborWest() {
    PositionImpl p = new PositionImpl(5, 5);
    Position west = p.getNeighbor(Direction.WEST);
    assertEquals(4, west.getX());
    assertEquals(5, west.getY());
  }
}