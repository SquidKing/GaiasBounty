package gaiasbounty.world.gen.tree;

import gaiasbounty.block.BlockManager;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenHazelnut extends WorldGenerator
{
   @Override
   public boolean generate(World world, Random rand, int x, int y, int z)
   {
      return StructureGenTreeTall.instance.generate(world, rand, x, y, z,
               BlockManager.logs4, 1, BlockManager.leaves4, 1);
   }
}
