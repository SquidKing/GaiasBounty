package gaiasbounty.recipe;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingFuels implements IFuelHandler
{  
   public static SmeltingFuels instance = new SmeltingFuels();
   
   private SmeltingFuels() {}
   
   public static void addFuelHandler()
   {
      GameRegistry.registerFuelHandler(instance);
   }

   @Override
   public int getBurnTime(ItemStack fuel)
   {
      if (fuel.isItemEqual(ItemsGB.MESQUITE_CHARCOAL))
         return 2400;   // Mesquite Charcoal
      else
         return 0;
   }
}
