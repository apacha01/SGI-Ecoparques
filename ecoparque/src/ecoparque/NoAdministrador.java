
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.InOut.leerInt;
import static clasesAuxiliares.InOut.*;
import java.util.Date;

/**
 *
 * @author Agustin Pacheco
 */
public abstract class NoAdministrador extends Empleado {

    /**
     *
     * @param usuario
     * @param contra
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechaIngreso
     */
    public NoAdministrador(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso){
        super(usuario, contra, nombre, direccion, telefono, fechaIngreso);
    }

    /**
     *
     */
    @Override
    public void printMenu(){
        super.printMenu();
    }
    
    /**
     *
     */
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
    }
    
    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean ingresar(Sistema s){
        boolean seguir = true;
        int opc;
        
        while(seguir){
            this.printMenu();
            opc = leerInt(CANT_OPC_MENU_NO_ADMIN);
            seguir = procesarOpcion(opc, s);
        }
        
        return true;
    }
    
    
    private boolean procesarOpcion(int op, Sistema s){
        boolean seguir = true;
        switch(op){
            case Integer.MIN_VALUE: printError("Ocurrió un error al elegir la opción del menu."); break;
            case SALIR_MENU: seguir = false; break;
            case CONSULTAR_DATOS: consultarDatos(s); break;
            default: break;
        }
        
        return seguir;
    }
    
    /**
     *
     * @param s
     */
    @Override
    public abstract void consultarDatos(Sistema s);
}
