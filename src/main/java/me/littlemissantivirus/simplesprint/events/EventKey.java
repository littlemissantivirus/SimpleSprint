package me.littlemissantivirus.simplesprint.events;

import me.littlemissantivirus.common.utils.ChatUtils;
import me.littlemissantivirus.simplesprint.SimpleSprint;
import me.littlemissantivirus.simplesprint.SimpleSprint.Settings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class EventKey {

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

  }

}