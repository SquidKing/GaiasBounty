package gaiasbounty.client;

import gaiasbounty.client.model.*;
import gaiasbounty.client.render.*;
import gaiasbounty.common.CommonProxy;
import gaiasbounty.entity.*;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
   private HashMap<String, Integer> armourIds = new HashMap(1);
   
   @Override
   public void registerRenderers()
   {
      ClientTickHandler.init();
      EntityManager.registerRenderers();
   }
   
   @Override
   public Object getClientGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z)
   {
      TileEntity tile = world.getTileEntity(x, y, z);
      
      switch (id)
      {
         default:
            return null;
      }
   }
}
