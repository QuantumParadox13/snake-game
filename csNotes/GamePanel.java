package csNotes;
import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    public GamePanel() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(20,20,50,50);
    }

}
