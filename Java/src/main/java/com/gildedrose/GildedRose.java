package com.gildedrose;

import com.gildedrose.rule.DefaultAbstractRuleFactory;
import com.gildedrose.rule.Rule;

class GildedRose {
    final Item[] items;
    private final DefaultAbstractRuleFactory defaultAbstractRuleFactory;

    public GildedRose(Item[] items) {
        this.items = items;
        this.defaultAbstractRuleFactory = new DefaultAbstractRuleFactory();
    }

    public void updateQuality() {
        for (Item item : items) {
            Rule rule = this.defaultAbstractRuleFactory.getRule(item);
            rule.applyRule(item);
            rule.runPostValidations(item);
        }//end for

    }


}
