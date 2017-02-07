package com.squidpalace.gaiasbounty.block;

import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTrellis extends BlockPane
{
    private final String texFace;
    private final String texEdge;
    @SideOnly(Side.CLIENT)
    private IIcon icon;

    public BlockTrellis(String texFace, String texEdge,
                        Material material, boolean dropSelf)
    {
        super(texFace, texEdge, material, dropSelf);
        this.texFace = texFace;
        this.texEdge = texEdge;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon func_150097_e()
    {
        return this.icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icons)
    {
        this.blockIcon = icons.registerIcon(Reference.GB_TEX_PREFIX + texFace);
        this.icon = icons.registerIcon(Reference.GB_TEX_PREFIX + texEdge);
    }
}
