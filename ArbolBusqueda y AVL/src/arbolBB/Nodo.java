/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

/**
 *
 * @author
 */
public class Nodo {
    public int dato,fe;
    public Nodo izq,der;

    public Nodo(int dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
        this.fe =0;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
 
}
