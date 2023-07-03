package com.gildedrose.rule;

import com.gildedrose.Item;

public class ConjureRule extends AbstractRule {

    private static final Rule rule = new ConjureRule();

    private ConjureRule() {
    }

    public static Rule getInstance() {
        return rule;
    }

    @Override
    public void applyRule(final Item item) {
        item.quality -= 2;
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality -= 2;
        }
    }

}
