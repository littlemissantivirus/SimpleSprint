package me.littlemissantivirus.simplesprint.events;

import me.littlemissantivirus.common.utils.ChatUtils;
import me.littlemissantivirus.simplesprint.SimpleSprint.Settings;
import me.littlemissantivirus.simplesprint.gui.RenderTextGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventRender {

  private final RenderTextGUI renderTextGUI = new RenderTextGUI(Minecraft.getMinecraft());

  @SubscribeEvent
  public void onRenderGUI(RenderGameOverlayEvent.Post event) {
    // Save the hotbar and stuff from getting messed up.
    if (event.type != ElementType.EXPERIENCE) return;

    // TODO: Allow for toggling and changing the text of the overlays.
    if (Settings.SPRINT)
      renderTextGUI.render(ChatUtils.translateColorCodes(Settings.SPRINT_MSG),
          5, 5);

    if (Settings.SNEAK)
      renderTextGUI.render(ChatUtils.translateColorCodes(Settings.SNEAK_MSG),
          renderTextGUI.getStringWidth(Settings.SNEAK_MSG) / 4, 35);
  }

}