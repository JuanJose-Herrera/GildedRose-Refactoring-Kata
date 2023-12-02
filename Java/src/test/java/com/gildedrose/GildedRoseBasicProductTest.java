package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseBasicProductTest {

    @Test
    void normalDegradation() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(19, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);

        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(18, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
    }

    @Test
    void dateHasPassedDegradationTwice() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 1) };
        GildedRose app = new GildedRose(items);

        //first day
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);


        //second day
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative2() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 0) };
        GildedRose app = new GildedRose(items);

        //first day
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        //second day
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

}
