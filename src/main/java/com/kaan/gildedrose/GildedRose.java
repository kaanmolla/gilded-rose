package com.kaan.gildedrose;

import com.kaan.gildedrose.model.Item;
import com.kaan.gildedrose.model.ItemsMapper;
import com.kaan.gildedrose.model.Type;
import com.kaan.gildedrose.service.ItemUpdater;
import com.kaan.gildedrose.service.ItemsUpdaterFactory;

public class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void processItems() {
    for (Item item : items) {
      update(item);
    }
  }

  private void update(Item item) {
    Type type = ItemsMapper.getType(item.name);
    ItemUpdater updater = ItemsUpdaterFactory.getUpdater(type);

    updater.update(item);
  }

}
