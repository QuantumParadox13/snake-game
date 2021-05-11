package csNotes;
import javax.swing.JFrame;
import java.awt.*;

public class GameFrame extends JFrame{
    private JFrame frame;
    private GamePanel panel;
    public GameFrame(){
        frame = new JFrame("snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new GamePanel();
        panel.setPreferredSize(new Dimension(800, 1000));
        panel.setBackground(new Color(145,132,18));
        frame.getContentPane().add(panel);
    }

    public void display(){
        frame.pack();
        frame.setVisible(true);
    }
}
