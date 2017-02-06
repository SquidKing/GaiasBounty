package gaiasbounty.recipe;

import gaiasbounty.block.BlockManager;
import gaiasbounty.item.ItemManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingFuels implements IFuelHandler
{
    public static SmeltingFuels instance = new SmeltingFuels();
    private static final ItemStack MESQUITE_CHARCOAL = new ItemStack(ItemManager.material, 1, 1);

    private SmeltingFuels() {}

    public static void addFuelHandler()
    {
        GameRegistry.registerFuelHandler(instance);
    }

    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.isItemEqual(MESQUITE_CHARCOAL))
            return 2400;    // Mesquite Charcoal
        else if (fuel.getItem() == Item.getItemFromBlock(BlockManager.saplings1)
                || fuel.getItem() == Item.getItemFromBlock(BlockManager.saplings2)
                || fuel.getItem() == Item.getItemFromBlock(BlockManager.saplings3)
                || fuel.getItem() == Item.getItemFromBlock(BlockManager.saplings4)
                || fuel.getItem() == Item.getItemFromBlock(BlockManager.saplings5)
                || fuel.getItem() == Item.getItemFromBlock(BlockManager.saplings6))
            return 100;     // Saplings
        else
            return 0;
    }
}
