
package servicio;

import java.util.ArrayList;
import java.util.List;
import negocio.*;
import persistencia.*;

/**
 *
 * @author KARLA
 */
public class ServicioImp implements Servicio{
    
    private Asistenciaclase asis;
    //private Empleadoclase emp;
    private BoletaPagoclase bol=new BoletaPagoclase();
    
    
    
    private EmpleadoDao empDao;

    public void setEmpDao(EmpleadoDao empDao) {
        this.empDao = empDao;
    }
    
    
    private AsistenciaDao asisDao;

    public void setAsisDao(AsistenciaDao asisDao) {
        this.asisDao = asisDao;
    }
    
    
    private BoletaDao bolDao;

    public void setBolDao(BoletaDao bolDao) {
        this.bolDao = bolDao;
    }
    

    @Override
    public void nuevaAsistencia() {
        asis=new Asistenciaclase();
    }

    @Override
    public Object[] marcarAsistencia(String dni) {
        Object[] datosregistro = null;
        
        String id=Genera.getNum();
        
        String fecha=Fecha.getFec();
        
        String horaRegistro=Fecha.getHor();
        
        int horas = Integer.parseInt(horaRegistro.substring(0, 2));
        
        int minutos = Integer.parseInt(horaRegistro.substring(3));
        
        String observacion=asis.validarHorarioAsistencia(horas, minutos);
        
        asis.setId(id);
        asis.setIdempleado(dni);
        asis.setFecha(fecha);
        asis.setHora(horaRegistro);
        asis.setObservacion(observacion);
        
        if (empDao.buscar(dni) != null) {
            datosregistro = new Object[6];
            datosregistro[0] = asis.getId();
            datosregistro[1] = asis.getFecha();
            datosregistro[2] = asis.getHora();
            datosregistro[3] = asis.getObservacion();
            datosregistro[4] = asis.getIdempleado();
            datosregistro[5] = empDao.buscar(dni).getNombre();
        }

        return datosregistro;
    }

    @Override
    public List listarEmpleados() {
        List listaempleados = new ArrayList();
        for(int i=0;i<empDao.listar().size();i++){
            Empleado empleado=(Empleado)empDao.listar().get(i);
            Object[] fil= new Object[2];
            fil[0]=empleado.getId();
            fil[1]=empleado.getNombre();
            listaempleados.add(fil);
        }
        return listaempleados;
    }

    @Override
    public List listarAsistencias(String idEmp, String mes) {
        List listaasistencias = new ArrayList();
        String mesbuscar;
        switch(mes.toUpperCase()){
            case "ENERO": mesbuscar="01"; break;
            case "FEBRERO": mesbuscar="02";break;
            case "MARZO": mesbuscar="03";break;
            case "ABRIL": mesbuscar="04";break;
            case "MAYO": mesbuscar="05";break;
            case "JUNIO": mesbuscar="06";break;
            case "JULIO": mesbuscar="07";break;
            case "AGOSTO": mesbuscar="08";break;
            case "SETIEMBRE": mesbuscar="09";break;
            case "OCTUBRE": mesbuscar="10";break;
            case "NOVIEMBRE": mesbuscar="11";break;
            default:mesbuscar="12";break;
        }
        for(int i=0;i<asisDao.listar().size();i++){
            
            Asistencia asistencia=(Asistencia)asisDao.listar().get(i);
            Object[] fil= new Object[5];
            fil[0]=asistencia.getId();
            fil[1]=asistencia.getFecha();
            fil[2]=asistencia.getHora();
            fil[3]=asistencia.getObservacion();
            fil[4]=asistencia.getIdempleado().getId();
            
            if(fil[4].equals(idEmp) && fil[1].toString().substring(3, 5).equals(mesbuscar)){
                listaasistencias.add(fil);
            }         
        }
        return listaasistencias;
    }

    @Override
    public Object[] CalcularBoletaPago(List lista, String dni) {
        int dias;
        int faltas;
        int tardanzas;
        Object[] datosboleta=null;
        //List listaprueba=new ArrayList();
        
        if(empDao.buscar(dni)!=null){
            
            //listaprueba=listarAsistencias(dni, "NOVIEMBRE");
            
            faltas=asis.validarFaltas(lista);
            dias=30-faltas;
            tardanzas=asis.validarTardanzas(lista);
          
            bol.setId(Genera.getCod());
            bol.setSueldobruto(bol.SueldoBruto(dias));
            bol.setDesob(bol.DescuentoObs(tardanzas, faltas));
            bol.setDesafp(bol.DescuentoAFP());
            bol.setBonificacion(bol.Bonificacion());
            bol.setSueldoneto(bol.SueldoNeto());
            bol.setIdempleado(dni);
            
            datosboleta=new Object[9];
            datosboleta[0]=bol.getId();
            datosboleta[1]=bol.getSueldobruto();
            datosboleta[2]=bol.getDesob();
            datosboleta[3]=bol.getDesafp();
            datosboleta[4]=bol.getBonificacion();
            datosboleta[5]=bol.getSueldoneto();
            datosboleta[6]=bol.getIdempleado();
            datosboleta[7]=faltas;
            datosboleta[8]=tardanzas;
            
            return datosboleta;
        } else {
            return datosboleta;
        }
    }

    @Override
    public String guardarBoleta(String id, String sueldobruto, String desob, String desafp, String bonificacion, String sueldoneto, String dni) {
        String msg=null;
                     
        if (empDao.buscar(dni) != null) {
            persistencia.BoletaPago boleta = new persistencia.BoletaPago();
            boleta.setId(id);
            boleta.setSueldobruto(Double.parseDouble(sueldobruto));
            boleta.setDesob(Double.parseDouble(desob));
            boleta.setDesafp(Double.parseDouble(desafp));
            boleta.setBonificacion(Double.parseDouble(bonificacion));
            boleta.setSueldoneto(Double.parseDouble(sueldoneto));
            boleta.setIdemp(empDao.buscar(dni));
            try {
                msg=bolDao.grabar(boleta);
                 
            } catch (Exception e) {
                msg = e.getMessage();
            }
        }
        return msg;
    }   

    @Override
    public String guardarAsistencia(String id, String fecha, String hora, String observacion, String dni) {
        String msg=null;
                     
        if (empDao.buscar(dni) != null) {
            persistencia.Asistencia miasistencia = new persistencia.Asistencia();
            miasistencia.setId(id);
            miasistencia.setFecha(fecha);
            miasistencia.setHora(hora);
            miasistencia.setObservacion(observacion);
            miasistencia.setIdempleado(empDao.buscar(dni));
                       
            try {
                msg=asisDao.grabar(miasistencia);
                 
            } catch (Exception e) {
                msg = e.getMessage();
            }
        }
        return msg;
    }

    @Override
    public Object[] login(String dni, String contra) {
        Object[] datosusuario=null;
//        persistencia.Empleado emp=new persistencia.Empleado();
//                emp=empDao.buscar(dni);
        if(empDao.buscar(dni)!=null){
            if(empDao.buscar(dni).getId().equals(dni) && empDao.buscar(dni).getContrasena().equals(contra)){
                datosusuario= new Object[2]; 
                datosusuario[0]=empDao.buscar(dni).getId();
                datosusuario[1]=empDao.buscar(dni).getNombre();               
            }
        }
        return datosusuario;
    }
    
}
