package gaiasbounty.village;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.item.ItemManager;
import gaiasbounty.lib.Reference;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class VillagerGrocer implements IVillageTradeHandler
{
   public static VillagerGrocer instance = new VillagerGrocer();
   private static boolean increaseHoneyChance = false;
   private static int villagerId;
   
   private VillagerGrocer() {}
   
   public static void init(int id)
   {
      villagerId = id;
      increaseHoneyChance = !Loader.isModLoaded("Forestry");
      VillagerRegistry.instance().registerVillageTradeHandler(villagerId, instance);
      VillagerRegistry.instance().registerVillagerId(villagerId);
      VillagerRegistry.instance().registerVillagerSkin(villagerId,
               new ResourceLocation(Reference.MOD_ID, "textures/villagers/grocer.png"));
   }

   @Override
   public void manipulateTradesForVillager(EntityVillager villager,
            MerchantRecipeList recipes, Random rand)
   {
      if (villager.getProfession() == villagerId)
      {
         recipes.addToListWithCheck(new MerchantRecipe(new ItemStack(Items.emerald, 1),
                  new ItemStack(ItemManager.seafood, 7 + rand.nextInt(2), 2)));
      }
   }
}
