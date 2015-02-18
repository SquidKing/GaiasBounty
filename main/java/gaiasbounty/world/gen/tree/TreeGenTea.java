package gaiasbounty.world.gen.tree;

import gaiasbounty.block.BlockManager;
import gaiasbounty.world.gen.shape.ShapeGenTreeInvTeardrop;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenTea extends WorldGenerator
{
   @Override
   public boolean generate(World world, Random rand, int x, int y, int z)
   {
      return ShapeGenTreeInvTeardrop.instance.generate(world, rand, x, y, z,
               BlockManager.logs6, 1, BlockManager.leaves6, 1);
   }
}
