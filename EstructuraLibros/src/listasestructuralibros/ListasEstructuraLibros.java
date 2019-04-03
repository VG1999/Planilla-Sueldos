
package listasestructuralibros;

import javax.swing.JOptionPane;

/**
 *
 * Ester Guamuch
 * 0901-17-998
 * Programa de listas enlazadas que inserta y elimina datos
 */
public class ListasEstructuraLibros {
      
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
            
            iOpc = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido que operacion desea realizar:\n1.IngresarPrincipio\n2.Mostrar\n3.InsertarUltimo\n4.InsertarDespues\n5.EliminarPrincipio\n6.Eliminar Ultimo\n7.EliminarLibro\n8.Salir"));
             
             switch(iOpc){
                 // inserta datos al principio
                  case 1: 
                      insertarDato();
                      libro = new Libro(titulos,autores,isbn);
                      fun.insertarPrincipio(libro);
                                        break;   
                                        
                  // muestra los datos
                  case 2:
                   JOptionPane.showMessageDialog(null,"Datos\n"+ fun.Listar()); 
                      break;
                   
                      // inserta los datos al final de la lista
                  case 3:
                     insertarDato();
                      libro = new Libro(titulos,autores,isbn);
                      fun.insertarFinal(libro);
                      break;
                      
                      // inserta datos en la posicion deseada
                  case 4:
                       InsertarDatosDespues();
                      libro = new Libro(titulos,autores,isbn);
                      fun.insertarDespues(iInsertarPos,libro);
                      break;
                      
                      // elimina el inicio de la lista
                  case 5:
                      libro = new Libro(titulos,autores,isbn);
                      fun.eliminaPrincipio();
                      break;
                      
                      // elimina el final de la lista
         case 6:
                      libro = new Libro(titulos,autores,isbn);
                      fun.eliminarUltimo();
                      break;
                      
         case 7:
             iInsertarPos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su posicion"));    
              libro = new Libro(titulos,autores,isbn);
                      fun.eliminarLibro(iBorrarLibro);
             
             }
      
    }while(iOpc !=8);
       
   
        }
    
    // metodo que permite pedir los datos
   public static void  insertarDato(  ){
           titulos = JOptionPane.showInputDialog("Ingrese el titulo del libro");
          autores =   JOptionPane.showInputDialog("Ingrese el autor");
          isbn =   JOptionPane.showInputDialog("Ingrese el isbn");
                        
              
   }
        
   // Me pide los datos en la posicion deseada
   public static void InsertarDatosDespues(){
        int  iRespuesta = 0;
        iInsertarPos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su posicion"));

             titulos = JOptionPane.showInputDialog("Ingrese el titulo del libro");
          autores =   JOptionPane.showInputDialog("Ingrese el autor");
          isbn =   JOptionPane.showInputDialog("Ingrese el isbn");
           
   }
   }


