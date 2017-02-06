package gaiasbounty;

import gaiasbounty.common.*;
import gaiasbounty.lib.Reference;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class GaiasBounty
{
    @Instance(Reference.MOD_ID)
    public static GaiasBounty instance;
    @SidedProxy(clientSide = "gaiasbounty.client.ClientProxy",
            serverSide = "gaiasbounty.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    public static void consoleMessage(String msg, Object... data)
    {
        consoleMessage(Level.INFO, msg, data);
    }

    public static void consoleMessage(Level level, String msg, Object... data)
    {
        FMLLog.log(Reference.MOD_NAME, level, msg, data);
    }
}
