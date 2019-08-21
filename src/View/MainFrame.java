package View;

import bean.Mensagem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame{
    private Container screen;
    private JPanel leftPanel, forumPanel, classPanel;
    private JLabel softName, forumName, className;
    private JButton tornarModerador, criarTurma, addTurma, criarTopico, enviarMensagem;
    private ArrayList<JButton> forumPosts;
    private List <Mensagem> mensagens;
    public MainFrame(List <Mensagem> mensagens) {
        screen = getContentPane();
        leftPanel = new JPanel(null);
        forumPanel = new JPanel(null);
        classPanel = new JPanel(null);
        softName = new JLabel("Tasukete");
        forumName = new JLabel("Fórum");
        className = new JLabel("Turma");
        tornarModerador = new JButton("Tornar moderador");
        criarTurma = new JButton("Criar turma");
        addTurma = new JButton("adicionar turma");
        criarTopico = new JButton("Criar tópico");
        enviarMensagem = new JButton("Enviar Mensagem");
        this.mensagens = mensagens;
        for(int i = 0; i < mensagens.size(); i++) {
            forumPosts.add(new JButton(mensagens.get(i).getAssunto()));
        }
    }

    private void addScreen() {
        leftPanel.add(tornarModerador);
        leftPanel.add(criarTopico);
        leftPanel.add(addTurma);
        leftPanel.add(criarTurma);
        leftPanel.add(enviarMensagem);
        for(int i = 0; i < forumPosts.size(); i++) {
            forumPanel.add(forumPosts.get(i));
        }
        screen.add(leftPanel);
        screen.add(forumPanel);
    }

    private void position() {

    }

    private void config() {
        setLayout(null);
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
