
package clasesAuxiliares;

import ecoparque.Cuidador;
import ecoparque.Sistema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase con métodos para leer por consola distintos tipos de datos.
 * @author Agustín Pacheco
 */
public class LecturaPorConsola {
    
    //////////////////////////////////////////FUNCIONES DE LECTURA POR CONSOLA//////////////////////////////////////////
    /**
     *
     * @return String leida por consola
     */
    public static String leerString(){
        Scanner in = new Scanner(System.in);
        String s;
        
        s = in.nextLine();
        
        return (s == null ? "" : s);
    }
    
    /**
     *
     * @return cualquier int leido por consola
     * @throws InputMismatchException
     */
    public static int leerInt(){
        Scanner in = new Scanner(System.in);
        int opc = Integer.MIN_VALUE;
        
        try{
            System.out.println("Ingrese un número entero: ");   
            opc = in.nextInt();
        }catch(InputMismatchException e){System.out.println("\nEso no es un número entero.\n");}
        
        return opc;
    }
    
    /**
     *
     * @param max numero maximo que puede ingresar
     * @return numero leido por consola, lo limita entre 1 y max (para los menu)
     * @throws InputMismatchException
     */
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
    
    /**
     *
     * @param max numero maximo que puede leer
     * @param min numero minimo que puede leer
     * @return el int que lea por consola que este entre min y max
     * @throws InputMismatchException
     */
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
    
    /**
     *
     * @return el char que lea por consola
     */
    public static char leerChar(){
        String s = leerString();
        return (s.length() == 0 ? '0' : s.charAt(0));
    }
    
    /**
     *
     * @return un char que solo puede ser S,s,N,n
     */
    public static char leerSiNo(){
        char c;
        do{
            c = leerChar();
        }while(c != 's' && c == 'S' && c == 'n' && c == 'N');
        return c;
    }
    
    /**
     * 
     * @return un boolean dependiendo la entrada por consola, S,s true y N,n false
     */
    public static boolean leerBoolean(){
        boolean resp;
        char c = leerSiNo();
        
        if (c == 's' || c == 'S') {
            resp = true;
        }
        else {
            resp = false;
        }
        
        return resp;
    }
    
    //////////////////////////////////////////DATOS PARA EMPLEADOS//////////////////////////////////////////
    /**
     * Pide el nombre de usuario para los empleados
     * @return un String con el usuario ingresado por consola
     * @throws NullPointerException
     */
    public static String pedirUsuario(){
        //PIDO NOMBRE DE USUARIO DEL EMPLEADO
        System.out.print("Ingrese su usuario: ");
        String usuario = leerString();
        if (usuario.equals("")) {
            throw new NullPointerException("ERROR: El usuario no puede ser nulo.");
        }
        return usuario;
    }
    
    /**
     * Pide una contraseña para los empleados
     * @return un String con la contraseña ingresada por consola
     * @throws NullPointerException
     */
    public static String pedirContra(){
        //PIDO CONTRASEÑA PARA EL USUARIO
        System.out.print("Ingrese su contraseña: ");
        String contra = leerString();
        if (contra.equals("")) {
            throw new NullPointerException("ERROR: La password no puede ser nula.");
        }
        return contra;
    }
    
    /**
     * Pide el nombre del empleado
     * @return un String con el nombre ingresado por consola
     * @throws NullPointerException
     */
    public static String pedirNombreEmpleado(){
        //PIDO NOMBRE DEL EMPLEADO
        System.out.print("Ingrese su nombre completo: ");
        String nombre = leerString();
        if (nombre.equals("")) {
            throw new NullPointerException("ERROR: Su nombre no puede ser nulo.");
        }
        return nombre;
    }
    
    /**
     * Pide la dirección del empleado
     * @return un String con la direccoin ingresada por consola
     * @throws NullPointerException
     */
    public static String pedirDireccion(){
        //PIDO DIRECCIÓN DEL EMPLEADO
        System.out.print("Ingrese su dirección: ");
        String direccion = leerString();
        if (direccion.equals("")) {
            throw new NullPointerException("ERROR: Su dirección no puede ser nula.");
        }
        return direccion;
    }
    
    /**
     * Pide un telefono para los empleados
     * @return un String con el telefono ingresado por consola
     * @throws NullPointerException
     */
    public static String pedirTelefono(){
        //PIDO TELEFONO DEL EMPLEADO
        System.out.print("Ingrese su telefono: ");
        String telefono = leerString();
        if (telefono.equals("")) {
            throw new NullPointerException("ERROR: Su telefono no puede ser nulo.");
        }
        return telefono;
    }
    
    /**
     * Pide TODOS los datos necesarios para los empleados exceptuando la fecha de ingreso
     * @return un ArrayList de strings con usuario, contraseña, nombre, direccion y telefono en ese orden
     */
    public static ArrayList<String> pedirDatosEmpleado(){
        ArrayList<String> datos = new ArrayList<>();
        datos.add(pedirUsuario());
        datos.add(pedirContra());
        datos.add(pedirNombreEmpleado());
        datos.add(pedirDireccion());
        datos.add(pedirTelefono());
        return datos;
    }
    
    /**
     * Confirma la decisión que va a tomar el usuario
     * @return true si esta seguro y false si se retracto
     */
    public static boolean confirmarDecision(){
        boolean decision = false;
        char c = 'a';
        
        while(c != 's' && c != 'S' && c != 'n' && c != 'N'){
            System.out.print("\n¿Está seguro que desea realizar esta acción? (s/n): ");
            c = leerChar();
        }
        
        if (c == 's' || c == 'S') decision = true;
        if (c == 'n' || c == 'N') decision = false;
        
        return decision;
    }
    
    //////////////////////////////////////////DATOS PARA ESPECIES//////////////////////////////////////////
    /**
     * Pide el nombre de la especie
     * @return un String con el nombre ingresado por consola
     * @throws NullPointerException
     */
    public static String pedirNombreColoquialEspecie(){
        //PIDO NOMBRE DEL HABITAT A REGISTRAR
        System.out.print("\nIngrese el nombre de la especie: ");
        String s = leerString();
        if (s.equals("")) {
            throw new NullPointerException("ERROR: Su nombre no puede ser nulo.");
        }
        return s;
    }
    
    /**
     * Pide el nombre cientifico de la especie
     * @return un String con el nombre ingresado por consola
     * @throws NullPointerException
     */
    public static String pedirNombreCientificoEspecie(){
        //PIDO NOMBRE DEL HABITAT A REGISTRAR
        System.out.print("\nIngrese el nombre cientifico de la especie: ");
        String s = leerString();
        if (s.equals("")) {
            throw new NullPointerException("ERROR: Su nombre no puede ser nulo.");
        }
        return s;
    }
    
    /**
     * Pide la descripción de la especie
     * @return un String con la descripcion ingresado por consola
     * @throws NullPointerException
     */
    public static String pedirDescripcion(){
        System.out.println("Ingrese la descripcion de la especie: ");
        String s = leerString();
        if (s.equals("")) {
            throw new NullPointerException("ERROR: Su nombre no puede ser nulo.");
        }
        return s;
    }
    
    /**
     * Pide los cuidadores de la especie
     * @param s sistema de donde se sacan los cuidadores
     * @return un Empleado encargado de cuidar a la especie
     */
    public static ArrayList<Cuidador> pedirCuidadores(Sistema s){
        ArrayList<Cuidador> e = new ArrayList<>();
        String cuidador;
        boolean hayMas;
        int i = 0;
        
        do{
            s.mostrarEmpleados();
            System.out.print("\nIngrese el nombre de usuario del cuidador de esta especie (0 para salir): ");
            cuidador = leerString();
            e.add(s.existeCuidador(cuidador));
            
            if (e.get(i) == null) {
                System.err.println("Error: ese empleado no existe o no es un cuidador.\n");
                hayMas = true;
            }
            else if(cuidador.equals("0")) hayMas = false;
            else {
                
                System.out.print("¿Hay más cuidadores asignados a esta especie? (s/n): ");
                hayMas = leerBoolean();
            }
            i++;
        }while(hayMas);
        
        e.removeAll(Collections.singleton(null));
                
        
        return e;
    }
    
    
}
