package com.kaan.gildedrose.service;

import com.kaan.gildedrose.model.Item;

public class RegularItemsUpdater implements ItemUpdater {

  @Override
  public void update(Item item) {
    reduceQuality(item);
    reduceSellInDate(item);

    if (item.sellIn < 0)
      reduceQuality(item);
  }

}
