package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.lib.CreativeTabsGB;
import com.squidpalace.gaiasbounty.lib.Reference;
import com.squidpalace.gaiasbounty.potion.PotionGB;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemManager
{
    public static Item foodCrop;
    public static Item meat;
    public static Item seafood;
    public static Item foodIngredient;
    public static Item foodPrepared;
    public static Item material;
    public static Item spigot;
    public static Item knife;
    public static Item churn;

    public static void addItems()
    {
        ItemFoodMulti foodItem;

        foodItem = new ItemFoodMulti(false);
        foodItem.setUnlocalizedName(Reference.GB_NAME_PREFIX + "food_crop")
                .setCreativeTab(CreativeTabsGB.FOOD);
        foodItem.addFoodType("peach", 4, 0.3F)
                .addFoodType("cherry", 4, 0.3F)
                .addFoodType("banana", 4, 0.3F)
                .addFoodType("orange", 4, 0.3F)
                .addFoodType("lemon", 3, 0.3F,
                        new PotionEffect(Potion.blindness.id, 60, 0),
                        new PotionEffect(Potion.moveSlowdown.id, 60, 0))
                .addFoodType("lime", 3, 0.3F,
                        new PotionEffect(Potion.blindness.id, 60, 0),
                        new PotionEffect(Potion.moveSlowdown.id, 60, 0))
                .addFoodType("plum", 4, 0.3F)
                .addFoodType("mango", 4, 0.3F)
                .addFoodType("pear", 4, 0.3F)
                .addFoodType("pomegranate", 4, 0.3F)
                .addFoodType("fig", 4, 0.3F)  // 10
                .addFoodType("walnut", 2, 0.6F)
                .addFoodType("hazelnut", 2, 0.6F)
                .addFoodType("pecan", 2, 0.6F)
                .addFoodType("almond", 2, 0.6F)
                .addFoodType("macadamia", 2, 0.6F)
                .addFoodType("olive", 2, 0.6F)
                .addFoodType("coconut", 3, 0.3F)
                .addFoodType("grapes_red", 4, 0.3F)
                .addFoodType("grapes_green", 4, 0.3F)
                .addFoodType("kiwi", 4, 0.3F) // 20
                .addFoodType("cantaloupe", 2, 0.3F)
                .addFoodType("honeydew", 2, 0.3F)
                .addFoodType("gourd", 2, 0.3F)
                .addFoodType("strawberry", 2, 0.3F)
                .addFoodType("raspberry", 2, 0.3F)
                .addFoodType("blackberry", 2, 0.3F)
                .addFoodType("blueberry", 2, 0.3F)
                .addFoodType("saskatoon", 2, 0.3F)
                .addFoodType("cranberry", 2, 0.3F)
                .addFoodType("pineapple", 4, 0.3F)  // 30
                .addFoodType("tomato", 3, 0.3F)
                .addFoodType("rice", 2, 0.3F)
                .addFoodType("beet", 4, 0.6F)
                .addFoodType("turnip", 4, 0.6F)
                .addFoodType("peanut", 2, 0.6F)
                .addFoodType("truffle", 2, 0.6F)
                .addFoodType("pea", 2, 0.4F)
                .addFoodType("cucumber", 2, 0.4F)
                .addFoodType("zucchini", 2, 0.4F)
                .addFoodType("beans", 2, 0.3F,
                        new PotionEffect(PotionGB.gas.id, 1200, 0))  // 40
                .addFoodType("corn", 3, 0.3F)
                .addFoodType("lettuce", 2, 0.4F)
                .addFoodType("celery", 1, 0.2F)
                .addFoodType("cabbage", 3, 0.6F)
                .addFoodType("leek", 1, 0.2F)
                .addFoodType("rhubarb", 1, 0.4F)
                .addFoodType("broccoli", 3, 0.4F)
                .addFoodType("cauliflower", 2, 0.4F)
                .addFoodType("onion", 2, 0.4F)
                .addFoodType("bell_pepper_red", 2, 0.4F)  // 50
                .addFoodType("bell_pepper_green", 2, 0.4F)
                .addFoodType("chili_pepper", 1, 0.2F,
                        new PotionEffect(Potion.confusion.id, 120, 0),
                        new PotionEffect(Potion.weakness.id, 60, 0))
                .addFoodType("agave", 3, 0.4F);
        foodItem.setUseDuration(24, 16);
        foodItem.setUseDuration(25, 16);
        foodItem.setUseDuration(26, 16);
        foodItem.setUseDuration(27, 16);
        foodItem.setUseDuration(28, 16);
        foodItem.setUseDuration(29, 16);
        foodItem.setUseDuration(52, 16);
        foodCrop = foodItem;
        GameRegistry.registerItem(foodCrop, "food_crop");

        foodItem = new ItemFoodMulti(false);
        foodItem.setUnlocalizedName(Reference.GB_NAME_PREFIX + "meat")
                .setCreativeTab(CreativeTabsGB.FOOD);
        foodItem.addFoodType("horse_raw", 3, 0.3F)
                .addFoodType("horse_cooked", 8, 0.8F)
                .addFoodType("bacon_raw", 2, 0.3F)
                .addFoodType("bacon_cooked", 6, 0.8F)
                .addFoodType("bison_raw", 3, 0.3F)
                .addFoodType("bison_cooked", 8, 0.8F)
                .addFoodType("turkey_raw", 3, 0.3F)
                .addFoodType("turkey_cooked", 8, 0.8F)
                .addFoodType("duck_raw", 2, 0.3F)
                .addFoodType("duck_cooked", 6, 0.8F)
                .addFoodType("venison_raw", 3, 0.3F)
                .addFoodType("venison_cooked", 8, 0.8F)
                .addFoodType("mutton_raw", 2, 0.3F)
                .addFoodType("mutton_cooked", 6, 0.8F);
        meat = foodItem;
        GameRegistry.registerItem(meat, "meat");

        foodItem = new ItemFoodMulti(false);
        foodItem.setUnlocalizedName(Reference.GB_NAME_PREFIX + "seafood")
                .setCreativeTab(CreativeTabsGB.FOOD);
        foodItem.addFoodType("squid_raw", 2, 0.3F)
                .addFoodType("squid_cooked", 5, 0.6F)
                .addFoodType("prawn_raw", 2, 0.3F)
                .addFoodType("prawn_cooked", 5, 0.6F);
        seafood = foodItem;
        GameRegistry.registerItem(seafood, "seafood");

        foodItem = new ItemFoodMulti(false);
        foodItem.setUnlocalizedName(Reference.GB_NAME_PREFIX + "food_ingredient")
                .setCreativeTab(CreativeTabsGB.FOOD);
        foodItem.addFoodType("pickle", 4, 0.6F)
                .addFoodType("raisin", 2, 0.3F)
                .addFoodType("sultana", 2, 0.3F)
                .addFoodType("butter", 1, 0.2F)
                .addFoodType("cheese", 5, 0.6F)
                .addFoodType("caramel", 1, 0.2F)
                .addFoodType("chocolate", 1, 0.2F)
                .addFoodType("raw_egg", 1, 0.2F);
        foodItem.setUseDuration(1, 16);
        foodItem.setUseDuration(2, 16);
        foodIngredient = foodItem;
        GameRegistry.registerItem(foodIngredient, "food_ingredient");

        foodItem = new ItemFoodMulti(false);
        foodItem.setUnlocalizedName(Reference.GB_NAME_PREFIX + "prepared_food")
                .setCreativeTab(CreativeTabsGB.FOOD);
        foodItem.addFoodType("sushi_fish", 8, 0.8F)
                .addFoodType("sushi_salmon", 8, 0.8F)
                .addFoodType("sushi_squid", 8, 0.8F)
                .addFoodType("sushi_prawn", 8, 0.8F)
                .addFoodType("pork_honey_raw", 4, 0.3F)
                .addFoodType("pork_honey_cooked", 10, 0.8F)
                .addFoodType("pork_sandwich", 10, 0.8F)
                .addFoodType("hamburger", 10, 0.8F)
                .addFoodType("lamburger", 10, 0.8F)
                .addFoodType("chicken_bucket", 10, 0.8F)
                .addFoodType("borscht", 10, 0.8F, ((Item) Item.itemRegistry
                        .getObject("bowl")))
                .addFoodType("curry", 10, 0.8F, ((Item) Item.itemRegistry
                        .getObject("bowl")))
                .addFoodType("fried_egg", 3, 0.6F)
                .addFoodType("pie_apple", 8, 0.3F)
                .addFoodType("pie_melon", 8, 0.3F)
                .addFoodType("pie_peach", 8, 0.3F)
                .addFoodType("pie_cherry", 8, 0.3F)
                .addFoodType("pie_banana", 8, 0.3F)
                .addFoodType("pie_blackberry", 8, 0.3F)
                .addFoodType("pie_blueberry", 8, 0.3F)
                .addFoodType("pie_raspberry", 8, 0.3F)
                .addFoodType("pie_strawberry", 8, 0.3F)
                .addFoodType("pie_lemon", 8, 0.3F)
                .addFoodType("pie_lime", 8, 0.3F)
                .addFoodType("pie_pecan", 8, 0.3F)
                .addFoodType("pie_rhubarb", 8, 0.3F)
                .addFoodType("pie_mud", 6, 0.3F,
                        new PotionEffect(Potion.field_76444_x.id, 600, 0))
                .addFoodType("popcorn", 2, 0.3F)
                .addFoodType("popcorn_butter", 7, 0.7F)
                .addFoodType("caramel_apple", 5, 0.3F,
                        new PotionEffect(Potion.field_76444_x.id, 300, 0))
                .addFoodType("candy", 1, 0.2F,
                        new PotionEffect(Potion.field_76444_x.id, 300, 0))
                .addFoodType("jelly_beans", 1, 0.2F,
                        new PotionEffect(Potion.field_76444_x.id, 300, 0))
                .addFoodType("candy_corn", 1, 0.2F,
                        new PotionEffect(Potion.field_76444_x.id, 300, 0))
                .addFoodType("chocolate_bar", 3, 0.3F,
                        new PotionEffect(Potion.field_76444_x.id, 400, 0))
                .addFoodType("jaffa", 5, 0.3F,
                        new PotionEffect(Potion.field_76444_x.id, 500, 0))
                .addFoodType("cookie_ginger", 2, 0.1F,
                        new PotionEffect(Potion.field_76444_x.id, 160, 0))
                .addFoodType("cookie_oreo", 4, 0.3F,
                        new PotionEffect(Potion.field_76444_x.id, 300, 0));
        foodPrepared = foodItem;
        GameRegistry.registerItem(foodPrepared, "prepared_food");

        material = new ItemMaterialMulti(
                "mesquite", "charcoal_mesquite", "hops", "latex", "rubber",
                "maple_sap", "leaf_tea", "leaf_mint", "vanilla", "garlic",
                "cotton", "flax")
                .setUnlocalizedName(Reference.GB_NAME_PREFIX + "material")
                .setCreativeTab(CreativeTabsGB.MISC);
        GameRegistry.registerItem(material, "material");

        spigot = new ItemSpigot(50, "spigot")
                .setUnlocalizedName(Reference.GB_NAME_PREFIX + "spigot")
                .setCreativeTab(CreativeTabsGB.MISC);
        GameRegistry.registerItem(spigot, "spigot");

        knife = new ItemCraftingTool(249, "knife")
                .setUnlocalizedName(Reference.GB_NAME_PREFIX + "knife")
                .setCreativeTab(CreativeTabsGB.MISC);
        GameRegistry.registerItem(knife, "knife");

        churn = new ItemCraftingTool(131, "hand_churn")
                .setUnlocalizedName(Reference.GB_NAME_PREFIX + "hand_churn")
                .setCreativeTab(CreativeTabsGB.MISC);
        GameRegistry.registerItem(churn, "hand_churn");
    }
}
