package com.comp301.a04junit;

import com.comp301.a04junit.adventure.ItemImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Write unit tests for the ItemImpl class here */
public class EnchanterItemTests {

  @Test
  public void testGetName() {
    ItemImpl i = new ItemImpl("nandan");
    assertEquals("nandan", i.getName());
  }

  @Test
  public void testEqualsSameName() {
    ItemImpl i1 = new ItemImpl("aditya");
    ItemImpl i2 = new ItemImpl("aditya");
    assertTrue(i1.equals(i2));
  }

  @Test
  public void testEqualsDifferentName() {
    ItemImpl i1 = new ItemImpl("arya");
    ItemImpl i2 = new ItemImpl("aditya");
    assertFalse(i1.equals(i2));
  }

  @Test
  public void testEqualsNullOrDifferentObject() {
    ItemImpl i = new ItemImpl("arya");
    assertFalse(i.equals(null));
    assertFalse(i.equals("arya"));
  }

  @Test
  public void testToString() {
    ItemImpl i = new ItemImpl("nandan");
    assertEquals("nandan", i.toString());
  }

  @Test
  public void testEqualsCapitalizedName() {
    ItemImpl i1 = new ItemImpl("nandan");
    ItemImpl i2 = new ItemImpl("NANDAN");
    assertTrue(i1.equals(i2));
  }
}
