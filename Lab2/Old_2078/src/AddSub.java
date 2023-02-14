import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
public class AddSub  {
    JLabel l1,l2,result;
    JTextField t1,t2,r;
    JFrame f= new JFrame();
    AddSub()
    {
//        f.super("Add and Subtract with Mouse Event");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        l1 = new JLabel("First Number");
        f.add(l1);
        t1 = new JTextField(10);
        f.add(t1);
        l2 = new JLabel("Second Number");
        f.add(l2);
        t2 = new JTextField(10);
        f.add(t2);
        result = new JLabel("Result");
        f.add(result);
        r = new JTextField(10);
        f.add(r);
        r.setEditable(false);
        f.addMouseListener(new mousechecker());
        f.setSize(300,300);
        f.setLayout(new FlowLayout());
        f.setVisible(true);

    }
    class mousechecker extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            float x,y,z;
            x = Float.parseFloat(t1.getText());
            y = Float.parseFloat(t2.getText());
            z = x+y;
            r.setText(String.valueOf(z));
        }
        public void mouseReleased(MouseEvent e)
        {
            float x,y,z;
            x = Float.parseFloat(t1.getText());
            y = Float.parseFloat(t2.getText());
            z = x-y;
            r.setText(String.valueOf(z));
        }
    }


    public static void main(String[] args)
    {
        new AddSub();
    }

}
