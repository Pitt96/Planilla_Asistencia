package servicio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KARLA
 */
public class Prueba {

    public static void main(String[] args) {
        Servicio serv=new ServicioImp();
        Object[]asis=new Object[5];
 //       List lista = new ArrayList();
        List lista1 = new ArrayList();
        
        //PRUEBA METODO MARCAR ASISTENCIA
        serv.nuevaAsistencia();
//        asis=serv.marcarAsistencia("E002");      
//        System.out.println("Asistencia N°"+asis[0]+" Fecha:"+asis[1]+" Hora:"+asis[2]+" Observación:"+asis[3]+" Empleado:"+asis[4]);
//        
//        //PRUEBA METODO GUARDAR ASISTENCIA
//        String msg=serv.guardarAsistencia(asis[0].toString(), asis[1].toString(), asis[2].toString(), asis[3].toString(), asis[4].toString());
//        System.out.println("Mensaje:"+msg);
//        
        
//        //PRUEBA LISTAR EMPLEADOS
//        lista=serv.listarEmpleados();
//        for(int i=0;i<lista.size();i++){
//            Object[]emp=new Object[2];
//            emp=(Object[])lista.get(i);
//            
//            System.out.println("Empleado N°"+i+" Dni:"+emp[0]+" Nombre:"+emp[1]);
//        }
        
//        //PRUEBA LISTAR ASISTENCIAS
//        lista1=serv.listarAsistencias("4444", "OCTUBRE");
//        for(int i=0;i<lista1.size();i++){
//            Object[]asi=new Object[5];
//            asi=(Object[])lista1.get(i);
//            
//            System.out.println("Asistencia N°"+i+" Código:"+asi[0]+" Fecha:"+asi[1]+" Hora:"+asi[2]+" Observación:"+asi[3]+" Empleado"+asi[4]);
//        }
        
        //PRUEBA CALCULAR BOLETA
//        Object[] dtbol=new Object[7];
//        dtbol=serv.CalcularBoletaPago(serv.listarAsistencias("4444", "octubre"),"4444");
//        System.out.println(dtbol[0]+" "+dtbol[1]+" "+dtbol[2]+" "+dtbol[3]+" "+dtbol[4]+" "+dtbol[5]+" "+dtbol[6]+" "+dtbol[7]+" "+dtbol[8]);
//       
        //PRUEBA GUARDAR BOLETA
//        String msg=serv.guardarBoleta(dtbol[0].toString(), dtbol[1].toString(), 
//                dtbol[2].toString(), dtbol[3].toString(), dtbol[4].toString(),
//                dtbol[5].toString(), dtbol[6].toString());
//        
//        System.out.println("Mensaje:"+msg); 

       //PRUEBA LOGIN
       Object[] usuario=serv.login("5555", "123");
        System.out.println(usuario[0]+" "+usuario[1]);
    }
    
}
