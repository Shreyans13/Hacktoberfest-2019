package dev.sunshine_sudo.snake.world;

public enum TileType {
  Empty, // empty tile, nothing
  Food, // increase points by one
  Body, // tail of the snake, die
  Abyss, // out of the world, die
}
