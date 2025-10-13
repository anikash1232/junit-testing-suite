package com.comp301.a04junit;

import com.comp301.a04junit.adventure.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SorcererInventoryTests {

  @Test
  public void testConstructorAndIsEmpty() {
    InventoryImpl inv = new InventoryImpl();
    assertTrue(inv.isEmpty());
    assertEquals(0, inv.getNumItems());
  }

  @Test
  public void testAddItem() {
    InventoryImpl inv = new InventoryImpl();
    ItemImpl item = new ItemImpl("nandan");
    inv.addItem(item);
    assertFalse(inv.isEmpty());
    assertEquals(1, inv.getNumItems());
  }

  @Test
  public void testRemoveItem() {
    InventoryImpl inv = new InventoryImpl();
    ItemImpl i = new ItemImpl("nandan");
    inv.addItem(i);
    inv.removeItem(i);
    assertTrue(inv.isEmpty());
    assertEquals(0, inv.getNumItems());
  }

  @Test
  public void testClear() {
    InventoryImpl inv = new InventoryImpl();
    inv.addItem(new ItemImpl("nandan"));
    inv.addItem(new ItemImpl("aditya"));
    inv.clear();
    assertTrue(inv.isEmpty());
    assertEquals(0, inv.getNumItems());
  }

  @Test
  public void testTransferFromMovesItems() {
    InventoryImpl inv1 = new InventoryImpl();
    InventoryImpl inv2 = new InventoryImpl();
    inv2.addItem(new ItemImpl("arya"));
    inv2.addItem(new ItemImpl("nandan"));
    inv1.transferFrom(inv2);
    assertTrue(inv2.isEmpty());
    assertEquals(2, inv1.getNumItems());
  }

  @Test
  public void testTransferFromNullDoesNothing() {
    InventoryImpl inv = new InventoryImpl();
    ItemImpl item = new ItemImpl("nandan");
    inv.addItem(item);

    int beforeCount = inv.getNumItems();
    boolean hadItem = inv.getItems().contains(item);

    inv.transferFrom(null);

    assertEquals(beforeCount, inv.getNumItems());
    assertTrue(inv.getItems().contains(item));
    assertTrue(hadItem);
  }
}
