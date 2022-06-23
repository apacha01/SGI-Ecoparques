
package ecoparque;

import clasesAuxiliares.Vegetacion;
import clasesAuxiliares.Continente;
import clasesAuxiliares.Clima;
import static clasesAuxiliares.Clima.toStringClima;
import static clasesAuxiliares.Continente.toStringContinente;
import static clasesAuxiliares.Vegetacion.toStringVegetacion;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Agustín Pacheco
 * Clase para los habitats del ecoparque.
 */
public class Habitat implements Serializable{
    
    private String nom;
    private Clima clima;
    private Vegetacion vegPredominante;
    private ArrayList<Continente> conts;

    /**
     *
     * @param nom
     * @param clima
     * @param vegPredominante
     * @param cont
     */
    public Habitat(String nom, Clima clima, Vegetacion vegPredominante, ArrayList<Continente> cont) {
        this.nom = nom;
        this.clima = clima;
        this.vegPredominante = vegPredominante;
        this.conts = cont;
    }
    
    /**
     *
     * @param nom
     * @param clima
     * @param vegPredominante
     * @param cont
     */
    public Habitat(String nom, Clima clima, Vegetacion vegPredominante, Continente cont) {
        this.nom = nom;
        this.clima = clima;
        this.vegPredominante = vegPredominante;
        conts = new ArrayList<>();
        conts.add(cont);
    }

    /**
     *
     * @param c
     */
    public void agregarContinente(Continente c){
        conts.add(c);
    }
    
    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public int getClima() {
        return clima.getClimaActual();
    }

    /**
     *
     * @return
     */
    public int getVegPredominante() {
        return vegPredominante.getVeg();
    }

    /**
     *
     * @return
     */
    public ArrayList<Continente> getConts() {
        return conts;
    }

    /**
     *
     * @param i
     * @return
     */
    public int getIthCont(int i){
        if (conts.isEmpty()) return 0;
        return conts.get(i).getContinente();
    }
    
    /**
     *
     */
    public void mostrarDatos(){
        System.out.println("Nombre del habitat: " + nom);
        System.out.println("Clima actual del habitat: " + toStringClima(clima.getClimaActual()));
        System.out.println("Tipo de vegetacóión del habitat: " + toStringVegetacion(vegPredominante.getVeg()));
        System.out.println("Este habitat se encuentra en " + (conts.size() > 1 ? "los continentes" : "el continente") + ":");
        for (Continente cont : conts) {
            System.out.println("\t" + toStringContinente(cont.getContinente()));
        }
    }
    
}
