package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseAgeBrieProductTest {


    @Test
    void ageBrieIncreaseQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);

        //first day
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);

        //second day
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(2, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        //third day (negative sell day)
        //Once the sell by date has passed, Quality degrades twice as fast
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }


    @Test
    void ageBrieIncreaseQualityNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 48) };
        GildedRose app = new GildedRose(items);

        //first day
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(49, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);


        //second day
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);

        //third day
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);

    }


}
