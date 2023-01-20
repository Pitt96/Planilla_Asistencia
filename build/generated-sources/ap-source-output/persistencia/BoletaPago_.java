package persistencia;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistencia.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-06T03:08:11")
@StaticMetamodel(BoletaPago.class)
public class BoletaPago_ { 

    public static volatile SingularAttribute<BoletaPago, Double> desafp;
    public static volatile SingularAttribute<BoletaPago, Double> sueldobruto;
    public static volatile SingularAttribute<BoletaPago, Double> desob;
    public static volatile SingularAttribute<BoletaPago, Double> sueldoneto;
    public static volatile SingularAttribute<BoletaPago, Double> bonificacion;
    public static volatile SingularAttribute<BoletaPago, String> id;
    public static volatile SingularAttribute<BoletaPago, Empleado> idemp;

}