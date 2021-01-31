package mods.flammpfeil.slashblade.stredgeuniverse;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.items.LudicrousItems;
import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.RecipeAwakeBlade;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.TagPropertyAccessor.TagPropertyBoolean;
import mods.flammpfeil.slashblade.TagPropertyAccessor.TagPropertyInteger;
import mods.flammpfeil.slashblade.TagPropertyAccessor.TagPropertyString;
import mods.flammpfeil.slashblade.named.event.LoadEvent;
import mods.flammpfeil.slashblade.named.event.LoadEvent.InitEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.StatCollector;
public class CommonProxy{
	public void preInit(FMLPreInitializationEvent event)
  {
	SlashBlade.InitEventBus.register(this);
  }
public void init(FMLInitializationEvent event)
  {
	EntityRegistry.registerModEntity(EntityAvada.class, "SAAvada", 23, stredgeuniverse.instance, 250, 200, true);
  }
public void postInit(FMLPostInitializationEvent event) {}
  @SubscribeEvent
	public void init(LoadEvent.InitEvent event)
	{
	String name = "flammpfeil.slashblade.named.stredgeuniverse";
	ItemStack customblade = new ItemStack(SlashBlade.bladeNamed, 1, 0);
	NBTTagCompound tag = new NBTTagCompound();
	customblade.setTagCompound(tag);
	ItemSlashBlade.specialAttacks.put(Integer.valueOf(421), new MeteoriteSword());
	ItemSlashBladeNamed.CurrentItemName.set(tag, name);
	ItemSlashBladeNamed.CustomMaxDamage.set(tag, Integer.valueOf(99999999));
	ItemSlashBlade.setBaseAttackModifier(tag, 32768.0F);
	ItemSlashBladeNamed.IsDefaultBewitched.set(tag, Boolean.valueOf(true));
	ItemSlashBlade.SpecialAttackType.set(tag, Integer.valueOf(421));
	ItemSlashBlade.TextureName.set(tag, "named/stredgeuniverse/texture");
	ItemSlashBlade.ModelName.set(tag, "named/stredgeuniverse/model");
	GameRegistry.registerCustomItemStack(name, customblade);
	ItemSlashBladeNamed.NamedBlades.add(name);
	customblade.addEnchantment(Enchantment.power,100);
	customblade.addEnchantment(Enchantment.sharpness,100);
	customblade.addEnchantment(Enchantment.looting,100);
	customblade.addEnchantment(Enchantment.fireAspect,100);
	customblade.addEnchantment(Enchantment.smite,100);
	customblade.addEnchantment(Enchantment.baneOfArthropods,100);
	customblade.getTagCompound().setBoolean("Unbreakable", true);
	NBTTagCompound displayTag = new NBTTagCompound();
	customblade.setTagInfo("display", displayTag);
	NBTTagList loreList = new NBTTagList();
	loreList.appendTag(new NBTTagString((StatCollector.translateToLocal("info.flammpfeil.slashblade.1"))));
	loreList.appendTag(new NBTTagString(("")));
	loreList.appendTag(new NBTTagString((StatCollector.translateToLocal("info.flammpfeil.slashblade.2"))));
	loreList.appendTag(new NBTTagString(("")));
	loreList.appendTag(new NBTTagString((StatCollector.translateToLocal("info.flammpfeil.slashblade.3"))));
	loreList.appendTag(new NBTTagString(("")));
	loreList.appendTag(new NBTTagString((StatCollector.translateToLocal("info.flammpfeil.slashblade.4"))));
	loreList.appendTag(new NBTTagString(("")));
	loreList.appendTag(new NBTTagString((StatCollector.translateToLocal("info.flammpfeil.slashblade.5"))));
	loreList.appendTag(new NBTTagString(("")));
	loreList.appendTag(new NBTTagString(("Creator: Fox")));
	displayTag.setTag("Lore", loreList);
 
	ItemStack blade = SlashBlade.getCustomBlade(name);
    ItemStack custombladeReqired = new ItemStack(Blocks.dragon_egg,1,0);
    ItemStack spheresoul = GameRegistry.findItemStack("flammpfeil.slashblade", "sphere_bladesoul", 1);
    ItemStack proudsoul = GameRegistry.findItemStack("flammpfeil.slashblade", "proudsoul", 1);
    ItemStack soul = GameRegistry.findItemStack("flammpfeil.slashblade", "tiny_bladesoul", 1);
    ItemStack ingotsoul = GameRegistry.findItemStack("flammpfeil.slashblade", "ingot_bladesoul", 1);
    ItemStack crystal = GameRegistry.findItemStack("flammpfeil.slashblade", "crystal_bladesoul", 1);
    ItemStack trapezohedron = GameRegistry.findItemStack("flammpfeil.slashblade", "trapezohedron_bladesoul", 1);

	IRecipe recipe = new mods.flammpfeil.slashblade.RecipeAwakeBlade(blade, custombladeReqired, new Object[] { "QGO", "FBF", "ATA", Character.valueOf('Q'), "trapezohedron", Character.valueOf('G'), "ingotsoul",  Character.valueOf('O'),  "spheresoul",  Character.valueOf('F'),  "proudsoul",  Character.valueOf('A'),  "soul",  Character.valueOf('T'),  "crystal", Character.valueOf('B'), custombladeReqired });
	SlashBlade.addRecipe(name, recipe);
	if (Loader.isModLoaded("Avaritia"))
	{
	ItemStack egg1 = new ItemStack(Blocks.dragon_egg);
	ItemStack helm = new ItemStack(LudicrousItems.infinity_helm);
	ItemStack armor = new ItemStack(LudicrousItems.infinity_armor);
	ItemStack pants = new ItemStack(LudicrousItems.infinity_pants);
	ItemStack shoes = new ItemStack(LudicrousItems.infinity_shoes);
	ItemStack sword = new ItemStack(LudicrousItems.infinity_sword);
	ItemStack pickaxe = new ItemStack(LudicrousItems.infinity_pickaxe);
	ItemStack netherstar = new ItemStack(Items.nether_star);
	IRecipe recipe1 = new RecipeAwakeBlade(blade, custombladeReqired, new Object[] { "ZXZ", "VNM", "JKL", Character.valueOf('Z'), netherstar, Character.valueOf('X'), egg1, Character.valueOf('V'), helm, Character.valueOf('N'), pants, Character.valueOf('M'), sword, Character.valueOf('J'), armor, Character.valueOf('K'), shoes, Character.valueOf('L'), pickaxe });
	SlashBlade.addRecipe(name, recipe1);
	}
  }
}


