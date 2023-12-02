package com.gildedrose.rule;


import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicRuleTest {

    @Test
    void normalDegradation() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);
        Rule rule = BasicRule.getInstance();

        rule.applyRule(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(19, item.quality);
        assertEquals(9, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(19, item.quality);
        assertEquals(9, item.sellIn);

        rule.applyRule(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(18, item.quality);
        assertEquals(8, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(18, item.quality);
        assertEquals(8, item.sellIn);
    }

    @Test
    void dateHasPassedDegradationTwice() {
        Item item = new Item("+5 Dexterity Vest", 0, 10);
        Rule rule = BasicRule.getInstance();

        rule.applyRule(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(8, item.quality);
        assertEquals(-1, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(8, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative() {
        Item item = new Item("+5 Dexterity Vest", 0, 1);
        Rule rule = BasicRule.getInstance();

        //first day
        rule.applyRule(item);
        assertEquals("+5 Dexterity Vest", item.name);
        //This negative value in the quality should be fixed after run the post validations
        assertEquals(-1, item.quality);
        assertEquals(-1, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);


        //second day
        rule.applyRule(item);
        assertEquals("+5 Dexterity Vest", item.name);
        //This negative value in the quality should be fixed after run the post validations
        assertEquals(-2, item.quality);
        assertEquals(-2, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(0, item.quality);
        assertEquals(-2, item.sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative2() {
        Item item = new Item("+5 Dexterity Vest", 0, 0);
        Rule rule = BasicRule.getInstance();

        //first day
        rule.applyRule(item);
        assertEquals("+5 Dexterity Vest", item.name);
        //This negative value in the quality should be fixed after run the post validations
        assertEquals(-2, item.quality);
        assertEquals(-1, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);

        //second day
        rule.applyRule(item);
        assertEquals("+5 Dexterity Vest", item.name);
        //This negative value in the quality should be fixed after run the post validations
        assertEquals(-2, item.quality);
        assertEquals(-2, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(0, item.quality);
        assertEquals(-2, item.sellIn);
    }

}
