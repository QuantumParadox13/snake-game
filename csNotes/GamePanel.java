package csNotes;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener , KeyListener{
    private Timer time = new Timer(5, this);
    private int locY;
    private int locX;
    private Image nilay = new ImageIcon("/home/maxine/AP-CS/Project/snake-games/csNotes/img.png").getImage();

    public GamePanel() {
        addKeyListener(this);
        time.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        locX = (int) (Math.random() * 600);
        locY = (int) (Math.random() * 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // allows g to be painted upon
        g.drawImage(nilay, 0, 0, null);
        g.drawRect(locX, locY, 100, 100);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int c = e.getKeyCode();
        if(c==KeyEvent.VK_LEFT){   
            locX-=5;
        }
        if(c==KeyEvent.VK_RIGHT){
            locX+=5;
        }
    }

    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
