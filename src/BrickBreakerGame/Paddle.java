package BrickBreakerGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
    private int x, y, width, height;
    private int moveSpeed = 20;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }

    public void moveLeft() {
        if (x > 0) {
            x -= moveSpeed;
        }
    }

    public void moveRight(int boardWidth) {
        if (x + width < boardWidth) {
            x += moveSpeed;
        }
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

