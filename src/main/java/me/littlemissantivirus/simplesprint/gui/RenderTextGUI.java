package me.littlemissantivirus.simplesprint.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class RenderTextGUI extends Gui {

  private final Minecraft mc;

  public RenderTextGUI(Minecraft mc) {
    this.mc = mc;
  }

  public void render(String text, int x, int y) {
    mc.fontRendererObj.drawStringWithShadow(text, x, y, 0xffffff);
  }

  public int getStringWidth(String text) {
    return mc.fontRendererObj.getStringWidth(text);
  }


}