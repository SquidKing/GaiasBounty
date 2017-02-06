package gaiasbounty.client.render;

import gaiasbounty.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBison extends RenderLiving
{
    public RenderBison(ModelBase model, float f)
    {
        super(model, f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity bison)
    {
        return new ResourceLocation(Reference.MOD_ID, "textures/mobs/bison.png");
    }
}
