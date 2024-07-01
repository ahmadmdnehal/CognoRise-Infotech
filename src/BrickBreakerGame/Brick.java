package BrickBreakerGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick {
    private int x, y, width, height;
    private boolean isDestroyed;

    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isDestroyed = false;
    }

    public void draw(Graphics g) {
        if (!isDestroyed) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }
}

