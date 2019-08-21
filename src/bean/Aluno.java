package bean;

public class Aluno {
    private int pontuacao;
    private String nome;
    private String instituicao;
    private String usuario;
    private String senha;
    private int e_moderador;
    public Aluno(String nome, String usuario, int e_moderador, int pontuacao, String instituicao) {
        this.nome = nome;
        this.usuario = usuario;
        this.pontuacao = pontuacao;
        this.e_moderador = e_moderador;
        this.instituicao = instituicao;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "pontuacao=" + pontuacao +
                ", nome='" + nome + '\'' +
                ", instituicao='" + instituicao + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", e_moderador=" + e_moderador +
                '}';
    }

    public Aluno(String nome, String usuario, String senha, int e_moderador, int pontuacao, String instituicao) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.pontuacao = pontuacao;
        this.e_moderador = e_moderador;
        this.instituicao = instituicao;
    }
    public Aluno(String nome, String usuario, String senha, int e_moderador) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.pontuacao = 0;
        this.e_moderador = e_moderador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getE_moderador() {
        return e_moderador;
    }

    public void setE_moderador(int e_moderador) {
        this.e_moderador = e_moderador;
    }
}
