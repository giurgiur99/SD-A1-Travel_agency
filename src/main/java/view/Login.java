package view;

import javax.swing.*;


public class Login extends JFrame {
    private JTextField usernameJTextField;
    private JPasswordField passwordJTextField;
    private JButton signUpButton;
    private JButton loginButton;
    private JPanel panel1;


    public Login (){
        super("Login tab");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setContentPane(panel1);
        this.setLocationRelativeTo(null);
        this.setBounds(100,100,450,500);
        this.setVisible(true);
    }

    public JTextField getUsernameJTextField() {
        return usernameJTextField;
    }

    public JPasswordField getPasswordJTextField() {
        return passwordJTextField;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
