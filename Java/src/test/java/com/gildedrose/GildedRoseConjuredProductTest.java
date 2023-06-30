package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseConjuredProductTest {


    @Test
    void normalDegradation() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
        GildedRose app = new GildedRose(items);

        //day one
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(18, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);

        //day two
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(16, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
    }

    @Test
    void dateHasPassedDegradationTwice() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 10) };
        GildedRose app = new GildedRose(items);

        //day three
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 1) };
        GildedRose app = new GildedRose(items);

        //first day
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);


        //second day
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 0) };
        GildedRose app = new GildedRose(items);

        //first day
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        //second day
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

}
