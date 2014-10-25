package gaiasbounty.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockLeavesFruitCoconut extends BlockLeavesFruit
{  
   public BlockLeavesFruitCoconut(String ... strings)
   {
      super(strings);
   }
   
   @Override
   protected int growRate(int meta)
   {
      if ((meta & 3) == 3) return 20;
      else return 70;
   }
   
   public boolean growFruit(World world, int x, int y, int z)
   {
      if (world.blockExists(x, y - 1, z)
               && world.isAirBlock(x, y - 1, z))
      {
         if ((world.getBlockMetadata(x, y, z) & 3) == 3)
         {
            if (growCoconut(world, x, y - 1, z, ForgeDirection.SOUTH))  // +z
               return true;
            if (growCoconut(world, x, y - 1, z, ForgeDirection.WEST))   // -x
               return true;
            if (growCoconut(world, x, y - 1, z, ForgeDirection.NORTH))  // -z
               return true;
            if (growCoconut(world, x, y - 1, z, ForgeDirection.EAST))   // +x
               return true;
            return false;
         }
         else
         {
            world.setBlock(x, y - 1, z, this.fruitBlock,
                     world.getBlockMetadata(x, y, z) & 3, 3);
            return true;
         }
      }
      else return false;
   }
   
   private boolean growCoconut(World world, int x, int y, int z, ForgeDirection dir)
   {
      int meta, facing;
      Block block;
      
      if (dir == ForgeDirection.SOUTH)
      {
         block = world.getBlock(x, y, z + 1);
         meta = world.getBlockMetadata(x, y, z + 1);
         facing = 0;
      }
      else if (dir == ForgeDirection.WEST)
      {
         block = world.getBlock(x - 1, y, z);
         meta = world.getBlockMetadata(x - 1, y, z);
         facing = 1;
      }
      else if (dir == ForgeDirection.NORTH)
      {
         block = world.getBlock(x, y, z - 1);
         meta = world.getBlockMetadata(x, y, z - 1);
         facing = 2;
      }
      else if (dir == ForgeDirection.EAST)
      {
         block = world.getBlock(x + 1, y, z);
         meta = world.getBlockMetadata(x + 1, y, z);
         facing = 3;
      }
      else return false;
      
      if (block == BlockManager.logs5 && (meta & 3) == 3)
      {
         world.setBlock(x, y, z, BlockManager.coconut, facing, 3);
         return true;
      }
      
      return false;
   }
}
