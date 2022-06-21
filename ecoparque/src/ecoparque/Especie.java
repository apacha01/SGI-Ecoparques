
package ecoparque;

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
    private ArrayList<Habitat> habitats;
    private Zona zona;

    public Especie(String nomEspecie, String nomCientifico, String descripcion, ArrayList<Cuidador> cuidadores) {
        this.nomEspecie = nomEspecie;
        this.nomCientifico = nomCientifico;
        this.descripcion = descripcion;
        this.cuidadores = cuidadores;
        habitats = new ArrayList<>();
        zona = null;
    }
    
    /**
     *
     * @param c Cuidador a agregar que cuida la especie
     */
    public void agregarCuidador(Cuidador c){
        if(c != null && !cuidadores.contains(c)) cuidadores.add(c);
    }
    
    public void quitarCuidador(Cuidador c){
        cuidadores.remove(c);
    }
    
    /**
     *
     * @param z Zona donde esta la especie
     */
    public void asignarZona(Zona z){
        zona = z;
    }
    
    public void quitarZona(){
        zona = null;
    }
    
    public void asignarHabitat(Habitat h){
        habitats.add(h);
    }
    
    public void asignarHabitats(ArrayList<Habitat> h){
        habitats = h;
    }
    
    /**
     * Muestra los datos de una especie
     */
    public void mostrarDatos() {
        System.out.println("Nombre de la Especie: " + nomEspecie);
        System.out.println("Nombre Científico: " + nomCientifico);
        System.out.println("Descripción:\n\t" + descripcion);
        if (!cuidadores.isEmpty()) {
            System.out.println("Esta especie es cuidada por:");
            for (int i = 0; i < cuidadores.size(); i++) {
                System.out.println("\t" + cuidadores.get(i).getNombre());
            }
        }
        if (!habitats.isEmpty()) {
            System.out.println("Esta especie se encuentra en " + (habitats.size() > 1 ? "los habitats" : "el habitat") + ":");
            for (int i = 0; i < habitats.size(); i++) {
                System.out.println("\t" + habitats.get(i).getNom());
            }
        }
        if(zona != null) System.out.println("Zona en la que se encuentra la especie: " + zona.getNombre());
    }

    public String getNomEspecie() {
        return nomEspecie;
    }
    
    public String getNomCientifico() {
        return nomCientifico;
    }

    public Zona getZona() {
        return zona;
    }
    
    public ArrayList<Cuidador> getCuidadores() {
        return cuidadores;
    }
}
