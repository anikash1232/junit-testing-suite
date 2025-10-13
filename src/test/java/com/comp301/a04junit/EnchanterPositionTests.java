package com.comp301.a04junit;

import com.comp301.a04junit.adventure.PositionImpl;
import com.comp301.a04junit.adventure.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnchanterPositionTests {

  @Test
  public void constructorStoresXY() {
    PositionImpl p = new PositionImpl(2, 3);
    assertEquals(2, p.getX());
    assertEquals(3, p.getY());
  }

  @Test
  public void getNeighborMovesOneUnitCardinals() {
    PositionImpl p = new PositionImpl(5, 10);

    PositionImpl east = (PositionImpl) p.getNeighbor(Direction.EAST);
    assertEquals(6, east.getX());
    assertEquals(10, east.getY());

    PositionImpl west = (PositionImpl) p.getNeighbor(Direction.WEST);
    assertEquals(4, west.getX());
    assertEquals(10, west.getY());

    PositionImpl north = (PositionImpl) p.getNeighbor(Direction.NORTH);
    assertEquals(5, north.getX());
    assertEquals(11, north.getY());

    PositionImpl south = (PositionImpl) p.getNeighbor(Direction.SOUTH);
    assertEquals(5, south.getX());
    assertEquals(9, south.getY());

    // make sure original position doesn't change
    assertEquals(5, p.getX());
    assertEquals(10, p.getY());
  }
}
