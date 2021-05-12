package csNotes;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    private Timer time = new Timer(5, this);
    private int locY;
    private int locX;

    public GamePanel() {
        time.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        locX = (int) (Math.random() * 600);
        locY = (int) (Math.random() * 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // allows g to be painted upon
        g.fillRect(locX, locY, 50, 50); // makes rectangle at 20, 20 size 50, 50
        g.drawString("Snake", 390, 250); // say snake
        g.setColor(Color.BLUE);
        g.drawLine(390, 250, 428, 250); // make underline
        for (int i = 0; i < 10; i++) {
            g.fillRect(locX, locY, 50, 50);
        }
    }

    public void actionPerformed(ActionEvent e) {
        locY += 1;
        if (locY == 1000) {
            locY = 0;
        }
        repaint();
    }

}
