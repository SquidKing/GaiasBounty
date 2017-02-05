// Date: 19/09/2014 11:50:52 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package gaiasbounty.client.model;

import gaiasbounty.entity.EntityDeer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

public class ModelDeer extends ModelBase
{
   // fields
   ModelRenderer body;
   ModelRenderer head;
   ModelRenderer neck;
   ModelRenderer antlerRight;
   ModelRenderer antlerLeft;
   ModelRenderer earRight;
   ModelRenderer earLeft;
   ModelRenderer legFrontRight;
   ModelRenderer legFrontLeft;
   ModelRenderer legRearRight;
   ModelRenderer legRearLeft;
   ModelRenderer tail;
   
   protected float translateY = 12.0F;
   protected float translateZ = 4.0F;
   
   public ModelDeer()
   {
      textureWidth = 64;
      textureHeight = 32;
      
      body = new ModelRenderer(this, 28, 6);
      body.addBox(-4F, -8F, -5F, 8, 16, 10);
      body.setRotationPoint(0F, 9F, 0F);
      body.setTextureSize(64, 32);
      setRotation(body, 1.570796F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-3F, -5F, -7F, 6, 6, 8);
      head.setRotationPoint(0F, 2F, -10F);
      head.setTextureSize(64, 32);
      setRotation(head, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 12, 14);
      neck.addBox(-2F, -3F, -2F, 4, 6, 4);
      neck.setRotationPoint(0F, 3.5F, -8.5F);
      neck.setTextureSize(64, 32);
      setRotation(neck, 0.7853982F, 0F, 0F);
      antlerRight = new ModelRenderer(this, 20, 0);
      antlerRight.mirror = true;
      antlerRight.addBox(-10F, -12F, -1F, 8, 8, 0);
      antlerRight.setRotationPoint(0F, 2F, -10F);
      antlerRight.setTextureSize(64, 32);
      setRotation(antlerRight, 0F, 0F, 0F);
      antlerLeft = new ModelRenderer(this, 20, 0);
      antlerLeft.addBox(2F, -12F, -1F, 8, 8, 0);
      antlerLeft.setRotationPoint(0F, 2F, -10F);
      antlerLeft.setTextureSize(64, 32);
      setRotation(antlerLeft, 0F, 0F, 0F);
      earRight = new ModelRenderer(this, 0, 0);
      earRight.addBox(-4F, -7F, -3F, 1, 3, 2);
      earRight.setRotationPoint(0F, 2F, -10F);
      earRight.setTextureSize(64, 32);
      setRotation(earRight, 0F, 0F, 0F);
      earLeft = new ModelRenderer(this, 0, 0);
      earLeft.mirror = true;
      earLeft.addBox(3F, -7F, -3F, 1, 3, 2);
      earLeft.setRotationPoint(0F, 2F, -10F);
      earLeft.setTextureSize(64, 32);
      setRotation(earLeft, 0F, 0F, 0F);
      legFrontRight = new ModelRenderer(this, 0, 14);
      legFrontRight.addBox(-1.5F, 0F, -1.5F, 3, 10, 3);
      legFrontRight.setRotationPoint(-2.5F, 14F, -6.5F);
      legFrontRight.setTextureSize(64, 32);
      setRotation(legFrontRight, 0F, 0F, 0F);
      legFrontLeft = new ModelRenderer(this, 0, 14);
      legFrontLeft.addBox(-1.5F, 0F, -1.5F, 3, 10, 3);
      legFrontLeft.setRotationPoint(2.5F, 14F, -6.5F);
      legFrontLeft.setTextureSize(64, 32);
      setRotation(legFrontLeft, 0F, 0F, 0F);
      legRearRight = new ModelRenderer(this, 0, 14);
      legRearRight.addBox(-1.5F, 0F, -1.5F, 3, 10, 3);
      legRearRight.setRotationPoint(-2.5F, 14F, 5.5F);
      legRearRight.setTextureSize(64, 32);
      setRotation(legRearRight, 0F, 0F, 0F);
      legRearLeft = new ModelRenderer(this, 0, 14);
      legRearLeft.addBox(-1.5F, 0F, -1.5F, 3, 10, 3);
      legRearLeft.setRotationPoint(2.5F, 14F, 5.5F);
      legRearLeft.setTextureSize(64, 32);
      setRotation(legRearLeft, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 0, 27);
      tail.addBox(-1F, 0F, 0F, 2, 4, 1);
      tail.setRotationPoint(0F, 5F, 8F);
      tail.setTextureSize(64, 32);
      setRotation(tail, 0F, 0F, 0F);
   }
   
   public void render(Entity entity, float f, float f1, float f2, float f3,
            float f4, float f5)
   {
      super.render(entity, f, f1, f2, f3, f4, f5);
      setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      
      if (this.isChild)
      {
         float f6 = 2.0F;
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, this.translateY * f5, this.translateZ * f5);
         head.render(f5);
         earRight.render(f5);
         earLeft.render(f5);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
         GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
         body.render(f5);
         neck.render(f5);
         legFrontRight.render(f5);
         legFrontLeft.render(f5);
         legRearRight.render(f5);
         legRearLeft.render(f5);
         tail.render(f5);
         GL11.glPopMatrix();
      }
      else
      {
         body.render(f5);
         head.render(f5);
         neck.render(f5);
         if (((EntityDeer)entity).hasAntlers)
         {
            antlerRight.render(f5);
            antlerLeft.render(f5);
         }
         earRight.render(f5);
         earLeft.render(f5);
         legFrontRight.render(f5);
         legFrontLeft.render(f5);
         legRearRight.render(f5);
         legRearLeft.render(f5);
         tail.render(f5);
      }
   }
   
   private void setRotation(ModelRenderer model, float x, float y, float z)
   {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }
   
   /**
    * Sets the model's various rotation angles. For bipeds, par1 and par2 are
    * used for animating the movement of arms and legs, where par1 represents
    * the time(so that arms and legs swing back and forth) and par2 represents
    * how "far" arms and legs can swing at most. NOTE: Parameters not properly
    * documented; these values may not accurately represent what is actually
    * being passed.
    * 
    * @param f - Limb swing amount; higher for child mobs
    * @param f1 - Limb swing delta
    * @param f2 - Set by model render class in handleRotationFloat(EntityLivingBase, float)
    * @param f3 - Look vector Y
    * @param f4 - Look vector X
    * @param f5 - Usually 0.0625F
    * @param entity - Reference to an entity using this model
    */
   @Override
   public void setRotationAngles(float f, float f1, float f2, float f3,
            float f4, float f5, Entity entity)
   {
      float f6 = (180F / (float) Math.PI);
      this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.antlerRight.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.antlerRight.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.antlerLeft.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.antlerLeft.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.earRight.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.earRight.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.earLeft.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.earLeft.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.body.rotateAngleX = ((float) Math.PI / 2F);
      this.legFrontRight.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.legFrontLeft.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
               * 1.4F * f1;
      this.legRearRight.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
               * 1.4F * f1;
      this.legRearLeft.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
   }
   
}
