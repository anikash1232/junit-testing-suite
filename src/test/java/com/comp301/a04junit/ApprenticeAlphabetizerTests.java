package com.comp301.a04junit;


import com.comp301.a04junit.alphabetizer.Alphabetizer;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/** Write tests for the Alphabetizer class here */
public class ApprenticeAlphabetizerTests {
  @Test
  public void testInOrder() {
    String[] arr = {"charanjit", "anirudh", "bibek"};
    Alphabetizer alpha = new Alphabetizer(arr);
    assertEquals("anirudh", alpha.next());
    assertEquals("bibek", alpha.next());
    assertEquals("charanjit", alpha.next());
  }

  @Test
  public void testHasNext() {
    Alphabetizer alpha = new Alphabetizer(new String[]{"bibek", "anirudh"});
    assertTrue(alpha.hasNext());
    alpha.next();
    assertTrue(alpha.hasNext());
    alpha.next();
    assertFalse(alpha.hasNext());
  }

  @Test
  public void testNextWhenEmpty() {
    Alphabetizer alpha = new Alphabetizer(new String[]{"bibek", "anirudh"});
    alpha.next();
    alpha.next();
    try {
      alpha.next();
      fail("Shoud throw an exception if it is empty");
    } catch (NoSuchElementException e) {
    }
  }

  @Test
  public void testDuplicates() {
    String[] arr = {"anirudh", "bibek", "anirudh"};
    Alphabetizer alpha = new Alphabetizer(arr);
    assertEquals("anirudh", alpha.next());
    assertEquals("anirudh", alpha.next());
    assertEquals("bibek", alpha.next());
  }

  @Test
  public void testArrayNotChanged() {
    String[] arr = {"charanjit", "bibek", "anirudh"};
    String[] copy = arr.clone();
    Alphabetizer alpha = new Alphabetizer(arr);
    assertArrayEquals(copy, arr);
  }
}