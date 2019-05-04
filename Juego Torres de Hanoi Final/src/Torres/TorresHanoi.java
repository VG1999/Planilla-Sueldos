
package Torres;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * Clase que se encarga de los movimientos de las torres
 *  autor Ester Guamuch
 */
public class TorresHanoi  implements Serializable{
    
    String sTorre;
    ArrayList<String> Torres;
    
    // guarda el numero de de pasos realizados
    int iContadorPasos;
    public TorresHanoi() {
        sTorre = "";
        Torres= new ArrayList<>();
       iContadorPasos=0;
    }
    
    // logica de las Torres
    public void RecursividadHanoi(int num, int inicio, int auxiliar, int fin) throws IOException {
        if (num == 1) {
             sTorre = "MOVER DE LA TORRE " + inicio + " A LA TORRE " + fin;
            iContadorPasos++;
            Torres.add(sTorre);
            
        } else {
           RecursividadHanoi(num - 1, inicio, fin, auxiliar);
            sTorre= "MOVER DE LA TORRE " + inicio + " A LA TORRE " + fin;
            iContadorPasos++;
            Torres.add(sTorre);
            
           RecursividadHanoi(num - 1, auxiliar, inicio, fin);
        }
    }

   
   /***********************************************************************************/
    
   
   /*  Metodos Para verificar si se llevo a cabo el juego 
    *@param n
    *
    */
     public boolean VerificarFinalJuego(int n, int numeroArosTorre3){
        
        return n==numeroArosTorre3;
    }
    
     /************************************************************************************/
     
     /**
      * Metodo que retorna el minimo de movimientos segun el numero de aros
      */
     
       public int getContador() {
        return iContadorPasos;
    }
       
      /************************************************************************************/
       
       /**
     * Metodo para setear el contador
     * @param contador 
     */
    public void setContador(int contador) {
        this.iContadorPasos = contador;
    }
       
}
