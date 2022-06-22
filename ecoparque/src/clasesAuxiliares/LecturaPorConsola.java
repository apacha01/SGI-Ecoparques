
package clasesAuxiliares;

import static clasesAuxiliares.Clima.toStringClima;
import static clasesAuxiliares.Vegetacion.toStringVegetacion;
import static clasesAuxiliares.Continente.toStringContinente;
import static clasesAuxiliares.Constantes.*;
import ecoparque.Cuidador;
import ecoparque.Especie;
import ecoparque.Guia;
import ecoparque.Habitat;
import ecoparque.Intinerario;
import ecoparque.Sistema;
import ecoparque.Zona;
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
    private static int pedirInt(){
        Scanner in = new Scanner(System.in);
        int opc = Integer.MIN_VALUE;
        
        try{
            System.out.print("\nIngrese un número entero: ");   
            opc = in.nextInt();
        }catch(InputMismatchException e){System.err.println("Error: Eso no es un número entero.");}
        
        return opc;
    }
    
    /**
     *
     * @return
     */
    public static int leerInt(){
        int lectura;
        
        do {
            lectura = pedirInt();
        } while (lectura == Integer.MIN_VALUE);
        
        return lectura;
    }
    
    /**
     *
     * @return cualquier int leido por consola
     * @throws InputMismatchException
     */
    private static double pedirDouble(){
        Scanner in = new Scanner(System.in);
        double lectura = Integer.MIN_VALUE;
        
        try{
            System.out.print("\nIngrese un número (para un decimal utilice la coma ',' en lugar del punto '.'): ");   
            lectura = in.nextDouble();
        }catch(InputMismatchException e){System.err.println("Error: Eso no es un número, recuerde usar la coma.");}
        
        return lectura;
    }
    
    /**
     *
     * @return
     */
    public static double leerDouble(){
        double lectura;
        
        do {
            lectura = pedirDouble();
        } while (lectura == Integer.MIN_VALUE);
        
        return lectura;
    }
    
    /**
     *
     * @param max numero maximo que puede ingresar
     * @return numero leido por consola, lo limita entre 1 y max (para los menu)
     * @throws InputMismatchException
     */
    private static int pedirInt(int max){
        Scanner in = new Scanner(System.in);
        int opc = Integer.MIN_VALUE;
        
        try{
            while(opc > max || opc < 1){
                System.out.print("\nIngrese un número entero entre 1 y " + max +  ": ");
                opc = in.nextInt();
            }
        } catch (InputMismatchException e){System.err.println("Error: Eso no es un número entero.");}
        
        return opc;
    }
    
    /**
     *
     * @param max
     * @return
     */
    public static int leerInt(int max){
        int num;
        
        do {
            num = pedirInt(max);
        } while (num > max || num < 1);
        
        return num;
    }
    
    /**
     *
     * @param max numero maximo que puede leer
     * @param min numero minimo que puede leer
     * @return el int que lea por consola que este entre min y max
     * @throws InputMismatchException
     */
    private static int pedirInt(int min, int max){
        Scanner in = new Scanner(System.in);
        int opc = Integer.MIN_VALUE;
        
        try{
            while(opc > max || opc < min){   
                System.out.print("\nIngrese un número entero entre " + min + " y " + max +  ": ");   
                opc = in.nextInt();
            }
        }catch(InputMismatchException e){System.err.println("Error: Eso no es un número entero.");}
        
        
        return opc;
    }
    
    /**
     *
     * @param min
     * @param max
     * @return
     */
    public static int leerInt(int min, int max){
        int num;
        
        do {
            num = pedirInt(min, max);
        } while (num > max || num < min);
        
        return num;
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
        boolean flag = false;
        
        do{
            if (flag) {
                System.out.print("Debe ingresar 'S' (o 's') o 'N' (o 'n') para la respuesta: ");
            }
            c = leerChar();
            flag = true;
        }while(c != 's' && c != 'S' && c != 'n' && c != 'N');
        
        return c;
    }
    
    /**
     * 
     * @return un boolean dependiendo la entrada por consola, S,s true y N,n false
     */
    public static boolean leerBoolean(){
        char c = leerSiNo();
        return (c == 's' || c == 'S');
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
        System.out.print("Ingrese el nombre cientifico de la especie: ");
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
        ArrayList<Cuidador> c = new ArrayList<>();
        Cuidador cuid;
        String cuidador;
        boolean hayMas;
        
        
        if (s.obtenerCuidadores().isEmpty()) {
            System.err.println("Error: No hay cuidadores registrados en el sistema.");
            return c;
        }
        else{
            do{
                s.mostrarCuidadores();
                System.out.print("\nIngrese el nombre de usuario del cuidador de esta especie (0 para salir): ");
                cuidador = leerString();

                if(cuidador.equals("0")) break;

                cuid = s.existeCuidador(cuidador);

                if (cuid == null) {
                    System.err.println("Error: ese cuidador no existe.");
                    hayMas = true;
                }
                else {
                    if (!c.contains(cuid)) {
                        c.add(cuid);
                        System.out.print("¿Hay más cuidadores que desee elegir? (s/n): ");
                        hayMas = leerBoolean();
                    }
                    else{
                        System.err.println("Error: Ese cuidador ya lo selecciono anteriormente.");
                        hayMas = true;
                    }
                }
            }while(hayMas);
        }
        
        
        c.removeAll(Collections.singleton(null));
                
        
        return c;
    }
    
    /**
     * Pide los cuidadores de la especie
     * @param s sistema de donde se sacan los cuidadores
     * @return un Empleado encargado de cuidar a la especie
     */
    public static Cuidador pedirCuidador(Sistema s){
        Cuidador e = null;
        String cuidador;
        
        
        if (s.obtenerCuidadores().isEmpty()) {
            System.err.println("Error: No hay cuidadores registrados en el sistema.");
            return e;
        }
        else{
            do {
                s.mostrarCuidadores();
                System.out.print("\nIngrese el nombre de usuario del cuidador de esta especie (0 para salir): ");
                cuidador = leerString();
                e = s.existeCuidador(cuidador);

                if(cuidador.equals("0")) break;
                if (e == null) {
                    System.err.println("Error: ese cuidador no existe.");
                }
                else {break;}
            } while (true);
            
        }
        
        return e;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static Zona pedirZona(Sistema s){
        Zona e;
        String zona;
        boolean hayMas;
        
        do{
            if (s.getZonas().isEmpty()) {
                e = null;
                hayMas = false;
                System.err.println("Error: No hay zonas en el sistema.");
            }
            else{
                s.mostrarZonas();
                System.out.print("\nIngrese el nombre de la zona (0 para salir): ");
                zona = leerString();
                e = s.existeZona(zona);
                
                if(zona.equals("0")) break;
                if (e == null) {
                    System.err.println("Error: esa zona no existe.\n");
                    hayMas = true;
                }
                else{
                    hayMas = false;
                }
            }
        }while(hayMas);
        
        return e;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static ArrayList<Habitat> pedirHabitats(Sistema s){
        ArrayList<Habitat> h = new ArrayList<>();
        Habitat hab;
        String habitat;
        boolean hayMas;
        
        do{
            if (s.getHabitats().isEmpty()) {
                System.err.println("Error: No hay habitats registrados en el sistema.");
                return h;
            }
            else{
                s.mostrarHabitats();
                System.out.print("\nIngrese el nombre del habitat que quiere seleccionar (0 para salir): ");
                habitat = leerString();
                
                if(habitat.equals("0")) break;
                
                hab = s.existeHabitat(habitat);
                
                if (hab == null) {
                    System.err.println("Error: ese habitat no existe.\n");
                    hayMas = true;
                }
                else {
                    if (!h.contains(hab)) {
                        h.add(hab);
                        System.out.print("¿Hay más habitats que desee elegir? (s/n): ");
                        hayMas = leerBoolean();
                    }
                    else{
                        System.err.println("Error: Ese habitat ya lo selecciono anteriormente.");
                        hayMas = true;
                    }
                    
                }
            }
        }while(hayMas);
        
        return h;
    }
    
    //////////////////////////////////////////DATOS PARA ZONAS//////////////////////////////////////////

    
    /**
     *
     * @param s sistema del cual se quieren las especies
     * @return un arraylist de las especies seleccionadas
     */
    public static ArrayList<Especie> pedirEspecies(Sistema s){
        ArrayList<Especie> e = new ArrayList<>();
        Especie esp;
        String especie;
        boolean hayMas;
        
        do{
            if (s.getEspecies().isEmpty()) {
                hayMas = false;
                System.err.println("Error: No hay especies en el sistema.");
            }
            else{
                s.mostrarEspecies();
                System.out.print("\nIngrese el nombre de cientifico de la especie (0 para salir): ");
                especie = leerString();
                
                if(especie.equals("0")) break;
                
                esp = s.existeEspecie(especie);
                
                if (esp == null) {
                    System.err.println("Error: esa especie no existe.\n");
                    hayMas = true;
                }
                else{
                    if (!e.contains(esp)) {
                        e.add(esp);
                        System.out.print("¿Hay más especies que desee elegir? (s/n): ");
                        hayMas = leerBoolean();
                    }
                    else{
                        System.err.println("Error: Esa especie ya la selecciono anteriormente.");
                        hayMas = true;
                    }
                }
            }
        }while(hayMas);
        
        return e;
    }
    
    //////////////////////////////////////////DATOS PARA HABITATS//////////////////////////////////////////

    /**
     *
     * @return clima seleccionado por consola
     */ 
    public static Clima pedirClima(){
        Clima c;
        int opc;
        
        System.out.println("Ingrese el clima (0 para salir): ");
        
        System.out.println((SOLEADO - SUMA_CLIMA) + ". " + toStringClima(SOLEADO));
        System.out.println((NUBLADO - SUMA_CLIMA) + ". " + toStringClima(NUBLADO));
        System.out.println((LLUVIA - SUMA_CLIMA) + ". " + toStringClima(LLUVIA));
        System.out.println((TORMENTA - SUMA_CLIMA) + ". " + toStringClima(TORMENTA));
        System.out.println((TEMPLADO - SUMA_CLIMA) + ". " + toStringClima(TEMPLADO));
        opc = leerInt(0,5) + SUMA_CLIMA;

        if (opc == SUMA_CLIMA) return null;
        else { c = new Clima(opc); }
            
        return c;
    }
    
    /**
     *
     * @return la vegetacion seleccionada por consola
     */
    public static Vegetacion pedirVegetacion(){
        Vegetacion v;
        int opc;
        
        System.out.println("Ingrese la vegetacion (0 para salir): ");
        
        System.out.println((PASTIZAL - SUMA_VEGETACION) + ". " + toStringVegetacion(PASTIZAL));
        System.out.println((SABANA - SUMA_VEGETACION) + ". " + toStringVegetacion(SABANA));
        System.out.println((BOSQUE - SUMA_VEGETACION) + ". " + toStringVegetacion(BOSQUE));
        System.out.println((DESIERTO - SUMA_VEGETACION) + ". " + toStringVegetacion(DESIERTO));
        opc = leerInt(0,4) + SUMA_VEGETACION;

        if (opc == SUMA_VEGETACION) return null;
        else { v = new Vegetacion(opc); }
            
        return v;
    }
    
    /**
     *
     * @return un arraylist con los continentes que se eligan
     */
    public static ArrayList<Continente> pedirContinentes(){
        ArrayList<Continente> conts = new ArrayList<>();
        int opc;
        boolean hayMas;
        
        do{
            System.out.println("Ingrese el continente (0 para salir): ");
            
            System.out.println((AFRICA - SUMA_CONTINENTE) + ". " + toStringContinente(AFRICA));
            System.out.println((ANTARTIDA - SUMA_CONTINENTE) + ". " + toStringContinente(ANTARTIDA));
            System.out.println((AMERICA - SUMA_CONTINENTE) + ". " + toStringContinente(AMERICA));
            System.out.println((ASIA - SUMA_CONTINENTE) + ". " + toStringContinente(ASIA));
            System.out.println((OCEANIA - SUMA_CONTINENTE) + ". " + toStringContinente(OCEANIA));
            System.out.println((EUROPA - SUMA_CONTINENTE) + ". " + toStringContinente(EUROPA));
            
            opc = leerInt(0,6) + SUMA_CONTINENTE;
            
            if (opc == SUMA_CONTINENTE) break;
            else {
                conts.add(new Continente(opc));
                System.out.print("¿Hay más continentes que contengan este habitat? (s/n): ");
                hayMas = leerBoolean();
            }
        }while(hayMas);
        
        
        return conts;
    }
    
    //////////////////////////////////////////DATOS PARA INTINERARIOS//////////////////////////////////////////

    /**
     *
     * @return
     */
    
    public static String pedirCodigoIntinerario(){
        String codigo;
        
        System.out.print("\nIngrese el codigo del intinerario: ");
        codigo = leerString();
        
        return codigo;
    }
    
    /**
     *
     * @return
     */
    public static Duracion pedirDuracionIntinerario(){
        Duracion duracion;
        int hora, min;
        
        while(true){
            System.out.print("\nIngrese la cantidad de horas que dura el recorrido del intinerario: ");
            hora = leerInt();
            if (hora >= 0) {
                break;
            }
            System.err.println("Error: La hora no puede ser negativa.");
        }
        while(true){
            System.out.print("\nIngrese la cantidad de minutos que dura el recorrido del intinerario: ");
            min = leerInt();
            if (min >= 0 && min < 60) {
                break;
            }
            System.err.println("Error: Los minutos no pueden ser negativos o superar 60.");
        }
        
        duracion = new Duracion(hora,min);
        
        return duracion;
    }
    
    /**
     *
     * @return
     */
    public static double pedirLongitudIntinerario(){
        double longitud;
        
        System.out.print("\nIngrese la longitud del recorrido del intinerario en m: ");
        longitud = leerDouble();
        
        return longitud;
    }
    
    /**
     *
     * @return
     */
    public static int pedirMaximoVisitas(){
        int max;
        
        System.out.print("\nIngrese el numero maximo de visitantes que puede tener este intinerario: ");
        max = leerInt();
        
        return max;
    }
    
    /**
     *
     * @return
     */
    public static int pedirNumEspeciesVisita(){
        int espVisita;
        
        System.out.print("\nIngrese el numero de especies que visita este intinerario: ");
        espVisita = leerInt();
        
        return espVisita;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static Intinerario pedirIntinerario(Sistema s){
        Intinerario i;
        String codIntinerario;
        boolean hayMas;
        
        do{
            if (s.getInts().isEmpty()) {
                i = null;
                hayMas = false;
                System.err.println("Error: No hay intinerarios en el sistema.");
            }
            else{
                s.mostrarIntinerarios();
                System.out.print("\nIngrese el codigo del intinerario (0 para salir): ");
                codIntinerario = leerString();
                i = s.existeIntinerario(codIntinerario);
                
                if(codIntinerario.equals("0")) break;
                if (i == null) {
                    System.err.println("Error: ese intinerario no existe.\n");
                    hayMas = true;
                }
                else{
                    hayMas = false;
                }
            }
        }while(hayMas);
        
        return i;
        
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static Guia pedirGuia(Sistema s){
        Guia g;
        String guia;
        boolean hayMas;
        
        do{
            if (s.obtenerGuias().isEmpty()) {
                g = null;
                hayMas = false;
                System.err.println("Error: No hay guias en el sistema.");
            }
            else{
                s.mostrarGuias();
                System.out.print("\nIngrese el nombre de usuario del guia (0 para salir): ");
                guia = leerString();
                g = s.existeGuia(guia);
                
                if(guia.equals("0")) break;
                if (g == null) {
                    System.err.println("Error: ese guia no existe.\n");
                    hayMas = true;
                }
                else{
                    hayMas = false;
                }
            }
        }while(hayMas);
        
        return g;
    }
    
}
