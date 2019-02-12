/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;


import javax.swing.JOptionPane;


public class Empleados {   
     public static double [][]  MatrizCalculoPlanilla= new double [10][7];
      public static double [] departamentos =new double [5];
     public static int sumaFilas;
     
        public static void main(String[] args) {
    int intOpcionesMenu = 0;
        do{
             intOpcionesMenu= Integer.parseInt(JOptionPane.showInputDialog("Bienvenido que operacion desea realizar:\n1.Datos\n2.Salir"));
             
             switch(intOpcionesMenu){
                  case 1: { matriz();};
                  break;
                     
               
             }
             
        } while(intOpcionesMenu!=2);
        
     }
        public static void matriz(){
                 
             int nfilas;
            int n=0;
            double calculo_ISR=0;
             double sueldo_Liquido=0;
        for( nfilas=0; nfilas<10; nfilas++){
                  n+=1;
                          for( int ncolumnas=0; ncolumnas<7;ncolumnas++){
                              
                              // COLUMNA CODIGO EMPLEADO
                      MatrizCalculoPlanilla [nfilas][0]= n;
                      
                      // COLUMNA SUELDOS BASE
                 MatrizCalculoPlanilla [nfilas][ncolumnas]=3000+ (int) (Math.random() *10000);
                  
                // calculo IGGS
                 double calculo_IGSS= MatrizCalculoPlanilla [nfilas][1]*0.0483;
                MatrizCalculoPlanilla [nfilas][2]=  (double) Math.round(calculo_IGSS*100d)/100;
                
                //COLUMNA BONIFICACION
                 MatrizCalculoPlanilla [nfilas][3]=  250;

                  // calculo sueldo liquido 
              double   total_Descuento=0;
                                   
                 total_Descuento = calculo_IGSS+ MatrizCalculoPlanilla [nfilas][4];
                  sueldo_Liquido= MatrizCalculoPlanilla [nfilas][1]+MatrizCalculoPlanilla [nfilas][3] -  total_Descuento;
                  
                       // COLUMNA SUELDO LIQUIDO
                   
               MatrizCalculoPlanilla [nfilas][5]= (double)Math.round(sueldo_Liquido*10d)/10;
               
               
               // Columna departamentos
                MatrizCalculoPlanilla [nfilas][6]= 1+ (int) (Math.random() *5);
                
                // calculo del ISR
                
                if(MatrizCalculoPlanilla [nfilas][1]<4000){
                     MatrizCalculoPlanilla [nfilas][4]=0.0;
                                   }else{
                    
                                  if(MatrizCalculoPlanilla [nfilas][1]>=4000){
                                      double calculo_Deduccion_Legal = 48000-calculo_IGSS*12;
                                   calculo_ISR=(MatrizCalculoPlanilla [nfilas][1]+250)*12-calculo_Deduccion_Legal ;
                            MatrizCalculoPlanilla [nfilas][4]=( (double)Math.round(calculo_ISR*0.05/12*100d)/100);
                                  }  else{
                                      double calculo_Descuento_Legal = 48000-calculo_IGSS*12;
                                    calculo_ISR=  MatrizCalculoPlanilla [nfilas][1]+250*12-calculo_Descuento_Legal*0.07+1500;
                                       MatrizCalculoPlanilla [nfilas][4]=(double) Math.round(calculo_ISR*100d)/100;
                                  }                          
                   }                        
    }                        
             // sueldo total liquido por departamentos;
             
                         if(  MatrizCalculoPlanilla [nfilas][6]  ==1 ){
               departamentos[0]+=MatrizCalculoPlanilla [nfilas][5];  
            }
            if(MatrizCalculoPlanilla [nfilas][6] ==2){
                departamentos[1]+=MatrizCalculoPlanilla [nfilas][5]; 
            }
             if(MatrizCalculoPlanilla [nfilas][6] ==3){
                departamentos[2]+=MatrizCalculoPlanilla [nfilas][5]; 
                
            } if(MatrizCalculoPlanilla [nfilas][6] ==4){
                departamentos[3]+=MatrizCalculoPlanilla [nfilas][5]; 
            }
             if(MatrizCalculoPlanilla [nfilas][6] ==5){
                departamentos[4]+=MatrizCalculoPlanilla [nfilas][5];
                
            } 

                }
     
                  // IMPRESION DE MATRIZ PLANILLA
          System.out.println("Calculo Planilla"+"\n");
          int fila; 
             System.out.print("CODIGO   "+"    SUELDO BASE   "+"   IGSS(-) "
                    + "   BONIFICACION (+)  "+   "   ISR(-)    "+"  SUELDO LIQUIDO   "+"   DEPARTAMENTOS  "+"\n");  
               for(  fila=0; fila<10;fila++){
        for(int columna=0; columna<7;columna++){
                            System.out.print(MatrizCalculoPlanilla[fila][columna]+"\t "+"\t");   
        }
        System.out.println();
          }
               // IMPRESION VECTOR, TOTAL SUELDOS POR DEPARTAMNTOS
                 System.out.println();
                       // Total de Sueldo a Pagar por departamento
                       System.out.println("SUELDOS POR DEPTO"+"\n");
                     for(int j =0; j<5;j++){
                            System.out.println((double) Math.round (departamentos[j]*100d)/100);   
        }
    
                       
                       
        
}
}
        
        /**************************************************************************************************************************************/

 

 
                              
             
   
  
