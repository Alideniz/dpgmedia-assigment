package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ConjuredUpdater extends DefaultItemUpdater {
    @Override
    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
    }
}
