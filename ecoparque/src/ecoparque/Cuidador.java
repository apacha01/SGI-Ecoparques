
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Agustín Pacheco
 */

public class Cuidador extends Empleado{
    
    private ArrayList<Date> tomaEspecie;
    private ArrayList<Especie> especiesCuidadas;

    public Cuidador(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(usuario, contra, nombre, direccion, telefono, fechaIngreso);
        tomaEspecie = new ArrayList<>();
        especiesCuidadas = new ArrayList<>();
    }
    
    @Override
    public void mostrarDatos(){
        System.out.println("Tipo de usuario: CUIDADOR");
        super.mostrarDatos();
        System.out.println("Especies que cuida:");
        for (int i = 0; i < especiesCuidadas.size(); i++) {
            System.out.println("\t" + especiesCuidadas.get(i).getNomEspecie() + "(fecha en la que tomo esta especie: " + 
                    tomaEspecie.get(i) + ")");
        }
    }
    
    public void tomarEspecie(Especie e){
        especiesCuidadas.add(e);
        tomaEspecie.add(new Date());
    }
    
    public void quitarEspecie(Especie e){
        int index = especiesCuidadas.indexOf(e);
        
        especiesCuidadas.remove(index);
        tomaEspecie.remove(index);
    }
    
    public void tomarEspecies(ArrayList<Especie> es){
        especiesCuidadas = es;
        for (int i = 0; i < es.size(); i++) {
            tomaEspecie.add(new Date());
        }
    }
    
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
