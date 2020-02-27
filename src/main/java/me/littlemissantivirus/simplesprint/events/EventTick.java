package me.littlemissantivirus.simplesprint.events;

import me.littlemissantivirus.simplesprint.SimpleSprint.Settings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class EventTick {

  @SubscribeEvent
  public void onTick(ClientTickEvent event) {
    if (Settings.SPRINT)
      KeyBinding.setKeyBindState(getKeyCodeSprint(), true);
    if (Settings.SNEAK) {
      // Make sure the game has focus, this is used if the player alt+tabs out and doesn't
      // have focus loss disabled.
      if (Minecraft.getMinecraft().currentScreen != null) return;
      KeyBinding.setKeyBindState(getKeyCodeSneak(), true);
    }
  }

  private int getKeyCodeSprint() {
    return Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode();
  }

  private int getKeyCodeSneak() {
    return Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode();
  }

}