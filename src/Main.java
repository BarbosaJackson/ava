import bean.Materia;
import daos.MateriaDao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Materia> materias = new MateriaDao().getAllMaterias();
        for(int i = 0; i < materias.size(); i++) {
            materias.get(i).setAlunos(new MateriaDao().getAlunos(materias.get(i).getId()));
        }
    }
}
