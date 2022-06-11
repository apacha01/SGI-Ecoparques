
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import java.util.ArrayList;

/**
 *
 * @author Agustín Pacheco
 */
public class Especie {
    private String nomEspecie;
    private String nomCientifico;
    private String descripcion;
    private ArrayList<Empleado> cuidadores;
    //private ArrayList<Habitat> habitats;

    public Especie(String nomEspecie, String nomCientifico, String descripcion, ArrayList<Empleado> cuidadores) {
        this.nomEspecie = nomEspecie;
        this.nomCientifico = nomCientifico;
        this.descripcion = descripcion;
        this.cuidadores = cuidadores;
    }
    
    public void mostrarDatos() {
        System.out.println(SEPARADOR);
        System.out.println("Nombre de la Especie: " + nomEspecie);
        System.out.println("Nombre Científico: " + nomCientifico);
        System.out.println("\n" + descripcion);
        System.out.println("Esta especie es cuidada por:\n");
        for (int i = 0; i < cuidadores.size(); i++) {
            System.out.println(cuidadores.get(i).getNombre());
            if (i != cuidadores.size()-2) System.out.println(" - ");
        }
    }
    
    
}
