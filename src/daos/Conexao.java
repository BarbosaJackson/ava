package daos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

        private static Connection con;
        private static String user, pass, db, host, url;

        public Conexao() {
            user = "kcajava";
            pass = "senhaminiava";
            db = "miniava";
            host = "";
            url = "jdbc:mysql://" + host + db;
        }

        public Connection getCon() {
            if(con == null) {
                try {
                    con = DriverManager.getConnection(url, user, pass);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro ao conectar o banco");
                }
            }
            return con;
        }
    }
}
