package daos;

import bean.Aluno;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
    private static Connection con;
    public AlunoDao() {
        con = new Conexao().getCon();
    }
    public List<Aluno> getAlunos(String query) {
        PreparedStatement ps;
        ResultSet rs;
        List<Aluno> a = new ArrayList<>();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                a.add(new Aluno(
                    rs.getString("nome"),
                    rs.getString("usuario"),
                    rs.getInt("e_moderador"),
                    rs.getInt("pontuacao"),
                    rs.getString("instituicao")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
        }
        return a;
    }
    public void addAluno(Aluno a) {
        PreparedStatement ps;
        try {
            String query = "insert into aluno(nome, usuario, senha, e_moderador, pontuacao, instituicao) values (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getUsuario());
            ps.setString(3, a.getSenha());
            ps.setInt(4, a.getE_moderador());
            ps.setInt(5, a.getPontuacao());
            ps.setString(6, a.getInstituicao());
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
        }
    }
    public void updateAluno(Aluno a) {
        PreparedStatement ps;
        try {
            String query = "update table aluno SET nome = ?, senha = ?, e_moderador = ?, pontuacao = ? WHERE usuario = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getSenha());
            ps.setInt(3, a.getE_moderador());
            ps.setInt(4, a.getPontuacao());
            ps.setString(5, a.getInstituicao());
            ps.setString(6, a.getUsuario());
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
        }
    }

    public void deleteAluno(String usuario) {
        String query = "delete from aluno where usuario = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.execute();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
        }
    }
}
