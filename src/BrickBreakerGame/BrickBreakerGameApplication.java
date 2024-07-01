package BrickBreakerGame;

import javax.swing.JFrame;

public class BrickBreakerGameApplication {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker Game");
        GameBoard gameBoard = new GameBoard();
        frame.add(gameBoard);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

