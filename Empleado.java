/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;


import javax.swing.JOptionPane;



public class Empleado {   
    
    static LLENADO id = new LLENADO();
    
     public static double [][]  MatrizCalculoPlanilla= new double [10][7];
     public static double sumaFilas;
     public static double[] departamentos = new double[5];
     
        public static void main(String[] args) {
    int intOpcionesMenu = 0;
        do{
             intOpcionesMenu= Integer.parseInt(JOptionPane.showInputDialog("Bienvenido que operacion desea realizar...:\n1.Datos\n2.Salir"));
             
             switch(intOpcionesMenu){
                  case 1: { matriz( MatrizCalculoPlanilla,departamentos);};
                  break;
                     
               
             }
             
        } while(intOpcionesMenu!=2);
        
     }
        public static void matriz(double [][]  MatrizCalculoPlanilla, double[] departamentos){
              
                  id.matriz_general(MatrizCalculoPlanilla, departamentos);
                  
               System.out.println("Calculo Planilla"+"\n");
                System.out.print("CODIGO  "+"      SUELDO BASE   "+"    IGGS(-)   "
                    + "    BONIFICACION(+)  "+"ISR(-)  "+" SUELDO LIQUIDO  "+"DEPARTAMENTOS"+"\n");  
               for( int fila=0; fila<10;fila++){
        for(int columna=0; columna<7;columna++){
                            System.out.print(MatrizCalculoPlanilla[fila][columna]+"\t "+"\t");                        
            } System.out.println();
                }
                      System.out.println();
                                   
                  System.out.print("Sueldo Total por departamentos"+"\n");
               for(int j=0; j<5 ;j++){
                    System.out.println(( (double)Math.round(departamentos[j]*100d)/100));  
               }   
                        
              

}
}
      

 

 
                              
             
   
  
