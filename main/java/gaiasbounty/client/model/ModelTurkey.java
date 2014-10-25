// Date: 15/09/2014 10:26:55 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package gaiasbounty.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTurkey extends ModelBase
{
   // fields
   ModelRenderer body;
   ModelRenderer head;
   ModelRenderer bill;
   ModelRenderer chin;
   ModelRenderer tail;
   ModelRenderer legLeft;
   ModelRenderer legRight;
   ModelRenderer wingLeft;
   ModelRenderer wingRight;
   
   public ModelTurkey()
   {
      textureWidth = 64;
      textureHeight = 32;
      
      body = new ModelRenderer(this, 0, 11);
      body.addBox(-4F, -3F, -5F, 8, 6, 10);
      body.setRotationPoint(0F, 16F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-2F, -5F, -3F, 4, 6, 3);
      head.setRotationPoint(0F, 14F, -4F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      bill = new ModelRenderer(this, 14, 0);
      bill.addBox(-1F, -3F, -6F, 2, 2, 3);
      bill.setRotationPoint(0F, 14F, -4F);
      bill.setTextureSize(64, 32);
      bill.mirror = true;
      setRotation(bill, 0F, 0F, 0F);
      chin = new ModelRenderer(this, 14, 5);
      chin.addBox(-1F, -1F, -4F, 2, 4, 2);
      chin.setRotationPoint(0F, 14F, -4F);
      chin.setTextureSize(64, 32);
      chin.mirror = true;
      setRotation(chin, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 36, 20);
      tail.addBox(-7F, -11F, 0F, 14, 12, 0);
      tail.setRotationPoint(0F, 18F, 5F);
      tail.setTextureSize(64, 32);
      tail.mirror = true;
      setRotation(tail, -0.3926991F, 0F, 0F);
      legLeft = new ModelRenderer(this, 26, 0);
      legLeft.addBox(-2F, 0F, -4F, 3, 5, 3);
      legLeft.setRotationPoint(2F, 19F, 1F);
      legLeft.setTextureSize(64, 32);
      legLeft.mirror = true;
      setRotation(legLeft, 0F, 0F, 0F);
      legRight = new ModelRenderer(this, 26, 0);
      legRight.addBox(-1F, 0F, -4F, 3, 5, 3);
      legRight.setRotationPoint(-2F, 19F, 1F);
      legRight.setTextureSize(64, 32);
      legRight.mirror = true;
      setRotation(legRight, 0F, 0F, 0F);
      wingLeft = new ModelRenderer(this, 36, 8);
      wingLeft.addBox(-1F, 0F, -4F, 1, 4, 8);
      wingLeft.setRotationPoint(5F, 13F, 0F);
      wingLeft.setTextureSize(64, 32);
      wingLeft.mirror = true;
      setRotation(wingLeft, 0F, 0F, 0F);
      wingRight = new ModelRenderer(this, 36, 8);
      wingRight.addBox(0F, 0F, -4F, 1, 4, 8);
      wingRight.setRotationPoint(-5F, 13F, 0F);
      wingRight.setTextureSize(64, 32);
      wingRight.mirror = true;
      setRotation(wingRight, 0F, 0F, 0F);
   }
   
   public void render(Entity entity, float f, float f1, float f2, float f3,
            float f4, float f5)
   {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      
      if (this.isChild)
      {
         float f6 = 2.0F;
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
         this.head.render(f5);
         this.bill.render(f5);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
         GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
         this.body.render(f5);
         this.legLeft.render(f5);
         this.legRight.render(f5);
         this.wingLeft.render(f5);
         this.wingRight.render(f5);
         GL11.glPopMatrix();
      }
      else
      {
         this.body.render(f5);
         this.head.render(f5);
         this.bill.render(f5);
         this.chin.render(f5);
         this.tail.render(f5);
         this.legLeft.render(f5);
         this.legRight.render(f5);
         this.wingLeft.render(f5);
         this.wingRight.render(f5);
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
   public void setRotationAngles(float f, float f1, float f2, float f3,
            float f4, float f5, Entity turkey)
   {
      this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.bill.rotateAngleX = this.head.rotateAngleX;
      this.bill.rotateAngleY = this.head.rotateAngleY;
      this.chin.rotateAngleX = this.head.rotateAngleX;
      this.chin.rotateAngleY = this.head.rotateAngleY;
      this.legRight.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.legLeft.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
               * 1.4F * f1;
      this.wingRight.rotateAngleZ = f2;
      this.wingLeft.rotateAngleZ = -f2;
      this.tail.rotateAngleX = -(0.2F + MathHelper.cos(f * 0.9F) * 0.5F * f1 +
               MathHelper.cos(((Minecraft.getSystemTime() + turkey.ticksExisted) & 65535) * 0.001F) * 0.2F);
   }
   
}
