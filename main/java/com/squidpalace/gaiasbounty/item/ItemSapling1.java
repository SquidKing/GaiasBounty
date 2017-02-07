package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;

public class ItemSapling1 extends ItemMultiBlock
{
    public ItemSapling1(Block block)
    {
        super(block);
        subNames = BlockManager.tree1Subtypes;
        setUnlocalizedName("saplings1");
    }

    @Override
    public IIcon getIconFromDamage(int dmg)
    {
        return BlockManager.saplings1.getIcon(0, dmg);
    }
}
