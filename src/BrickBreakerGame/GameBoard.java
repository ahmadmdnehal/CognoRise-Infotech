package BrickBreakerGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements ActionListener {
    private Paddle paddle;
    private Ball ball;
    private Brick[][] bricks;
    private boolean inGame = true;
    private Timer timer;

    public GameBoard() {
        setFocusable(true);
        setBackground(Color.BLACK);
        paddle = new Paddle(250, 550, 100, 20);
        ball = new Ball(290, 530, 20);
        bricks = new Brick[5][10];

        int brickWidth = 60;
        int brickHeight = 20;
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                bricks[i][j] = new Brick(j * brickWidth + 30, i * brickHeight + 50, brickWidth, brickHeight);
            }
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    paddle.moveLeft();
                }
                if (key == KeyEvent.VK_RIGHT) {
                    paddle.moveRight(getWidth());
                }
            }
        });

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (inGame) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            paddle.draw(g2d);
            ball.draw(g2d);

            for (int i = 0; i < bricks.length; i++) {
                for (int j = 0; j < bricks[i].length; j++) {
                    bricks[i][j].draw(g2d);
                }
            }
        } else {
            endGame(g);
        }
    }

    private void endGame(Graphics g) {
        String message = "Game Over";
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(message, (getWidth() - getFontMetrics(font).stringWidth(message)) / 2, getHeight() / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            ball.move();
            checkCollision();
            repaint();
        }
    }

    private void checkCollision() {
        if (ball.getX() <= 0 || ball.getX() >= getWidth() - ball.getDiameter()) {
            ball.reverseX();
        }
        if (ball.getY() <= 0) {
            ball.reverseY();
        }
        if (ball.getY() >= getHeight()) {
            inGame = false;
        }

        if (ball.getRect().intersects(paddle.getRect())) {
            ball.reverseY();
        }

        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                if (!bricks[i][j].isDestroyed() && ball.getRect().intersects(bricks[i][j].getRect())) {
                    ball.reverseY();
                    bricks[i][j].setDestroyed(true);
                }
            }
        }

        boolean allBricksDestroyed = true;
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                if (!bricks[i][j].isDestroyed()) {
                    allBricksDestroyed = false;
                    break;
                }
            }
        }

        if (allBricksDestroyed) {
            inGame = false;
        }
    }
}

