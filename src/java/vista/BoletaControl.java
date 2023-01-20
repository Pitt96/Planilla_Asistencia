/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import servicio.*;

/**
 *
 * @author KARLA
 */
public class BoletaControl extends org.apache.struts.action.Action {

    private Servicio ser ;
    private Presentador pre;

    public void setSer(Servicio ser) {
        this.ser = ser;
    }
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        BoletaForm bolform = (BoletaForm) form;

        if (bolform.getAcc().equals("Boleta de Pago")) {
            ser.nuevaAsistencia();
            pre = new Presentador();
            request.getSession().setAttribute("pre", pre);
            return mapping.findForward("BoletaPago");

            
        }else if (bolform.getAcc().equals("Mostrar Boleta")) {
            List listasistencias=ser.listarAsistencias(bolform.getDni(), bolform.getMes());
            
            if (!listasistencias.isEmpty()) {
                pre.setLis(listasistencias);

                Object[] datosbol = ser.CalcularBoletaPago(listasistencias, bolform.getDni());

                pre.setFil(datosbol);

                String msg = ser.guardarBoleta(datosbol[0].toString(),
                        datosbol[1].toString(), datosbol[2].toString(),
                        datosbol[3].toString(), datosbol[4].toString(), datosbol[5].toString(), datosbol[6].toString());

                pre.setMsg(msg);
                //request.getSession().setAttribute("pre", pre);
                //request.getSession().setAttribute("msg", msg);

                return mapping.findForward("DetalleBoleta");
            } else {
                pre.setMsg("No asistió en el mes, no le corresponde pago");
//            pre.setLis(listasistencias);
//            
//            Object[] datosbol=ser.CalcularBoletaPago(listasistencias, bolform.getDni());
//                    
//            pre.setFil(datosbol);
//            
//            String msg=ser.guardarBoleta(datosbol[0].toString(), 
//                    datosbol[1].toString(), datosbol[2].toString(), 
//                    datosbol[3].toString(), datosbol[4].toString(), datosbol[5].toString(), datosbol[6].toString());
//            
//            pre.setMsg(msg);
//            //request.getSession().setAttribute("pre", pre);
//            //request.getSession().setAttribute("msg", msg);

                return mapping.findForward("BoletaPago");
            }
        }else if (bolform.getAcc().equals("Volver")) { 
            ser.nuevaAsistencia();
            pre.setMsg("");
            return  mapping.findForward("BoletaPago");
           
        } else {

            return mapping.findForward("");
        }
    }
}
