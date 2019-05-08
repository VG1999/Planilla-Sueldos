/*PROGRAM QUE ELABORA LAS OPERACIONES ENCOLAR, DESENCOLAR, VACIO, MOSTRAR EN COLAR*/

/*
* Ester Guamuch
*0901-17-998
*/
package lab.pkg6.colas;

import javax.swing.JOptionPane;

public class Lab6Colas {
    
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
        
            iOpc = Integer.parseInt(JOptionPane.showInputDialog("Ester Guamuch\n0901-17-998\n\nBienvenido que operacion desea realizar:\n1.Encolar\n2.Mostrar\n3.Desencolar\n4.Esta Vacia\n5.Salir"));
             
             switch(iOpc){
                 
                 // inserta datos 
                  case 1: 
                      insertarDato();
                      libro = new Libro(titulos,autores,isbn);
                      fun.Encolar(libro);
                                        break;   
                                        
                  // muestra los datos
                  case 2:
                   JOptionPane.showMessageDialog(null,"Datos\n"+ fun.Listar()); 
                      break;
                   
                      // desencola los datos
                  case 3:
                      libro = new Libro(titulos,autores,isbn);
                      fun.Desencolar();
                      break;
                      
                      // verificar si esta vacia
                  case 4:
                      libro = new Libro(titulos,autores,isbn);
                      fun.estaVacia();
                      break;
                      
                                      
        
             
             }
      
    }while(iOpc !=5);
       
    }
    public static void  insertarDato(  ){
           titulos = JOptionPane.showInputDialog("Ingrese el titulo del libro");
          autores =   JOptionPane.showInputDialog("Ingrese el autor");
          isbn =   JOptionPane.showInputDialog("Ingrese el isbn");
                        
              
   }
    
    
}
