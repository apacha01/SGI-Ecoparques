
package clasesAuxiliares;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Agustín Pacheco
 * Clase con métodos para leer por consola distintos tipos de datos.
 */
public class LecturaPorConsola {
    
    public static String leerString(){
        Scanner in = new Scanner(System.in);
        String s;
        
        s = in.nextLine();
        
        return (s == null ? "" : s);
    }
    
    public static int leerInt(){
        Scanner in = new Scanner(System.in);
        int opc = Integer.MIN_VALUE;
        
        try{
            System.out.println("Ingrese un número entero: ");   
            opc = in.nextInt();
        }catch(InputMismatchException e){System.out.println("\nEso no es un número entero.\n");}
        
        return opc;
    }
    
    public static int leerInt(int max){
        Scanner in = new Scanner(System.in);
        int opc = Integer.MIN_VALUE;
        
        try{
            while(opc > max || opc < 1){
                System.out.print("\nIngrese un número entero entre 1 y " + max +  ": ");
                opc = in.nextInt();
            }
        } catch (InputMismatchException e){System.out.println("\nEso no es un número entero.\n");}
        
        return opc;
    }
    
    public static int leerInt(int max, int min){
        Scanner in = new Scanner(System.in);
        int opc = Integer.MIN_VALUE;
        
        try{
            while(opc > max || opc < min){   
                System.out.println("Ingrese un número entero entre " + min + " y " + max +  "...");   
                opc = in.nextInt();
            }
        }catch(InputMismatchException e){System.out.println("\nEso no es un número entero.\n");}
        
        
        return opc;
    }
    
    public static char leerChar(){
        String s = leerString();
        return (s.length() == 0 ? '0' : s.charAt(0));
    }
    
    public static String pedirUsuario(){
        //PIDO NOMBRE DE USUARIO DEL EMPLEADO
        System.out.print("Ingrese su usuario: ");
        String usuario = leerString();
        if (usuario.equals("")) {
            throw new NullPointerException("ERROR: El usuario no puede ser nulo.");
        }
        return usuario;
    }
    
    public static String pedirContra(){
        //PIDO CONTRASEÑA PARA EL USUARIO
        System.out.print("Ingrese su contraseña: ");
        String contra = leerString();
        if (contra.equals("")) {
            throw new NullPointerException("ERROR: La password no puede ser nula.");
        }
        return contra;
    }
    
    public static String pedirNombre(){
        //PIDO NOMBRE DEL EMPLEADO
        System.out.print("Ingrese su nombre completo: ");
        String nombre = leerString();
        if (nombre.equals("")) {
            throw new NullPointerException("ERROR: Su nombre no puede ser nulo.");
        }
        return nombre;
    }
    
    public static String pedirDireccion(){
        //PIDO DIRECCIÓN DEL EMPLEADO
        System.out.print("Ingrese su dirección: ");
        String direccion = leerString();
        if (direccion.equals("")) {
            throw new NullPointerException("ERROR: Su dirección no puede ser nula.");
        }
        return direccion;
    }
    
    public static String pedirTelefono(){
        //PIDO TELEFONO DEL EMPLEADO
        System.out.print("Ingrese su telefono: ");
        String telefono = leerString();
        if (telefono.equals("")) {
            throw new NullPointerException("ERROR: Su telefono no puede ser nulo.");
        }
        return telefono;
    }
    
    public static ArrayList<String> pedirDatos(){
        ArrayList<String> datos = new ArrayList<>();
        datos.add(pedirUsuario());
        datos.add(pedirContra());
        datos.add(pedirNombre());
        datos.add(pedirDireccion());
        datos.add(pedirTelefono());
        return datos;
    }
    
}
