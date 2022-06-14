
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Agustín Pacheco
 */
public class Especie implements Serializable{
    private String nomEspecie;
    private String nomCientifico;
    private String descripcion;
    private ArrayList<Cuidador> cuidadores;
    //private ArrayList<Habitat> habitats;
    //private Zona zona;

    public Especie(String nomEspecie, String nomCientifico, String descripcion, ArrayList<Cuidador> cuidadores) {
        this.nomEspecie = nomEspecie;
        this.nomCientifico = nomCientifico;
        this.descripcion = descripcion;
        this.cuidadores = cuidadores;
    }
    
    /**
     *
     * @param c Cuidador a agregar que cuida la especie
     */
    public void agregarCuidador(Cuidador c){
        if(c != null) cuidadores.add(c);
    }
    
    /**
     * Muestra los datos de una especie
     */
    public void mostrarDatos() {
        System.out.println("Nombre de la Especie: " + nomEspecie);
        System.out.println("Nombre Científico: " + nomCientifico);
        System.out.println("Descripción:\n\t" + descripcion);
        System.out.println("Esta especie es cuidada por:");
        for (int i = 0; i < cuidadores.size(); i++) {
            System.out.println("\t" + cuidadores.get(i).getNombre());
        }
        System.out.println(SEPARADOR);
    }

    public String getNomCientifico() {
        return nomCientifico;
    }
    
}
