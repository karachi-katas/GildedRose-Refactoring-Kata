using System.Collections.Generic;

namespace csharp
{
    public class GildedRose
    {
        IList<Item> Items;
        public GildedRose(IList<Item> Items)
        {
            this.Items = Items;
        }

        public void UpdateQualityV2()
        {
            for (var i = 0; i < Items.Count; i++)
            {
                if (Items[i].Name != "Sulfuras, Hand of Ragnaros")
                {
                    if (Items[i].SellIn > 0)
                    {
                        Items[i].SellIn--;
                    }

                    switch (Items[i].Name)
                    {
                        case "Aged Brie":
                            {
                                Items[i].Quality++;
                                if(Items[i].SellIn == 0)
                                    Items[i].Quality++;
                                break;
                            }
                        case "Backstage passes to a TAFKAL80ETC concert":
                            {
                                if (Items[i].SellIn == 0)
                                    Items[i].Quality = 0;
                                else if (Items[i].SellIn <= 5)
                                    Items[i].Quality++;
                                else if (Items[i].SellIn <= 10)
                                    Items[i].Quality += 2;
                                else
                                    Items[i].Quality++;

                                break;
                            }
                        case "Conjured Mana Cake":
                            {
                                Items[i].Quality -= 2;
                                if (Items[i].SellIn == 0)
                                    Items[i].Quality -= 2;
                                break;
                            }
                        default:
                            {
                                if (Items[i].SellIn == 0)
                                    Items[i].Quality = Items[i].Quality - 2;
                                else
                                    Items[i].Quality--;
                                break;
                            }

                    }

                    if (Items[i].Quality > 50)
                        Items[i].Quality = 50;
                    if (Items[i].Quality < 0)
                        Items[i].Quality = 0;
                }
            }
        }

        public void UpdateQuality()
        {
            for (var i = 0; i < Items.Count; i++)
            {
                if (Items[i].Name != "Aged Brie" && Items[i].Name != "Backstage passes to a TAFKAL80ETC concert")
                {
                    if (Items[i].Quality > 0)
                    {
                        if (Items[i].Name != "Sulfuras, Hand of Ragnaros")
                        {
                            Items[i].Quality = Items[i].Quality - 1;
                        }
                    }
                }
                else
                {
                    if (Items[i].Quality < 50)
                    {
                        Items[i].Quality = Items[i].Quality + 1;

                        if (Items[i].Name == "Backstage passes to a TAFKAL80ETC concert")
                        {
                            if (Items[i].SellIn < 11)
                            {
                                if (Items[i].Quality < 50)
                                {
                                    Items[i].Quality = Items[i].Quality + 1;
                                }
                            }

                            if (Items[i].SellIn < 6)
                            {
                                if (Items[i].Quality < 50)
                                {
                                    Items[i].Quality = Items[i].Quality + 1;
                                }
                            }
                        }
                    }
                }

                if (Items[i].Name != "Sulfuras, Hand of Ragnaros")
                {
                    Items[i].SellIn = Items[i].SellIn - 1;
                }

                if (Items[i].SellIn < 0)
                {
                    if (Items[i].Name != "Aged Brie")
                    {
                        if (Items[i].Name != "Backstage passes to a TAFKAL80ETC concert")
                        {
                            if (Items[i].Quality > 0)
                            {
                                if (Items[i].Name != "Sulfuras, Hand of Ragnaros")
                                {
                                    Items[i].Quality = Items[i].Quality - 1;
                                }
                            }
                        }
                        else
                        {
                            Items[i].Quality = Items[i].Quality - Items[i].Quality;
                        }
                    }
                    else
                    {
                        if (Items[i].Quality < 50)
                        {
                            Items[i].Quality = Items[i].Quality + 1;
                        }
                    }
                }
            }
        }
    }
}
