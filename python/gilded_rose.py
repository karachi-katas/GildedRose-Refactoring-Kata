# -*- coding: utf-8 -*-

class GildedRose(object):

    def __init__(self, items):
        self.items = items

    def update_quality(self):
        for item in self.items:
            if self.is_not_Backstage_pass_and_not_aged_brie(item.name):
                if item.quality > 0:
                    if self.is_not_Sulfuras_Hand_of_Ragnaros(item.name):
                        item.quality = item.quality - 1
            else:
                if item.quality < 50:
                    item.quality = item.quality + 1
                    if self.is_Backstage_pass_less_than_11_days(item.name,item.sell_in,item.quality):
                        item.quality = item.quality + 1
                    if self.is_Backstage_pass_less_than_6_days(item.name,item.sell_in,item.quality):
                        item.quality = item.quality + 1
            if self.is_not_Sulfuras_Hand_of_Ragnaros(item.name):
                item.sell_in = item.sell_in - 1
            if item.sell_in < 0:
                if item.name != "Aged Brie":
                    if item.name != "Backstage passes to a TAFKAL80ETC concert":
                        if item.quality > 0:
                            if self.is_not_Sulfuras_Hand_of_Ragnaros(item.name):
                                item.quality = item.quality - 1
                    else:
                        item.quality = item.quality - item.quality
                else:
                    if item.quality < 50:
                        item.quality = item.quality + 1

    def is_Backstage_pass_less_than_11_days(self,item_name, item_sell_in ,item_quality):
        return item_sell_in < 11 and item_quality < 50 and item_name =="Backstage passes to a TAFKAL80ETC concert"

    def is_Backstage_pass_less_than_6_days(self,item_name, item_sell_in ,item_quality):
        return item_sell_in < 6 and item_quality < 50 and item_name =="Backstage passes to a TAFKAL80ETC concert"

    def is_not_Backstage_pass_and_not_aged_brie(self,item_name):
        return item_name != "Aged Brie" and item_name != "Backstage passes to a TAFKAL80ETC concert"

    def is_not_Sulfuras_Hand_of_Ragnaros(self,item_name):
        return item_name!= "Sulfuras, Hand of Ragnaros"


class Item:
    def __init__(self, name, sell_in, quality):
        self.name = name
        self.sell_in = sell_in
        self.quality = quality

    def __repr__(self):
        return "%s, %s, %s" % (self.name, self.sell_in, self.quality)
