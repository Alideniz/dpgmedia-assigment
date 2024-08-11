package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieUpdater extends DefaultItemUpdater {
    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
