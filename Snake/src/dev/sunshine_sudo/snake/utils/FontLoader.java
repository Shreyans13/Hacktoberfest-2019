package dev.sunshine_sudo.snake.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontLoader {

  public static Font loadFont(String path) {
    try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(font);
      return font;
    } catch (FontFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
