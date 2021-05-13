import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transparent extends JComponent{


    public static void createTransparentWindow(){
        JFrame t = new JFrame("transparent");
        t.setSize(1000, 500);
        t.setVisible(true);
        // t.getContentPane().setOpaque(false);
        ((JComponent) t.getContentPane()).setOpaque(true);
        t.getContentPane().setBackground(new Color(0, 0, 0, 0));
        t.addWindowListener(new WindowAdapter() {// when window closes, exit program
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
