package bean;

public class Mensagem {
    private String assunto;
    private String conteudo;

    public Mensagem(String assunto, String conteudo) {
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
