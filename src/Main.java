import bean.Materia;
import daos.MateriaDao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Materia> materias = new MateriaDao().getAllMaterias();
    }
}
