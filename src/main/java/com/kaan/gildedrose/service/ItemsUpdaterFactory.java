package com.kaan.gildedrose.service;

import com.kaan.gildedrose.model.Type;

import java.util.HashMap;
import java.util.Map;

import static com.kaan.gildedrose.model.Type.*;

public class ItemsUpdaterFactory {

  private static final Map<Type, ItemUpdater> updatersMap;
  static {
    updatersMap = new HashMap<>();
    updatersMap.put(REGULAR, new RegularItemsUpdater());
    updatersMap.put(FIXED_QUALITY, new FixedQualityItemsUpdater());
    updatersMap.put(STRICTLY_EXPIRING, new StrictlyExpiringItemsUpdater());
    updatersMap.put(WELL_AGING, new WellAgingItemsUpdater());
  }

  private ItemsUpdaterFactory() {
  }

  public static ItemUpdater getUpdater(Type type) {
    return updatersMap.get(type);
  }

}
