package empleados
        ;
public class LLENADO {

       private double calculo_IGSS = 0;
       private  double total_Descuento = 0;
    private void calculo_deducciones(double[][] MatrizCalculoPlanilla) {
        for (int nfilas = 0; nfilas < 10; nfilas++) {
            for (int ncolumnas = 0; ncolumnas < 7; ncolumnas++) {

                // calculo IGGS
            
                calculo_IGSS = MatrizCalculoPlanilla[nfilas][1] * 0.0483;
                MatrizCalculoPlanilla[nfilas][2] = ((double) Math.round(calculo_IGSS * 10d) / 10);

                // calculo ISR
                double calculo_Deduccion_Legal = 48000 - calculo_IGSS * 12;

                if (MatrizCalculoPlanilla[nfilas][1] < 4000) {
                    MatrizCalculoPlanilla[nfilas][4] = 0.00;

                } else if (MatrizCalculoPlanilla[nfilas][1] >= 4000) {
                    double calculo_ISR = (MatrizCalculoPlanilla[nfilas][1] + 250) * 12 - calculo_Deduccion_Legal;
                    MatrizCalculoPlanilla[nfilas][4] = ((double) Math.round(calculo_ISR * 0.05 / 12 * 100d) / 100);

                } else {
                    double calculo_ISR = MatrizCalculoPlanilla[nfilas][1] * 12 - calculo_Deduccion_Legal;
                    MatrizCalculoPlanilla[nfilas][4] = ((double) Math.round(calculo_ISR * 0.07 / 12 * 100d) / 100);

                }//fin else
            }// fin columnas
        } // fin filas
    }// fin calculo deducciones

    private void calculo_de_Sueldo_departamentos(double[][] MatrizCalculoPlanilla, double[] departamentos) {

                                      
    }//fin calculo sueldo po departamentos

    public void matriz_general(double[][] MatrizCalculoPlanilla, double[] departamentos) {
                      int nfilas;
        double sueldo_Liquido = 0;
             int n = 0;
        for (nfilas = 0; nfilas < 10; nfilas++) {
            n += 1;
           
            for (int ncolumnas = 0; ncolumnas < 7; ncolumnas++) {
                MatrizCalculoPlanilla[nfilas][0] = n;
                
                // llamada de metodos
           calculo_deducciones(MatrizCalculoPlanilla);
            calculo_de_Sueldo_departamentos(MatrizCalculoPlanilla, departamentos);
        
                //Sueldo Base
                MatrizCalculoPlanilla[nfilas][ncolumnas] = 3000 + (int) (Math.random() * 10000);

                // Bonificacion
                MatrizCalculoPlanilla[nfilas][3] = 250;

                // COLUMNA SUELDO LIQUIDO
                MatrizCalculoPlanilla[nfilas][5] = ((double) Math.round(sueldo_Liquido * 10d) / 10);

                // llenado vector departamento
                MatrizCalculoPlanilla[nfilas][6] = 1 + (int) (Math.random() * 5);

                // calculo sueldo liquido 
             
                total_Descuento =    MatrizCalculoPlanilla[nfilas][2] +MatrizCalculoPlanilla[nfilas][4];
                sueldo_Liquido = MatrizCalculoPlanilla[nfilas][1] - total_Descuento +250;

                             }
                 if (MatrizCalculoPlanilla[nfilas][6] == 1) {
                departamentos[0] += MatrizCalculoPlanilla[nfilas][5];
            }
            if (MatrizCalculoPlanilla[nfilas][6] == 2) {
                departamentos[1] += MatrizCalculoPlanilla[nfilas][5];
            }
            if (MatrizCalculoPlanilla[nfilas][6] == 3) {
                departamentos[2] += MatrizCalculoPlanilla[nfilas][5];

            }
            if (MatrizCalculoPlanilla[nfilas][6] == 4) {
                departamentos[3] += MatrizCalculoPlanilla[nfilas][5];
            }
            if (MatrizCalculoPlanilla[nfilas][6] == 5) {
                departamentos[4] += MatrizCalculoPlanilla[nfilas][5];
            }
    } // fin matriz general
}// fin llenado
}