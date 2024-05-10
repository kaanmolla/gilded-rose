package com.kaan.gildedrose.service;


import com.kaan.gildedrose.model.Item;

public class StrictlyExpiringItemsUpdater implements ItemUpdater {

  @Override
  public void update(Item item) {
    reduceSellInDate(item);

    if (item.sellIn < 0) {
      item.quality = 0;
      return;
    }

    increaseQuality(item);

    if (item.quality >= 50)
      return;

    if (item.sellIn < 11)
      item.quality = item.quality + 1;

    if (item.sellIn < 6)
      item.quality = item.quality + 1;

  }

}
