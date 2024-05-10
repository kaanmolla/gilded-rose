package com.kaan.gildedrose;

import com.kaan.gildedrose.model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {


  @Test
  void processItems_shouldReduceRegularItemsQuality() {
    Item regularItem = new Item("Regular", 10, 25);

    GildedRose gildedRose = new GildedRose(new Item[]{regularItem});
    gildedRose.processItems();

    assertEquals("Regular", gildedRose.items[0].name);
    assertEquals(9, gildedRose.items[0].sellIn);
    assertEquals(24, gildedRose.items[0].quality);
  }

  @Test
  void processItems_shouldNotReduceRegularItemsQualityBelowZero() {
    Item regularItem = new Item("Regular", -1, 0);

    GildedRose gildedRose = new GildedRose(new Item[]{regularItem});
    gildedRose.processItems();

    assertEquals("Regular", gildedRose.items[0].name);
    assertEquals(-2, gildedRose.items[0].sellIn);
    assertEquals(0, gildedRose.items[0].quality);
  }

  @Test
  void processItems_shouldIncreaseAgedBrieQuality() {
    Item agedBrie = new Item("Aged Brie", 10, 5);

    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    gildedRose.processItems();

    assertEquals("Aged Brie", gildedRose.items[0].name);
    assertEquals(9, gildedRose.items[0].sellIn);
    assertEquals(6, gildedRose.items[0].quality);
  }

}
