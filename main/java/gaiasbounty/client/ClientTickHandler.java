package gaiasbounty.client;

import gaiasbounty.block.BlockLeavesStandard;
import gaiasbounty.block.BlockManager;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ClientTickHandler
{  
   public static final ClientTickHandler INSTANCE = new ClientTickHandler();
   
   private ClientTickHandler() {}
   
   public static void init()
   {
      FMLCommonHandler.instance().bus().register(INSTANCE);
   }
   
   @SubscribeEvent
   public void clientTick(ClientTickEvent event)
   {
      boolean fancyGraphics = Minecraft.getMinecraft().gameSettings.fancyGraphics;
      ((BlockLeavesStandard)BlockManager.leaves1).setGraphicsLevel(fancyGraphics);
      ((BlockLeavesStandard)BlockManager.leaves2).setGraphicsLevel(fancyGraphics);
      ((BlockLeavesStandard)BlockManager.leaves3).setGraphicsLevel(fancyGraphics);
      ((BlockLeavesStandard)BlockManager.leaves4).setGraphicsLevel(fancyGraphics);
      ((BlockLeavesStandard)BlockManager.leaves5).setGraphicsLevel(fancyGraphics);
      ((BlockLeavesStandard)BlockManager.leaves6).setGraphicsLevel(fancyGraphics);
   }
}
