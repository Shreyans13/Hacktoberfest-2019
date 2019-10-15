package dev.sunshine_sudo.snake;

import dev.sunshine_sudo.snake.player.Snake;
import dev.sunshine_sudo.snake.utils.KeyboardListener;

import javax.swing.*;
import java.awt.*;

public class Window {
  private final static int WINDOW_WIDTH = 500;
  private final static int WINDOW_HEIGHT = 500;
  private final static String WINDOW_TITLE = "Snake AI Test";

  private static JFrame frame;
  private static Canvas canvas;

  public static void open(Snake snake) {
    frame = new JFrame(WINDOW_TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setFocusable(false);
    frame.setResizable(false);

    canvas = new Canvas();
    canvas.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    canvas.addKeyListener(new KeyboardListener(snake));
    frame.add(canvas);

    frame.pack();
    frame.setVisible(true);
  }

  public static void close() {
    frame.dispose();
  }

  public static Canvas getCanvas() {
    return canvas;
  }

  public static Graphics2D getGraphics() {
    return (Graphics2D) getCanvas().getGraphics();
  }

  public static int getWindowWidth() {
    return WINDOW_WIDTH;
  }

  public static int getWindowHeight() {
    return WINDOW_HEIGHT;
  }

}
