package gaiasbounty.client;

import gaiasbounty.common.CommonProxy;
import gaiasbounty.entity.EntityManager;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
