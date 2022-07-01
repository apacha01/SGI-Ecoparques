
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.InOut.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Agustín Pacheco
 */
public class Guia extends NoAdministrador {
    
    private ArrayList<Intinerario> intinerarios;
    private ArrayList<Date> intinerarioAsignado;

    /**
     *
     * @param usuario
     * @param contra
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechaIngreso
     */
    public Guia(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(usuario, contra, nombre, direccion, telefono, fechaIngreso);
        intinerarioAsignado = new ArrayList<>();
        intinerarios = new ArrayList<>();
    }
    
    public boolean tieneIntinerarios(){
        return intinerarios.isEmpty();
    }
    
    /**
     *
     * @param i
     */
    public void tomarIntinerario(Intinerario i){
        if (i.isOcupado()) {
            if (intinerarios.contains(i)) {
                printError("Este intinerario ya esta en posesion de " + this.getNombre());
            }
            else{
                printError("Este intinerario ya lo tiene otro guia");
            }
        }
        else{
            i.setOcupado(true);
            intinerarios.add(i);
            intinerarioAsignado.add(new Date());
        }
    }
    
    /**
     *
     * @param i
     */
    public void quitarIntinerario(Intinerario i){
        if (i != null){
            int index = intinerarios.indexOf(i);
            
            if (index != -1) {
                i.setOcupado(false);
                intinerarios.remove(index);
                intinerarioAsignado.remove(index);
            }
            else{
                printError("El guia " + getNombre() + " no tiene un intinerario con el codigo " + i.getCodigo());
            }
        }
    }
    
    public boolean tieneIntinerario(Intinerario i){
        return intinerarios.contains(i);
    }
    
    /**
     *
     */
    @Override
    public void printMenu(){
        printLine("\n" + SEPARADOR_MEDIO + "MENU DE GUIA" + SEPARADOR_MEDIO);
        super.printMenu();
    }
    
    /**
     *
     */
    @Override
    public void mostrarDatos(){
        printLine("Tipo de usuario: GUIA");
        super.mostrarDatos();
        if (!intinerarios.isEmpty()) {
            printLine("Intinerarios que posee:");
            for (int i = 0; i < intinerarios.size(); i++) {
            printLine("\t" + intinerarios.get(i).getCodigo() + " (Fecha en la que tomo este intinerario: " + 
                    intinerarioAsignado.get(i) + ")");
            }
        }
    }

    /**
     *
     * @param s
     */
    @Override
    public void consultarDatos(Sistema s) {
        printLine(SEPARADOR_MEDIO + "MIS DATOS" + SEPARADOR_MEDIO);
        mostrarDatos();
        printLine(SEPARADOR);
    }

    @Override
    public void eliminarme() {
        intinerarios.clear();
    }
    
}
