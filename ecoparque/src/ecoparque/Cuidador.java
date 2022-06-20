
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

    public ArrayList<Especie> getEspeciesCuidadas() {
        return especiesCuidadas;
    }
    
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
    
    public void tomarEspecie(Especie e){
        if (!especiesCuidadas.contains(e)) {
            especiesCuidadas.add(e);
            tomaEspecie.add(new Date());
        }
        else{
            System.err.println("Error: Este cuidador ya cuida la especie " + e.getNomEspecie());
        }
    }
    
    public void quitarEspecie(Especie e){
        int index = especiesCuidadas.indexOf(e);
        
        if (index != -1) {
            e.quitarCuidador(this);
            especiesCuidadas.remove(index);
            tomaEspecie.remove(index);
        }
    }
    
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
    
    public void mostrarEspeciesCuidadas(){
        System.out.println("Especies del cuidador " + this.getNombre());
        for (Especie especieCuidada : especiesCuidadas) {
            System.out.println("\t" + especieCuidada.getNomCientifico());
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
