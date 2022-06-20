
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Agustín Pacheco
 */
public class Guia extends Empleado{
    
    private ArrayList<Intinerario> intinerarios;
    private ArrayList<Date> intinerarioAsignado;

    public Guia(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(usuario, contra, nombre, direccion, telefono, fechaIngreso);
        intinerarios = new ArrayList<>();
    }

    public ArrayList<Intinerario> getIntinerarios() {
        return intinerarios;
    }
    
    public void tomarIntinerario(Intinerario i){
        if (i.isOcupado()) {
            System.err.println("Error: Este intinerario ya lo tiene otro guia.");
        }
        else{
            i.setOcupado(true);
            intinerarios.add(i);
            intinerarioAsignado.add(new Date());
        }
    }
    
    public void quitarIntinerario(Intinerario i){
        if (i != null){
            int index = intinerarios.indexOf(i);
            
            i.setOcupado(false);
            
            intinerarios.remove(index);
            intinerarioAsignado.remove(index);
        }
    }
    
    @Override
    public void printMenu(){
        System.out.println("\n" + SEPARADOR_MEDIO + "MENU DE GUIA" + SEPARADOR_MEDIO);
        super.printMenu();
    }
    
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
    
    @Override
    public void consultarDatos(Sistema s){
        
    }

    @Override
    public boolean ingresar(Sistema s) {
        printMenu();
        return false;
    }
}
