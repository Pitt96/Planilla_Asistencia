/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author KARLA
 */
public class BoletaForm extends org.apache.struts.action.ActionForm {
    
    private String id,sueldobruto,desob,desafp,sueldoneto,dni,acc,mes;
     

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSueldobruto() {
        return sueldobruto;
    }

    public void setSueldobruto(String sueldobruto) {
        this.sueldobruto = sueldobruto;
    }

    public String getDesob() {
        return desob;
    }

    public void setDesob(String desob) {
        this.desob = desob;
    }

    public String getDesafp() {
        return desafp;
    }

    public void setDesafp(String desafp) {
        this.desafp = desafp;
    }

    public String getSueldoneto() {
        return sueldoneto;
    }

    public void setSueldoneto(String sueldoneto) {
        this.sueldoneto = sueldoneto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (dni == null || dni.length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
