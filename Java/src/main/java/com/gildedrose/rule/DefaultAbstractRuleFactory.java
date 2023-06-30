package com.gildedrose.rule;

import com.gildedrose.Item;

public class DefaultAbstractRuleFactory {


    public Rule getRule(Item item) {

        switch (item.name) {
            case "Conjured Mana Cake":
                return ConjureRule.getInstance();
            case "Sulfuras, Hand of Ragnaros":
                return SulfurasRule.getInstance();
            case "Aged Brie":
                return AgeBrieRule.getInstance();
            case "Backstage passes to a TAFKAL80ETC concert":
                return BackStageRule.getInstance();
            default:
                return BasicRule.getInstance();
        }

    }

}
