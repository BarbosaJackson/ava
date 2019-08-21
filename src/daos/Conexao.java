package daos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

        private static Connection con;
        private static String user, pass, db, host, url;

        public Conexao() {
            user = "";
            pass = "";
            db = "miniava";
            host = "localhost:3306/";
            url = "jdbc:mysql://" + host + db;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null,"Erro ao conectar o banco");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public Connection getCon() {
            return con;
        }
}
