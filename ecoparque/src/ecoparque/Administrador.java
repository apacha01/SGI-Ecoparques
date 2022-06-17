
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.LecturaPorConsola.*;
import clasesAuxiliares.Clima;
import clasesAuxiliares.Vegetacion;
import clasesAuxiliares.Continente;
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
    public void mostrarDatos(){
        System.out.println("Tipo de usuario: ADMINISTRADOR");
        super.mostrarDatos();
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
        
        return true;
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
        int opc = -1;
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
                System.err.println("Ese empleado ya esta registrado en el sistema, no se puede repetir.");
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
            case -1: System.err.println("Error 1 al dar de alta empleado."); break;
            case 1:
                e = new Cuidador(_nomUsuario,_contra,_nombre,_direccion,_telefono, _fechaIngreso);
                break;
            case 2:
                e = new Guia(_nomUsuario,_contra,_nombre,_direccion,_telefono, _fechaIngreso);
                break;
            case 3: return; //NO DEBERIA SER NECESARIO
            default: System.err.println("Error 2 al dar de alta empleado."); break;
        }
        if (e != null) s.getEmpleados().add(e);
    }

    private void darBajaEmp(Sistema s) {
        //ASD hacer q no se pueda darBaja un ADMIN (o hacer q se pueda darAlta uno y SOLO DAR BAJA SI HAY AL MENOS 2)
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
                System.err.println("Ese nombre cientifico ya existe en el sistema, no se puede repetir.");
            }
            nomCient = pedirNombreCientificoEspecie();
            hay = true;
        } while (s.existeEspecie(nomCient) != null);
        
        desc = pedirDescripcion();
        
        cuidadores = pedirCuidadores(s);
        
        if (cuidadores.isEmpty()) {
            System.err.println("No se puede dar de alta una especie sin un empleado que la cuide.");
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
                    //ELIMINO LA ESPECIE DE LOS CUIDADORES QUE LA CUIDAN
                    for (Cuidador cuidador : e.getCuidadores()) {
                        cuidador.quitarEspecie(e);
                    }
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
                boolean tieneEspecie = false;
                
                System.out.print("\nIngrese el nombre de la zona: ");
                nomZona = leerString();
                
                System.out.print("\nExtensión de la zona en m2: ");
                //USO LA VARIABLE tieneEspecie PARA NO CREAR OTRA, EL NOMBRE NO COINCIDE CON LA FUNCION QUE CUMPLE
                do {
                    if (tieneEspecie) {
                        System.err.println("La extension no puede ser menor a 0.");
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
                    
                    //GUARDO EN LA ESPECIE LA ZONA EN LA QUE SE LA ESTA PONIENDO
                    for (Especie esp : e) {
                        try {
                            esp.getZona().quitarEspecie(esp);   //Quito la especie de la zona (ya que solo puede estar en 1)
                        }catch(NullPointerException ex) {}      //Si no tiene zona, zona == null. Asiq trato la excepcion
                        esp.asignarZona(z);                 //La agrego en la que acaban de ingresar
                    }
                }
                else { sis.getZonas().add(new Zona(nomZona,extZona)); }
                break;
            case STRING_HABITAT:
                System.out.print("\nIngrese el nombre del habitat: ");
                String nom = leerString();
                
                Clima c = pedirClima();
                
                Vegetacion v = pedirVegetacion();
                
                ArrayList<Continente> conts = pedirContinentes();
                
                sis.getHabitats().add(new Habitat(nom,c,v,conts));
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
                    else { System.err.println("Esa zona no existe."); }
                }

                if (z != null) {
                    //QUITO A LAS ESPECIES LA ZONA YA QUE SE INHABILITA
                    for (Especie especie : z.getEspecies()) {
                        especie.quitarZona();
                    }

                    sis.eliminarZona(z);
                }
                
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
                }

                sis.eliminarHabitat(h);
                
                break;
            default: System.err.println("Error al inhabilitar, no es ni una zona ni un habitat."); break;
        }
    }

    private void asignarEspecieCuidador(Sistema s) {
        ArrayList<Especie> e;
        Cuidador c;
        
        while(true){
            e = pedirEspecies(s);
            if (e != null && e.isEmpty()) {
                c = pedirCuidador(s);
                if (c != null) {
                    c.tomarEspecies(e);
                    break;
                }
            }
        }
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
        
    }

    private void removerIntinerarioGuia(Sistema s) {
        
    }
    
    private void listarXantiguedad(Sistema s) {
        
    }
    
}
