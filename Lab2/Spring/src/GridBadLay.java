import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GridBadLay extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JButton b;
    public GridBadLay()
    {
        setSize(400,400);
        setTitle("Simple Interest With GridBag Layout");
        setLayout(new GridBagLayout());
        GridBagConstraints s = new GridBagConstraints();

        s.gridx =0;
        s.gridy =0;
        l1=new JLabel("Principle");
        add(l1);
        t1 = new JTextField(15);
        add(t1);

        s.gridx =0;
        s.gridy =1;
        l2=new JLabel("Time");
        add(l2,s);
        t2 = new JTextField(15);
        s.gridx = 1;
        add(t2,s);

        s.gridx =0;
        s.gridy =2;
        l3=new JLabel("Rate");
        add(l3,s);
        t3 = new JTextField(15);
        s.gridx=1;
        add(t3,s);

        s.gridx =0;
        s.gridy =3;
        l4=new JLabel("Interest");
        add(l4,s);
        t4 = new JTextField(15);
        t4.setEditable(false);
        s.gridx =1;
        add(t4,s);

        s.fill =GridBagConstraints.BOTH;
        s.gridx =1;
        s.gridy =5;
        s.gridwidth= 1;
        b = new JButton("Calculate Inrerest");
        b.addActionListener(this);
        add(b,s);

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
        new GridBadLay();
    }
}
