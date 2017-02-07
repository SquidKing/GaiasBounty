package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLogs2 extends ItemMultiBlock
{
    public ItemLogs2(Block block)
    {
        super(block);
        subNames = BlockManager.tree2Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "logs2");
    }
}
