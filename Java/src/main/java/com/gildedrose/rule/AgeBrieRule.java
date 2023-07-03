package com.gildedrose.rule;

import com.gildedrose.Item;

public class AgeBrieRule extends AbstractRule {

    private static final Rule rule = new AgeBrieRule();

    private AgeBrieRule() {
    }

    public static Rule getInstance() {
        return rule;
    }

    @Override
    public void applyRule(final Item item) {
        item.quality++;
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality++;
        }
    }

}
