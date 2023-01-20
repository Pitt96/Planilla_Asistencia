
package servicio;

import java.util.List;
import persistencia.*;

public class Genera {
    public static String getNum(){
        String numGen;
        String numObt=null;
        AsistenciaJpaController asisDao=new AsistenciaJpaController();
        List lis=asisDao.findAsistenciaEntities();
        for(int i=0;i<lis.size();i++){
            Asistencia asis=(Asistencia)lis.get(i);
            numObt=asis.getId();
        }
         String parInt=numObt.substring(2);
         String parStr=numObt.substring(0,1);
         String nueParInt=String.valueOf(Integer.parseInt(parInt)+1);
         while(nueParInt.length()<5){
             nueParInt="0"+nueParInt;
         }
        numGen=parStr+nueParInt;    
        return numGen;
    }   
    
    public static String getCod(){
        String numGen;
        String numObt=null;
        BoletaPagoJpaController bolDao=new BoletaPagoJpaController();
        List lis=bolDao.findBoletaPagoEntities();
        for(int i=0;i<lis.size();i++){
            BoletaPago boleta=(BoletaPago)lis.get(i);
            numObt=boleta.getId();
        }
         String parInt=numObt.substring(2);
         String parStr=numObt.substring(0,1);
         String nueParInt=String.valueOf(Integer.parseInt(parInt)+1);
         while(nueParInt.length()<5){
             nueParInt="0"+nueParInt;
         }
        numGen=parStr+nueParInt;    
        return numGen;
    }   
}
