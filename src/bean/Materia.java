package bean;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private List <Aluno> alunos;
    private List <Moderador> moderadores;
    private List <Mensagem> mensagens;
    private String nome;

    public Materia(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
        this.moderadores = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addAluno(Aluno a){

    }
    public List<Aluno> getAlunos() {
        List<Aluno> aluno = new ArrayList<>();

        return aluno;
    }
}
