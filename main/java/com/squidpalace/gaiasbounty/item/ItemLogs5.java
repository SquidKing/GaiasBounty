package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLogs5 extends ItemMultiBlock
{
    public ItemLogs5(Block block)
    {
        super(block);
        subNames = BlockManager.tree5Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "logs5");
    }
}
