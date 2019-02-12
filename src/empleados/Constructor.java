/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;

public class Constructor {
    private String nombreEmpleado;
    private int SueldoBase;
    private int totDescuento;
    private int totIngresos;
    private int sueldoLiquido;
    private int deptoEmpleado;
    
    public Constructor()
    {  nombreEmpleado=" ";
       SueldoBase=0;
       totDescuento=0;
       totIngresos=0;
       sueldoLiquido=0;
       deptoEmpleado=0;       
   
    }
    public Constructor(String nombreEmpleado, int SueldoBase, int totDescuento, int totIngresos, int sueldoLiquido, int deptoEmpleado){
        this.totDescuento = totDescuento;
        this.SueldoBase = SueldoBase;
        this.nombreEmpleado = nombreEmpleado;
        this.totIngresos = totIngresos;
        this.sueldoLiquido=sueldoLiquido;
        this.deptoEmpleado=deptoEmpleado;    
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getSueldoBase() {
        return SueldoBase;
    }

    public void setSueldoBase(int SueldoBase) {
        this.SueldoBase = SueldoBase;
    }

    public int getTotDescuento() {
        return totDescuento;
    }

    public void setTotDescuento(int totDescuento) {
        this.totDescuento = totDescuento;
    }

    public int getTotIngresos() {
        return totIngresos;
    }

    public void setTotIngresos(int totIngresos) {
        this.totIngresos = totIngresos;
    }

    public int getSueldoLiquido() {
        return sueldoLiquido;
    }

    public void setSueldoLiquido(int sueldoLiquido) {
        this.sueldoLiquido = sueldoLiquido;
    }

    public int getDeptoEmpleado() {
        return deptoEmpleado;
    }

    public void setDeptoEmpleado(int deptoEmpleado) {
        this.deptoEmpleado = deptoEmpleado;
    }
   
}
