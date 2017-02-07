package com.squidpalace.gaiasbounty;

import com.squidpalace.gaiasbounty.common.CommonProxy;
import com.squidpalace.gaiasbounty.lib.Reference;

import cpw.mods.fml.common.event.*;
import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class GaiasBounty
{
    @Instance(Reference.MOD_ID)
    public static GaiasBounty instance;
    @SidedProxy(clientSide = "com.squidpalace.gaiasbounty.client.ClientProxy",
            serverSide = "com.squidpalace.gaiasbounty.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void fmlLifeCycleEvent(FMLPreInitializationEvent event)
    {
        proxy.fmlLifeCycleEvent(event);
    }

    @EventHandler
    public void fmlLifeCycleEvent(FMLInitializationEvent event)
    {
        proxy.fmlLifeCycleEvent(event);
    }

    @EventHandler
    public void fmlLifeCycleEvent(FMLPostInitializationEvent event)
    {
        proxy.fmlLifeCycleEvent(event);
    }

    /*@EventHandler
    public void fmlLifeCycleEvent(FMLServerAboutToStartEvent event)
    {
        proxy.fmlLifeCycleEvent(event);
    }

    @EventHandler
    public void fmlLifeCycleEvent(FMLServerStartingEvent event)
    {
        proxy.fmlLifeCycleEvent(event);
    }

    @EventHandler
    public void fmlLifeCycleEvent(FMLServerStartedEvent event)
    {
        proxy.fmlLifeCycleEvent(event);
    }

    @EventHandler
    public void fmlLifeCycleEvent(FMLServerStoppingEvent event)
    {
        proxy.fmlLifeCycleEvent(event);
    }

    @EventHandler
    public void fmlLifeCycleEvent(FMLServerStoppedEvent event)
    {
        proxy.fmlLifeCycleEvent(event);
    }*/

    public static void consoleMessage(String msg, Object... data)
    {
        consoleMessage(Level.INFO, msg, data);
    }

    public static void consoleMessage(Level level, String msg, Object... data)
    {
        FMLLog.log(Reference.MOD_NAME, level, msg, data);
    }
}
