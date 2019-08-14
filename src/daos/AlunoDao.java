package daos;

import java.sql.Connection;

public class AlunoDao {
    private static Connection con;
    public AlunoDao() {
        con = new Conexao().getCon();
    }

}
