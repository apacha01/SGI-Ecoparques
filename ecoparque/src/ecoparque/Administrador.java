
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.LecturaPorConsola.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Agustín Pacheco
 */
public class Administrador extends Empleado implements Serializable{
    
    public Administrador(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(usuario, contra, nombre, direccion, telefono, fechaIngreso);
    }
    
    @Override
    public boolean ingresar(Sistema s) {
        boolean seguir = true;
        int opc;
        
        while(seguir){
            this.printMenu();
            opc = leerInt(CANT_OPC_MENU_ADMIN);
            seguir = procesarOpcion(opc, s);
        }
        
        return false;
    }
    
    @Override
    public void printMenu() {
        System.out.println("\n" + SEPARADOR_MEDIO + "MENU DE ADMINISTRADOR" + SEPARADOR_MEDIO);
        super.printMenu();
        System.out.println(DAR_ALTA_EMPLEADO + ". Dar de alta un empleado.");
        System.out.println(DAR_BAJA_EMPLEADO + ". Dar de baja un empleado.");
        System.out.println(DAR_ALTA_ESPECIE + ". Dar de alta una especie.");
        System.out.println(DAR_BAJA_ESPECIE + ". Dar de baja una especie.");
        System.out.println(REGISTRAR_ZONA + ". Registrar zona.");
        System.out.println(INHABILITAR_ZONA + ". Inhabilitar zona.");
        System.out.println(REGISTRAR_HABITAT + ". Registrar habitat.");
        System.out.println(INHABILITAR_HABITAT + ". Inhabilitar habitat.");
        System.out.println(ASIGNAR_ESP_CUIDADOR + ". Asignar una especie a un cuidador.");
        System.out.println(REMOVER_ESP_CUIDADOR + ". Remover una especie a un cuidador.");
        System.out.println(ASIGNAR_INT_GUIA + ". Asignar un intinerario a un guia.");
        System.out.println(REMOVER_INT_GUIA + ". Remover un intinerario a un guia.");
        System.out.println(LISTAR_EMPLEADOS_X_ANTIGUEDAD + ". Listar empleados por antiguedad.");
    }

    private boolean procesarOpcion(int op, Sistema s){
        boolean seguir = true;
        switch(op){
            case Integer.MIN_VALUE: System.err.println("Ocurrió un error al elegir la opción del menu."); break;
            case SALIR_MENU: seguir = false; break;
            case CONSULTAR_DATOS: consultarDatos(s); break;
            case DAR_ALTA_EMPLEADO: darAltaEmp(s); break;
            case DAR_BAJA_EMPLEADO: darBajaEmp(s); break;
            case DAR_ALTA_ESPECIE: darAltaEsp(s); break;
            case DAR_BAJA_ESPECIE: darBajaEsp(s); break;
            case REGISTRAR_ZONA: registrar(STRING_ZONA, s); break;
            case INHABILITAR_ZONA: inhabilitar(STRING_ZONA, s); break;
            case REGISTRAR_HABITAT: registrar(STRING_HABITAT, s); break;
            case INHABILITAR_HABITAT: inhabilitar(STRING_HABITAT, s); break;
            case ASIGNAR_ESP_CUIDADOR: ; break;
            case REMOVER_ESP_CUIDADOR: ; break;
            case ASIGNAR_INT_GUIA: ; break;
            case REMOVER_INT_GUIA: ; break;
            case LISTAR_EMPLEADOS_X_ANTIGUEDAD: listarXantiguedad(s); break;
            default: System.err.println("Error: esa opción no existe."); break;
        }
        if (op >= 3 && op <= CANT_OPC_MENU_ADMIN-1) {
            try { s.serializar(NOMBRE_ARCHIVO); }
            catch (IOException e) { e.printStackTrace(); }
        }
        
        return seguir;
    }
    
    @Override
    public void consultarDatos(Sistema s) {
        System.out.println("\n");
        
        //MUESTRO EMPLEADOS
        s.mostrarEmpleados();
        
        //MUESTRO ESPECIES
        s.mostrarEspecies();
        
        //MUESTRO HABITATS
        s.mostrarHabitats();
        
        //MUESTRO ZONAS
        s.mostrarZonas();
        
        //MUESTRO INTINERARIOS
        s.mostrarIntinerarios();
        
    }

    private void darAltaEmp(Sistema s) {
        //ASD AGREAGAR VALIDACION DESPUES NO MAS DE 2 NOM_USUARIOS IGUALES ------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        int opc = -1;
        Empleado e = null;
        ArrayList<String> datos;
        
        System.out.println("\n¿Qué tipo de empleado desea ingresar al sistema?\n");
        System.out.println("1. Cuidador\n2. Guía\n3. Salir");
        opc = leerInt(3);
        
        
        switch(opc){
            case -1: System.err.println("Error 1 al dar de alta empleado."); break;
            case 1:
                datos = pedirDatosEmpleado();
                e = new Cuidador(datos.get(0),datos.get(1),datos.get(2),datos.get(3),datos.get(4), new Date());
                break;
            case 2: 
                datos = pedirDatosEmpleado();
                e = new Guia(datos.get(0),datos.get(1),datos.get(2),datos.get(3),datos.get(4), new Date());
                break;
            case 3: return;
            default: System.err.println("Error 2 al dar de alta empleado."); break;
        }
        if (e != null) s.getEmpleados().add(e);
    }

    private void darBajaEmp(Sistema s) {
        String empBaja;
        Empleado e = null;
        
        while(true){
            System.out.println("\n¿Qué empleado desea dar de baja?");
            s.mostrarEmpleados();
            System.out.print("\nIngrese el nombre de usuario del empleado que desea elminiar (0 para salir): ");
            empBaja = leerString();
            if (empBaja.equals("0")) break;
            e = s.existeEmpleado(empBaja);
            if (e != null) {
                if (confirmarDecision()) {
                    break;
                }
            }
        }
        
        s.eliminarEmpleado(e);
        
    }

    private void darAltaEsp(Sistema s) {
        //ASD AGREAGAR VALIDACION DESPUES NO MAS DE 2 NOM_CIENTIFICOS IGUALES ------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         String nom = pedirNombreColoquialEspecie();
         String nomCient = pedirNombreCientificoEspecie();
         String desc = pedirDescripcion();
         ArrayList<Cuidador> cuidadores = pedirCuidadores(s);
         
         Especie nuevaEspecie = new Especie(nom,nomCient,desc,cuidadores);
         
         s.getEspecies().add(nuevaEspecie);
    }

    private void darBajaEsp(Sistema s) {
        String espBaja;
        Especie e = null;
        
        while(true){
            System.out.println("\n¿Qué especie desea dar de baja?");
            s.mostrarEspecies();
            System.out.print("\nIngrese el nombre cientifico de la especie que desea elminiar (0 para salir): ");
            espBaja = leerString();
            
            if (espBaja.equals("0")) break;
            
            e = s.existeEspecie(espBaja);
            if (e != null) {
                if (confirmarDecision()) {
                    break;
                }
            }
        }
        
        s.eliminarEspecie(e);
    }

    private void registrar(String s, Sistema sis) {
        switch (s) {
            case STRING_ZONA:
                String nomZona;
                Double extZona;
                boolean tieneEspecie;
                
                System.out.print("\nIngrese el nombre de la zona: ");
                nomZona = leerString();
                
                System.out.print("\nExtensión de la zona en m2: ");
                //ASD AGREAGAR VALIDACION PARA QUE NO PUEDA SER MENOR A 0
                extZona = leerDouble();
                
                System.out.print("\n¿Esta zona tiene especies? (s/n): ");
                tieneEspecie = leerBoolean();
                
                if (tieneEspecie){
                    ArrayList<Especie> e = pedirEspecies(sis);
                    Zona z = new Zona(nomZona,extZona,e);
                    sis.getZonas().add(z);
                    
                    //GUARDO EN LA ESPECIE LA ZONA EN LA QUE SE LA ESTA PONIENDO
                    for (Especie esp : e) {
                        esp.asignarEspeiceZona(z);
                    }
                }
                else { sis.getZonas().add(new Zona(nomZona,extZona)); }
                break;
            case STRING_HABITAT:
                break;
            default: System.err.println("Error al registrar, no es ni una zona ni un habitat."); break;
        }
    }

    private void inhabilitar(String s, Sistema sis) {
        switch (s) {
            case STRING_ZONA:
                String inhabilitarZona;
                Zona z = null;

                while(true){
                    System.out.println("\n¿Qué zona desea inhabilitar?");
                    sis.mostrarZonas();
                    System.out.print("\nIngrese el nombre de la zona que desea elminiar (0 para salir): ");
                    inhabilitarZona = leerString();

                    if (inhabilitarZona.equals("0")) break;

                    z = sis.existeZona(inhabilitarZona);
                    
                    if (z != null) {
                        if (confirmarDecision()) {
                            break;
                        }
                    }
                }

                sis.eliminarZona(z);
                
                break;
            case STRING_HABITAT:
                break;
            default: System.err.println("Error al inhabilitar, no es ni una zona ni un habitat."); break;
        }
    }

    private void listarXantiguedad(Sistema s) {
        
    }
    
    
}
