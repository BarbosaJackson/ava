package View;

import bean.Aluno;
import bean.Materia;
import bean.Mensagem;
import daos.MateriaDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame{
    private Container screen;
    private JPanel leftPanel, forumPanel, classPanel;
    private JLabel posRaking, forumName, className;
    private JButton criarTurma, addTurma, criarTopico, enviarMensagem, exit, softName;
    private ArrayList<JButton> forumPosts;
    private Aluno usuario;
    public MainFrame(Aluno usuario) {
        screen = getContentPane();
        this.usuario = usuario;
        leftPanel = new JPanel(null);
        forumPanel = new JPanel(null);
        exit = new JButton("Sair");
        softName = new JButton(UTILS.toHtmlH2("Tasukete"));
        forumName = new JLabel(UTILS.toHtmlH3("Fórum"));
        className = new JLabel("Turma");
        criarTurma = new JButton("Criar turma");
        addTurma = new JButton("adicionar turma");
        criarTopico = new JButton("Criar tópico");
        enviarMensagem = new JButton("Enviar Mensagem");
//        this.mensagens = mensagens;
//        for(int i = 0; i < mensagens.size(); i++) {
//            forumPosts.add(new JButton(mensagens.get(i).getAssunto()));
//        }
    }

    private void addScreen() {
        leftPanel.add(criarTopico);
        leftPanel.add(addTurma);
        leftPanel.add(criarTurma);
        leftPanel.add(enviarMensagem);
//        for(int i = 0; i < forumPosts.size(); i++) {
//            forumPanel.add(forumPosts.get(i));
//        }
        screen.add(forumName);
        screen.add(leftPanel);
        screen.add(forumPanel);
        screen.add(exit);
    }

    private void position() {
        leftPanel.setBounds(0, 0, 200, 500);
        softName.setBounds(300, 50, 150, 50);
        forumName.setBounds(210, 90, 100, 20);
        criarTopico.setBounds(10, 30, 180, 50);
        addTurma.setBounds(10, 100, 180, 50);
        criarTurma.setBounds(10, 170, 180, 50);
        enviarMensagem.setBounds(10, 240, 180, 50);
        forumPanel.setBounds(210, 120, 380, 350);
        exit.setBounds(500, 20, 80, 30);
    }

    private void actions() {
        exit.addActionListener((ActionEvent ae) -> {
            dispose();
        });
        criarTurma.addActionListener((ActionEvent ae) -> {
            String nomeTurma = JOptionPane.showInputDialog("Digite o nome da turma: ");
            new MateriaDao().addMateria(new Materia(nomeTurma), usuario.getUsuario());
        });
    }

    public void initScreen() {
        position();
        ViewAPI.paint(softName, exit, criarTopico, criarTurma, addTurma, enviarMensagem, forumName);
        addScreen();
        screen.setBackground(UTILS.backgroundColorPrimary);
        forumPanel.setBackground(UTILS.backgroundColorSecondWindows);
        leftPanel.setBackground(UTILS.backgroundColorSecondWindows);
        ViewAPI.addItems(screen, softName, leftPanel, forumPanel, exit);
        ViewAPI.configScreen(this, 600, 500);
        JButtonUtils.configButton(exit, criarTopico, criarTurma, addTurma, enviarMensagem);
        JButtonUtils.allignButtons(exit);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        JButtonUtils.allignButtons(softName);
        JButtonUtils.paintButtons(softName);
        softName.setEnabled(false);
        actions();
    }

}
