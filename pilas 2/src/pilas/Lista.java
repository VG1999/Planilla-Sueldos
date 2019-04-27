
package pilas;

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

// apilar
public void push(Libro libro){

    Nodo nodo=new Nodo(libro); // crea un nuevo nodo Tipo Libro
       nodo.siguiente=cabeza; // nodo siguiente ahora apunta a nulo
		cabeza=nodo;
		longitud++;	
}

// desapilar
public void pop (){
       if(cabeza == cabeza.siguiente){
                cabeza = null;
                cabeza.siguiente = null;
            }else{
                cabeza = cabeza.siguiente;
            }
}

public void vaciarPila()
{
                if (cabeza!=null){
                Nodo Primer = cabeza;
                cabeza=cabeza.siguiente=null;
                Primer.siguiente = null;
                cabeza = cabeza;
                longitud--;
   }
  }

public  int  tamaño(){
    return longitud;
}

 public boolean estaVacia() {
            return cabeza==null;
        }

 public Libro peek(){
        if (cabeza== null){
         return null;
     }else{
         return cabeza.libro;
     }
 }
 
 
 
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
}