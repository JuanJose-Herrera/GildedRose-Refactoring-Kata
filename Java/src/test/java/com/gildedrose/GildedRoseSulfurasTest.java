package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseSulfurasTest {

    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void nonDegradationNonSellDays() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();


        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        ////Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        //Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }
}
