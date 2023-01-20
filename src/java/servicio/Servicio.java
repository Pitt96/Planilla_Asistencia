package servicio;

import java.util.List;

/**
 *
 * @author KARLA
 */
public interface Servicio {
    public void nuevaAsistencia();
    public Object[] marcarAsistencia(String dni);
    public String guardarAsistencia(String id, String fecha, String hora, String observacion, String dni);
    public List listarEmpleados();
    public List listarAsistencias(String idEmp, String mes);
    public Object[] CalcularBoletaPago(List lista, String dni);
    public String guardarBoleta(String id, String sueldobruto, String desob, String desafp, String bonificacion, String sueldoneto, String idempleado);
    public Object[] login(String dni, String contra);
}
