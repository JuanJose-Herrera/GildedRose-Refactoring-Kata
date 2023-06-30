package com.gildedrose.rule;

import com.gildedrose.Item;

public interface Rule {

    void applyRule(Item item);


    void runPostValidations(Item item);

}
