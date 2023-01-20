
package negocio;

import java.util.List;

/**
 *
 * @author KARLA
 */
public class Asistenciaclase {
    String id,fecha,hora,observacion,idempleado;

    public Asistenciaclase() {
    }

    public Asistenciaclase(String id, String fecha, String hora, String observacion, String idempleado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.observacion = observacion;
        this.idempleado = idempleado;
    }
    
        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }
    
    //Métodos
    public String validarHorarioAsistencia(int horas, int minutos) {
        String mensaje = "";
        if ((horas == 8 && minutos == 0) || horas < 8) {
            mensaje = "Llego a tiempo";
        } else if (horas == 8 && minutos != 0) {
            mensaje = "Llego " + minutos + " minutos tarde";
        } else if (horas > 8) {
            mensaje = "Llego " + (horas - 8) + " hora con " + minutos + " minutos tarde";
        }
        return mensaje;
    }
    
    public int validarFaltas(List listaAsistencia){
        int faltas=0;
        if(listaAsistencia.size()<30){
            faltas=30-listaAsistencia.size();         
        }
        return faltas;
    }
    
    public int validarTardanzas(List listaAsistencia){
        int tardanzas=0;
        for (int i=0; i<listaAsistencia.size(); i++){           
            //Asistenciaclase asis=(Asistenciaclase)listaAsistencia.get(i);
            Object[] prueba=(Object[]) listaAsistencia.get(i);
            Object[] fil= new Object[1];
           
            fil[0]=prueba[3];          
            
            if(!fil[0].equals("Llego a tiempo")){
                tardanzas++;
          
            //System.out.println(listaAsistencia.get(i).getObservacion());
//            if(listaAsistencia.get(i).getObservacion()!="Llego a tiempo"){
                //System.out.println(listaAsistencia.get(i).getObservacion());
                
            }
        }
        return tardanzas;
    }
    
}
