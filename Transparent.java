import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transparent extends JComponent{


    public static void createTransparentWindow(){
        JFrame t = new JFrame("transparent");
        JFrame close = new JFrame("Close");
        JButton button = new JButton("Close Me");
        button.addActionListener(e -> System.exit(0));
        t.getContentPane().add(button, BorderLayout.EAST);//makes button east side
        // t.getContentPane().add(new JLabel("Drag Me", JLabel.CENTER), BorderLayout.CENTER);//makes label in center


        close.setSize(200, 50);
        t.setSize(1000, 500);
        t.setUndecorated(true);

        
        // ((JComponent) t.getContentPane()).setOpaque(true);
        t.setOpacity(0.1f);
        // t.getContentPane().setBackground(new Color(0, 0, 0, 0));


        close.addWindowListener(new WindowAdapter() {// when window closes, exit program
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        t.setVisible(true);
        close.setVisible(true);
    }
}
