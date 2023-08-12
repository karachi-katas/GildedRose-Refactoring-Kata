package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void shouldDecreseTheQualityIfItemIsNotAgeBrieAndBackstagePassesToAndSulfuras() {
            //Init
        Item[] items = new Item[] { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        int expectedQualityValue = 0;


        app.updateQuality();


        assertEquals(expectedQualityValue,items[0].quality);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    void shouldDecreseTheQualityIfItemIsNotAgeBrieAndBackstagePassesToAndSsulfuras() {
        //Init
        Item[] items = new Item[] { new Item("foo", 0, 2) };
        GildedRose app = new GildedRose(items);
        int expectedQualityValue = 0;

        app.updateQuality();


        assertEquals(expectedQualityValue,items[0].quality);
    }


    @Test
    void shouldAgeBrieIncrese() {
        //Init
        Item[] items = new Item[] { new Item("Aged Brie", 1, 1) };
        GildedRose app = new GildedRose(items);
        int expectedQualityValue = 2;


        app.updateQuality();


        assertEquals(expectedQualityValue,items[0].quality);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    void shouldNotIncreaseQualityFrom50() {
        //Init
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        int expectedQualityValue = 50;


        app.updateQuality();


        assertEquals(expectedQualityValue,items[0].quality);
    }


    @Test
    void qualityShouldNotBeInNegitive() {
        //Init
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        int expectedQualityValue = 0;

        app.updateQuality();

        assertEquals(expectedQualityValue,items[0].quality);
    }

    @Test
    void sulfurasQualityShouldNotBeChange() {
        //Init
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 11, 11) };
        GildedRose app = new GildedRose(items);
        int expectedQualityValue = 11;

        app.updateQuality();

        assertEquals(expectedQualityValue,items[0].quality);
        assertEquals(11, items[0].sellIn);
    }


    @Test
    void backstageBecomeZeroWhenSellinAreZero() {
        //Init
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 11) };
        GildedRose app = new GildedRose(items);
        int expectedQualityValue = 0;

        app.updateQuality();

        assertEquals(expectedQualityValue,items[0].quality);
    }

    @Test
    void backstageShouldIncreaseBy3When5DaysOrLess() {
        //Init
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 11) };
        GildedRose app = new GildedRose(items);
        int expectedQualityValue = 14;

        app.updateQuality();

        assertEquals(expectedQualityValue,items[0].quality);
    }

    @Test
    void backstageShouldIncreaseBy2When10DaysGreater() {
        //Init
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 11) };
        GildedRose app = new GildedRose(items);
        int expectedQualityValue = 13;

        app.updateQuality();

        assertEquals(expectedQualityValue,items[0].quality);
    }






}
