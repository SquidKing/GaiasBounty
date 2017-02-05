package gaiasbounty.recipe;

import gaiasbounty.block.BlockManager;
import gaiasbounty.item.ItemManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeManager
{
   public static void init()
   {
      addOreDictEntries();
      RemoveRecipes.removeRecipes();
      CraftingRecipesBlocks.addRecipes();
      CraftingRecipesItems.addRecipes();
      SmeltingRecipes.addRecipes();
      SmeltingFuels.addFuelHandler();
   }
   
   private static void addOreDictEntries()
   {
      for (int i = 0; i < 4; i++)
         OreDictionary.registerOre("logWood", new ItemStack(
                  BlockManager.logs1, 1, i));
      for (int i = 0; i < 4; i++)
         OreDictionary.registerOre("logWood", new ItemStack(
                  BlockManager.logs2, 1, i));
      for (int i = 0; i < 4; i++)
         OreDictionary.registerOre("logWood", new ItemStack(
                  BlockManager.logs3, 1, i));
      for (int i = 0; i < 4; i++)
         OreDictionary.registerOre("logWood", new ItemStack(
                  BlockManager.logs4, 1, i));
      for (int i = 0; i < 4; i++)
         OreDictionary.registerOre("logWood", new ItemStack(
                  BlockManager.logs5, 1, i));
      
      for (int i = 0; i < 16; i++)
         OreDictionary.registerOre("plankWood", new ItemStack(
                  BlockManager.planks1, 1, i));
      for (int i = 0; i < 7; i++)
         OreDictionary.registerOre("plankWood", new ItemStack(
                  BlockManager.planks2, 1, i));
      
      OreDictionary.registerOre("cropPeach", new ItemStack(
               ItemManager.foodCrop, 1, 0));
      OreDictionary.registerOre("cropCherry", new ItemStack(
               ItemManager.foodCrop, 1, 1));
      OreDictionary.registerOre("cropBanana", new ItemStack(
               ItemManager.foodCrop, 1, 2));
      OreDictionary.registerOre("cropOrange", new ItemStack(
               ItemManager.foodCrop, 1, 3));
      OreDictionary.registerOre("cropLemon", new ItemStack(
               ItemManager.foodCrop, 1, 4));
      OreDictionary.registerOre("cropLime", new ItemStack(
               ItemManager.foodCrop, 1, 5));
      OreDictionary.registerOre("cropPlum", new ItemStack(
               ItemManager.foodCrop, 1, 6));
      OreDictionary.registerOre("cropMango", new ItemStack(
               ItemManager.foodCrop, 1, 7));
      OreDictionary.registerOre("cropPear", new ItemStack(
               ItemManager.foodCrop, 1, 8));
      OreDictionary.registerOre("cropPomegranate", new ItemStack(
               ItemManager.foodCrop, 1, 9));
      OreDictionary.registerOre("cropFig", new ItemStack(
               ItemManager.foodCrop, 1, 10));
      OreDictionary.registerOre("cropWalnut", new ItemStack(
               ItemManager.foodCrop, 1, 11));
      OreDictionary.registerOre("cropHazelnut", new ItemStack(
               ItemManager.foodCrop, 1, 12));
      OreDictionary.registerOre("cropPecan", new ItemStack(
               ItemManager.foodCrop, 1, 13));
      OreDictionary.registerOre("cropAlmond", new ItemStack(
               ItemManager.foodCrop, 1, 14));
      OreDictionary.registerOre("cropMacadamia", new ItemStack(
               ItemManager.foodCrop, 1, 15));
      OreDictionary.registerOre("cropOlive", new ItemStack(
               ItemManager.foodCrop, 1, 16));
      OreDictionary.registerOre("cropCoconut", new ItemStack(
               ItemManager.foodCrop, 1, 17));
      OreDictionary.registerOre("cropGrape", new ItemStack(
               ItemManager.foodCrop, 1, 18));
      OreDictionary.registerOre("cropGrapeRed", new ItemStack(
               ItemManager.foodCrop, 1, 18));
      OreDictionary.registerOre("cropGrape", new ItemStack(
               ItemManager.foodCrop, 1, 19));
      OreDictionary.registerOre("cropGrapeGreen", new ItemStack(
               ItemManager.foodCrop, 1, 19));
      OreDictionary.registerOre("cropKiwi", new ItemStack(
               ItemManager.foodCrop, 1, 20));
      OreDictionary.registerOre("cropCantaloupe", new ItemStack(
               ItemManager.foodCrop, 1, 21));
      OreDictionary.registerOre("cropHoneydew", new ItemStack(
               ItemManager.foodCrop, 1, 22));
      OreDictionary.registerOre("cropGourd", new ItemStack(
               ItemManager.foodCrop, 1, 23));
      OreDictionary.registerOre("cropStrawberry", new ItemStack(
               ItemManager.foodCrop, 1, 24));
      OreDictionary.registerOre("cropRaspberry", new ItemStack(
               ItemManager.foodCrop, 1, 25));
      OreDictionary.registerOre("cropBlackberry", new ItemStack(
               ItemManager.foodCrop, 1, 26));
      OreDictionary.registerOre("cropBlueberry", new ItemStack(
               ItemManager.foodCrop, 1, 27));
      OreDictionary.registerOre("cropSaskatoon", new ItemStack(
               ItemManager.foodCrop, 1, 28));
      OreDictionary.registerOre("cropCranberry", new ItemStack(
               ItemManager.foodCrop, 1, 29));
      OreDictionary.registerOre("cropPineapple", new ItemStack(
               ItemManager.foodCrop, 1, 30));
      OreDictionary.registerOre("cropTomato", new ItemStack(
               ItemManager.foodCrop, 1, 31));
      OreDictionary.registerOre("cropRice", new ItemStack(
               ItemManager.foodCrop, 1, 32));
      OreDictionary.registerOre("cropBeet", new ItemStack(
               ItemManager.foodCrop, 1, 33));
      OreDictionary.registerOre("cropTurnip", new ItemStack(
               ItemManager.foodCrop, 1, 34));
      OreDictionary.registerOre("cropPeanut", new ItemStack(
               ItemManager.foodCrop, 1, 35));
      OreDictionary.registerOre("cropTruffle", new ItemStack(
               ItemManager.foodCrop, 1, 36));
      OreDictionary.registerOre("cropPea", new ItemStack(
               ItemManager.foodCrop, 1, 37));
      OreDictionary.registerOre("cropCucumber", new ItemStack(
               ItemManager.foodCrop, 1, 38));
      OreDictionary.registerOre("cropZucchini", new ItemStack(
               ItemManager.foodCrop, 1, 39));
      OreDictionary.registerOre("cropBean", new ItemStack(
               ItemManager.foodCrop, 1, 40));
      OreDictionary.registerOre("cropCorn", new ItemStack(
               ItemManager.foodCrop, 1, 41));
      OreDictionary.registerOre("cropLettuce", new ItemStack(
               ItemManager.foodCrop, 1, 42));
      OreDictionary.registerOre("cropCelery", new ItemStack(
               ItemManager.foodCrop, 1, 43));
      OreDictionary.registerOre("cropCabbage", new ItemStack(
               ItemManager.foodCrop, 1, 44));
      OreDictionary.registerOre("cropLeek", new ItemStack(
               ItemManager.foodCrop, 1, 45));
      OreDictionary.registerOre("cropRhubarb", new ItemStack(
               ItemManager.foodCrop, 1, 46));
      OreDictionary.registerOre("cropBroccoli", new ItemStack(
               ItemManager.foodCrop, 1, 47));
      OreDictionary.registerOre("cropCauliflower", new ItemStack(
               ItemManager.foodCrop, 1, 48));
      OreDictionary.registerOre("cropOnion", new ItemStack(
               ItemManager.foodCrop, 1, 49));
      OreDictionary.registerOre("cropBellPepperRed", new ItemStack(
               ItemManager.foodCrop, 1, 50));
      OreDictionary.registerOre("cropBellPepperGreen", new ItemStack(
               ItemManager.foodCrop, 1, 51));
      OreDictionary.registerOre("cropChili", new ItemStack(
               ItemManager.foodCrop, 1, 52));
      OreDictionary.registerOre("cropAgave", new ItemStack(
               ItemManager.foodCrop, 1, 53));

      OreDictionary.registerOre("foodSheepRaw", new ItemStack(
               ItemManager.meat, 1, 0));
      OreDictionary.registerOre("foodSheep", new ItemStack(
               ItemManager.meat, 1, 1));
      OreDictionary.registerOre("foodHorseRaw", new ItemStack(
               ItemManager.meat, 1, 2));
      OreDictionary.registerOre("foodHorse", new ItemStack(
               ItemManager.meat, 1, 3));
      OreDictionary.registerOre("foodBaconRaw", new ItemStack(
               ItemManager.meat, 1, 4));
      OreDictionary.registerOre("foodBacon", new ItemStack(
               ItemManager.meat, 1, 5));
      
      OreDictionary.registerOre("foodSquidRaw", new ItemStack(
               ItemManager.seafood, 1, 0));
      OreDictionary.registerOre("foodSquid", new ItemStack(
               ItemManager.seafood, 1, 1));
      OreDictionary.registerOre("foodPrawnRaw", new ItemStack(
               ItemManager.seafood, 1, 2));
      OreDictionary.registerOre("foodPrawn", new ItemStack(
               ItemManager.seafood, 1, 3));
      
      OreDictionary.registerOre("foodPickle", new ItemStack(
               ItemManager.foodIngredient, 1, 0));
      OreDictionary.registerOre("foodRaisin", new ItemStack(
               ItemManager.foodIngredient, 1, 1));
      OreDictionary.registerOre("foodRaisin", new ItemStack(
               ItemManager.foodIngredient, 1, 2));
      OreDictionary.registerOre("foodSultana", new ItemStack(
               ItemManager.foodIngredient, 1, 2));
      OreDictionary.registerOre("foodButter", new ItemStack(
               ItemManager.foodIngredient, 1, 3));
      OreDictionary.registerOre("foodCheese", new ItemStack(
               ItemManager.foodIngredient, 1, 4));
      OreDictionary.registerOre("foodCaramel", new ItemStack(
               ItemManager.foodIngredient, 1, 5));
      OreDictionary.registerOre("foodChocolate", new ItemStack(
               ItemManager.foodIngredient, 1, 6));
      
      OreDictionary.registerOre("itemRubber", new ItemStack(
               ItemManager.material, 1, 4));
      OreDictionary.registerOre("materialRubber", new ItemStack(
               ItemManager.material, 1, 4));
   }
}
