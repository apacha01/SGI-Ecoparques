
package ecoparque;

import static clasesAuxiliares.Constantes.*;
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

    /**
     *
     * @return
     */
    public ArrayList<Intinerario> getIntinerarios() {
        return intinerarios;
    }
    
    /**
     *
     * @param i
     */
    public void tomarIntinerario(Intinerario i){
        if (i.isOcupado()) {
            if (intinerarios.contains(i)) {
                System.err.println("Error: Este intinerario ya esta en posesion de " + this.getNombre());
            }
            else{
                System.err.println("Error: Este intinerario ya lo tiene otro guia.");
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
                System.err.println("Error: El guia " + getNombre() + " no tiene un intinerario con el codigo " + i.getCodigo());
            }
        }
    }
    
    /**
     *
     */
    @Override
    public void printMenu(){
        System.out.println("\n" + SEPARADOR_MEDIO + "MENU DE GUIA" + SEPARADOR_MEDIO);
        super.printMenu();
    }
    
    /**
     *
     */
    @Override
    public void mostrarDatos(){
        System.out.println("Tipo de usuario: GUIA");
        super.mostrarDatos();
        if (!intinerarios.isEmpty()) {
            System.out.println("Intinerarios que posee:");
            for (int i = 0; i < intinerarios.size(); i++) {
            System.out.println("\t" + intinerarios.get(i).getCodigo() + " (Fecha en la que tomo este intinerario: " + 
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
        System.out.println(SEPARADOR_MEDIO + "MIS DATOS" + SEPARADOR_MEDIO);
        mostrarDatos();
        System.out.println(SEPARADOR);
    }
    
}
