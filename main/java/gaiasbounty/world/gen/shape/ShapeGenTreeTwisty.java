package gaiasbounty.world.gen.shape;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class ShapeGenTreeTwisty extends ShapeGenTree
{
   public static final ShapeGenTree instance = new ShapeGenTreeTwisty();
   private int branchX1, branchZ1, branchY1, branchX2, branchZ2, branchY2;
   private Random branchRand;
   
   protected int height(Random rand)
   {
      this.branchRand = rand;
      return rand.nextInt(2) + 7;
   }
   
   protected boolean check(World world, int x, int y, int z, int height)
   {
      Block checkBlock;
      boolean branchCheck = false;
      
      if (y < 1 || y + height + 1 > 256) return false;
      checkBlock = world.getBlock(x, y - 1, z);
      if ((checkBlock != Blocks.grass && checkBlock != Blocks.dirt)
               || y > 254 - height)
         return false;
      
      checkBlock = world.getBlock(x, y + 1, z);
      if (!world.isAirBlock(x, y + 1, z) && !checkBlock.isLeaves(world, x, y + 1, z))
         return false;
      
      for (int i = 0; i < 3; i++)
      {
         branchY1 = height - 2;
         if (branchRand.nextBoolean())
         {
            branchX1 = branchRand.nextInt(2) + 1;
            if (branchRand.nextBoolean()) branchX1 *= -1;
            branchZ1 = branchRand.nextBoolean() ? 1 : 0;
            if (branchRand.nextBoolean()) branchZ1 = -1;
         }
         else
         {
            branchZ1 = branchRand.nextInt(2) + 1;
            if (branchRand.nextBoolean()) branchZ1 *= -1;
            branchX1 = branchRand.nextBoolean() ? 1 : 0;
            if (branchRand.nextBoolean()) branchX1 = -1;
         }
         if (checkSub(world, x + branchX1, y + 2, z + branchZ1, branchY1))
         {
            branchCheck = true;
            break;
         }
      }
      
      if (branchCheck) branchCheck = false;
      else return false;
      
      for (int i = 0; i < 3; i++)
      {
         branchY2 = height - 2 - branchRand.nextInt(2);
         
         do
         {
            if (branchRand.nextBoolean())
            {
               branchX2 = branchRand.nextInt(2) + 1;
               if (branchRand.nextBoolean()) branchX2 *= -1;
               branchZ2 = branchRand.nextBoolean() ? 1 : 0;
               if (branchRand.nextBoolean()) branchZ2 = -1;
            }
            else
            {
               branchZ2 = branchRand.nextInt(2) + 1;
               if (branchRand.nextBoolean()) branchZ2 *= -1;
               branchX2 = branchRand.nextBoolean() ? 1 : 0;
               if (branchRand.nextBoolean()) branchX2 = -1;
            }
         } while (!(((branchX1 > 0 && branchX2 > 0) || (branchX1 < 0 && branchX2 < 0))
                  && ((branchZ1 > 0 && branchZ2 > 0) || (branchZ1 < 0 && branchZ2 < 0))));
         
         if (checkSub(world, x + branchX2, y + 2, z + branchZ2, branchY2))
         {
            branchCheck = true;
            break;
         }
      }

      if (branchCheck) branchCheck = false;
      else return false;
      
      if (branchX1 > branchZ1)
         branchCheck = tracePath(world, x, y + 1, z, branchX1, branchZ1, false, null, 0, false);
      else if (branchZ1 > branchX1)
         branchCheck = tracePath(world, x, y + 1, z, branchX1, branchZ1, true, null, 0, false);
      else
         branchCheck = tracePath(world, x, y + 1, z, branchX1, branchZ1, branchRand.nextBoolean(), null, 0, false);

      if (branchCheck) branchCheck = false;
      else return false;
      
      if (branchX2 > branchZ2)
         branchCheck = tracePath(world, x, y + 1, z, branchX2, branchZ2, false, null, 0, false);
      else if (branchZ2 > branchX2)
         branchCheck = tracePath(world, x, y + 1, z, branchX2, branchZ2, true, null, 0, false);
      else
         branchCheck = tracePath(world, x, y + 1, z, branchX2, branchZ2, branchRand.nextBoolean(), null, 0, false);
      
      return branchCheck;
   }
   
   protected boolean checkSub(World world, int x, int y, int z, int height)
   {
      int checkX;
      int checkY;
      int checkZ;
      Block checkBlock;
      
      if (y < 1 || y + height + 1 > 256) return false;
      checkBlock = world.getBlock(x, y - 1, z);
      if (y > 254 - height)
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
   
   private boolean tracePath(World world, int x, int y, int z, int xTarget, int zTarget, boolean zFirst, Block logBlock, int logMeta, boolean draw)
   {
      int scanX = 0, scanZ = 0;
      Block block;
      
      if (zFirst)
      {
         while (scanZ != zTarget)
         {
            if (zTarget < scanZ) scanZ--;
            else scanZ++;
            block = world.getBlock(x, y, z + scanZ);
            
            if ((!world.isAirBlock(x, y, z + scanZ) && !block.isLeaves(world,
                              x, y, z + scanZ)))
               return false;
            
            if (draw)
            {
               if (scanZ == zTarget) world.setBlock(x, y, z + scanZ, logBlock, logMeta + 12, 2);
               else world.setBlock(x, y, z + scanZ, logBlock, logMeta + 8, 2);
            }
         }
         while (scanX != xTarget)
         {
            if (xTarget < scanX) scanX--;
            else scanX++;
            block = world.getBlock(x + scanX, y, z + scanZ);
            
            if (!world.isAirBlock(x + scanX, y, z + scanZ) && !block.isLeaves(world,
                              x + scanX, y, z + scanZ))
               return false;
            
            if (draw)
            {
               world.setBlock(x + scanX, y, z + scanZ, logBlock, logMeta + 12, 2);
            }
         }
      }
      else
      {
         while (scanX != xTarget)
         {
            if (xTarget < scanX) scanX--;
            else scanX++;
            block = world.getBlock(x + scanX, y, z);
            
            if (!world.isAirBlock(x + scanX, y, z) && !block.isLeaves(world,
                              x + scanX, y, z))
               return false;
            
            if (draw)
            {
               if (scanX == xTarget) world.setBlock(x + scanX, y, z, logBlock, logMeta + 12, 2);
               else world.setBlock(x + scanX, y, z, logBlock, logMeta + 4, 2);
            }
         }
         while (scanZ != zTarget)
         {
            if (zTarget < scanZ) scanZ--;
            else scanZ++;
            block = world.getBlock(x + scanX, y, z + scanZ);
            
            if (!world.isAirBlock(x + scanX, y, z + scanZ) && !block.isLeaves(world,
                              x + scanX, y, z + scanZ))
               return false;
            
            if (draw)
            {
               world.setBlock(x + scanX, y, z + scanZ, logBlock, logMeta + 12, 2);
            }
         }
      }
      
      return true;
   }

   protected void makeTree(World world, Random rand, int x, int y,
            int z, int height, Block logBlock, int logMeta, Block leafBlock, int leafMeta)
   {
      world.setBlock(x, y - 1, z, Blocks.dirt);
      world.setBlock(x, y, z, logBlock, logMeta, 2);
      world.setBlock(x, y + 1, z, logBlock, logMeta + 12, 2);
      
      if (branchX1 > branchZ1)
         tracePath(world, x, y + 1, z, branchX1, branchZ1, false, logBlock, logMeta, true);
      else if (branchZ1 > branchX1)
         tracePath(world, x, y + 1, z, branchX1, branchZ1, true, logBlock, logMeta, true);
      else
         tracePath(world, x, y + 1, z, branchX1, branchZ1, branchRand.nextBoolean(), logBlock, logMeta, true);
      
      if (branchX2 > branchZ2)
         tracePath(world, x, y + 1, z, branchX2, branchZ2, false, logBlock, logMeta, true);
      else if (branchZ2 > branchX2)
         tracePath(world, x, y + 1, z, branchX2, branchZ2, true, logBlock, logMeta, true);
      else
         tracePath(world, x, y + 1, z, branchX2, branchZ2, branchRand.nextBoolean(), logBlock, logMeta, true);
      
      makeBranch(world, rand, x + branchX1, y + 1, z + branchZ1, branchY1, logBlock, logMeta, leafBlock, leafMeta);
      makeBranch(world, rand, x + branchX2, y + 1, z + branchZ2, branchY2, logBlock, logMeta, leafBlock, leafMeta);
   }
   
   private void makeBranch(World world, Random rand, int x, int y,
            int z, int height, Block logBlock, int logMeta, Block leafBlock, int leafMeta)
   {
      int genY, genX, genZ, leafLayer, leafSpread;
      Block genPosBlock;
      
      for (genY = y - 2 + height; genY <= y + height; genY++)
      {
         leafLayer = genY - (y + height);
         leafSpread = leafLayer == -1 ? 2 : 1;
         
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
      
      for (genY = 1; genY < height; ++genY)
      {
         genPosBlock = world.getBlock(x, y + genY, z);
         
         if (world.isAirBlock(x, y + genY, z)
                  || genPosBlock.isLeaves(world, x, y + genY, z))
         {
            world.setBlock(x, y + genY, z, logBlock, logMeta, 2);
         }
      }
   }
   
}
