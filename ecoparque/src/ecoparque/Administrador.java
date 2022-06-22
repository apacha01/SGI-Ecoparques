
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.LecturaPorConsola.*;
import clasesAuxiliares.Clima;
import clasesAuxiliares.Vegetacion;
import clasesAuxiliares.Continente;
import clasesAuxiliares.Duracion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * @author Agustín Pacheco
 */
public class Administrador extends Empleado {
    
    /**
     *
     * @param usuario
     * @param contra
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechaIngreso
     */
    public Administrador(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(usuario, contra, nombre, direccion, telefono, fechaIngreso);
    }
    
    /**
     *
     */
    @Override
    public void mostrarDatos(){
        System.out.println("Tipo de usuario: ADMINISTRADOR");
        super.mostrarDatos();
    }
    
    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean ingresar(Sistema s) {
        boolean seguir = true;
        int opc;
        
        while(seguir){
            this.printMenu();
            opc = leerInt(CANT_OPC_MENU_ADMIN);
            seguir = procesarOpcion(opc, s);
        }
        
        return true;
    }
    
    /**
     *
     */
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
        System.out.println(REGISTRAR_INTINERARIO + ". Registrar intinerario.");
        System.out.println(INHABILITAR_INTINERARIO + ". Inhabilitar intinerario.");
        System.out.println(ASIGNAR_ESP_CUIDADOR + ". Asignar una especie a un cuidador.");
        System.out.println(REMOVER_ESP_CUIDADOR + ". Remover una especie a un cuidador.");
        System.out.println(ASIGNAR_INT_GUIA + ". Asignar un intinerario a un guia.");
        System.out.println(REMOVER_INT_GUIA + ". Remover un intinerario a un guia.");
        System.out.println(LISTAR_EMPLEADOS_X_ANTIGUEDAD + ". Listar empleados por antiguedad.");
    }

    private boolean procesarOpcion(int op, Sistema s){
        boolean seguir = true;
        switch(op){
            //ASD modificar cada cosa???
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
            case REGISTRAR_INTINERARIO: registrar(STRING_INTINERARIO, s); break;
            case INHABILITAR_INTINERARIO: inhabilitar(STRING_INTINERARIO, s); break;
            case ASIGNAR_ESP_CUIDADOR: asignarEspecieCuidador(s); break;
            case REMOVER_ESP_CUIDADOR: removerEspecieCuidador(s); break;
            case ASIGNAR_INT_GUIA: asignarIntinerarioGuia(s); break;
            case REMOVER_INT_GUIA: removerIntinerarioGuia(s); break;
            case LISTAR_EMPLEADOS_X_ANTIGUEDAD: listarXantiguedad(s); break;
            default: System.err.println("Error: esa opción no existe."); break;
        }
        
        if (op >= 3 && op <= CANT_OPC_MENU_ADMIN-1) {
            try { s.serializar(NOMBRE_ARCHIVO); }
            catch (IOException e) { e.printStackTrace(); }
        }
        
        return seguir;
    }
    
    /**
     *
     * @param s
     */
    @Override
    public void consultarDatos(Sistema s) {
        System.out.println("\n");
        
        //MUESTRO EMPLEADOS
        s.mostrarEmpleados();
        
        //MUESTRO ESPECIES
        s.mostrarEspecies();
        
        //MUESTRO ZONAS
        s.mostrarZonas();
        
        //MUESTRO HABITATS
        s.mostrarHabitats();
        
        //MUESTRO INTINERARIOS
        s.mostrarIntinerarios();
        
    }

    private void darAltaEmp(Sistema s) {
        int opc;
        Empleado e = null;
        String _nomUsuario;
        String _contra;
        String _nombre;
        String _direccion;
        String _telefono;
        Date _fechaIngreso;
        boolean existeEmpleado = false;
        
        System.out.println("\n¿Qué tipo de empleado desea ingresar al sistema?\n");
        System.out.println("1. Cuidador\n2. Guía\n3. Salir");
        opc = leerInt(3);
        
        if (opc == 3) return;
        
        do {
            if (existeEmpleado) {
                System.err.println("Error: Ese empleado ya esta registrado en el sistema, no se puede repetir.");
            }
            _nomUsuario = pedirUsuario();
            existeEmpleado = true;
        } while (s.existeEmpleado(_nomUsuario) != null);
        _contra = pedirContra();
        _nombre = pedirNombreEmpleado();
        _direccion = pedirDireccion();
        _telefono = pedirTelefono();
        _fechaIngreso = new Date();
        
        switch(opc){
            case 1:
                e = new Cuidador(_nomUsuario,_contra,_nombre,_direccion,_telefono, _fechaIngreso);
                break;
            case 2:
                e = new Guia(_nomUsuario,_contra,_nombre,_direccion,_telefono, _fechaIngreso);
                break;
            case 3: return; //NO DEBERIA SER NECESARIO
            default: System.err.println("Error al dar de alta empleado."); break;
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
        String nom;
        String nomCient;
        String desc;
        ArrayList<Cuidador> cuidadores;
        boolean hay = false;
        
        nom = pedirNombreColoquialEspecie();
        
        do {
            if (hay) {
                System.err.println("Error: Ese nombre cientifico ya existe en el sistema, no se puede repetir.");
            }
            nomCient = pedirNombreCientificoEspecie();
            hay = true;
        } while (s.existeEspecie(nomCient) != null);
        
        desc = pedirDescripcion();
        
        cuidadores = pedirCuidadores(s);
        
        if (cuidadores.isEmpty()) {
            System.err.println("Error: No se puede dar de alta una especie sin un empleado que la cuide.");
            return;
        }
        
        Especie nuevaEspecie = new Especie(nom,nomCient,desc,cuidadores);
        
        //GUARDO QUE ESPECIE CUIDA CADA EMPLEADO EN LOS CUIDADORES.
        for (Cuidador cuidador : cuidadores) {
            cuidador.tomarEspecie(nuevaEspecie);
        }
        
        //PARA ZONAS
        System.out.print("\n¿Existe alguna zona en la que se encuentre esta especie? (s/n): ");
        hay = leerBoolean();
        if (hay) {
            Zona zona = pedirZona(s);
            if (zona != null) {
                nuevaEspecie.asignarZona(zona);
                zona.agregarEspecie(nuevaEspecie);
            }
        }
        
        //PARA HABITATS
        System.out.print("\n¿Existe algun habitat en el que se encuentre esta especie? (s/n): ");
        hay = leerBoolean();
        if (hay) {
            ArrayList<Habitat> habitats = pedirHabitats(s);
            if (habitats != null && !habitats.isEmpty()) nuevaEspecie.asignarHabitats(habitats);
        }
        
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
        boolean tieneEspecie = false;
        switch (s) {
            case STRING_ZONA:
                String nomZona;
                Double extZona;
                
                System.out.print("\nIngrese el nombre de la zona: ");
                nomZona = leerString();
                
                System.out.print("\nExtensión de la zona en m2: ");
                //USO LA VARIABLE tieneEspecie PARA NO CREAR OTRA, EL NOMBRE NO COINCIDE CON LA FUNCION QUE CUMPLE
                do {
                    if (tieneEspecie) {
                        System.err.println("Error: La extension no puede ser menor a 0.");
                    }
                    extZona = leerDouble();
                    tieneEspecie = true;
                } while (extZona < 0);
                
                
                System.out.print("\n¿Esta zona tiene especies? (s/n): ");
                tieneEspecie = leerBoolean();
                
                if (tieneEspecie){
                    ArrayList<Especie> e = pedirEspecies(sis);
                    Zona z = new Zona(nomZona,extZona,e);
                    sis.getZonas().add(z);
                }
                else { sis.getZonas().add(new Zona(nomZona,extZona)); }
                break;
                
            case STRING_HABITAT:
                String nom;
                Habitat h;
                Clima c;
                Vegetacion v;
                ArrayList<Continente> conts;
                ArrayList<Especie> esps;
                
                System.out.print("\nIngrese el nombre del habitat: ");
                nom = leerString();
                
                c = pedirClima();
                v = pedirVegetacion();
                conts = pedirContinentes();
                h = new Habitat(nom,c,v,conts);
                
                System.out.print("\n¿Hay especies en este habitat? (s/n): ");
                tieneEspecie = leerBoolean();
                if (tieneEspecie) {
                    esps = pedirEspecies(sis);
                
                    for (Especie esp : esps) {
                        esp.asignarHabitat(h);
                    }
                }
                
                sis.getHabitats().add(h);
                break;
                
            case STRING_INTINERARIO:
                String codigo;
                Duracion duracion;
                double longitud;
                int maxVisitas, numEspeciesVisita;
                
                codigo = pedirCodigoIntinerario();
                duracion = pedirDuracionIntinerario();
                longitud = pedirLongitudIntinerario();
                maxVisitas = pedirMaximoVisitas();
                numEspeciesVisita = pedirNumEspeciesVisita();
                
                Intinerario i = new Intinerario(codigo,duracion,longitud,maxVisitas,numEspeciesVisita);
                
                sis.getInts().add(i);
                
                break;
            default: System.err.println("Error al registrar, no es ni una zona ni un habitat ni un intinerario."); break;
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
                    else { System.err.println("Error: Esa zona no existe."); }
                }

                if (z != null) sis.eliminarZona(z);
                
                break;

            case STRING_HABITAT:
                String inhabilitarHabitat;
                Habitat h = null;

                while(true){
                    System.out.println("\n¿Qué habitats desea inhabilitar?");
                    sis.mostrarHabitats();
                    System.out.print("\nIngrese el nombre del habitat que desea elminiar (0 para salir): ");
                    inhabilitarHabitat = leerString();

                    if (inhabilitarHabitat.equals("0")) break;

                    h = sis.existeHabitat(inhabilitarHabitat);
                    
                    if (h != null) {
                        if (confirmarDecision()) {
                            break;
                        }
                    }
                    else{
                        System.err.println("Error: Ese habitat no existe.");
                    }
                }

                if (h != null) sis.eliminarHabitat(h);
                
                break;
                
            case STRING_INTINERARIO:
                String inhabilitarCod;
                Intinerario i = null;
                
                while(true){
                    System.out.println("\n¿Qué intinerario desea inhabilitar?");
                    sis.mostrarIntinerarios();
                    System.out.print("\nIngrese el codigo del intinerario que desea elminiar (0 para salir): ");
                    inhabilitarCod = leerString();

                    if (inhabilitarCod.equals("0")) break;

                    i = sis.existeIntinerario(inhabilitarCod);
                    
                    if (i != null) {
                        if (confirmarDecision()) {
                            break;
                        }
                    }
                }

                if (i != null) sis.eliminarIntinerario(i);
                
                break;
                
            default: System.err.println("Error al inhabilitar, no es ni una zona ni un habitat ni un intinerario."); break;
        }
    }

    private void asignarEspecieCuidador(Sistema s) {
        ArrayList<Especie> e;
        Cuidador c;
        
        e = pedirEspecies(s);
        if (e == null || e.isEmpty()) return;
        
        c = pedirCuidador(s);
        if (c == null) return;
        
        c.tomarEspecies(e);
    }

    private void removerEspecieCuidador(Sistema s) {
        Cuidador c;
        Especie e;
        String esp;
        boolean quitarOtra;
        
        do {
            c = pedirCuidador(s);

            if (c != null) {
                do {
                    c.mostrarEspeciesCuidadas();
                    System.out.print("\nIngrese el nombre cientifico de la especie que quiera remover (0 para salir): ");
                    esp = leerString();

                    e = s.existeEspecie(esp);

                    if (esp.equals("0")) break;

                    if (e != null) {
                        c.quitarEspecie(e);
                        e.quitarCuidador(c);
                    }
                    else{
                        System.err.println("Error: Esa especie no existe");
                    }
                    
                    System.out.print("\n¿Quiere remover otra especie de este cuidador? (s/n): ");
                    quitarOtra = leerBoolean();
                } while (quitarOtra);
                
                System.out.print("\n¿Quiere remover una especie de otro cuidador? (s/n): ");
                quitarOtra = leerBoolean();
            }
            else {
                break;
            }
        } while (quitarOtra);
        
    }

    private void asignarIntinerarioGuia(Sistema s) {
        Intinerario i;
        Guia g;
        
        i = pedirIntinerario(s);
        if (i == null) return;
        
        g = pedirGuia(s);
        if (g == null) return;

        g.tomarIntinerario(i);
    }

    private void removerIntinerarioGuia(Sistema s) {
        Guia g;
        Intinerario i;
        
        g = pedirGuia(s);
        if (g == null) return;
        if (g.getIntinerarios().isEmpty()){
            System.err.println("Error: Este guia no tiene intinerarios");
            return;
        }
        
        i = pedirIntinerario(s);
        if (i == null) return;
        
        g.quitarIntinerario(i);
        
    }
    
    private void listarXantiguedad(Sistema s) {
        //NUEVA LISTA PARA NO MODIFICAR LA EXISTENTE, SOLO PIDE MOSTRAR POR ANTIGUEDAD NO ORDENAR
        ArrayList<Empleado> e = s.getEmpleados();
        
        Collections.sort(e, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado e1, Empleado e2) {
                    return (e1.getFechaIngreso()).compareTo((e2.getFechaIngreso()));
            }
        });
        
        System.out.println("\n" + SEPARADOR_MEDIO + "Empleados" + SEPARADOR_MEDIO);
        for (Empleado e1 : e) {
            e1.mostrarDatos();
            System.out.println(SEPARADOR);
        }
    }
    
}
