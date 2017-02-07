package com.squidpalace.gaiasbounty.common;

import com.squidpalace.gaiasbounty.GaiasBounty;
import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.config.ConfigManager;
import com.squidpalace.gaiasbounty.entity.EntityManager;
import com.squidpalace.gaiasbounty.event.EventManager;
import com.squidpalace.gaiasbounty.mod.ModManager;
import com.squidpalace.gaiasbounty.recipe.RecipeManager;
import com.squidpalace.gaiasbounty.tileentity.TileEntityManager;
import com.squidpalace.gaiasbounty.village.VillageManager;
import com.squidpalace.gaiasbounty.world.WorldGenManager;
import com.squidpalace.gaiasbounty.item.ItemManager;
import com.squidpalace.gaiasbounty.potion.PotionGB;
import cpw.mods.fml.common.event.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy implements IGuiHandler
{
    /**
     * Called during Forge pre-initialization phase.
     * @param event
     */
    public void fmlLifeCycleEvent(FMLPreInitializationEvent event)
    {
        ConfigManager.init(event.getSuggestedConfigurationFile());
        PotionGB.init();
        BlockManager.addBlocks();
        ItemManager.addItems();
        EventManager.init();
        VillageManager.init();
    }

    /**
     * Called during Forge initialization phase.
     * @param event
     */
    public void fmlLifeCycleEvent(FMLInitializationEvent event)
    {
        this.registerRenderers();
        EntityManager.registerEntities();
        TileEntityManager.register();
        BlockManager.setBlockMiscData();
        WorldGenManager.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(GaiasBounty.instance, this);
        RecipeManager.init();
    }

    /**
     * Called during Forge post-initialization phase.
     * @param event
     */
    public void fmlLifeCycleEvent(FMLPostInitializationEvent event)
    {
        EntityManager.registerEntitySpawn();
        WorldGenManager.createBiomeAssociations();
        ModManager.init();
    }

    /**
     * Called before server starts.
     * @param event
     */
    public void fmlLifeCycleEvent(FMLServerAboutToStartEvent event) {}

    /**
     * Called during server start.
     * @param event
     */
    public void fmlLifeCycleEvent(FMLServerStartingEvent event) {}

    /**
     * Called after server starts.
     * @param event
     */
    public void fmlLifeCycleEvent(FMLServerStartedEvent event) {}

    /**
     * Called during server stop.
     * @param event
     */
    public void fmlLifeCycleEvent(FMLServerStoppingEvent event) {}

    /**
     * Called after server stops.
     * @param event
     */
    public void fmlLifeCycleEvent(FMLServerStoppedEvent event) {}

    public void registerRenderers() {}

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                                      int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(x, y, z);

        switch (id)
        {
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                                      int x, int y, int z)
    {
        return null;
    }
}
