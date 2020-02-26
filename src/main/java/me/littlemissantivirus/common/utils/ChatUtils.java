package me.littlemissantivirus.common.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

/**
 * A class to help with certain chat stuff.
 *
 * @author littlemissantivirus
 * @since 02/20/2020
 */
public class ChatUtils {

  /**
   * A function to send a message to the player, and automagically format it.
   *
   * @param message The message to send.
   */
  public static void sendMessage(String message) {
    Minecraft.getMinecraft().thePlayer
        .addChatMessage(new ChatComponentText(translateColorCodes(message)));
  }

  /**
   * A function to translate all color codes in a message, similar to Bukkit/Spigot.
   *
   * @param message The message to translate
   * @return The message, with all '&'s replaced with ampersands.
   */
  public static String translateColorCodes(String message) {
    // The ampersand character.
    char color = 167;
    // Return the message, replacing & with ampersand, via a regex.
    return message.replaceAll("&(?=[abcdef1234567890klmnor])", color + "");
  }

}