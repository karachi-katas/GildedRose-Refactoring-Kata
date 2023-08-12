# -*- coding: utf-8 -*-
import unittest

from gilded_rose import Item, GildedRose



class TestGildedRose(unittest.TestCase):

    def setUp(self):
        self.items = []
        self.gilded_rose = GildedRose(self.items)

    def test_sellin_and_quality_decrease(self):
        self.items.append(Item("Normal Item", 10, 20))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[0].sell_in, 9)
        self.assertEqual(self.items[0].quality, 19)

    def test_quality_degrades_twice_as_fast(self):
        self.items.append(Item("Normal Item", 0, 20))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[0].quality, 18)

    def test_quality_never_negative(self):
        self.items.append(Item("Normal Item", 10, 0))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[0].quality, 0)

    def test_aged_brie_increases_in_quality(self):
        self.items.append(Item("Aged Brie", 10, 20))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[0].quality, 21)

    def test_quality_never_more_than_50(self):
        self.items.append(Item("Aged Brie", 10, 50))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[0].quality, 50)

    def test_sulfuras_never_decreases_in_quality(self):
        self.items.append(Item("Sulfuras, Hand of Ragnaros", 10, 40))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[0].quality, 40)
        self.assertEqual(self.items[0].sell_in, 10)

    def test_backstage_passes_increase_in_quality(self):
        self.items.append(Item("Backstage passes to a TAFKAL80ETC concert", 11, 20))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[0].quality, 21)

        self.items.append(Item("Backstage passes to a TAFKAL80ETC concert", 10, 20))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[1].quality, 22)

        self.items.append(Item("Backstage passes to a TAFKAL80ETC concert", 5, 20))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[2].quality, 23)

    def test_backstage_passes_quality_drops_to_zero(self):
        self.items.append(Item("Backstage passes to a TAFKAL80ETC concert", 0, 20))
        self.gilded_rose.update_quality()
        self.assertEqual(self.items[0].quality, 0)

if __name__ == "__main__":
    unittest.main()

        
if __name__ == '__main__':
    unittest.main()
