package me.littlemissantivirus.simplesprint;

import me.littlemissantivirus.simplesprint.events.EventKey;
import me.littlemissantivirus.simplesprint.events.EventTick;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import org.lwjgl.input.Keyboard;

@Mod(modid = SimpleSprint.MOD_ID, name = SimpleSprint.MOD_NAME, version = SimpleSprint.VERSION)
public class SimpleSprint {

  // Mod information
  static final String MOD_ID = "simplesprint";
  public static final String MOD_NAME = "Simple Sprint";
  public static final String VERSION = "0.1-dev";

  // The instance of SimpleSprint.
  private static SimpleSprint instance;

  // A list of KeyBindings for use in the mod.
  public final KeyBinding[] keyBindings = new KeyBinding[0];

  @EventHandler
  public void onPreInit(FMLPreInitializationEvent event) {
    instance = this;
  }

  @EventHandler
  public void onInit(FMLInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(this);
    MinecraftForge.EVENT_BUS.register(new EventKey());
    MinecraftForge.EVENT_BUS.register(new EventTick());

    keyBindings[0] = new KeyBinding("key.simplesprint.sprint", Keyboard.KEY_V, MOD_NAME);

    for (KeyBinding keyBinding : keyBindings) {
      ClientRegistry.registerKeyBinding(keyBinding);
    }
  }

  // Variables for the mod.
  public static class Settings {
    public static boolean SPRINT;
    // Will reimplement at a later time.
    // public static boolean SNEAK;
  }

  public static SimpleSprint getInstance() {
    return instance;
  }

}