import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddMultiply extends  JFrame implements ActionListener {
    JTextField t1, t2,t3, result;
    JLabel l1, l2, l3, r2;
    JButton b1, b2,b3;

    public AddMultiply()
    {
        super("Add and Mutiply and Simple Interest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new JLabel("First Number or Principle");
        l2 = new JLabel("Second Number or Interest");
        l3 = new JLabel("Time");
        r2 = new JLabel("Result");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        result = new JTextField(10);
        result.setEditable(false);
        b1 = new JButton("Add");
        b1.addActionListener(this);
        b2 = new JButton("Multiply");
        b2.addActionListener(this);
        b3 = new JButton("Simple Interest");
        b3.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT,150,10));
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(r2);
        add(result);
        add(b1);
        add(b2);
        add(b3);
        setSize(400,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        float time,x, y,z;
        x = Float.parseFloat(t1.getText());
        y = Float.parseFloat(t2.getText());
        time = Float.parseFloat(t3.getText());

        if(e.getSource()== b1){
            z = x+y;
            result.setText(String.valueOf(z));
        }
        else if(e.getSource() == b2) {
            z = x*y;
            result.setText(String.valueOf(z));
        }
        else{
            z = (x * y * time) / 100;
            result.setText(String.valueOf(z));
        }
    }
    public static void main(String args[])
    {
        new AddMultiply();
    }
}
