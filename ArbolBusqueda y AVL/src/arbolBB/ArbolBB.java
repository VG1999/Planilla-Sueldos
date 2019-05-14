/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author .
 */

public class ArbolBB {

    private Nodo raiz;
    int num_nodos;
    int alt;
    
    public ArbolBB() {
        raiz = null;
    }
    
    public boolean agregar(int dato) {
       insertar(dato);   
        return true;
    }
    
    // Metodo Buscar
    public Nodo Buscar(int d, Nodo r){
    if(raiz == null){
        return null;
    }else if(r.dato == d){
        return r;
    }else if(r.dato<d){
        return Buscar(d, r.der);        
    }else{
        return Buscar(d,r.izq);
    }
    }
    
    // Obtener el Factor de equilibrio
    public int obtenerFE(Nodo obtener)
    {
        if(obtener == null){
            return -1;
        }else{
            return obtener.fe;
        }
    }
    
    // Rotacion Simple Izquierdo
    public Nodo rotacionIzquierda(Nodo ri){
     Nodo aux = ri.izq;
     ri.izq = aux.der;
     aux.der = ri;
     // metodo max obtiene el maximo en el arbol
     ri.fe = Math.max(obtenerFE(ri.izq), obtenerFE(ri.der))+1;
     aux.fe = Math.max(obtenerFE(aux.izq), obtenerFE(aux.der))+1;
     return aux;
     
    }
    
    // Rotacion Simple Derecho
     public Nodo rotacionDerecho(Nodo rd){
     Nodo aux = rd.der;
     rd.der = aux.izq;
     aux.izq = rd;
       // metodo max obtiene el maximo en el arbol
     rd.fe = Math.max(obtenerFE(rd.izq), obtenerFE(rd.der))+1;
     aux.fe = Math.max(obtenerFE(aux.izq), obtenerFE(aux.der))+1;
     return aux;
    }
    
     
     // Rotacion Doble a la  Izquierda
     
     public Nodo rotacionDobleIzquierda(Nodo c){
         Nodo temp;
         c.izq = rotacionDerecho(c.izq);
         temp = rotacionIzquierda(c);
         return temp;      
     }
      //Rotacion Doble a la derecha
      public Nodo rotacionDobleDerecha(Nodo c){
         Nodo temp;
         c.der = rotacionIzquierda(c.der);
         temp = rotacionDerecho(c);
         return temp;      
         
     }
      
      // Metodo para insertar AVL
 public Nodo insertarAVL(Nodo nuevo, Nodo sub) {
        Nodo nuevoPadre = sub;
        if (nuevo.dato < sub.dato) {
            if (sub.izq == null) {
                sub.izq = nuevo;
            } else {
                sub.izq  = insertarAVL(nuevo, sub.izq);
                if (((obtenerFE((sub.izq ))) - (obtenerFE(sub.der))) == 2) {
                    if (nuevo.dato < sub.izq .dato) {
                        nuevoPadre = rotacionIzquierda(sub);
                    } else {
                        nuevoPadre = rotacionDobleIzquierda(sub);
                    }
                }
            }
        }else if(nuevo.dato>sub.dato){
            if(sub.der==null){
                sub.der=nuevo;
            }else{
                sub.der=insertarAVL(nuevo,sub.der);
                if (((obtenerFE((sub.der))) - (obtenerFE(sub.izq))) == 2) {
                    if (nuevo.dato > sub.der.dato) {
                        nuevoPadre = rotacionDerecho(sub);
                    } else {
                        nuevoPadre = rotacionDobleDerecha(sub);
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "NODO DUPLICADO", "", JOptionPane.PLAIN_MESSAGE);
        }
        //Actualizando la altura
        if((sub.izq ==null)&&(sub.der!=null)){
            sub.fe=sub.der.fe+1;
        }else if((sub.der==null)&&(sub.izq !=null)){
            sub.fe=sub.izq.fe+1;
        }else{
            sub.fe=Math.max(obtenerFE(sub.izq), obtenerFE(sub.der))+1;
        }
        return nuevoPadre;
    }  
 
 
 // 
//Metodo para insertar un dato en el arbol...no acepta repetidos :)
    public void insertar(int dato) {
       Nodo nuevo = new Nodo(dato);
        if (this.raiz == null) {
            raiz = nuevo;
        } else {         
            raiz = insertarAVL(nuevo, raiz);
            }
        }

    

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }
    
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }
    
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }

    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzq(), nivel + 1);
            alt = nivel;
            altura(aux.getDer(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }
    
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
