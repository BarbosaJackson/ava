package View;

import bean.Aluno;
import daos.AlunoDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class Login extends JFrame {
    private JLabel login, password;
    private JTextField loginTF;
    private JPasswordField passwordField;
    private JButton loginJB, registerJB, exit, softName;
    private Container screen;
    public Login() {
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

    private void position() {
        softName.setBounds(50, 50, 200, 40);
        exit.setBounds(230, 30, 100, 50);
        login.setBounds(30, 100, 100, 20);
        password.setBounds(30, 140, 100, 20);
        loginTF.setBounds(140, 100, 100, 20);
        passwordField.setBounds(140, 140, 100, 20);
        loginJB.setBounds(60, 190, 100, 50);
        registerJB.setBounds(180, 190, 120, 50);
    }

    public void actions() {
        exit.addActionListener((ActionEvent ae) -> {
            dispose();
        });
        registerJB.addActionListener((ActionEvent ae) -> {
            new RegisterStudentWindow().initScreen();
            dispose();
        });
        loginJB.addActionListener((ActionEvent ae) -> {
            String query = "select * from aluno where usuario = '" + loginTF.getText() + "' and senha = '"
                    + new String(passwordField.getPassword()) + "'";
            List<Aluno> alu = new AlunoDao().getAlunos(query);
            if(alu.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos, favor, verifique");
            } else {
                 new MainFrame().initScreen();
                dispose();
            }
        });
    }

    public void initScreen() {
        position();
        ViewAPI.paint(login, softName, password, exit);
        screen.setBackground(UTILS.backgroundColorPrimary);
        ViewAPI.addItems(screen, softName, login, password, loginTF, passwordField, loginJB, registerJB, exit);
        ViewAPI.configScreen(this, 330, 280);
        JButtonUtils.configButton(registerJB, loginJB);
        JButtonUtils.allignButtons(exit);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        JButtonUtils.allignButtons(softName);
        JButtonUtils.paintButtons(softName);
        softName.setEnabled(false);
        actions();
        loginTF.requestFocus();
    }

    public static void main(String[] args) {
        new Login().initScreen();
    }
}
