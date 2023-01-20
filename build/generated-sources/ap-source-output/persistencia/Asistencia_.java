package persistencia;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistencia.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-06T03:08:11")
@StaticMetamodel(Asistencia.class)
public class Asistencia_ { 

    public static volatile SingularAttribute<Asistencia, String> fecha;
    public static volatile SingularAttribute<Asistencia, String> hora;
    public static volatile SingularAttribute<Asistencia, String> id;
    public static volatile SingularAttribute<Asistencia, String> observacion;
    public static volatile SingularAttribute<Asistencia, Empleado> idempleado;

}