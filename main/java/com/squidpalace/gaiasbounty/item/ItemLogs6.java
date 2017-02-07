package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLogs6 extends ItemMultiBlock
{
    public ItemLogs6(Block block)
    {
        super(block);
        subNames = BlockManager.tree6Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "logs6");
    }
}
