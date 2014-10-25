package gaiasbounty.world.gen.tree;

import gaiasbounty.block.BlockManager;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenLime extends WorldGenerator
{
   @Override
   public boolean generate(World world, Random rand, int x, int y, int z)
   {
      return StructureGenTreeBig.instance.generate(world, rand, x, y, z,
               BlockManager.logs2, 2, BlockManager.leaves2, 2);
   }
}
