export class Item {
  name: string;
  sellIn: number;
  quality: number;

  constructor(name, sellIn, quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }
}

export class GildedRose {
  items: Array<Item>;

  constructor(items = [] as Array<Item>) {
    this.items = items;
  }

  checkItemName(itemName: string, nameToCompare: string){
    return itemName != nameToCompare;
  }

  updateQuality() {
    for (let i = 0; i < this.items.length; i++) {
      let itemName =this.items[i].name;
      if (this.checkItemName(itemName, "Aged Brie") && this.checkItemName(itemName, 'Backstage passes to a TAFKAL80ETC concert')) {
        if (this.items[i].quality > 0) {
          if (this.checkItemName(itemName, 'Sulfuras, Hand of Ragnaros')) {
            this.items[i].quality = this.items[i].quality - 1
          }
        }
      } else {
        if (this.items[i].quality < 50) {
          this.items[i].quality = this.items[i].quality + 1
          if (!this.checkItemName(itemName, 'Backstage passes to a TAFKAL80ETC concert')) {
            if (this.items[i].sellIn < 11) {
              if (this.items[i].quality < 50) {
                this.items[i].quality = this.items[i].quality + 1
              }
            }
            if (this.items[i].sellIn < 6) {
              if (this.items[i].quality < 50) {
                this.items[i].quality = this.items[i].quality + 1
              }
            }
          }
        }
      }
      if (this.checkItemName(itemName, 'Sulfuras, Hand of Ragnaros')) {
        this.items[i].sellIn = this.items[i].sellIn - 1;
      }
      if (this.items[i].sellIn < 0) {
        if (this.checkItemName(itemName, 'Aged Brie') && this.checkItemName(itemName, 'Backstage passes to a TAFKAL80ETC concert')) {
            if (this.items[i].quality > 0) {
              if (this.checkItemName(itemName, 'Sulfuras, Hand of Ragnaros')) {
                this.items[i].quality = this.items[i].quality - 1
              }
          } else {
            this.items[i].quality = this.items[i].quality - this.items[i].quality
          }
        } else {
          if (this.items[i].quality < 50) {
            this.items[i].quality = this.items[i].quality + 1
          }
        }
      }
    }

    return this.items;
  }
}
