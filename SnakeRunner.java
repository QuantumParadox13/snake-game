import java.awt.*;
//import java.util.*;

public class SnakeRunner{
    public static void start() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight(); 


        //Snake m = new Snake();                how to make a snake head
        //Snake c = new SnakeBody(x, y);    how to make a snake body
        

        Snake head = new Snake();
        Snake body = new SnakeBody();

        
        body.createSnakeWindow(100, 100, 400, 100);
        head.createSnakeWindow(100, 100, 500, 100);
        

        while(head.getLocationX()<=width){
            wait(700);
            head.move(2);
            body.move(2);
        }
        
        
        System.out.println(width + " " + height);

        /*
        Snake head = new Snake();
        head.createSnakeWindow(100, 100, X, Y);
        
        Fruit fruit = new Fruit();
        fruit.createSnakeWindow(random.nextInt(width + 1), random.nextInt(height + 1))

        ArrayList<SnakeBody> bodies = new ArrayList<SnakeBody>(); //make new arrayList of snake objects
        bodies.add(new SnakeBody()); //add first body
        bodies.get(0).createSnakeWindow(100, 100, 100, 100); // creates window for first body

        boolean alive = true; //sets alive = true
        int direction = 0;  //0 = up, 1 = left, 2 = right, 3 = down
        int speed = 1; 

        while(alive){
            if(head.gotFruit(fruit)){
                fruit.changeLocation(random.nextInt(width + 1), random.nextInt(height + 1));
                bodies.add(new SnakeBody());//make new body
                switch(bodies.get(bodies.size() - 2).getDirection()){
                    case 0:
                        bodies.get(bodies.size()-1).createSnakeWindow(100, 100, bodies.get(bodies.size()-2).getLocationX(), bodies.get(bodies.size()-2).getLocationY()-100);
                        break;
                    case 1:
                        bodies.get(bodies.size()-1).createSnakeWindow(100, 100, bodies.get(bodies.size()-2).getLocationX()+100, bodies.get(bodies.size()-2).getLocationY());
                        break;
                    case 2:
                        bodies.get(bodies.size()-1).createSnakeWindow(100, 100, bodies.get(bodies.size()-2).getLocationX()-100, bodies.get(bodies.size()-2).getLocationY());
                        break;
                    case 3:
                        bodies.get(bodies.size()-1).createSnakeWindow(100, 100, bodies.get(bodies.size()-2).getLocationX(), bodies.get(bodies.size()-2).getLocationY()+100);
                        break;
                }
            }
            
            head.move(direction);
            for(int i=1;i<bodies.size();i++){
                bodies.get(i).move(bodies.get(i-1).getDirection());
            }

            switch(keypress){
                case 0:
                    if(direction != 3){direction = 0;}
                    break;
                case 1:
                    if(direction != 2){direction = 1;}
                    break;
                case 2:
                    if(direction != 1){direction = 2;}
                    break;
                case 3:
                    if(direction != 0){direction = 3;}
                    break;
            }
            
            for(int i=0;i<bodies.size();i++){
                if(!head.isAlive(bodies.get(i))){
                    alive = false;
                }
            }

            
            
            wait(1000 * speed); //eventually replace this with speed
        }


        //learn how to check for keypresses (in class)
        //make right amount of snakeBodies and store them in arrList of snakes (arrList body)

    */
        
   
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