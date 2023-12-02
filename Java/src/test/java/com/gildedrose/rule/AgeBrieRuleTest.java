package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeBrieRuleTest {

    @Test
    void ageBrieIncreaseQuality() {
        Item item = new Item("Aged Brie", 2, 0);

        Rule rule = AgeBrieRule.getInstance();

        //first day
        rule.applyRule(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(1, item.quality);
        assertEquals(1, item.sellIn);


        rule.runPostValidations(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(1, item.quality);
        assertEquals(1, item.sellIn);


        //second day
        rule.applyRule(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(2, item.quality);
        assertEquals(0, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(2, item.quality);
        assertEquals(0, item.sellIn);

        //third day (negative sell day)
        //Once the sell by date has passed, Quality degrades twice as fast
        rule.applyRule(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(4, item.quality);
        assertEquals(-1, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(4, item.quality);
        assertEquals(-1, item.sellIn);
    }


    @Test
    void ageBrieIncreaseQualityNeverMoreThan50() {
        Item item = new Item("Aged Brie", 10, 48);
        Rule rule = AgeBrieRule.getInstance();

        //first day
        rule.applyRule(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(49, item.quality);
        assertEquals(9, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(49, item.quality);
        assertEquals(9, item.sellIn);


        //second day
        rule.applyRule(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(50, item.quality);
        assertEquals(8, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(50, item.quality);
        assertEquals(8, item.sellIn);

        //third day
        rule.applyRule(item);
        assertEquals("Aged Brie", item.name);
        //before run runPostValidations is normal to brake some rules
        assertEquals(51, item.quality);
        assertEquals(7, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Aged Brie", item.name);
        assertEquals(50, item.quality);
        assertEquals(7, item.sellIn);

    }

}
