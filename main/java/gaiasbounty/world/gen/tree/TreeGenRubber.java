package gaiasbounty.world.gen.tree;

import gaiasbounty.block.BlockManager;
import gaiasbounty.world.gen.shape.ShapeGenTreeSapInvTeardrop;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenRubber extends WorldGenerator
{
   @Override
   public boolean generate(World world, Random rand, int x, int y, int z)
   {
      return ((ShapeGenTreeSapInvTeardrop) ShapeGenTreeSapInvTeardrop.instance)
               .setSapBlock(BlockManager.logsSap, 8, 9, 10, 11).generate(world,
                        rand, x, y, z, BlockManager.logs6, 2,
                        BlockManager.leaves6, 2);
   }
}
