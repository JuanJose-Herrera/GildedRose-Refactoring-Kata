package com.gildedrose.rule;

import com.gildedrose.Item;

public class BackStageRule extends AbstractRule {


    private static final Rule rule = new BackStageRule();

    private BackStageRule() {
    }

    public static Rule getInstance() {
        return rule;
    }

    @Override
    public void applyRule(Item item) {
        item.quality++;
        if (item.sellIn <= 10 && item.sellIn > 5) {
            item.quality++;
        }
        if (item.sellIn <= 5 && item.sellIn >= 0) {
            item.quality += 2;
        }
        item.sellIn--;
    }

    @Override
    public void runPostValidations(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
