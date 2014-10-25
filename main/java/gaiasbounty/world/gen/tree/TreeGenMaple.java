package gaiasbounty.world.gen.tree;

import gaiasbounty.block.BlockManager;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenMaple extends WorldGenerator
{
   @Override
   public boolean generate(World world, Random rand, int x, int y, int z)
   {
      return ((StructureGenTreeSapBig) StructureGenTreeSapBig.instance)
               .setSapBlock(BlockManager.logsSap, 12, 13, 14, 15).generate(
                        world, rand, x, y, z, BlockManager.logs6, 3,
                        BlockManager.leaves6, 3);
   }
}
