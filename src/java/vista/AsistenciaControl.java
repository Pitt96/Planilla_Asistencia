/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

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
public class AsistenciaControl extends org.apache.struts.action.Action {

    private Servicio ser ;
    private Presentador pre;

    public void setSer(Servicio ser) {
        this.ser = ser;
    }
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        AsistenciaForm aform = (AsistenciaForm) form;

        if (aform.getAcc().equals("Marcar Asistencia")) {
            ser.nuevaAsistencia();
            pre = new Presentador();
            request.getSession().setAttribute("pre", pre);
            return mapping.findForward("MarcarAsistencia");
            
            
        } else if (aform.getAcc().equals("Grabar Asistencia")) {
            Object[] datosasistencia=ser.marcarAsistencia(aform.getDni());
            
            if (datosasistencia != null) {
                String msg = ser.guardarAsistencia(datosasistencia[0].toString(),
                        datosasistencia[1].toString(), datosasistencia[2].toString(),
                        datosasistencia[3].toString(), datosasistencia[4].toString());
                
                pre.setMsg(msg);

                request.getSession().setAttribute("datosasistencia", datosasistencia);
                //request.getSession().setAttribute("pre", pre);
                return mapping.findForward("DetalleAsistencia");
                
            } else {
               
                pre.setMsg("Empleado no encontrado");
                //request.getSession().setAttribute("pre", pre);
                //pre.setMsg(null);
                return mapping.findForward("MarcarAsistencia");
            }
          
        } else if (aform.getAcc().equals("Login")) { 
            pre = new Presentador();
            request.getSession().setAttribute("pre", pre);
            return  mapping.findForward("Login");
           
        } else if (aform.getAcc().equals("Volver Asistencia")) { 
            ser.nuevaAsistencia();
            pre.setMsg("");
            return  mapping.findForward("MarcarAsistencia");
           
        }else if (aform.getAcc().equals("Validar")) {
            Object[] login=ser.login(aform.getDni(), aform.getContra());
            if(login!=null){
                //request.getSession().setAttribute("login", login);
                pre.setFil(login);
                return  mapping.findForward("MenuAdmin");
            }else{
                String msg="Usuario inválido";
                //request.getSession().setAttribute("msg", msg);
                pre.setMsg(msg);
                return  mapping.findForward("Login");
            } 
                                
        }else {
            return mapping.findForward("/MenuPrincipal.jsp");
        }
    }
}
