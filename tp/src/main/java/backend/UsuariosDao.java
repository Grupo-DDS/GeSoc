package backend;

import static java.util.Arrays.asList;
import java.util.List;

public class UsuariosDao {

    public List<Usuario> getAll() {
        return asList(
                new Usuario("alex", "password", "admin"),
                new Usuario("lexa", "password", "normal"),
                new Usuario("xela", "password", "normal")
        );
    }
}
