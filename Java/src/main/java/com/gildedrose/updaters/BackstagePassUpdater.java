package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackstagePassUpdater extends DefaultItemUpdater {
    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            increaseQuality(item);
            if (item.sellIn < 10) {
                increaseQuality(item);
            }
            if (item.sellIn < 5) {
                increaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
