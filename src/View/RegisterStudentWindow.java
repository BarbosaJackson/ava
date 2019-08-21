package View;

import bean.Aluno;
import daos.AlunoDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegisterStudentWindow extends JFrame {
    private JLabel login, password, nome, instituicao, e_mod;
    private JTextField loginTF, nomeTF, instituicaoTF;
    private JPasswordField passwordField;
    private JCheckBox e_modJCB;
    private JButton registerJB, exit, softName;
    private Container screen;
    public RegisterStudentWindow() {
        this.screen = getContentPane();
        this.softName = new JButton("Tasukete!");
        this.login = new JLabel("Username");
        this.password = new JLabel("Senha");
        this.nome = new JLabel("Nome");
        this.instituicao = new JLabel("Instituição");
        this.e_mod = new JLabel("Moderador");
        this.loginTF = new JTextField();
        this.passwordField = new JPasswordField();
        this.nomeTF = new JTextField();
        this.instituicaoTF = new JTextField();
        this.e_modJCB = new JCheckBox();
        this.registerJB = new JButton("Cadastrar");
        this.exit = new JButton("Sair");
    }
    private void position() {
        softName     .setBounds(50, 50, 200, 40);
        exit         .setBounds(230, 30, 100, 50);
        login        .setBounds(30, 100, 100, 20);
        password     .setBounds(30, 130, 100, 20);
        nome         .setBounds(30, 160, 100, 20);
        instituicao  .setBounds(30, 190, 100, 20);
        e_mod        .setBounds(30, 210, 100, 20);
        loginTF      .setBounds(150, 100, 100, 20);
        passwordField.setBounds(150, 130, 100, 20);
        nomeTF       .setBounds(150, 160, 100, 20);
        instituicaoTF.setBounds(150, 190, 100, 20);
        e_modJCB     .setBounds(150, 220, 100, 20);
        registerJB   .setBounds(75, 250, 100, 50);
    }
    private void actions() {
        exit.addActionListener((ActionEvent ae) -> {
            new Login().initScreen();
            dispose();
        });
        registerJB.addActionListener((ActionEvent ae)->{
            // String nome, String usuario, String senha, int e_moderador, int pontuacao, String instituicao
            int emoderador = e_modJCB.isSelected() ? 1 : 0;
            Aluno a = new Aluno(
                    nomeTF.getText(), loginTF.getText(), new String(passwordField.getPassword()),
                    emoderador, 0, instituicaoTF.getText());
            System.out.println(a);
            new AlunoDao().addAluno(a);
            new Login().initScreen();
            dispose();
        });
    }

    public void initScreen() {
        position();
        ViewAPI.paint(login, softName, password, nome, instituicao, e_mod, exit, e_modJCB);
        e_modJCB.setBackground(UTILS.backgroundColorPrimary);
        screen.setBackground(UTILS.backgroundColorPrimary);
        ViewAPI.addItems(screen, softName, login, password, loginTF, passwordField, registerJB, exit, e_mod, nome, instituicao, loginTF);
        ViewAPI.addItems(screen, loginTF, passwordField, nomeTF, instituicaoTF, e_modJCB);
        ViewAPI.configScreen(this, 330, 400);
        JButtonUtils.configButton(registerJB);
        JButtonUtils.allignButtons(exit);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        JButtonUtils.allignButtons(softName);
        JButtonUtils.paintButtons(softName);
        softName.setEnabled(false);
        actions();
        loginTF.requestFocus();
    }
}
