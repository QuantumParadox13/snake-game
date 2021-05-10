import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Snake{
    private JFrame m;
    private int posX, posY, width, height, direction;

    public Snake(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int)screenSize.getWidth();
        height = (int)screenSize.getHeight(); 
        
    }

    public void createSnakeWindow(int sizeX, int sizeY, int posX, int posY){
        direction = 0;
        this.posX = posX;
        this.posY = posY;
        m = new JFrame("hello gamer");//creates frame
        m.setSize(sizeX, sizeY);//sets size of frame
        m.addWindowListener(new WindowAdapter() {//when window closes, exit program
            public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
            }        
         });  

        m.setLocation(posX, posY);//sets location to x, y relative to 0, 0(top left)
        
        m.setVisible(true);//makes frame visible
    }

    public void changeLocation(int x, int y){
        m.setLocation(x, y);
        posX = x;
        posY = y;
    }

    public void move(int direction){
        switch(direction){
            case 0: 
                posY+=50;
                m.setLocation(posX, posY);
                break;
            case 1:
                posX-=50;
                m.setLocation(posX, posY);
                break;
            case 2:
                posX+=50;
                m.setLocation(posX, posY);
                break;
            case 3:
                posY-=50;
                m.setLocation(posX, posY);
                break;
        }
        this.direction = direction;
    }

    public boolean isAlive(Snake x){
        if(posX < 0 
        || posX > width
        || posY < 0 
        || posY > height){
            return false;
        }
        
        if(posX == x.getLocationX() && posY == x.getLocationY()){
            return false;
        }

        return true;
    }

    public int getLocationX(){
        return posX;
    }
    public int getLocationY(){
        return posY;
    }

    public int getDirection(){
        return direction;
    }

    public boolean gotfruit(Fruit x){
        if(x.getLocationX() == posX && x.getLocationY() == posY){
            return true;
        }
        
        return false;
    }
}