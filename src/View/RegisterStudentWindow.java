package View;

import javax.swing.*;
import java.awt.*;

public class RegisterStudentWindow extends JFrame {
    private JLabel login, password;
    private JTextField loginTF;
    private JPasswordField passwordField;
    private JButton loginJB, registerJB, exit, softName;
    private Container screen;
    public RegisterStudentWindow() {
        this.screen = getContentPane();
        this.softName = new JButton("Tasukete!");
        this.login = new JLabel("Username");
        this.password = new JLabel("Senhna");
        this.loginTF = new JTextField();
        this.passwordField = new JPasswordField();
        this.loginJB = new JButton("Login");
        this.registerJB = new JButton("Cadastrar");
        this.exit = new JButton("Sair");
    }
}
