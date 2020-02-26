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
  }

  private int getKeyCodeSprint() {
    return Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode();
  }

}