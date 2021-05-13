import java.awt.*;
import java.util.*;

public class SnakeRunner {
    public static void start() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        Snake head = new Snake(); // *makes new snake head
        head.createSnakeWindow(100, 100, 150, 100); // *makes snake head visible

        Fruit fruit = new Fruit(); // *makes new fruit
        fruit.createSnakeWindow(100, 100, rand(width-50), rand(height-50)); // *makes fruit visible at random location

        ArrayList<SnakeBody> bodies = new ArrayList<SnakeBody>(); // *make new arrayList of snake objects
        bodies.add(new SnakeBody()); // *add first body
        bodies.get(0).createSnakeWindow(100, 100, 100, 100); // *creates window for first body

        boolean alive = true; // *sets alive = true
        int direction = 2; // *0 = up, 1 = left, 2 = right, 3 = down
        int speed = 1; // *sets speed to 1
        head.reqFocus(); // *focuses head

        while (alive) { // *while snake is alive
            direction = head.d(direction); // *set direction to the direction of the head
            if (head.gotFruit(fruit)) { // *if the head got fruit
                fruit.changeLocation(rand(width), rand(height)); // *randomize location of fruit
                int dirX, dirY; // *init dirX and dirY
                if (bodies.size() == 1) { // *if there is only 1 body
                    dirX = bodies.get(bodies.size() - 1).getLocationX() - head.getLocationX(); // *calculates dirX
                    dirY = bodies.get(bodies.size() - 1).getLocationY() - head.getLocationY(); // *calculates dirY
                } else {
                    dirX = bodies.get(bodies.size() - 1).getLocationX() - bodies.get(bodies.size() - 2).getLocationX(); // *calculates dirX
                    dirY = bodies.get(bodies.size() - 1).getLocationY() - bodies.get(bodies.size() - 2).getLocationY(); // *calculates dirY
                }
                bodies.add(new SnakeBody());// *make new body
                if (dirX == 0) { // *if the change is vertical
                    if (dirY < 0) { // *if going up, make body under
                        bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                                bodies.get(bodies.size() - 2).getLocationX(),
                                bodies.get(bodies.size() - 2).getLocationY() - 50);
                    } else { // *if going down, make body above
                        bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                                bodies.get(bodies.size() - 2).getLocationX(),
                                bodies.get(bodies.size() - 2).getLocationY() + 50);
                    }
                } else { // *if horizontal change
                    if (dirX < 0) { // *if going right, make body left
                        bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                                bodies.get(bodies.size() - 2).getLocationX() - 50,
                                bodies.get(bodies.size() - 2).getLocationY());
                    } else { // *if going left, make body right
                        bodies.get(bodies.size() - 1).createSnakeWindow(100, 100,
                                bodies.get(bodies.size() - 2).getLocationX() + 50,
                                bodies.get(bodies.size() - 2).getLocationY());
                    }
                }

                for (int i = bodies.size() - 1; i >= 0; i--) { // *cascades body windows
                    bodies.get(i).reqFocus();
                }
                head.reqFocus(); // *gets focus of head
            }

            if (bodies.size() > 1) { // *if there is more than one body
                for (int i = bodies.size() - 1; i > 0; i--) { // *for each body
                    bodies.get(i).changeLocation(bodies.get(i - 1).getLocationX(), bodies.get(i - 1).getLocationY()); // *moves all bodies except [0]
                }
            }
            bodies.get(0).changeLocation(head.getLocationX(), head.getLocationY()); // *moves first body
            head.move(direction); // *moves head

            for (int i = 0; i < bodies.size(); i++) { // *for each body
                if (!head.isAlive(bodies.get(i))) { // *checks each body's collision with the head
                    alive = false; // *sets alive to false, ending while loop
                    for (int j = 0; j < bodies.size(); j++) {
                        bodies.get(j).setColor(255, 0, 0); // *sets all of the snake to red color
                        head.setColor(255, 0, 0); 
                    }
                }
            }
            wait(500 * speed); // *waits 500*speed ms to set game speed
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