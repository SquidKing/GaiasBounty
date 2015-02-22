package gaiasbounty.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCrops extends TileEntity
{  
   private int cropId;
   
   @Override
   public void writeToNBT(NBTTagCompound nbtTags)
   {
      super.writeToNBT(nbtTags);
      nbtTags.setByte("cropId", (byte) (this.cropId & 255));
   }
   
   @Override
   public void readFromNBT(NBTTagCompound nbtTags)
   {
      super.readFromNBT(nbtTags);
      this.cropId = nbtTags.getByte("cropId");
   }
   
   @Override
   public Packet getDescriptionPacket()
   {
      /*NBTTagCompound nbttagcompound = new NBTTagCompound();
      this.writeToNBT(nbttagcompound);
      return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord,
               4, nbttagcompound);*/
      return null;
   }
   
   /**
    * Called when you receive a TileEntityData packet for the location this
    * TileEntity is currently in. On the client, the NetworkManager will always
    * be the remote server. On the server, it will be whomever is responsible for
    * sending the packet.
    *
    * @param net The NetworkManager the packet originated from
    * @param pkt The data packet
    */
   @Override
   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
   {
      this.readFromNBT(pkt.func_148857_g());
   }
   
   public void setCropId(int i)
   {
      this.cropId = i;
   }
   
   public int getCropId()
   {
      return this.cropId;
   }
}
