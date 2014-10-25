package gaiasbounty.client.render;

import gaiasbounty.entity.EntityDuck;
import gaiasbounty.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderDuck extends RenderLiving
{
   public RenderDuck(ModelBase model, float f)
   {
      super(model, f);
   }
   
   protected float handleRotationFloat(EntityDuck duck, float partialTickTime)
   {
       float f1 = duck.fallDistPrev + (duck.fallDist - duck.fallDistPrev) * partialTickTime;
       float f2 = duck.destPosPrev + (duck.destPos - duck.destPosPrev) * partialTickTime;
       return (MathHelper.sin(f1) + 1.0F) * f2;
   }
   
   @Override
   protected float handleRotationFloat(EntityLivingBase duck, float partialTickTime)
   {
       return this.handleRotationFloat((EntityDuck)duck, partialTickTime);
   }

   @Override
   protected ResourceLocation getEntityTexture(Entity duck)
   {
      return new ResourceLocation(Reference.MOD_ID, "textures/mobs/duck.png");
   }
}
