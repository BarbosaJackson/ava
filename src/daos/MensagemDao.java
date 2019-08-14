package daos;

import bean.Mensagem;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MensagemDao {
    private Connection con;
    public MensagemDao() {
        con = new Conexao().getCon();
    }
    public void addMensagem(Mensagem m) {
        String query = "insert into mensagem(assunto, conteudo, remetente, destinatario) values (?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, m.getAssunto());
            ps.setString(2, m.getConteudo());
            ps.setString(3, m.getRemetente());
            ps.setString(4, m.getDestinatario());
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
        }
    }

    public List<Mensagem> getMensagem(String query) {
        PreparedStatement ps;
        ResultSet rs;
        List<Mensagem> m = new ArrayList<>();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                m.add(
                  new Mensagem(
                          rs.getString("assunto"),
                          rs.getString("conteudo"),
                          rs.getString("remetente"),
                          rs.getString("destinatario")
                  )
                );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
        }
        return m;
    }


}
