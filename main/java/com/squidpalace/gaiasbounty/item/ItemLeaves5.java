package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLeaves5 extends ItemMultiBlock
{
    public ItemLeaves5(Block block)
    {
        super(block);
        subNames = BlockManager.tree5Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves5");
    }
}
