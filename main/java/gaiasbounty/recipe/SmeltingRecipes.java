package gaiasbounty.recipe;

import gaiasbounty.item.ItemManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingRecipes
{
   public static void addRecipes()
   {
      // Grapes -> Raisins, Sultanas
      GameRegistry.addSmelting(new ItemStack(ItemManager.foodCrop, 1, 18),
               new ItemStack(ItemManager.foodIngredient, 1, 1), 0.35F);
      GameRegistry.addSmelting(new ItemStack(ItemManager.foodCrop, 1, 19),
               new ItemStack(ItemManager.foodIngredient, 1, 2), 0.35F);
      
      // Logs -> Charcoal
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
      GameRegistry.addSmelting(ItemsGB.LOG_MESQUITE, ItemsGB.MESQUITE_CHARCOAL, 0.25F);
      
      // Raw Latex -> Rubber
      GameRegistry.addSmelting(ItemsGB.LATEX, new ItemStack(ItemManager.material, 1, 4), 0.35F);
      
      // Raw Meat -> Cooked Meat
      GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 0),
               new ItemStack(ItemManager.meat, 1, 1), 0.35F);
      GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 2),
               new ItemStack(ItemManager.meat, 1, 3), 0.35F);
      GameRegistry.addSmelting(new ItemStack(ItemManager.meat, 1, 4),
               new ItemStack(ItemManager.meat, 1, 5), 0.35F);
      GameRegistry.addSmelting(new ItemStack(ItemManager.seafood, 1, 0),
               new ItemStack(ItemManager.seafood, 1, 1), 0.35F);
      GameRegistry.addSmelting(new ItemStack(ItemManager.seafood, 1, 2),
               new ItemStack(ItemManager.seafood, 1, 3), 0.35F);
      GameRegistry.addSmelting(ItemsGB.HONEY_PORK_RAW, ItemsGB.HONEY_PORK_COOKED, 0.35F);
   }
}
