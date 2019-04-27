
package pilas;

import javax.swing.JOptionPane;


public class Pilas {

        
   static  Libro libro = new Libro(""," ",""); // estructura libro que recibe los 3 parametros de los datos a utilizar
     private static String autores; // variable que almacena los autores
      public static String titulos; // variable que almacena el titulo
      public static String isbn; // variable que almacena e; isbn de los libros
      static   Lista fun = new Lista (); // Llama a l metodo lista donde se encuentras los metodos para realizar con el nodo
      static int iInsertarPos; // variable que inserta la posicion donde de deseo insertar datos
      static int iBorrarLibro; // varable que me permiete borrar el dato deseado
     
   
    public static void main(String[] args) {
     int iOpc = 0; // variable de la opciones que se utilizaran en el menu
        
     // Menu
     do{
            
            iOpc = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido que operacion desea realizar:\n1.push\n2.Mostrar\n3.pop\n4.vaciar toda la pila\n5.obtener\n6.Salir"));
             
             switch(iOpc){
                 // inserta datos al principio
                  case 1: 
                      insertarDato();
                      libro = new Libro(titulos,autores,isbn);
                      fun.push(libro);
                                        break;   
                                        
                  // muestra los datos
                  case 2:
                   JOptionPane.showMessageDialog(null,"Datos\n"+ fun.Listar()); 
                      break;
                   
                      // desapila los datos 
                  case 3:
                      libro = new Libro(titulos,autores,isbn);
                      fun.pop();
                      break;
                      
                      // vacia la pila 
                  case 4:
                      libro = new Libro(titulos,autores,isbn);
                      fun.vaciarPila();
                      break;
                      
                      // obtener la pila
                  case 5:
                    libro = new Libro(titulos,autores,isbn);
                      JOptionPane.showMessageDialog(null,fun.peek());
                      break;
                      
        
             
             }
      
    }while(iOpc !=6);
       
   
        }
    
public static void  insertarDato(  ){
           titulos = JOptionPane.showInputDialog("Ingrese el titulo del libro");
          autores =   JOptionPane.showInputDialog("Ingrese el autor");
          isbn =   JOptionPane.showInputDialog("Ingrese el isbn");
                        
              
   }
    
}
