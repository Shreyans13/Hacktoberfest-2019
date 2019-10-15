package dev.sunshine_sudo.snake.player;

import dev.sunshine_sudo.snake.Game;
import dev.sunshine_sudo.snake.utils.KeyboardListener;
import dev.sunshine_sudo.snake.world.TileType;
import dev.sunshine_sudo.snake.world.World;

import java.awt.*;
import java.util.ArrayDeque;

public class Snake {

  private int bonus = 0;

  private ArrayDeque<int[]> tailPieces;

  private Direction lastDirection = Direction.None;

  public Snake(int x, int y) {
    tailPieces = new ArrayDeque<int[]>();
    tailPieces.addLast(new int[]{x, y});
    World.setTile(x, y, TileType.Body);
  }

  public void update() {
    int[] headInArray = tailPieces.peekFirst();
    int headX = headInArray[0];
    int headY = headInArray[1];


    Direction snakeDirection = KeyboardListener.getSnakeDirection();
    lastDirection = snakeDirection;

    if (snakeDirection == Direction.None) {
      return;
    }

    int newPosX = snakeDirection == Direction.Right ? headX + 1 :
            snakeDirection == Direction.Left ? headX - 1 : headX;
    int newPosY = snakeDirection == Direction.Up ? headY + 1 :
            snakeDirection == Direction.Down ? headY - 1 : headY;

    if (World.getTile(newPosX, newPosY) == TileType.Empty) {
      tailPieces.addFirst(new int[]{newPosX, newPosY});
      World.setTile(newPosX, newPosY, TileType.Body);
      if (bonus == 0) {
        int[] tailEndArr = tailPieces.pollLast();
        World.setTile(tailEndArr[0], tailEndArr[1], TileType.Empty);
      } else {
        bonus--;
      }
    } else if (World.getTile(newPosX, newPosY) == TileType.Food) {
      Game.increaseScore();
      tailPieces.addFirst(new int[]{newPosX, newPosY});
      World.setTile(newPosX, newPosY, TileType.Body);
      World.placeNewFood();
      bonus++; // bonus+1 is how many pieces the snake will gain when it touches food
    } else {
      Game.gameOver();
    }
  }

  public void draw(Graphics2D graphics) {
    for (int[] arr : tailPieces) {
      World.drawTile(arr[0], arr[1], TileType.Body, graphics);
    }
  }

  public Direction getLastDirection() {
    return lastDirection;
  }
}
