import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class SnakeGame extends JPanel implements ActionListener {

    private Timer timer;
    private int delay = 100;
    private Snake snake;
    private Apple apple;

    public SnakeGame() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
        setFocusable(true);

        snake = new Snake();
        apple = new Apple(9,Color.red);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                snake.keyPressed(e);
            }
        });

        timer = new Timer(delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
        apple.draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        snake.move();
        if (snake.collidesWith(apple)) {
            snake.grow();
            apple.randomizePosition();
        }
        if (snake.collidesWithItself()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game over!");
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new SnakeGame());
        frame.pack();
        frame.setVisible(true);
    }
}

class Snake {

    private final int SIZE = 10;
    private final int[] x = new int[1000];
    private final int[] y = new int[1000];
    private int length = 3;
    private int dx = 0;
    private int dy = SIZE;

    public Snake() {
        x[0] = 100;
        y[0] = 100;
        x[1] = 100;
        y[1] = 90;
        x[2] = 100;
        y[2] = 80;
    }



    public void draw(Graphics g) {
        g.setColor(Color.white);
        for (int i = 0; i < length; i++) {
            g.fillRect(x[i], y[i], SIZE, SIZE);
        }
    }

    public void move() {
        for (int i = length; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        x[0] += dx;
        y[0] += dy;

    }

    public void grow() {
        length++;
    }

    public boolean collidesWith(Apple apple) {
        return x[0] == apple.getX() && y[0] == apple.getY();
    }

    public boolean collidesWithItself() {
        for (int i = 1; i < length; i++) {
            if (x[i] == x[0] && y[i] == y[0]) {
                return true;
            }
        }
        return false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && dx == 0) {
            dx = -SIZE;
            dy = 0;
        }
        if (key == KeyEvent.VK_RIGHT && dx == 0) {
            dx = SIZE;
            dy = 0;
        }
        if (key == KeyEvent.VK_UP && dy == 0) {
            dx = 0;
            dy = -SIZE;
        }
        if (key == KeyEvent.VK_DOWN && dy == 0) {
            dx = 0;
            dy = SIZE;
        }
    }
}
 class Apple {
    private int x; // x-coordinate of the apple
    private int y; // y-coordinate of the apple
    private final int SIZE; // size of the apple
    private final Color COLOR; // color of the apple

    // Constructor
    public Apple(int size, Color color) {
        SIZE = size;
        COLOR = color;
        randomizePosition();
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Draw the apple
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(x, y, SIZE, SIZE);
    }

    // Generate a new random position for the apple
    public void randomizePosition() {
        Random random = new Random();
        x = random.nextInt(480/SIZE) * SIZE;
        y = random.nextInt(480/SIZE) * SIZE;
    }
}
