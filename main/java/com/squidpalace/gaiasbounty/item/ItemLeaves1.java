package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLeaves1 extends ItemMultiBlock
{
    public ItemLeaves1(Block block)
    {
        super(block);
        subNames = BlockManager.tree1Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves1");
    }
}
