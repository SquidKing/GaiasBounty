package gaiasbounty.block;

import gaiasbounty.item.ItemSpigot;
import gaiasbounty.lib.Reference;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSapLog extends BlockDirectional
{  
   private int logMeta1, logMeta2;
   private Block logBase;
   private ItemStack drop1, drop2;
   private String logName1, logName2;
   private IIcon[][] icons;
   
   public BlockSapLog(String log1, String log2)
   {
      super(Material.wood);
      this.setHardness(2.0F);
      this.setStepSound(soundTypeWood);
      this.setBaseLogs(BlockManager.logs6, 2, 3);
      this.setTickRandomly(true);
      this.logName1 = log1;
      this.logName2 = log2;
   }
   
   public BlockSapLog setBaseLogs(Block log, int logMeta1, int logMeta2)
   {
      this.logBase = log;
      this.logMeta1 = logMeta1;
      this.logMeta2 = logMeta2;
      return this;
   }
   
   public BlockSapLog setDrops(ItemStack drop1, ItemStack drop2)
   {
      this.drop1 = drop1;
      this.drop2 = drop2;
      return this;
   }
   
   @Override
   public void updateTick(World world, int x, int y, int z, Random rand)
   {
      int meta = world.getBlockMetadata(x, y, z);
      if (meta < 8 && rand.nextInt(16) == 0)
         world.setBlockMetadataWithNotify(x, y, z, meta | 8, 3);
   }
   
   @Override
   public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int side, float par7, float par8, float par9)
   {
      if (world.isRemote)
      {
         return true;
      }
      else
      {
         ItemStack playerItem = player.inventory.getCurrentItem();
         
         if (playerItem == null)
         {
            return true;
         }
         else
         {
            Item item = playerItem.getItem();
            int meta = world.getBlockMetadata(x, y, z);
            int sapSide = meta & 3;
            int face = side - 2;
            if (!(item instanceof ItemSpigot))
               return true;
            
            if ((meta & 8) != 8)
               return true;
            if (sapSide != face)
               return true;
            
            ItemStack resultItem = (meta & 4) == 4 ? this.drop2 : this.drop1;
            double velX = sapSide == 3 ? 0.2D : (sapSide == 2 ? -0.2D : 0.0D);
            double velZ = sapSide == 1 ? 0.2D : (sapSide == 0 ? -0.2D : 0.0D);
            EntityItem worldDrop = new EntityItem(world, x + 0.0F + velX * 2.5F,
                     y + 0.5F, z + 0.0F + velZ * 2.5F, ItemStack.copyItemStack(resultItem));
            worldDrop.setVelocity(velX * 2.5F, 0.0D, velZ * 2.5F);
            world.spawnEntityInWorld(worldDrop);
            
            world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D,
                     Reference.GB_AUDIO_PREFIX + "tool.spigot", 1.0F, 1.0F);
            
            playerItem.damageItem(1, player);
            world.setBlockMetadataWithNotify(x, y, z, meta & 7, 3);
            
            return false;
         }
      }
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public Item getItem(World world, int x, int y, int z)
   {
      return Item.getItemFromBlock(this.logBase);
   }

   @Override
   public Item getItemDropped(int par1, Random rand, int par3)
   {
      return Item.getItemFromBlock(this.logBase);
   }

   @Override
   public int damageDropped(int meta)
   {
      return (meta & 4) == 0 ? logMeta1 : logMeta2;
   }

   @Override
   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int side, int meta)
   {
      if (side < 2) return this.icons[(meta & 4) / 4][1];
      
      if (side - 2 == this.getDirection(meta))
      {
         if ((meta & 8) == 8) return this.icons[(meta & 4) / 4][3];
         else return this.icons[(meta & 4) / 4][2];
      }
      else return this.icons[(meta & 4) / 4][0];
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister icons)
   {
      this.icons = new IIcon[2][4];
      
      this.icons[0][0] = this.logBase.getIcon(2, this.logMeta1);
      this.icons[0][1] = this.logBase.getIcon(0, this.logMeta1);
      this.icons[0][2] = icons.registerIcon(Reference.GB_TEX_PREFIX
               + "tree_" + logName1 + "_dry");
      this.icons[0][3] = icons.registerIcon(Reference.GB_TEX_PREFIX
               + "tree_" + logName1 + "_sap");
      
      this.icons[1][0] = this.logBase.getIcon(2, this.logMeta2);
      this.icons[1][1] = this.logBase.getIcon(0, this.logMeta2);
      this.icons[1][2] = icons.registerIcon(Reference.GB_TEX_PREFIX
               + "tree_" + logName2 + "_dry");
      this.icons[1][3] = icons.registerIcon(Reference.GB_TEX_PREFIX
               + "tree_" + logName2 + "_sap");
   }
}
