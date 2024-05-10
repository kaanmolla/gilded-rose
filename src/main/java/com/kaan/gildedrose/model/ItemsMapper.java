package com.kaan.gildedrose.model;

import java.util.HashMap;
import java.util.Map;

import static com.kaan.gildedrose.model.Type.*;

public class ItemsMapper {

  private static final Map<String, Type> itemsStore;
  static {
    itemsStore = new HashMap<>();
    itemsStore.put("Aged Brie", WELL_AGING);
    itemsStore.put("Backstage passes to a TAFKAL80ETC concert", STRICTLY_EXPIRING);
    itemsStore.put("Sulfuras, Hand of Ragnaros", FIXED_QUALITY);
  }

  private ItemsMapper() {
  }

  public static Type getType(String itemName) {
    return itemsStore.getOrDefault(itemName, REGULAR);
  }

}
