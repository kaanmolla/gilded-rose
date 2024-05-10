package com.kaan.gildedrose.service;

import com.kaan.gildedrose.model.Item;

public interface ItemUpdater {

  void update(Item item);

  default void reduceSellInDate(Item item) {
    item.sellIn = item.sellIn - 1;
  }

  default void reduceQuality(Item item) {
    if (item.quality > 0)
      item.quality = item.quality - 1;
  }

  default void increaseQuality(Item item) {
    if (item.quality < 50)
      item.quality = item.quality + 1;
  }

}
