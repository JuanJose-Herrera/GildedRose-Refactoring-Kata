package com.gildedrose.rule;

import com.gildedrose.Item;

public class SulfurasRule implements Rule {


    private static final Rule rule = new SulfurasRule();

    private SulfurasRule() {
    }

    public static Rule getInstance() {
        return rule;
    }

    @Override
    public void applyRule(final Item item) {

    }

    @Override
    public void runPostValidations(final Item item) {

    }
}
