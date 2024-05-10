package com.kaan.gildedrose.service;

import com.kaan.gildedrose.model.Item;

public class FastDecayingItemsUpdater implements ItemUpdater {

  @Override
  public void update(Item item) {
    reduceQuality(item);
    reduceSellInDate(item);
  }

}
