package bean;

public class Mensagem {
    private String assunto;
    private String conteudo;
    private String remetente, destinatario;
    public Mensagem(String assunto, String conteudo, String remetente, String destinatario) {
        this.assunto = assunto;
        this.conteudo = conteudo;
        this.remetente = remetente;
        this.destinatario = destinatario;
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

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
