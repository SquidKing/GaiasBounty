package gaiasbounty.village;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import gaiasbounty.config.ConfigManager;
import gaiasbounty.item.ItemManager;
import gaiasbounty.lib.Reference;
import cpw.mods.fml.common.Loader;

public class VillageManager
{
   public static void init()
   {
      VillagerGrocer.init(ConfigManager.villagerGrocerID);
   }
}
