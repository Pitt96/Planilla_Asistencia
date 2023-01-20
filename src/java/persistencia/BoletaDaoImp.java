/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author KARLA
 */
public class BoletaDaoImp implements BoletaDao{
    private final BoletaPagoJpaController bjp=new BoletaPagoJpaController();

    @Override
    public String grabar(BoletaPago bol) {
        String msg;

        try {
            bjp.create(bol);
            msg = "Boleta registrada";
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }
     
}
