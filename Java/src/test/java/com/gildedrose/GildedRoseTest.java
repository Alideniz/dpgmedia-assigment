package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private GildedRose app;

    @Test
    public void testUpdateQuality() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6)
        };

        app = new GildedRose(items);
        // Day 0
        checkItemState(0, "+5 Dexterity Vest", 10, 20);
        checkItemState(1, "Aged Brie", 2, 0);
        checkItemState(2, "Elixir of the Mongoose", 5, 7);
        checkItemState(3, "Sulfuras, Hand of Ragnaros", 0, 80);
        checkItemState(4, "Sulfuras, Hand of Ragnaros", -1, 80);
        checkItemState(5, "Backstage passes to a TAFKAL80ETC concert", 15, 20);
        checkItemState(6, "Backstage passes to a TAFKAL80ETC concert", 10, 49);
        checkItemState(7, "Backstage passes to a TAFKAL80ETC concert", 5, 49);
        checkItemState(8, "Conjured Mana Cake", 3, 6);

        // Day 1
        app.updateQuality();
        checkItemState(0, "+5 Dexterity Vest", 9, 19);
        checkItemState(1, "Aged Brie", 1, 1);
        checkItemState(2, "Elixir of the Mongoose", 4, 6);
        checkItemState(3, "Sulfuras, Hand of Ragnaros", 0, 80);
        checkItemState(4, "Sulfuras, Hand of Ragnaros", -1, 80);
        checkItemState(5, "Backstage passes to a TAFKAL80ETC concert", 14, 21);
        checkItemState(6, "Backstage passes to a TAFKAL80ETC concert", 9, 50);
        checkItemState(7, "Backstage passes to a TAFKAL80ETC concert", 4, 50);
        checkItemState(8, "Conjured Mana Cake", 2, 4);

        // Add more days similarly...
        // Day 2
        app.updateQuality();
        checkItemState(0, "+5 Dexterity Vest", 8, 18);
        checkItemState(1, "Aged Brie", 0, 2);
        checkItemState(2, "Elixir of the Mongoose", 3, 5);
        checkItemState(3, "Sulfuras, Hand of Ragnaros", 0, 80);
        checkItemState(4, "Sulfuras, Hand of Ragnaros", -1, 80);
        checkItemState(5, "Backstage passes to a TAFKAL80ETC concert", 13, 22);
        checkItemState(6, "Backstage passes to a TAFKAL80ETC concert", 8, 50);
        checkItemState(7, "Backstage passes to a TAFKAL80ETC concert", 3, 50);
        checkItemState(8, "Conjured Mana Cake", 1, 2);

        // Day 3
        app.updateQuality();
        checkItemState(0, "+5 Dexterity Vest", 7, 17);
        checkItemState(1, "Aged Brie", -1, 4);
        checkItemState(2, "Elixir of the Mongoose", 2, 4);
        checkItemState(3, "Sulfuras, Hand of Ragnaros", 0, 80);
        checkItemState(4, "Sulfuras, Hand of Ragnaros", -1, 80);
        checkItemState(5, "Backstage passes to a TAFKAL80ETC concert", 12, 23);
        checkItemState(6, "Backstage passes to a TAFKAL80ETC concert", 7, 50);
        checkItemState(7, "Backstage passes to a TAFKAL80ETC concert", 2, 50);
        checkItemState(8, "Conjured Mana Cake", 0, 0);

        // Day 4
        app.updateQuality();
        checkItemState(0, "+5 Dexterity Vest", 6, 16);
        checkItemState(1, "Aged Brie", -2, 6);
        checkItemState(2, "Elixir of the Mongoose", 1, 3);
        checkItemState(3, "Sulfuras, Hand of Ragnaros", 0, 80);
        checkItemState(4, "Sulfuras, Hand of Ragnaros", -1, 80);
        checkItemState(5, "Backstage passes to a TAFKAL80ETC concert", 11, 24);
        checkItemState(6, "Backstage passes to a TAFKAL80ETC concert", 6, 50);
        checkItemState(7, "Backstage passes to a TAFKAL80ETC concert", 1, 50);
        checkItemState(8, "Conjured Mana Cake", -1, 0);


    }

    private void checkItemState(int index, String expectedName, int expectedSellIn, int expectedQuality) {
        Item item = app.items[index];
        assertEquals(expectedName, item.name);
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
