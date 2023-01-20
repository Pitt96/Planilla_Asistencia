package persistencia;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistencia.Asistencia;
import persistencia.BoletaPago;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-06T03:08:11")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> contrasena;
    public static volatile SingularAttribute<Empleado, String> id;
    public static volatile ListAttribute<Empleado, BoletaPago> boletaPagoList;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile ListAttribute<Empleado, Asistencia> asistenciaList;

}