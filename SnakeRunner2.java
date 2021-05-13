import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

public class SnakeRunner2 implements ActionListener, KeyListener {
    private static int direction;
    private Timer time = new Timer(5, this);
    private static Snake head = new Snake();
    private static ArrayList<SnakeBody> bodies = new ArrayList<SnakeBody>(); // make new arrayList of snake objects
    private static Fruit fruit = new Fruit();
    private static boolean alive = true; // sets alive = true


    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        // Snake m = new Snake(); how to make a snake head
        // Snake c = new SnakeBody(x, y); how to make a snake body

        System.out.println(width + " " + height);

        Snake head = new Snake();
        head.createSnakeWindow(100, 100, 100, 150);

        Fruit fruit = new Fruit();
        fruit.createSnakeWindow(100, 100, (int) (Math.random() * width) + 1, (int) (Math.random() * height) + 1);

        ArrayList<SnakeBody> bodies = new ArrayList<SnakeBody>(); // make new arrayList of snake objects
        bodies.add(new SnakeBody()); // add first body
        bodies.get(0).createSnakeWindow(100, 100, 100, 100); // creates window for first body

        alive = true; // sets alive = true
        direction = 0; // 0 = up, 1 = left, 2 = right, 3 = down
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                direction = 0;
                System.out.println("up");
                break;
            case KeyEvent.VK_LEFT:
                direction = 1;
                System.out.println("left");
                break;
            case KeyEvent.VK_RIGHT:
                direction = 2;
                System.out.println("right");
                break;
            case KeyEvent.VK_DOWN:
                direction = 3;
                System.out.println("down");
                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        if (head.gotFruit(fruit)) {
            fruit.changeLocation((int) (Math.random() * width) + 1, (int) (Math.random() * height) + 1);
            bodies.add(new SnakeBody());// make new body
            switch (bodies.get(bodies.size() - 2).getDirection()) {
                case 0:
                    bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                            bodies.get(bodies.size() - 2).getLocationX(),
                            bodies.get(bodies.size() - 2).getLocationY() - 100);
                    break;
                case 1:
                    bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                            bodies.get(bodies.size() - 2).getLocationX() + 100,
                            bodies.get(bodies.size() - 2).getLocationY());
                    break;
                case 2:
                    bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                            bodies.get(bodies.size() - 2).getLocationX() - 100,
                            bodies.get(bodies.size() - 2).getLocationY());
                    break;
                case 3:
                    bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                            bodies.get(bodies.size() - 2).getLocationX(),
                            bodies.get(bodies.size() - 2).getLocationY() + 100);
                    break;
            }
        }

        head.move(direction);
        for (int i = 1; i < bodies.size(); i++) {
            bodies.get(i).move(bodies.get(i - 1).getDirection());
        }

        for (int i = 0; i < bodies.size(); i++) {
            if (!head.isAlive(bodies.get(i))) {
                alive = false;
            }
        }

        wait(1000); // eventually replace this with speed
        

    }

    public static void wait(int msec) {
        try {
            Thread.currentThread();
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
