
package ecoparque;

import static clasesAuxiliares.Constantes.*;
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
        System.out.println("Tipo de usuario: CUIDADOR");
        super.mostrarDatos();
        if (!especiesCuidadas.isEmpty()) {
            System.out.println("Especies que cuida:");
            for (int i = 0; i < especiesCuidadas.size(); i++) {
                System.out.println("\t" + especiesCuidadas.get(i).getNomEspecie() + " (Fecha en la que tomo esta especie: " + 
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
            System.err.println("Error: Este cuidador ya cuida la especie " + e.getNomEspecie() + " (" + e.getNomCientifico() + ")");
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
                System.err.println("Error: Este cuidador ya cuida la especie " + es.get(i).getNomEspecie());
            }
        }
    }
    
    /**
     *
     */
    public void mostrarEspeciesCuidadas(){
        System.out.println("Especies del cuidador " + this.getNombre());
        for (Especie especieCuidada : especiesCuidadas) {
            System.out.println("\t" + especieCuidada.getNomCientifico());
        }
    }
    
    /**
     *
     */
    @Override
    public void printMenu(){
        System.out.println("\n" + SEPARADOR_MEDIO + "MENU DE CUIDADOR" + SEPARADOR_MEDIO);
        super.printMenu();
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
