import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlowLay extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JButton b;
    public FlowLay()
    {
        super("Simple Interest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1=new JLabel("Principle:");
        l2=new JLabel("Time:");
        l3=new JLabel("Rate:");
        l4=new JLabel("Interest:");
        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        t4=new JTextField(10);
        t4.setEditable(false);
        b=new JButton("Calculate");
        b.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT,150,10));
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b);
        setSize(400,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        double p,t,r,interest;
        p=Double.parseDouble(t1.getText());
        t=Double.parseDouble(t2.getText());
        r=Double.parseDouble(t3.getText());
        interest=(p*t*r)/100;
        t4.setText(String.valueOf(interest));
    }

    public static void main(String a[])
    {
        new FlowLay();
    }
}