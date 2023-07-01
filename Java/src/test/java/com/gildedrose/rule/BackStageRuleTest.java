package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackStageRuleTest {

    @Test
    void increaseQualityBy1DaysMoreThan10Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20);

        Rule rule = BackStageRule.getInstance();

        //day 1
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(21, item.quality);
        assertEquals(19, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(21, item.quality);
        assertEquals(19, item.sellIn);

        //day 2
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(22, item.quality);
        assertEquals(18, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(22, item.quality);
        assertEquals(18, item.sellIn);
    }

    @Test
    void increaseQualityBy2DaysLessThan10DaysMoreThan5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        Rule rule = BackStageRule.getInstance();

        //day 1
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(22, item.quality);
        assertEquals(9, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(22, item.quality);
        assertEquals(9, item.sellIn);


        //day 2
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(24, item.quality);
        assertEquals(8, item.sellIn);


        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(24, item.quality);
        assertEquals(8, item.sellIn);

        //day 3
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(26, item.quality);
        assertEquals(7, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(26, item.quality);
        assertEquals(7, item.sellIn);

        //day 4
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(28, item.quality);
        assertEquals(6, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(28, item.quality);
        assertEquals(6, item.sellIn);

        //day 5
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(30, item.quality);
        assertEquals(5, item.sellIn);


        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(30, item.quality);
        assertEquals(5, item.sellIn);
    }


    @Test
    void increaseQualityBy3LessThan5Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30);
        Rule rule = BackStageRule.getInstance();

        //day 1
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(33, item.quality);
        assertEquals(4, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(33, item.quality);
        assertEquals(4, item.sellIn);


        //day 2
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(36, item.quality);
        assertEquals(3, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(36, item.quality);
        assertEquals(3, item.sellIn);

        //day 3
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(39, item.quality);
        assertEquals(2, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(39, item.quality);
        assertEquals(2, item.sellIn);

        //day 4
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(42, item.quality);
        assertEquals(1, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(42, item.quality);
        assertEquals(1, item.sellIn);


        //day 5
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(45, item.quality);
        assertEquals(0, item.sellIn);


        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        assertEquals(45, item.quality);
        assertEquals(0, item.sellIn);

        //day 5
        rule.applyRule(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality should drop to 0 after the concert, but this happens only after run post validations
        assertEquals(48, item.quality);
        assertEquals(-1, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        //Quality drops to 0 after the concert
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);
    }

}
