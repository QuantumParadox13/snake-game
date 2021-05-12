package csNotes;
import javax.swing.JFrame;
import java.awt.*;

public class GameFrame extends JFrame{
    private JFrame frame;
    private GamePanel panel;
    public GameFrame(){
        frame = new JFrame("snake"); //creates new frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits program? at close

        panel = new GamePanel(); //creates new panel
        panel.setPreferredSize(new Dimension(800, 1000)); //sets size
        panel.setBackground(new Color(145,132,18)); //sets background color
        frame.getContentPane().add(panel); //adds panel to frame
    }

    public void display(){
        frame.pack(); //sets frame to fit components
        frame.setVisible(true); //makes frame visible
    }
}
