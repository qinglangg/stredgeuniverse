package mods.flammpfeil.slashblade.stredgeuniverse;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
 
@Mod(modid="stredgeuniverse", name="Stredge Universe:The end of all things. Endless stars", version="0.0.3", dependencies="required-after:flammpfeil.slashblade")
public class stredgeuniverse
 {
   public static final String MODID = "stredgeuniverse";
   public static final String MODNAME = "Stredge Universe:The end of all things. Endless stars";
   public static final String version = "0.0.3";
   @Mod.Instance("stredgeuniverse")
   public static stredgeuniverse instance;
   @cpw.mods.fml.common.SidedProxy(clientSide="mods.flammpfeil.slashblade.stredgeuniverse.ClientProxy", serverSide="mods.flammpfeil.slashblade.stredgeuniverse.CommonProxy")
   public static CommonProxy proxy;
   
   @Mod.EventHandler
   public void preInit(FMLPreInitializationEvent event)
   {
	proxy.preInit(event);
   }
   
   @Mod.EventHandler
   public void init(FMLInitializationEvent event) {
	proxy.init(event);
   }
   
   @Mod.EventHandler
   public void postInit(FMLPostInitializationEvent event) {
 proxy.postInit(event);
   }
 }
