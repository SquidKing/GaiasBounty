package gaiasbounty.client.render;

import gaiasbounty.entity.EntityTurkey;
import gaiasbounty.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderTurkey extends RenderLiving
{
   public RenderTurkey(ModelBase model, float f)
   {
      super(model, f);
   }
   
   protected float handleRotationFloat(EntityTurkey turkey, float partialTickTime)
   {
       float f1 = turkey.fallDistPrev + (turkey.fallDist - turkey.fallDistPrev) * partialTickTime;
       float f2 = turkey.destPosPrev + (turkey.destPos - turkey.destPosPrev) * partialTickTime;
       return (MathHelper.sin(f1) + 1.0F) * f2;
   }
   
   @Override
   protected float handleRotationFloat(EntityLivingBase turkey, float partialTickTime)
   {
       return this.handleRotationFloat((EntityTurkey)turkey, partialTickTime);
   }

   @Override
   protected ResourceLocation getEntityTexture(Entity turkey)
   {
      return new ResourceLocation(Reference.MOD_ID, "textures/mobs/turkey.png");
   }
}
