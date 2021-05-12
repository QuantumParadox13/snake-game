package csNotes;
import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    public GamePanel() {
        setFocusable(true); //sets GamePanel able to be focused
        setFocusTraversalKeysEnabled(false); //sets focus traversal keys to be disabled
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); //allows g to be painted upon
        g.fillRect(20,20,50,50); //makes rectangle at 20, 20 size 50, 50
    }

}
