package com.comp301.a04junit;

import com.comp301.a04junit.adventure.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SorcererPlayerTests {

  @Test
  public void testConstructorStoresFields() {
    PlayerImpl p = new PlayerImpl("nandan", 2, 3);
    assertEquals("nandan", p.getName());
    assertEquals(2, p.getPosition().getX());
    assertEquals(3, p.getPosition().getY());
  }

  @Test
  public void testGetName() {
    PlayerImpl p = new PlayerImpl("aditya", 0, 0);
    assertEquals("aditya", p.getName());
  }

  @Test
  public void testMoveAllDirections() {
    PlayerImpl p = new PlayerImpl("arya", 0, 0);
    p.move(Direction.NORTH);
    assertEquals(0, p.getPosition().getX());
    assertEquals(1, p.getPosition().getY());
    p.move(Direction.SOUTH);
    assertEquals(0, p.getPosition().getX());
    assertEquals(0, p.getPosition().getY());
    p.move(Direction.EAST);
    assertEquals(1, p.getPosition().getX());
    assertEquals(0, p.getPosition().getY());
    p.move(Direction.WEST);
    assertEquals(0, p.getPosition().getX());
    assertEquals(0, p.getPosition().getY());
  }

  @Test
  public void testPositionChangesWithMove() {
    PlayerImpl p = new PlayerImpl("nandan", 5, 5);
    Position start = p.getPosition();
    p.move(Direction.NORTH);
    Position after = p.getPosition();
    assertNotEquals(start.getY(), after.getY());
  }

  @Test
  public void testNullNameThrows() {
    assertThrows(IllegalArgumentException.class, () -> {
      new PlayerImpl(null, 0, 0);
    });
  }
}
