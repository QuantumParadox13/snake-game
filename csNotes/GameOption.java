package csNotes;
import javax.swing.JOptionPane;
// import java.awt.*;s
// import java.awt.event.*;    
// import javax.swing.*;

public class GameOption {
    private GameFrame lotf;
    int direction;
    public GameOption(){
        lotf = new GameFrame(); //creates new GameFrame
    }


    public void start(){
        int x = JOptionPane.showConfirmDialog(null, "play the game?", null, 0); //shows popup with options (yes, no, cancel)
        if(x == JOptionPane.YES_OPTION){ // if yes is pressed
            lotf.display(); //run game
        }
        if(x == JOptionPane.NO_OPTION){ //if no is pressed
            JOptionPane.showMessageDialog(null, "Sorry To See You Go"); //says "sorry to see you go"
        } 
    }
}