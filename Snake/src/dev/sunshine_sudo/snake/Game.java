package dev.sunshine_sudo.snake;

import dev.sunshine_sudo.snake.player.Snake;
import dev.sunshine_sudo.snake.utils.FontLoader;
import dev.sunshine_sudo.snake.utils.KeyboardListener;
import dev.sunshine_sudo.snake.world.World;

import java.awt.*;

public class Game {
  public static volatile boolean isRunning = false;
  public static volatile int score = 0;
  private static Font EightBitFont;
  private static Font EightBitFont16Point;
  private Snake snake;

  /* Initialization */
  public Game() {
    EightBitFont = FontLoader.loadFont("res/8BitFont.ttf");
    EightBitFont16Point = EightBitFont.deriveFont(16f);
    World world = new World();
    World.placeNewFood();
    snake = new Snake(Math.round(World.getGridWidth() / 2), Math.round(World.getGridHeight() / 2));
  }

  /* Startup */
  public static void main(String[] args) {
    Game game = new Game();
    Window.open(game.getSnake());
    game.run();
    Window.close();
  }

  public static void gameOver() {
    score = 0;
    Game game = new Game();
    KeyboardListener.reset(game.getSnake());
    game.run();
    /* Sometimes Controls Get Inverted When Game Restarts TODO: Fix */
  }

  public static int getScore() {
    return score;
  }

  public static void increaseScore() {
    score++;
  }

  /* Running */
  public void run() {
    isRunning = true;

    final double renderConversion = 0.001D * 30D;
    final double updateConversion = 0.001D * 20D;
    long secondPoint;
    long firstPoint = System.currentTimeMillis();
    double updateDelta = 0;
    double renderDelta = 0;

    while (isRunning) {
      secondPoint = System.currentTimeMillis();
      updateDelta += (secondPoint - firstPoint) * updateConversion;
      renderDelta += (secondPoint - firstPoint) * renderConversion;
      firstPoint = secondPoint;

      if (updateDelta >= 1.0D) {
        tick();
        updateDelta--;
      }

      if (renderDelta >= 1.0D) {
        render();
        renderDelta--;
      }
    }
  }

  public void tick() {
    snake.update();
  }

  public void render() {
    if (Window.getCanvas().getBufferStrategy() == null) {
      Window.getCanvas().createBufferStrategy(3);
      return;
    }
    Graphics2D graphics = Window.getGraphics();
    graphics.setColor(Color.BLACK);
    graphics.fillRect(0, 0, Window.getWindowWidth(), Window.getWindowHeight());
    // draw begin
    World.draw(graphics);
    snake.draw(graphics);
    graphics.setColor(Color.WHITE);
    graphics.setFont(EightBitFont16Point);
    graphics.drawString(String.valueOf(score),
            (Window.getWindowWidth() - graphics.getFontMetrics().stringWidth(String.valueOf(
                    score))) / 2,
            30);
    // draw end
    graphics.dispose();
  }

  public Snake getSnake() {
    return snake;
  }

}
