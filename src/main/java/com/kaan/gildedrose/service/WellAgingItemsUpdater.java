package com.kaan.gildedrose.service;

import com.kaan.gildedrose.model.Item;

public class WellAgingItemsUpdater implements ItemUpdater {

  @Override
  public void update(Item item) {
    increaseQuality(item);
    reduceSellInDate(item);

    if (item.sellIn < 0)
      increaseQuality(item);

  }

}
