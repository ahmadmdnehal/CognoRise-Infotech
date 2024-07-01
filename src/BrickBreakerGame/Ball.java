package BrickBreakerGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private int x, y, diameter;
    private int xSpeed = 2, ySpeed = -2;

    public Ball(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter);
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    public void reverseX() {
        xSpeed = -xSpeed;
    }

    public void reverseY() {
        ySpeed = -ySpeed;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }
}

