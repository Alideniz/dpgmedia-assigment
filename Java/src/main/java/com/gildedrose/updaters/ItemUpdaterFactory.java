package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ItemUpdaterFactory {
    public static ItemUpdater create(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieUpdater();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassUpdater();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasUpdater();
            case "Conjured Mana Cake":
                return new ConjuredUpdater();
            default:
                return new DefaultItemUpdater();
        }
    }
}
