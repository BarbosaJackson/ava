package daos;

import bean.Aluno;
import bean.Materia;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao {
    private Connection con;
    public MateriaDao() {
        con = new Conexao().getCon();
    }
    public void addMateria(Materia m, String userName) {
        String query = "insert into materia(nome) values (?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, m.getNome());
            ps.execute();
            ps = con.prepareStatement("select  MAX(ID) as id from materia");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_mat = rs.getInt("id");
            query = "insert into materia_aluno(nome, id) values (?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setInt(2, id_mat);
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
            ex.printStackTrace();
        }
    }
    public List<Materia> getAllMaterias() {
        String query = "select * from materia";
        PreparedStatement ps;
        ResultSet rs;
        List<Materia> m = new ArrayList<>();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
        } finally {
            return m;
        }
    }
    public List<Aluno> getAlunos(int id) {
        PreparedStatement ps;
        ResultSet rs;
        String query = "select * from aluno, aluno_materia WHERE materia_aluno.id = ? AND materia_aluno.usuario = aluno.usuario";
        List<Aluno> alunos = new ArrayList<>();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                alunos.add(
                        new Aluno(
                                rs.getString("nome"),
                                rs.getString("usuario"),
                                rs.getInt("e_moderador"),
                                rs.getInt("pontuacao"),
                                rs.getString("instituicao")
                        )
                );
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar o banco de dados");
        } finally {
            return alunos;
        }
    }
}
