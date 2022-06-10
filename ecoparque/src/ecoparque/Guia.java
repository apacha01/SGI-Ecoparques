
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Agustín Pacheco
 */
public class Guia extends Empleado{
    
    //private ArrayList<Intinerario> intinerarios;
    private Date intinerarioAsignado;

    public Guia(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(usuario, contra, nombre, direccion, telefono, fechaIngreso);
        //intinerarios = new ArrayList<>();
    }
    
    @Override
    public void printMenu(){
        System.out.println("\n" + SEPARADOR_MEDIO + "MENU DE GUIA" + SEPARADOR_MEDIO);
        super.printMenu();
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
