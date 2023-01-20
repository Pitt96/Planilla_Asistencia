
package negocio;

/**
 *
 * @author KARLA
 */
public class BoletaPagoclase {
    String id, idempleado;
    double sueldobruto, desob, desafp, bonificacion, sueldoneto;

    public BoletaPagoclase(String id, String idempleado, double sueldobruto, double desob, double desafp, double bonificacion, double sueldoneto) {
        this.id = id;
        this.idempleado = idempleado;
        this.sueldobruto = sueldobruto;
        this.desob = desob;
        this.desafp = desafp;
        this.bonificacion = bonificacion;
        this.sueldoneto = sueldoneto;
    }

    public BoletaPagoclase() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public double getSueldobruto() {
        return sueldobruto;
    }

    public void setSueldobruto(double sueldobruto) {
        this.sueldobruto = sueldobruto;
    }

    public double getDesob() {
        return desob;
    }

    public void setDesob(double desob) {
        this.desob = desob;
    }

    public double getDesafp() {
        return desafp;
    }

    public void setDesafp(double desafp) {
        this.desafp = desafp;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public double getSueldoneto() {
        return sueldoneto;
    }

    public void setSueldoneto(double sueldoneto) {
        this.sueldoneto = sueldoneto;
    }
    
    //MÉTODOS
    //Métodos de calculo
    public double SueldoBruto(int dias){
        return 50*dias;
    }
    
    public double DescuentoObs(int tardanzas, int faltas){
        return (tardanzas*0.2)+(faltas*1);
    }
    
    public double DescuentoAFP(){
        return getSueldobruto()*0.1;
    }
    
    public double Bonificacion(){
        return getSueldobruto()*0.05;
    }
    
    public double SueldoNeto(){
        return getSueldobruto()+getBonificacion()-getDesob()-getDesafp();
    }
}
