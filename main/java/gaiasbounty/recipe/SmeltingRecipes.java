package gaiasbounty.recipe;

import gaiasbounty.item.ItemManager;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingRecipes
{
    public static void addRecipes()
    {
        // Raisins, Sultanas
        GameRegistry.addSmelting(new ItemStack(ItemManager.foodCrop, 1, 18),
                new ItemStack(ItemManager.foodIngredient, 1, 1), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemManager.foodCrop, 1, 19),
                new ItemStack(ItemManager.foodIngredient, 1, 2), 0.35F);

        // Charcoal
        GameRegistry.addSmelting(ItemsGB.LOG_ALMOND, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_APPLE, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_BANANA, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_CHERRY, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_FIG, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_HAZELNUT, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_LEMON, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_LIME, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_MACADAMIA, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_MANGO, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_OLIVE, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_ORANGE, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_PALM, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_PEACH, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_PEAR, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_PECAN, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_PLUM, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_POMEGRANATE, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_WALNUT, ItemsGB.CHARCOAL, 0.15F);
        GameRegistry.addSmelting(ItemsGB.LOG_MESQUITE,
                new ItemStack(ItemManager.material, 1, 1), 0.25F);

        // Rubber
        GameRegistry.addSmelting(ItemsGB.LATEX, new ItemStack(ItemManager.material, 1, 4), 0.35F);

        // Meat
        GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 0),
                new ItemStack(ItemManager.meat, 1, 1), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 2),
                new ItemStack(ItemManager.meat, 1, 3), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 4),
                new ItemStack(ItemManager.meat, 1, 5), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 6),
                new ItemStack(ItemManager.meat, 1, 7), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 8),
                new ItemStack(ItemManager.meat, 1, 9), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 10),
                new ItemStack(ItemManager.meat, 1, 11), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 12),
                new ItemStack(ItemManager.meat, 1, 13), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemManager.seafood, 1, 0),
                new ItemStack(ItemManager.seafood, 1, 1), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemManager.seafood, 1, 2),
                new ItemStack(ItemManager.seafood, 1, 3), 0.35F);

        // Honey Pork
        GameRegistry.addSmelting(new ItemStack(ItemManager.foodPrepared, 1, 4),
                new ItemStack(ItemManager.foodPrepared, 1, 5), 0.35F);

        // Fried Egg
        GameRegistry.addSmelting(new ItemStack(ItemManager.foodIngredient, 1, 7),
                new ItemStack(ItemManager.foodPrepared, 1, 12), 0.35F);
    }
}
