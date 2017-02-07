package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLeaves4 extends ItemMultiBlock
{
    public ItemLeaves4(Block block)
    {
        super(block);
        subNames = BlockManager.tree4Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves4");
    }
}
