package com.gildedrose.rule;

public class BasicRule extends AbstractRule {

    private static final Rule rule = new BasicRule();


    private BasicRule() {
    }

    public static Rule getInstance() {
        return rule;
    }

}
