import java.awt.*;
import java.util.*;

public class SnakeRunner{
    private int direction;
    private static int x = 0;
    private static int y = 0;
    


    public static void start() {

        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight(); 


        //Snake m = new Snake();                how to make a snake head
        //Snake c = new SnakeBody(x, y);    how to make a snake body
        
        
        System.out.println(width + " " + height);

        
        Snake head = new Snake();
        head.createSnakeWindow(100, 100, 150, 100);
        
        
        Fruit fruit = new Fruit();
        //fruit.createSnakeWindow(100, 100, (int)(Math.random()*width) + 1, (int)(Math.random()*height) +1);
        fruit.createSnakeWindow(100, 100, 400, 400);

        ArrayList<SnakeBody> bodies = new ArrayList<SnakeBody>(); //make new arrayList of snake objects
        bodies.add(new SnakeBody()); //add first body
        bodies.get(0).createSnakeWindow(100, 100, 100, 100); // creates window for first body

        boolean alive = true; //sets alive = true
        int direction = 2;  //0 = up, 1 = left, 2 = right, 3 = down
        int speed = 1; 
        head.reqFocus();

        while(alive){
            
            direction = head.d(direction);
            if(head.gotFruit(fruit)){
                fruit.changeLocation((int)(Math.random()*width) + 1, (int)(Math.random()*height) +1);
                bodies.add(new SnakeBody());//make new body
                switch(bodies.get(bodies.size() - 2).getDirection()){
                    case 0:
                        bodies.get(bodies.size()-1).createSnakeWindow(100, 100, bodies.get(bodies.size()-2).getLocationX(), bodies.get(bodies.size()-2).getLocationY()-50);
                        break;
                    case 1:
                        bodies.get(bodies.size()-1).createSnakeWindow(100, 100, bodies.get(bodies.size()-2).getLocationX()+50, bodies.get(bodies.size()-2).getLocationY());
                        break;
                    case 2:
                        bodies.get(bodies.size()-1).createSnakeWindow(100, 100, bodies.get(bodies.size()-2).getLocationX()-50, bodies.get(bodies.size()-2).getLocationY());
                        break;
                    case 3:
                        bodies.get(bodies.size()-1).createSnakeWindow(100, 100, bodies.get(bodies.size()-2).getLocationX(), bodies.get(bodies.size()-2).getLocationY()+50);
                        break;
                    default:
                        bodies.get(bodies.size()-1).createSnakeWindow(100, 100, bodies.get(bodies.size()-2).getLocationX(), bodies.get(bodies.size()-2).getLocationY()+50);
                }
                head.reqFocus();
            }
            
            head.move(direction);
            bodies.get(0).move(direction);

            for(int i=1;i<bodies.size();i++){
                if(i==0){
                    bodies.get(0).move(direction);
                }
                bodies.get(i).move(bodies.get(i-1).getDirection());
            }

            for(int i=0;i<bodies.size();i++){
                if(!head.isAlive(bodies.get(i))){
                    alive = false;
                }
            }


            wait(1000 * speed);
        }


        //learn how to check for keypresses (in class)
        //make right amount of snakeBodies and store them in arrList of snakes (arrList body)

    
        
   
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