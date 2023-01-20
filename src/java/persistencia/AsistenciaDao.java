package persistencia;

import java.util.List;

/**
 *
 * @author KARLA
 */
public interface AsistenciaDao {
    public List listar();
    public String grabar(Asistencia asis);

}
