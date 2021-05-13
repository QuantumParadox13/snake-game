import java.awt.*;
import java.util.*;

public class SnakeRunner {
    public static void start() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        Snake head = new Snake();
        head.createSnakeWindow(100, 100, 150, 100);

        Fruit fruit = new Fruit();
        fruit.createSnakeWindow(100, 100, 150, 400);

        ArrayList<SnakeBody> bodies = new ArrayList<SnakeBody>(); // *make new arrayList of snake objects
        bodies.add(new SnakeBody()); // add first body
        bodies.get(0).createSnakeWindow(100, 100, 100, 100); // *creates window for first body

        boolean alive = true; // *sets alive = true
        int direction = 2; // *0 = up, 1 = left, 2 = right, 3 = down
        int speed = 1;
        head.reqFocus();

        while (alive) {
            direction = head.d(direction);
            if (head.gotFruit(fruit)) {

                

                fruit.changeLocation(rand(width), rand(height));
                int dirX, dirY;
                if (bodies.size() == 1) {
                    dirX = bodies.get(bodies.size() - 1).getLocationX() - head.getLocationX();
                    dirY = bodies.get(bodies.size() - 1).getLocationY() - head.getLocationY();
                } else {
                    dirX = bodies.get(bodies.size() - 1).getLocationX() - bodies.get(bodies.size() - 2).getLocationX();
                    dirY = bodies.get(bodies.size() - 1).getLocationY() - bodies.get(bodies.size() - 2).getLocationY();
                }
                bodies.add(new SnakeBody());// make new body
                if (dirX == 0) {
                    if (dirY < 0) {
                        bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                                bodies.get(bodies.size() - 2).getLocationX(),
                                bodies.get(bodies.size() - 2).getLocationY() - 50);
                    } else {
                        bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                                bodies.get(bodies.size() - 2).getLocationX(),
                                bodies.get(bodies.size() - 2).getLocationY() + 50);
                    }
                } else {
                    if (dirX < 0) {
                        bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                                bodies.get(bodies.size() - 2).getLocationX() - 50,
                                bodies.get(bodies.size() - 2).getLocationY());
                    } else {
                        bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                                bodies.get(bodies.size() - 2).getLocationX() + 50,
                                bodies.get(bodies.size() - 2).getLocationY());
                    }
                }

                for (int i = bodies.size() - 1; i >= 0; i--) {
                    bodies.get(i).reqFocus();
                }
                head.reqFocus();
            }

            if (bodies.size() > 1) {
                for (int i = bodies.size() - 1; i > 0; i--) {
                    bodies.get(i).changeLocation(bodies.get(i - 1).getLocationX(), bodies.get(i - 1).getLocationY());
                }
            }
            bodies.get(0).changeLocation(head.getLocationX(), head.getLocationY());
            head.move(direction);

            for (int i = 0; i < bodies.size(); i++) {
                if (!head.isAlive(bodies.get(i))) {
                    alive = false;
                }
            }
            wait(500 * speed);
        }
    }

    private static int rand(int max) {
        for (int val = ((int) (Math.random() * max) + 1)+50; val < max-50; val++) {
            if(val%50 == 0){
                return val;
            }
        }
        return -1;
    }

    public static void wait(int msec) {
        try {
            Thread.currentThread();
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}