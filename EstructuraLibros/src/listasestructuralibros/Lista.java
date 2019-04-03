/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasestructuralibros;

/**
 *
 * Ester Guamuch
 * 0901-17-998
 */
public class Lista {
    
    // puntero de inicio o principal
    	private Nodo cabeza=null;
        
        // variable de longitud de la lista
	private int longitud=0;
        
	private class Nodo {
		public Libro libro; // estructura del libro
		public Nodo siguiente=null; // puntero para enlazar
                
                //Constructor para insertar al final
		public Nodo(Libro libro) {
			this.libro=libro;
		}
	}
        
        // Inserta datos al inicio de la lista
	public void insertarPrincipio(Libro libro) {
		Nodo nodo=new Nodo(libro); // crea un nuevo nodo Tipo Libro
	                nodo.siguiente=cabeza; // nodo siguiente ahora apunta a nulo
		cabeza=nodo;
		longitud++;	
	}
        
        // inserta al final de la lista
	public void insertarFinal(Libro libro) {
		Nodo nodo=new Nodo(libro); // Crea un nuevo nodo
		if (cabeza==null) { // si la cabeza esta vacia 
			cabeza=nodo; // el inicio pasa a apuntar el nuevo nodo
		} else {
			Nodo puntero=cabeza;
			while (puntero.siguiente!=null) {
				puntero=puntero.siguiente;
			}
			puntero.siguiente=nodo;
		}
		longitud++;
	}
        
        // Muestra los datos 
        public String Listar()
	{
		String Dato=" "; // crea una varibable que guarda los datos asignados a la lista
		Nodo aux=cabeza; // nuevo nodo que recorre la lista
		while (aux!=null) // muestra todos los datos mientras que no sea nulo
		{
		/*Datos que se van a mostrar*/Dato+="" + aux.libro.getAutor()+"\n" + aux.libro.getTitulo()+"\n" +aux.libro.getIsbn()+"\n\n" + "";
		/*avanza al siguiente*/aux=aux.siguiente; // 
		}
		return(Dato); 
	}
        
        // Inserta en una posicion especifica
	public void insertarDespues(int n, Libro libro) {
		Nodo nodo=new Nodo(libro);
		if (cabeza==null) {
			cabeza=nodo;
		} else {
			Nodo puntero=cabeza;
			int contador=0;
			while (contador<n && puntero.siguiente!=null) {
				puntero=puntero.siguiente;
				contador++;
			}
			nodo.siguiente=puntero.siguiente;
			puntero.siguiente=nodo;
		}
		longitud++;
	}
	public Libro obtener( int n ) {
                
		if (cabeza==null) {
			return null;
		} else {
			Nodo puntero=cabeza;
			int contador=0;
			while (contador<n && puntero.siguiente!=null) {
				puntero=puntero.siguiente;
				contador++;
			}
			if (contador!=n) {
				return null;
			} else {
				return puntero.libro;
			}
		}
	}
           
      
	public int contar() {
		return longitud;
	}
        public boolean estaVacia() {
            return cabeza==null;
        }
        // metodo para eliminar un nodo al inicio
        public void eliminaPrincipio() {
                 if(cabeza == cabeza.siguiente){
                cabeza = null;
                cabeza.siguiente = null;
            }else{
                cabeza = cabeza.siguiente;
            }
        
                /*if (cabeza!=null){
                Nodo Primer = cabeza;
                cabeza=cabeza.siguiente=null;
                Primer.siguiente = null;
                cabeza = cabeza.siguiente;
                longitud--;
                }*/        }
        public void eliminarUltimo() {
            if (cabeza!= null) {
                if (cabeza.siguiente==null) {
                    cabeza=null;  
                    longitud--;
                } else {
                    Nodo puntero=cabeza;
                    while (puntero.siguiente.siguiente!=null) {                    
                        puntero=puntero.siguiente;
                    }
                    puntero.siguiente=null;
                    longitud--;
                }
            }
        }
        public void eliminarLibro(int n) {
            if (cabeza!=null){
                if (n==0){
                    Nodo primer=cabeza;
                    cabeza=cabeza.siguiente;
                    primer.siguiente=null;
                    longitud--;
                } else if (n<longitud) {
                    Nodo puntero=cabeza;
                    int contador=0;
                    while (contador<(n-1)){
                        puntero=puntero.siguiente;
                        contador++;
                    }
                    Nodo temp=puntero.siguiente;
                    puntero.siguiente=temp.siguiente;
                    temp.siguiente=null;
                    longitud--;
                }
            }
        }
}
