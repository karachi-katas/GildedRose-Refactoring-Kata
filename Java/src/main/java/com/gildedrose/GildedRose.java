package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (items[i].name.equals("Aged Brie")) {
                applyAgedBrieRules(i);
            }

            if (isNotSpecialItem(i)) {
                applyNotSpecialItemRules(i);
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                applyBackstagePassRules(i);
            }
        }
    }

    private void applyBackstagePassRules(int i) {
        items[i].sellIn = items[i].sellIn - 1;
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
            if (items[i].sellIn < 11 && items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
            }
            if (items[i].sellIn < 6 && items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
            }
        }

        if (items[i].sellIn < 0) {
            items[i].quality = items[i].quality - items[i].quality;
        }
    }

    private void applyNotSpecialItemRules(int i) {
        items[i].sellIn = items[i].sellIn - 1;
        if (items[i].quality > 0) {
            items[i].quality = items[i].quality - 1;
        }

        if (items[i].sellIn < 0 && items[i].quality > 0) {
            items[i].quality = items[i].quality - 1;
        }
    }

    private void applyAgedBrieRules(int i) {
        items[i].sellIn = items[i].sellIn - 1;
        if (items[i].sellIn < 0 && items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }

        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }

    private boolean isNotSpecialItem(int i) {
        return !items[i].name.equals("Aged Brie")
            && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
            && !items[i].name.equals("Sulfuras, Hand of Ragnaros");
    }
}
