package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseBackstageProductTest {


    @Test
    void increaseQualityBy1DaysMoreThan10Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20) };
        GildedRose app = new GildedRose(items);

        //day 1
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(21, app.items[0].quality);
        assertEquals(19, app.items[0].sellIn);

        //day 2
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(22, app.items[0].quality);
        assertEquals(18, app.items[0].sellIn);
    }

    @Test
    void increaseQualityBy2DaysLessThan10DaysMoreThan5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        //day 1
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(22, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);


        //day 2
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(24, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);

        //day 3
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(26, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);

        //day 4
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(28, app.items[0].quality);
        assertEquals(6, app.items[0].sellIn);

        //day 5
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(30, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }


    @Test
    void increaseQualityBy3LessThan5Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30) };
        GildedRose app = new GildedRose(items);

        //day 1
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(33, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);


        //day 2
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(36, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);

        //day 3
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(39, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);

        //day 4
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(42, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);

        //day 5
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(45, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        //day 5
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        //Quality drops to 0 after the concert
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}
