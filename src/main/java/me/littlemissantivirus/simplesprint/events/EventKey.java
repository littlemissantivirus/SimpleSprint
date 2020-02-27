package me.littlemissantivirus.simplesprint.events;

import me.littlemissantivirus.common.utils.ChatUtils;
import me.littlemissantivirus.simplesprint.SimpleSprint;
import me.littlemissantivirus.simplesprint.SimpleSprint.Settings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class EventKey {

  boolean toggledHypixel;

  @SubscribeEvent
  public void onEvent(KeyInputEvent event) {
    // Get the KeyBindings list from the mod.
    KeyBinding[] keyBindings = SimpleSprint.getInstance().keyBindings;

    if (keyBindings[0].isPressed()) {
      Settings.SPRINT = !Settings.SPRINT;
      ChatUtils.sendMessage(
          "&b&lSimpleSprint >> &7Sprint has been " + (Settings.SPRINT ? "&aenabled"
              : "&cdisabled"));
    }
    if (keyBindings[1].isPressed()) {
      Settings.SNEAK = !Settings.SNEAK;

      // Hypixel check.
      if (Settings.SNEAK && !toggledHypixel) {
        // Get the current server ip.
        if (Minecraft.getMinecraft().getCurrentServerData() != null) {
          String serverIP = Minecraft.getMinecraft().getCurrentServerData().serverIP;
          // Check for Hypixel.
          if (serverIP.contains("hypixel.net") || serverIP.contains("104.16.78.21")) {
            // Warn the player, and untoggle sneak.
            ChatUtils.sendMessage(
                "&b&lSimpleSprint >> &cThis is use at &lyour own risk&c, if you are banned it is your own fault! Please toggle sneak again if you would like to proceed.");
            Settings.SNEAK = false;
            toggledHypixel = true;
            return;
          }

        }

      }
      ChatUtils.sendMessage(
          "&b&lSimpleSprint >> &7Sneak has been " + (Settings.SNEAK ? "&aenabled"
              : "&cdisabled"));
    }

  }

}