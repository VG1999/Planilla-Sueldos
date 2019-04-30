package torres.de.hanou;

import java.util.Scanner;


public class TorresDeHanou {

    
    public static void main(String[] args) {
      Scanner leer = new Scanner(System.in);
      
      System.out.println("Con cuantos discos quiere jugar");
      int iDiscos = leer.nextInt();
      Discos(iDiscos, 1,2,3);
      
      int iMovimientos = (int)(Math.pow(2,iDiscos)-1);
       System.out.println("El numero minimo de movientos para  "+iDiscos+" discos es "+ iMovimientos+" Movientos");
        
    }
    
    public static void Discos (int iDiscos,int iInicio,int iAuxiliar, int iDestino){
         
        if(iDiscos ==1){
            System.out.println("Moviendo de la torre"+iInicio+" a la torre"+ iDestino);
         }else{
            Discos(iDiscos-1, iInicio, iDestino,iAuxiliar);
              System.out.println("Moviendo de la tgrre"+iInicio+" a la torre"+ iDestino);
                     Discos(iDiscos-1,iAuxiliar, iInicio, iDestino);
                        
                 
        }
    }
}
