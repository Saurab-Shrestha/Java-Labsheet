import javax.swing.*;
import java.awt.*;

public class BorderLayoutEg extends JFrame {
    JButton b1,b2,b3,b4,b5;
    BorderLayoutEg(){
        setSize(500,250);
        setTitle("BorderLayout Example");
        setLayout(new BorderLayout(10,10));

        b1=new JButton("Header");
        b2=new JButton("Footer");
        b3=new JButton("Sidebar1");
        b4=new JButton("Sidebar2");
        b5=new JButton("Mainpage");

        add(b1,BorderLayout.NORTH);
        add(b2,BorderLayout.SOUTH);
        add(b3,BorderLayout.EAST);
        add(b4,BorderLayout.WEST);
        add(b5,BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String args[])
    {
        BorderLayoutEg frame=new BorderLayoutEg();
    }
}