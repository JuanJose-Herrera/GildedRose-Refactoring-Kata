package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseElixirOfTheMongooseTest {



    @Test
    void normalDegradation() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);

        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(5, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }


    @Test
    void dateHasPassedDegradationTwice() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 1) };
        GildedRose app = new GildedRose(items);

        //first day
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);


        //second day
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative2() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 0) };
        GildedRose app = new GildedRose(items);

        //first day
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        //second day
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }


}
