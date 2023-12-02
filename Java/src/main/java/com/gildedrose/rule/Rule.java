package com.gildedrose.rule;

import com.gildedrose.Item;

public interface Rule {

    void applyRule(final Item item);


    void runPostValidations(final Item item);

}
