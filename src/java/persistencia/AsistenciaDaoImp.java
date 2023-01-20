package persistencia;

import java.util.List;

/**
 *
 * @author KARLA
 */
public class AsistenciaDaoImp implements AsistenciaDao{
    private final AsistenciaJpaController ajp=new AsistenciaJpaController();

    @Override
    public List listar() {
        return ajp.findAsistenciaEntities();

    }

    @Override
    public String grabar(Asistencia asis) {
        String msg;

        try {
            ajp.create(asis);
            msg = "Asistencia registrada";
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

}
