
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.InOut.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Agustín Pacheco
 */

public class Cuidador extends NoAdministrador{
    
    private ArrayList<Date> tomaEspecie;
    private ArrayList<Especie> especiesCuidadas;

    /**
     *
     * @param usuario
     * @param contra
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechaIngreso
     */
    public Cuidador(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(usuario, contra, nombre, direccion, telefono, fechaIngreso);
        tomaEspecie = new ArrayList<>();
        especiesCuidadas = new ArrayList<>();
    }
    
    @Override
    public void eliminarme(){
        for (Especie especieCuidada : especiesCuidadas) {
            especieCuidada.quitarCuidador(this);
        }
    }
    
    /**
     *
     */
    @Override
    public void mostrarDatos(){
        printLine("Tipo de usuario: CUIDADOR");
        super.mostrarDatos();
        if (!especiesCuidadas.isEmpty()) {
            printLine("Especies que cuida:");
            for (int i = 0; i < especiesCuidadas.size(); i++) {
                printLine("\t" + especiesCuidadas.get(i).getNomEspecie() + " (Fecha en la que tomo esta especie: " + 
                        tomaEspecie.get(i) + ")");
            }
        }
    }
    
    /**
     *
     * @param e
     */
    public void tomarEspecie(Especie e){
        if (!especiesCuidadas.contains(e)) {
            especiesCuidadas.add(e);
            tomaEspecie.add(new Date());
        }
        else{
            printError("Este cuidador ya cuida la especie " + e.getNomEspecie() + " (" + e.getNomCientifico() + ")");
        }
    }
    
    /**
     *
     * @param e
     */
    public void quitarEspecie(Especie e){
        int index = especiesCuidadas.indexOf(e);
        
        if (index != -1) {
            especiesCuidadas.remove(index);
            tomaEspecie.remove(index);
        }
    }
    
    /**
     *
     * @param es
     */
    public void tomarEspecies(ArrayList<Especie> es){
        for (int i = 0; i < es.size(); i++) {
            
            if (!especiesCuidadas.contains(es.get(i))) {
                es.get(i).agregarCuidador(this);
                especiesCuidadas.add(es.get(i));
                tomaEspecie.add(new Date());
            }
            else{
                printError("Este cuidador ya cuida la especie " + es.get(i).getNomEspecie());
            }
        }
    }
    
    /**
     *
     */
    public void mostrarEspeciesCuidadas(){
        printLine("Especies del cuidador " + this.getNombre());
        for (Especie especieCuidada : especiesCuidadas) {
            printLine("\t" + especieCuidada.getNomCientifico());
        }
    }
    
    /**
     *
     */
    @Override
    public void printMenu(){
        printLine("\n" + SEPARADOR_MEDIO + "MENU DE CUIDADOR" + SEPARADOR_MEDIO);
        super.printMenu();
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
}
