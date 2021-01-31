package mods.flammpfeil.slashblade.stredgeuniverse;
import java.awt.Color;
import java.util.List;
import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.ItemSlashBlade.ComboSequence;
import mods.flammpfeil.slashblade.TagPropertyAccessor.TagPropertyFloat;
import mods.flammpfeil.slashblade.TagPropertyAccessor.TagPropertyInteger;
import mods.flammpfeil.slashblade.TagPropertyAccessor.TagPropertyIntegerWithRange;
import mods.flammpfeil.slashblade.ability.StylishRankManager;
import mods.flammpfeil.slashblade.ability.StylishRankManager.AttackTypes;
import mods.flammpfeil.slashblade.specialattack.SpecialAttackBase;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
public class MeteoriteSword extends SpecialAttackBase
{
  public String toString()
  {
return "meteoritesword";
  } 
public void EndAttackEntity(EntityLivingBase Entity)
{
  if ((!Entity.isDead) || (Entity.getHealth() > 0.0F))
  {
    if ((Entity instanceof EntityPlayer)) {
      EntityPlayer player = (EntityPlayer)Entity;
      player.setGameType(GameType.SURVIVAL);
      player.inventory.dropAllItems();
      player.hurtResistantTime = 0;
      player.attackEntityFrom(DamageSource.outOfWorld.setMagicDamage().setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), Float.MAX_VALUE);
      player.setHealth(0.0F);
      player.onDeath(DamageSource.outOfWorld);
      player.isDead = true;
      player.getDataWatcher().updateObject(6, Float.valueOf(MathHelper.clamp_float(0.0F, 0.0F, Entity.getMaxHealth())));
      player.experienceLevel = 0;
      player.experience = 0.0F;
      player.experienceTotal = 0;
      player.clearActivePotions();
    } else {
      Entity.hurtResistantTime = 0;
      Entity.attackEntityFrom(DamageSource.outOfWorld.setMagicDamage().setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), Float.MAX_VALUE);
      Entity.setHealth(0.0F);
      Entity.onDeath(DamageSource.outOfWorld);
      Entity.isDead = true;
      Entity.getDataWatcher().updateObject(6, Float.valueOf(MathHelper.clamp_float(0.0F, 0.0F, Entity.getMaxHealth())));
    }
  }
}
  public void doSpacialAttack(ItemStack stack, EntityPlayer player)
  {
	World world = player.worldObj;
    
	if (player.posY < -45.0D) {
	player.motionY += 10.0D;
    }
	NBTTagCompound tag = ItemSlashBlade.getItemTagCompound(stack);
    
	if (!world.isRemote)
    {
	ItemSlashBlade blade = (ItemSlashBlade)stack.getItem();
	Entity target = null;  
	int entityId = ItemSlashBlade.TargetEntityId.get(tag).intValue();
	if (entityId != 0) {
	Entity tmp = world.getEntityByID(entityId);
	if ((tmp != null) && 
	(tmp.getDistanceToEntity(player) < 200.0F)) {
	target = tmp;
        }
      }
	if (target == null) {
	target = getEntityToWatch(player);
      }
      
	if (target != null) {
	ItemSlashBlade.setComboSequence(tag, ItemSlashBlade.ComboSequence.SlashDim);
        
	int cost = -40;
	if (!ItemSlashBlade.ProudSoul.tryAdd(tag, Integer.valueOf(-40), false)) {
	ItemSlashBlade.damageItem(stack, 10, player);
        }
	StylishRankManager.setNextAttackType(player, StylishRankManager.AttackTypes.PhantomSword);
	blade.attackTargetEntity(stack, target, player, Boolean.valueOf(true));
	player.onCriticalHit(target);
	target.motionX = 0.0D;
	target.motionY = 0.0D;
	target.motionZ = 0.0D;
	if ((target instanceof EntityLivingBase)) {
	blade.setDaunting((EntityLivingBase)target);
	((EntityLivingBase)target).hurtTime = 0;
	((EntityLivingBase)target).hurtResistantTime = 0;
if ((target instanceof EntityPlayer)){
    EntityPlayer victim = (EntityPlayer)target;
    victim.heal(Float.MAX_VALUE);
    victim.inventory.dropAllItems();
    EndAttackEntity(victim);
}
    }
	int level = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
	float magicDamage = 1.0F + ItemSlashBlade.AttackAmplifier.get(tag).floatValue() * (level / 5.0F);    
	int count = 1 + StylishRankManager.getStylishRank(player);
        for (int i = 0; i < count; i++)
        {
	if (!world.isRemote) {
	boolean isBurst = i % 2 == 0;
	EntityAvada entityDrive = new EntityAvada(world, player, magicDamage, 10000.0F);
	EntityAvada entityDrive1 = new EntityAvada(world, player, magicDamage, 10000.0F);
	EntityAvada entityDrive2 = new EntityAvada(world, player, magicDamage, 10000.0F);
	EntityAvada entityDrive3 = new EntityAvada(world, player, magicDamage, 10000.0F);
	EntityAvada entityDrive4 = new EntityAvada(world, player, magicDamage, 10000.0F);
	EntityAvada entityDrive5 = new EntityAvada(world, player, magicDamage, 10000.0F);
	EntityAvada entityDrive6 = new EntityAvada(world, player, magicDamage, 10000.0F);
if (entityDrive != null)
{
  entityDrive.setLocationAndAngles(target.posX - 3.0D + 1.0D, target.posY + 4.0D, target.posZ - 3.0D + 1.0D, player.rotationYaw, player.rotationPitch);
  entityDrive1.setLocationAndAngles(target.posX - 3.0D + 2.0D, target.posY + 4.0D, target.posZ - 3.0D + 2.0D, player.rotationYaw, player.rotationPitch);
  entityDrive2.setLocationAndAngles(target.posX - 3.0D + 3.0D, target.posY + 4.0D, target.posZ - 3.0D + 3.0D, player.rotationYaw, player.rotationPitch);
  entityDrive3.setLocationAndAngles(target.posX - 3.0D + 4.0D, target.posY + 4.0D, target.posZ - 3.0D + 4.0D, player.rotationYaw, player.rotationPitch);
  entityDrive4.setLocationAndAngles(target.posX - 3.0D + 5.0D, target.posY + 4.0D, target.posZ - 3.0D + 5.0D, player.rotationYaw, player.rotationPitch);
  entityDrive5.setLocationAndAngles(target.posX - 3.0D + 6.0D, target.posY + 4.0D, target.posZ - 3.0D + 6.0D, player.rotationYaw, player.rotationPitch);
  entityDrive6.setLocationAndAngles(target.posX - 3.0D + 7.0D, target.posY + 4.0D, target.posZ - 3.0D + 7.0D, player.rotationYaw, player.rotationPitch);
  entityDrive.setColor(16711680);
  entityDrive1.setColor(14972979);
  entityDrive2.setColor(16776960);
  entityDrive3.setColor(65280);
  entityDrive4.setColor(65535);
  entityDrive5.setColor(7377883);
  entityDrive6.setColor(10040013);
  entityDrive.setTargetEntityId(target.getEntityId());
  world.spawnEntityInWorld(entityDrive);
  entityDrive1.setTargetEntityId(target.getEntityId());
  world.spawnEntityInWorld(entityDrive1);
  entityDrive2.setTargetEntityId(target.getEntityId());
  world.spawnEntityInWorld(entityDrive2);
  entityDrive3.setTargetEntityId(target.getEntityId());
  world.spawnEntityInWorld(entityDrive3);
  entityDrive4.setTargetEntityId(target.getEntityId());
  world.spawnEntityInWorld(entityDrive4);
  entityDrive5.setTargetEntityId(target.getEntityId());
  world.spawnEntityInWorld(entityDrive5);
  entityDrive6.setTargetEntityId(target.getEntityId());
  world.spawnEntityInWorld(entityDrive6);
}
}
        }
      }
    }
    
	ItemSlashBlade.setComboSequence(tag, ItemSlashBlade.ComboSequence.Kiriorosi);
  }
  
  private Entity getEntityToWatch(EntityPlayer player) {
	World world = player.worldObj;
	Entity target = null;
	for (int dist = 2; dist < 20; dist += 2) {
		AxisAlignedBB bb = player.boundingBox.copy();
		Vec3 vec = player.getLookVec();
		vec = vec.normalize();
		bb = bb.expand(2.0D, 0.25D, 2.0D);
		bb = bb.offset(vec.xCoord * dist, vec.yCoord * dist, vec.zCoord * dist);
      
		List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(player, bb, ItemSlashBlade.AttackableSelector);
		float distance = 1000.0F;
	for (Entity curEntity : list) {
			float curDist = curEntity.getDistanceToEntity(player);
			if (curDist < distance)
        {
		target = curEntity;
		distance = curDist;
        }
      }
	if (target != null)
	break;
}
	return target;
}
}

