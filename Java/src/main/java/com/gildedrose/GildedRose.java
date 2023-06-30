package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            //update Quality for Aged Brie and Backstage
            if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                //item can never have its Quality increase above 50
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    //"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }

            } else {
                if (item.name.startsWith("Conjured")) {
                    item.quality = item.quality - 2;
                    //The Quality of an item is never negative
                    if(item.quality<0){
                        item.quality = 0;
                    }
                } else
                //normal product quality degradation
                //Sulfuras never degrade
                if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                }
            }

            //Sulfuras never has to be sold all other proudcts get the sellIn properties updated
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            //Once the sell by date has passed, Quality degrades twice as fast
            if (item.sellIn < 0) {
                //"Aged Brie" actually increases in Quality the older it gets
                if (item.name.equals("Aged Brie")) {
                    //item can never have its Quality increase above 50
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                } else {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {

                           // "Conjured" items degrade in Quality twice as fast as normal items
                            if (item.name.startsWith("Conjured")) {
                                item.quality = item.quality - 2;
                                //The Quality of an item is never negative
                                if(item.quality<0){
                                    item.quality = 0;
                                }
                            } else
                                //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
                                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                // normal product Once the sell by date has passed, Quality degrades twice as fast
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                }
            }
        }//end for

    }


}
