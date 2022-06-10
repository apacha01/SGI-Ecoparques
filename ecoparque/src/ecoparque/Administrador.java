
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
        System.out.println(DAR_BAJA_EMPLEADO + ". Dar de baja una especie.");
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
            default: break;
        }
        if (op >= 3 && op <= CANT_OPC_MENU_ADMIN-1) {
            try { s.serializar(NOMBRE_ARCHIVO); }
            catch (IOException e) { e.printStackTrace(); }
        }
        
        return seguir;
    }
    
    private void mostrarEmpleados (Sistema s){
        System.out.println(SEPARADOR_MEDIO + "Empleados" + SEPARADOR_MEDIO);
        ArrayList<Empleado> emps = s.getEmpleados();
        for (int i = 0; i < emps.size(); i++) {
            emps.get(i).mostrarDatos();
            System.out.println(SEPARADOR);
        }
    }
    
    private void mostrarEspecies (Sistema s) {
        System.out.println(SEPARADOR_MEDIO + "Especies" + SEPARADOR_MEDIO);
        ArrayList<Especie> esps = new ArrayList<>();
        //ArrayList<Especie> esps = s.getEspecies();        //ME TOMA esps COMO NULL
        if (esps.isEmpty()) {
            System.out.println("No hay especies registradas en el sistema.");
        } else {
            for (int i = 0; i < esps.size(); i++) {
                esps.get(i).mostrarDatos();
                System.out.println(SEPARADOR);
            }
        }
    }
    
    private void mostrarHabitats (Sistema s){
        System.out.println(SEPARADOR_MEDIO + "Habitats" + SEPARADOR_MEDIO);
        ArrayList<Habitat> habitats = s.getHabitats();
        if (habitats.isEmpty()) {
            System.out.println("No hay habitats registradas en el sistema.");
        } else {
            for (int i = 0; i < habitats.size(); i++) {
                habitats.get(i).mostrarDatos();
                System.out.println(SEPARADOR);
            }
        }
    }
    
    private void mostrarZonas (Sistema s){
//        System.out.println(SEPARADOR_MEDIO + "Zonas" + SEPARADOR_MEDIO);
//        ArrayList<Zona> zonas = s.getZonas();
//        if (zonas.isEmpty()) {
//            System.out.println("No hay zonas registradas en el sistema.");
//        } else {
//            for (int i = 0; i < zona.size(); i++) {
//              zonas.get(i).mostrarDatos();
//              System.out.println(SEPARADOR);
//            }
//        }
    }
    
    private void mostrarIntinerarios (Sistema s){
//        System.out.println(SEPARADOR_MEDIO + "Habitats" + SEPARADOR_MEDIO);
//        ArrayList<Intinerario> ints = s.getIntinerarios();
//        if (ints.isEmpty()) {
//            System.out.println("No hay intinerarios registradas en el sistema.");
//        } else {
//            for (int i = 0; i < ints.size(); i++) {
//              ints.get(i).mostrarDatos();
//              System.out.println(SEPARADOR);
//            }
//        }
    }
    
    @Override
    public void consultarDatos(Sistema s) {
        System.out.println("\n");
        
        //MUESTRO EMPLEADOS
        mostrarEmpleados(s);
        
        //MUESTRO ESPECIES
        mostrarEspecies(s);
        
        //MUESTRO HABITATS
        mostrarHabitats(s);
        
        //MUESTRO ZONAS
        mostrarZonas(s);
        
        //MUESTRO INTINERARIOS
        mostrarIntinerarios(s);
        
    }

    private void darAltaEmp(Sistema s) {
        int opc = -1;
        Empleado e = null;
        
        System.out.println("\n¿Qué tipo de empleado desea ingresar al sistema?\n");
        System.out.println("1. Cuidador\n2. Guía\n3. Salir");
        opc = leerInt(3);
        
        ArrayList<String> datos = pedirDatos();
        
        switch(opc){
            case -1: System.err.println("Error 1 al dar de alta empleado"); break;
            case 1:
                e = new Cuidador(datos.get(0),datos.get(1),datos.get(2),datos.get(3),datos.get(4), new Date());
                break;
            case 2: 
                e = new Guia(datos.get(0),datos.get(1),datos.get(2),datos.get(3),datos.get(4), new Date());
                break;
            case 3: return;
            default: System.err.println("Error 2 al dar de alta empleado"); break;
        }
        if (e != null) s.getEmpleados().add(e);
    }

    private void darBajaEmp(Sistema s) {
        String empBaja;
        Empleado e = null;
        
        while(true){
            System.out.println("\n¿Qué empleado desea dar de baja?");
            mostrarEmpleados(s);
            System.out.print("\nIngrese el nombre de usuario del empleado que desea elminiar: ");
            empBaja = leerString();
            e = s.existeEmpleado(empBaja);
            if (e != null) break;
        }
        
        s.eliminarEmpleado(e);
        
    }

    private void darAltaEsp(Sistema s) {
         
    }

    private void darBajaEsp(Sistema s) {
        
    }

    private void registrar(String s, Sistema sis) {
        
    }

    private void inhabilitar(String s, Sistema sis) {
        
    }

    private void listarXantiguedad(Sistema s) {
        
    }
    
    
}
