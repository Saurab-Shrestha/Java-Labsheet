import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIForm extends JFrame implements ActionListener {
    JTextField t1,t2;
    JLabel l1,l2;
    JButton b1,b2,b3;
    public GUIForm()
    {
        super("GUI Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1=new JLabel("Input any string");
        l2=new JLabel("Result:");
        t1=new JTextField(10);
        t2=new JTextField(10);
        t2.setEditable(false);
        b1=new JButton("Check Palindrome");
        b1.setBounds(140,20,10,30);
        b1.addActionListener(this);
        b2=new JButton("Reverse");
        b2.addActionListener(this);
        b3=new JButton("Find Vowels");
        b3.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT,150,10));
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);
        add(b3);
        setSize(400,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String inputString=t1.getText();
        if(e.getSource()==b1)
        {
            if(Palindrome(inputString)==true)
                t2.setText("TRUE");
            else
                t2.setText("FALSE");
        }
        else if(e.getSource()==b2)
        {
            t2.setText(Reverse(inputString));
        }
        else
        {
            t2.setText(Vowels(inputString));
        }
    }

    public static String Reverse(String value)
    {
        String rev=new String();
        for (int i=value.length()-1;i>=0;i--)
            rev=rev+value.charAt(i);
        return rev;
    }

    public static Boolean Palindrome(String value) {
        int i;
        String rev=Reverse(value);
        rev=rev.toLowerCase();
        value=value.toLowerCase();
        for ( i=0;i<value.length();i++)
            if(rev.charAt(i)!=value.charAt(i))
                break;
        if(i!=value.length())
            return false;
        else
            return true;
    }

    public static String Vowels(String value) {
        String val=new String();
        for(int i=0;i<value.length();i++)
        {
            char x=value.charAt(i);
            if(x=='a'||x=='e'||x=='i'||x=='o'||x=='u'||x=='A'||x=='E'||x=='I'||x=='O'||x=='U')
                val+=x;
        }
        return val;
    }

    public static void main(String a[])
    {
        new GUIForm();
    }
}