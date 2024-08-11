package com.gildedrose.updaters;

import com.gildedrose.Item;

public class DefaultItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}

