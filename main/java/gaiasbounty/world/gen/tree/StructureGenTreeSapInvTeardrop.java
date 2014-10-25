package gaiasbounty.world.gen.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class StructureGenTreeSapInvTeardrop extends StructureGenTree
{
   public static final StructureGenTree instance = new StructureGenTreeSapInvTeardrop();
   
   private Block sapBlock;
   private int[] sapMeta;
   
   public StructureGenTree setSapBlock(Block sapBlock, int ... sapMeta)
   {
      this.sapBlock = sapBlock;
      this.sapMeta = sapMeta;
      return this;
   }
   
   protected int height(Random rand)
   {
      return rand.nextInt(2) + 4;
   }
   
   protected boolean check(World world, int x, int y, int z, int height)
   {
      int checkX;
      int checkY;
      int checkZ;
      Block checkBlock;
      
      if (y < 1 || y + height + 1 > 256) return false;
      checkBlock = world.getBlock(x, y - 1, z);
      if ((checkBlock != Blocks.grass && checkBlock != Blocks.dirt)
               || y > 254 - height)
         return false;
      
      for (checkY = y; checkY <= y + 1 + height; ++checkY)
      {
         byte checkPlanarDist = 1;
         
         if (checkY == y)
         {
            checkPlanarDist = 0;
         }
         
         if (checkY >= y + 1 + height - 2)
         {
            checkPlanarDist = 2;
         }
         
         for (checkX = x - checkPlanarDist; checkX <= x + checkPlanarDist; ++checkX)
         {
            for (checkZ = z - checkPlanarDist; checkZ <= z + checkPlanarDist; ++checkZ)
            {
               if (checkY >= 0 && checkY < 256)
               {
                  checkBlock = world.getBlock(checkX, checkY, checkZ);
                  
                  if (!world.isAirBlock(checkX, checkY, checkZ)
                           && !checkBlock.isLeaves(world, checkX, checkY, checkZ))
                     return false;
               }
               else return false;
            }
         }
      }
      
      return true;
   }

   protected void makeTree(World world, Random rand, int x, int y,
            int z, int height, Block logBlock, int logMeta, Block leafBlock, int leafMeta)
   {
      world.setBlock(x, y - 1, z, Blocks.dirt);
      int genY, genX, genZ, leafLayer, leafSpread;
      Block genPosBlock;
      
      for (genY = y - 3 + height; genY <= y + height + 1; genY++)
      {
         leafLayer = genY - (y + height);
         leafSpread = leafLayer == 1 ? 1 : 1 + (3 + leafLayer) / 2;
         
         for (genX = x - leafSpread; genX <= x + leafSpread; genX++)
         {
            int placeX = genX - x;
            
            for (genZ = z - leafSpread; genZ <= z + leafSpread; genZ++)
            {
               int placeZ = genZ - z;
               Block block = world.getBlock(genX, genY, genZ);
               
               if ((Math.abs(placeX) != leafSpread
                        || Math.abs(placeZ) != leafSpread || rand.nextInt(2) != 0
                        && leafLayer == -2)
                        && (world.isAirBlock(genX, genY, genZ) || block
                                 .canBeReplacedByLeaves(world, genX,
                                          genY, genZ)))
               {
                  world.setBlock(genX, genY, genZ, leafBlock, leafMeta, 2);
               }
            }
         }
      }
      
      for (genY = 0; genY < height; ++genY)
      {
         genPosBlock = world.getBlock(x, y + genY, z);
         
         if (world.isAirBlock(x, y + genY, z)
                  || genPosBlock.isLeaves(world, x, y + genY, z))
         {
            if (genY == 1)
               world.setBlock(x, y + genY, z, this.sapBlock,
                        this.sapMeta[rand.nextInt(this.sapMeta.length)], 2);
            else
               world.setBlock(x, y + genY, z, logBlock, logMeta, 2);
         }
      }
   }
}
