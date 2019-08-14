package bean;

import daos.AlunoDao;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private List <Aluno> alunos;
    private List <Mensagem> mensagens;
    private String nome;

    public Materia(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addAluno(Aluno a){
        new AlunoDao().addAluno(a);
    }
    public List<Aluno> getAllAlunos() {
        return new AlunoDao().getAlunos("select * from aluno");
    }
    public void deleteAluno(String usuario) {
        new AlunoDao().deleteAluno(usuario);
    }
    public void updateAluno(Aluno a) {
        new AlunoDao().updateAluno(a);
    }
}
