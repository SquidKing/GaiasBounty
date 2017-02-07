package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemPlanks1 extends ItemMultiBlock
{
    public ItemPlanks1(Block block)
    {
        super(block);
        subNames = BlockManager.planks1Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "planks1");
    }
}