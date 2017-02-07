package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;

public class ItemSapling2 extends ItemMultiBlock
{
    public ItemSapling2(Block block)
    {
        super(block);
        subNames = BlockManager.tree2Subtypes;
        setUnlocalizedName("saplings2");
    }

    @Override
    public IIcon getIconFromDamage(int dmg)
    {
        return BlockManager.saplings2.getIcon(0, dmg);
    }
}
