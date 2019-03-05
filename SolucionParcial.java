/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucionplanilla;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class SolucionParcial{

    /**
     * Variente B
     * Ester Guamuch
     * 
     */
       public static String [][]  MatrizCalculo= new String [10][4];
       public static int Total;
    public static void main(String[] args) {
        
   int intOpcionesMenu = 0;
        do{
             intOpcionesMenu= Integer.parseInt(JOptionPane.showInputDialog("Bienvenido que operacion desea realizar:\n1.Datos\n2.Salir"));
             
             switch(intOpcionesMenu){
                  case 1: { Mostrarmatriz( MatrizCalculo, Total);};
                  break;
    }
    
}while(intOpcionesMenu!=2);
        }   
    
    
      public static void Mostrarmatriz(String [][]  MatrizCalculo, int Total){
              
                  Llenado(MatrizCalculo);
               System.out.println("PRODUCTOS"+"\n");
                System.out.print("NOMBRE     "+"             PRECIO   "+"       CANTIDAD   "
                    + "     TOTAL ASOCIADO "+"\n");  
               for( int fila=0; fila<10;fila++){
        for(int columna=0; columna<4;columna++){
                            System.out.print(MatrizCalculo[fila][columna]+"\t "+"\t");       
            } System.out.println();
                }
                      System.out.println();
                    
                      
                                   
          
               }   
          
      public static void Llenado (String [][]  MatrizCalculo){
             for (int nfilas = 0; nfilas < 10; nfilas++) {
            for (int ncolumnas = 0; ncolumnas <5; ncolumnas++) {
                
                Llenadovalores(MatrizCalculo, Total);
                MatrizCalculo[nfilas][0]="Leche";
                 MatrizCalculo[nfilas][0]="Azucar";
                   MatrizCalculo[nfilas][0]="Harina";
                    MatrizCalculo[nfilas][0]="Pan";
                     MatrizCalculo[nfilas][0]="yogur";
                      MatrizCalculo[nfilas][0]="Cereal";
                       MatrizCalculo[nfilas][0]="Huevos";
                        MatrizCalculo[nfilas][0]="Galletas";
                         MatrizCalculo[nfilas][0]="Pan Integral";
                          MatrizCalculo[nfilas][0]="mayonesa";
                                      
                }
            }
            
            }
      
      public static void  Llenadovalores(String [][]  MatrizCalculo, int Total){
          
          for (int nfilas = 0; nfilas < 10; nfilas++) {
            for (int ncolumnas = 0; ncolumnas < 5; ncolumnas++) {
                MatrizCalculo[nfilas][1]= Integer.toString( 10 + (int) (Math.random() * 50));
                   MatrizCalculo[nfilas][2]= Integer.toString( 15 + (int) (Math.random() * 100));    
                      MatrizCalculo[nfilas][3]= Integer.toString((int) (Integer.parseInt(MatrizCalculo[nfilas][1])*Integer.parseInt(MatrizCalculo[nfilas][2])));
                        }
                           Total += Integer.parseInt(MatrizCalculo[nfilas][3]);
      }
}
      
      
}
              


                       
                       
   
