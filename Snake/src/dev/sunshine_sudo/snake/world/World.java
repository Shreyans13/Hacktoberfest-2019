package dev.sunshine_sudo.snake.world;

import dev.sunshine_sudo.snake.Window;

import java.awt.*;

import static dev.sunshine_sudo.snake.world.TileType.*;

public class World {

  public static final int GRID_WIDTH = 40;
  public static final int GRID_HEIGHT = 40;
  private static final int WINDOW_HEIGHT = dev.sunshine_sudo.snake.Window.getWindowHeight();
  private static final int WINDOW_WIDTH = Window.getWindowWidth();
  private static final int GRID_WIDTH_PXL = WINDOW_WIDTH / GRID_WIDTH;
  private static final int GRID_HEIGHT_PXL = WINDOW_HEIGHT / GRID_HEIGHT;
  private static boolean initialized = false;
  private static TileType[][] tiles = new TileType[GRID_WIDTH][GRID_HEIGHT];

  private static int foodX;
  private static int foodY;

  public World() {
    for (int x = 0; x < GRID_WIDTH; x++) {
      for (int y = 0; y < GRID_HEIGHT; y++) {
        tiles[x][y] = Empty;
      }
    }
    initialized = true;
  }

  public static void draw(Graphics2D graphics) {
    if (!initialized) {
      throw new IllegalStateException("Not yet initialized.");
    }
    drawTile(foodX, foodY, Food, graphics);
  }

  public static void drawTile(int x, int y, TileType tile, Graphics2D graphics) {
    switch (tile) {
      case Body:
        graphics.setColor(Color.WHITE);
        break;
      case Food:
        graphics.setColor(Color.RED);
        break;
      default:
        return;
    }
    graphics.fillRect(x * GRID_WIDTH_PXL,
            (WINDOW_HEIGHT - GRID_HEIGHT_PXL) - (y * GRID_HEIGHT_PXL),
            GRID_WIDTH_PXL, GRID_HEIGHT_PXL);
  }

  public static void placeNewFood() {
    if (!initialized) {
      throw new IllegalStateException("Not yet initialized.");
    }
    int newFoodX;
    int newFoodY;
    do {
      newFoodX = (int) (Math.random() * GRID_WIDTH);
      newFoodY = (int) (Math.random() * GRID_HEIGHT);
    } while (getTile(newFoodX, newFoodY) != Empty);
    foodX = newFoodX;
    foodY = newFoodY;
    tiles[foodX][foodY] = Food;
  }

  public static TileType getTile(int x, int y) {
    if (!initialized) {
      throw new IllegalStateException("Not yet initialized.");
    }
    if (x >= GRID_WIDTH || x < 0 || y >= GRID_HEIGHT || y < 0) {
      return Abyss;
    }
    return tiles[x][y];
  }

  public static void setTile(int x, int y, TileType tileType) {
    if (!initialized) {
      throw new IllegalStateException("Not yet initialized.");
    }
    if (x >= GRID_WIDTH || x < 0 || y >= GRID_HEIGHT || y < 0) {
      throw new IllegalArgumentException("Cannot a tile out side of the map. The map size is " +
              GRID_WIDTH + "x" + GRID_HEIGHT + " and you tried to set a tile at " + x + "x" + y +
              ".");
    }
    tiles[x][y] = tileType;
  }

  public static int getGridWidth() {
    return GRID_WIDTH;
  }

  public static int getGridHeight() {
    return GRID_HEIGHT;
  }

}
