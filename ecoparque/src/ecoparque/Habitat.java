
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
    
    public boolean coincideNombre(String nombre){
        return nom.equals(nombre);
    }
    
    /**
     *
     */
    public void mostrarDatos(){
        System.out.println("Nombre del habitat: " + nom);
        System.out.println("Clima actual del habitat: " + clima.toString());
        System.out.println("Tipo de vegetacóión del habitat: " + vegPredominante.toString());
        System.out.println("Este habitat se encuentra en " + (conts.size() > 1 ? "los continentes" : "el continente") + ":");
        for (Continente cont : conts) {
            System.out.println("\t" + cont.toString());
        }
    }
}
