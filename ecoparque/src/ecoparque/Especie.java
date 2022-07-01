
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

    /**
     *
     * @param nomEspecie
     * @param nomCientifico
     * @param descripcion
     * @param cuidadores
     */
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
    
    /**
     *
     * @param c
     */
    public void quitarCuidador(Cuidador c){
        cuidadores.remove(c);
    }
    
    /**
     *
     * @param z Zona donde esta la especie
     */
    public void asignarZona(Zona z){
        if (zona != null) zona.quitarEspecie(this);
        zona = z;
    }
    
    /**
     *
     */
    public void quitarZona(){
        zona = null;
    }
    
    /**
     *
     * @param h
     */
    public void asignarHabitat(Habitat h){
        habitats.add(h);
    }
    
    public void quitarHabitat(Habitat h){
        habitats.remove(h);
    }
    
    /**
     *
     * @param h
     */
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

    /**
     *
     * @return
     */
    public String getNomEspecie() {
        return nomEspecie;
    }
    
    /**
     *
     * @return
     */
    public String getNomCientifico() {
        return nomCientifico;
    }
    
    public boolean coincideNomCientifico(String nomCientifico){
        return this.nomCientifico.equals(nomCientifico);
    }
    
    public void eliminarme(){
        for (Cuidador cuidador : cuidadores) {
            cuidador.quitarEspecie(this);
        }
        if (zona != null) zona.quitarEspecie(this);
    }
}
