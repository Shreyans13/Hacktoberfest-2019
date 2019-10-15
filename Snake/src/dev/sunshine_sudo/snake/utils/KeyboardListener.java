package dev.sunshine_sudo.snake.utils;


import dev.sunshine_sudo.snake.Game;
import dev.sunshine_sudo.snake.player.Direction;
import dev.sunshine_sudo.snake.player.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

  private static Direction snakeDirection = Direction.None;
  private static Snake snake;

  public KeyboardListener(Snake snake) {
    KeyboardListener.snake = snake;
  }

  public static Direction getSnakeDirection() {
    return snakeDirection;
  }

  public static void reset(Snake newSnakeReference) {
    snake = newSnakeReference;
    snakeDirection = Direction.None;
  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {
    processKey(keyEvent.getKeyCode());
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    processKey(keyEvent.getKeyCode());
  }

  private void processKey(int keyCode) {
    Direction lastDirection = snake.getLastDirection();
    boolean scoreGreaterThanZero = Game.getScore() > 0;
    switch (keyCode) {
      case KeyEvent.VK_W:
      case KeyEvent.VK_UP:
        snakeDirection = lastDirection != Direction.Down || !scoreGreaterThanZero ? Direction.Up
                : lastDirection;
        break;
      case KeyEvent.VK_D:
      case KeyEvent.VK_RIGHT:
        snakeDirection = lastDirection != Direction.Left || !scoreGreaterThanZero ?
                Direction.Right :
                lastDirection;
        break;
      case KeyEvent.VK_S:
      case KeyEvent.VK_DOWN:
        snakeDirection = lastDirection != Direction.Up || !scoreGreaterThanZero ? Direction.Down
                : lastDirection;
        break;
      case KeyEvent.VK_A:
      case KeyEvent.VK_LEFT:
        snakeDirection = lastDirection != Direction.Right || !scoreGreaterThanZero ?
                Direction.Left :
                lastDirection;
        break;
      default: // any other keys
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent keyEvent) {
  }

}
