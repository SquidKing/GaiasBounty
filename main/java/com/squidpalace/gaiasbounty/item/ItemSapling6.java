package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;

public class ItemSapling6 extends ItemMultiBlock
{
    public ItemSapling6(Block block)
    {
        super(block);
        subNames = BlockManager.tree6Subtypes;
        setUnlocalizedName("saplings6");
    }

    @Override
    public IIcon getIconFromDamage(int dmg)
    {
        return BlockManager.saplings6.getIcon(0, dmg);
    }
}
