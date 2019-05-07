
package lab.pkg6.colas;


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
        
        public void Encolar(Libro libro){
            Nodo nodo = new Nodo(libro);
            if(cabeza == null){
                cabeza = nodo;
            }else{
                Nodo puntero = cabeza;
                while(puntero.siguiente != null){
                    puntero = puntero.siguiente;
                }
                puntero.siguiente = nodo;
            }
            longitud++;
        }
        
        public void Desencolar(){
          
            if(cabeza != null){
                Nodo Primero = cabeza;
                cabeza = cabeza.siguiente;
                Primero.siguiente =null;
                longitud --;
                       
            }
		
        }
        
      public String Listar()
	{
		String Dato=" "; // crea una varibable que guarda los datos asignados a la lista
		Nodo aux=cabeza; // nuevo nodo que recorre la lista
		while (aux!=null) // muestra todos los datos mientras que no sea nulo
		{
		/*Datos que se van a mostrar*/Dato+="" +"AUTOR: " + aux.libro.getAutor()+"\n" +"LIBRO: "+ aux.libro.getTitulo()+"\n" +"ISBN: "+aux.libro.getIsbn()+"\n\n" + "";
		/*avanza al siguiente*/aux=aux.siguiente; // 
		}
		return(Dato); 
	}
      
      public boolean estaVacia() {
            return cabeza==null;
        }
}
