package persistencia;

import java.util.List;
import javax.websocket.Session;

/**
 *
 * @author KARLA
 */
public class EmpleadoDaoImp implements EmpleadoDao{
    private final EmpleadoJpaController ejp=new EmpleadoJpaController();

    @Override
    public List listar() {
        return ejp.findEmpleadoEntities();
    }

    @Override
    public Empleado buscar(String dni) {
        return ejp.findEmpleado(dni);
    }

}
