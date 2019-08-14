package bean;

public class Moderador extends Aluno{
    private int id;
    public Moderador(String nome,  String usuario, String senha, int id) {
        super(nome, usuario, senha);
        this.id = id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
