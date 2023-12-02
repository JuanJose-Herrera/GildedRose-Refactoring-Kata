package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjureRuleTest {

    @Test
    void normalDegradation() {
        Item item = new Item("Conjured Mana Cake", 10, 20);
        Rule rule = ConjureRule.getInstance();

        //day one
        rule.applyRule(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(18, item.quality);
        assertEquals(9, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(18, item.quality);
        assertEquals(9, item.sellIn);

        //day two
        rule.applyRule(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(16, item.quality);
        assertEquals(8, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(16, item.quality);
        assertEquals(8, item.sellIn);
    }

    @Test
    void dateHasPassedDegradationTwice() {
        Item item = new Item("Conjured Mana Cake", 0, 10);
        Rule rule = ConjureRule.getInstance();

        //day three
        rule.applyRule(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(6, item.quality);
        assertEquals(-1, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(6, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative() {
        Item item = new Item("Conjured Mana Cake", 0, 1);
        Rule rule = ConjureRule.getInstance();

        //first day
        rule.applyRule(item);
        assertEquals("Conjured Mana Cake", item.name);
        //the quality drops as expected braking the rule, the quality should be 0 after run post validations
        assertEquals(-3, item.quality);
        assertEquals(-1, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);

        //second day
        rule.applyRule(item);
        assertEquals("Conjured Mana Cake", item.name);
        //the quality drops as expected braking the rule, the quality should be 0 after run post validations
        assertEquals(-4, item.quality);
        assertEquals(-2, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(0, item.quality);
        assertEquals(-2, item.sellIn);
    }

    @Test
    void dateHasPassedDegradationTwiceAvoidNegative2() {
        Item item = new Item("Conjured Mana Cake", 0, 0);
        Rule rule = ConjureRule.getInstance();

        //first day
        rule.applyRule(item);
        assertEquals("Conjured Mana Cake", item.name);
        //the quality drops as expected braking the rule, the quality should be 0 after run post validations
        assertEquals(-4, item.quality);
        assertEquals(-1, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);

        //second day
        rule.applyRule(item);
        assertEquals("Conjured Mana Cake", item.name);
        //the quality drops as expected braking the rule, the quality should be 0 after run post validations
        assertEquals(-4, item.quality);
        assertEquals(-2, item.sellIn);

        rule.runPostValidations(item);
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(0, item.quality);
        assertEquals(-2, item.sellIn);
    }

}
