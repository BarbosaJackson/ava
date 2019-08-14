package daos;

import bean.Aluno;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlunoDao {
    private static Connection con;
    public AlunoDao() {
        con = new Conexao().getCon();
    }
    public List<Aluno> getAlunos(String query) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
        }
    }
}
