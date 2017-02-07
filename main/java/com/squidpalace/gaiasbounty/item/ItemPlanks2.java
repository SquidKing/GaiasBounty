package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemPlanks2 extends ItemMultiBlock
{
    public ItemPlanks2(Block block)
    {
        super(block);
        subNames = BlockManager.planks2Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "planks2");
    }
}