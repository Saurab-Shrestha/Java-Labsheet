import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class UserAuth extends JFrame
{
    public static void main(String[] args)
    {
        UserAuth app   =new UserAuth();
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }

    public UserAuth ()
    {
        setLayout(new FlowLayout());
        add(new JLabel("Username"));
        JTextField LoginTextField = new JTextField(5);
        add(LoginTextField);

        add(new JLabel("Password"));
        JPasswordField LoginPasswordField = new JPasswordField(10);
        add(LoginPasswordField);

        JButton LoginButton = new JButton("Login");
        add(LoginButton);

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = LoginTextField.getText();
                char[] password = LoginPasswordField.getPassword();
                char[] actualPassword = {'a','d','m','i','n'};

                if (username.equals("admin") && Arrays.equals(actualPassword,password))
                {
                    System.out.println("access granted");
                    LoginTextField.setText("");
                    LoginPasswordField.setText("");
                    LoginTextField.requestFocus();
                }
                else
                {
                    System.out.println("access denied");
                    LoginTextField.setText("");
                    LoginPasswordField.setText("");
                    LoginTextField.requestFocus();
                }
            }
        });
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}