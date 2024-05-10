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

  @Test
  void processItems_shouldIncreaseAgedBrieQualityTwiceAfterSellInDateExpires() {
    Item agedBrie = new Item("Aged Brie", 0, 5);

    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    gildedRose.processItems();

    assertEquals("Aged Brie", gildedRose.items[0].name);
    assertEquals(-1, gildedRose.items[0].sellIn);
    assertEquals(7, gildedRose.items[0].quality);
  }

  @Test
  void processItems_shouldNotIncreaseAgedBrieQualityOverFifty() {
    Item agedBrie = new Item("Aged Brie", -1, 49);

    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    gildedRose.processItems();

    assertEquals("Aged Brie", gildedRose.items[0].name);
    assertEquals(-2, gildedRose.items[0].sellIn);
    assertEquals(50, gildedRose.items[0].quality);
  }

  @Test
  void processItems_shouldIncreaseStrictlyExpiringItemsQualityTwiceWhenSellInDateBelowTen() {
    Item agedBrie = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 5);

    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    gildedRose.processItems();

    assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
    assertEquals(8, gildedRose.items[0].sellIn);
    assertEquals(7, gildedRose.items[0].quality);
  }

  @Test
  void processItems_shouldIncreaseStrictlyExpiringItemsQualityThreeTimesWhenSellInDateBelowFive() {
    Item agedBrie = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5);

    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    gildedRose.processItems();

    assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
    assertEquals(4, gildedRose.items[0].sellIn);
    assertEquals(8, gildedRose.items[0].quality);
  }

  @Test
  void processItems_shouldSetStrictlyExpiringItemsQualityToZeroWhenItExpires() {
    Item agedBrie = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);

    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    gildedRose.processItems();

    assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
    assertEquals(-1, gildedRose.items[0].sellIn);
    assertEquals(0, gildedRose.items[0].quality);
  }

  @Test
  void processItems_shouldNotIncreaseStrictlyExpiringItemsQualityOverFifty() {
    Item agedBrie = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49);

    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    gildedRose.processItems();

    assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
    assertEquals(2, gildedRose.items[0].sellIn);
    assertEquals(50, gildedRose.items[0].quality);
  }

  @Test
  void processItems_shouldNotChangeFixedQualityItemsQualityAndSellIn() {
    Item agedBrie = new Item("Sulfuras, Hand of Ragnaros", 3, 49);

    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    gildedRose.processItems();

    assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.items[0].name);
    assertEquals(3, gildedRose.items[0].sellIn);
    assertEquals(49, gildedRose.items[0].quality);
  }

}
