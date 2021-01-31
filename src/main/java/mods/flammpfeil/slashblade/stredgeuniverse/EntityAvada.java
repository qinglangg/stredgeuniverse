package mods.flammpfeil.slashblade.stredgeuniverse;
import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.ability.StylishRankManager;
import mods.flammpfeil.slashblade.ability.StylishRankManager.AttackTypes;
import mods.flammpfeil.slashblade.entity.EntityPhantomSwordBase;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;

public class EntityAvada extends EntityPhantomSwordBase{
	private Entity player;
	public EntityAvada(World par1World)
  {
	super(par1World);
  }
  
public EntityAvada(World par1World, EntityLivingBase entityLiving, float AttackLevel) {
	super(par1World, entityLiving, AttackLevel);
  }
  
public EntityAvada(World par1World, EntityLivingBase entityLiving, float AttackLevel, float roll) {
	super(par1World, entityLiving, AttackLevel, roll);
  }
  
protected void entityInit()
  {
	super.entityInit();
	getDataWatcher().addObject(8, Byte.valueOf((byte)0));
  }
public boolean getBurst() {
	return getDataWatcher().getWatchableObjectByte(8) != 0;
  }
public void setBurst(boolean value) { 
	getDataWatcher().updateObject(8, Byte.valueOf((byte)(value ? 1 : 0))); 
  }
protected void attackEntity(Entity target)
  {
	if (getBurst()) {
	this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 1.0F, false, false);
 }
	if (!this.worldObj.isRemote) {
	float magicDamage = Math.max(1.0F, this.AttackLevel);
	target.hurtResistantTime = 0;
	DamageSource ds = new EntityDamageSource("directMagic", getThrower()).setDamageBypassesArmor().setMagicDamage();
	target.attackEntityFrom(ds, magicDamage);
	target.attackEntityFrom(DamageSource.outOfWorld.setMagicDamage().setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), Float.MAX_VALUE);
	if ((this.blade != null) && ((target instanceof EntityLivingBase)) && (this.thrower != null) && ((this.thrower instanceof EntityLivingBase))) {
	StylishRankManager.setNextAttackType(this.thrower, StylishRankManager.AttackTypes.PhantomSword);
	((ItemSlashBlade)this.blade.getItem()).hitEntity(this.blade, (EntityLivingBase)target, (EntityLivingBase)this.thrower);
	if (!target.isEntityAlive()) {
	((EntityLivingBase)this.thrower).heal(1.0F);
}
	((EntityLivingBase)target).hurtTime = 1;

   if (!(target instanceof EntityPlayer)) {
	((EntityLivingBase)target).onDeath(DamageSource.outOfWorld);
	((EntityLivingBase)target).setDead();
	((EntityLivingBase)target).setHealth(0.0F);
	((EntityLivingBase)target).getDataWatcher().updateObject(6, Float.valueOf(MathHelper.clamp_float(0.0F, 0.0F, ((EntityLivingBase)target).getMaxHealth())));
	((EntityLivingBase)target).attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
}
   if ((target instanceof EntityPlayer)) {
	EntityPlayer player = (EntityPlayer)target;
	player.setGameType(GameType.SURVIVAL);
	player.inventory.dropAllItems();
	player.hurtResistantTime = 0;
	player.attackEntityFrom(DamageSource.outOfWorld.setMagicDamage().setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), Float.MAX_VALUE);
	player.setHealth(0.0F);
	player.onDeath(DamageSource.outOfWorld);
	player.isDead = true;
	player.getDataWatcher().updateObject(6, Float.valueOf(MathHelper.clamp_float(0.0F, 0.0F, player.getMaxHealth())));
	player.experienceLevel = 0;
	player.experience = 0.0F;
	player.experienceTotal = 0;
	player.clearActivePotions();
}
	if (!getBurst()) {
	((EntityLivingBase)target).addPotionEffect(new PotionEffect(Potion.wither.getId(), 100, 1));
}
	((ItemSlashBlade)this.blade.getItem()).setDaunting((EntityLivingBase)target);
   }
 }
 
setDead();
}
	public void Foxs(){}
}
