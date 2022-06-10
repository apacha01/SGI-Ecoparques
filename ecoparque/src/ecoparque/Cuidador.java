
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Agustín Pacheco
 */

public class Cuidador extends Empleado{
    
    private Date tomaEspecie;
    private ArrayList<Especie> especiesCuidadas;

    public Cuidador(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(usuario, contra, nombre, direccion, telefono, fechaIngreso);
    }
    
    //HACER FUNCION TOMAR ESPECIE
    
    @Override
    public boolean ingresar(Sistema s) {
        printMenu();
        return false;
    }
    
    @Override
    public void printMenu(){
        System.out.println("\n" + SEPARADOR_MEDIO + "MENU DE CUIDADOR" + SEPARADOR_MEDIO);
        super.printMenu();
    }
    
    @Override
    public void consultarDatos(Sistema s){
        
    }
}
