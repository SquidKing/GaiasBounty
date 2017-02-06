package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemFlowerMulti extends ItemMultiBlock
{
    public ItemFlowerMulti(Block block)
    {
        super(block);
        setUnlocalizedName("flower");
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + stack.getItemDamage();
    }

    @Override
    public IIcon getIconFromDamage(int dmg)
    {
        return BlockManager.flower.getIcon(0, dmg);
    }
}
