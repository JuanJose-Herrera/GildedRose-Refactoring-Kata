package com.gildedrose.rule;

import com.gildedrose.Item;

public class AbstractRule implements Rule {

    @Override
    public void applyRule(Item item) {
        item.quality--;
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality--;
        }
    }

    @Override
    public void runPostValidations(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        }
        if (item.sellIn < 0 && item.quality < 0) {
            item.quality = 0;
        }
    }
}
