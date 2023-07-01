package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasRuleTest {


    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void nonDegradationNonSellDays() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Rule rule = SulfurasRule.getInstance();


        //Day 1
        rule.applyRule(item);
        assertEquals("Sulfuras, Hand of Ragnaros", item.name);
        ////Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
        assertEquals(80, item.quality);
        assertEquals(0, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Sulfuras, Hand of Ragnaros", item.name);
        ////Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
        assertEquals(80, item.quality);
        assertEquals(0, item.sellIn);


        //Day 2
        rule.applyRule(item);
        assertEquals("Sulfuras, Hand of Ragnaros", item.name);
        //Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
        assertEquals(80, item.quality);
        assertEquals(0, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Sulfuras, Hand of Ragnaros", item.name);
        //Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
        assertEquals(80, item.quality);
        assertEquals(0, item.sellIn);
    }

}
