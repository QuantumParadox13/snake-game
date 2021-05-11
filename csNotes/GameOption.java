package csNotes;
import javax.swing.JOptionPane;
// import java.awt.*;s
// import java.awt.event.*;    
// import javax.swing.*;

public class GameOption {
    private GameFrame lotf;
    int direction;
    public GameOption(){
        lotf = new GameFrame();
    }


    public void start(){
        int x = JOptionPane.showConfirmDialog(null, "play le game", null, 0);
        if(x == JOptionPane.YES_OPTION){
            lotf.display();
        }
        if(x == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Sorry To See You Go");
        } 
    }
}