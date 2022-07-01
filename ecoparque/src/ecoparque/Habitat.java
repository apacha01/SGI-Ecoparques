
package ecoparque;

import clasesAuxiliares.Vegetacion;
import clasesAuxiliares.Continente;
import clasesAuxiliares.Clima;
import static clasesAuxiliares.InOut.*;
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
        printLine("Nombre del habitat: " + nom);
        printLine("Clima actual del habitat: " + clima.toString());
        printLine("Tipo de vegetacóión del habitat: " + vegPredominante.toString());
        printLine("Este habitat se encuentra en " + (conts.size() > 1 ? "los continentes" : "el continente") + ":");
        for (Continente cont : conts) {
            printLine("\t" + cont.toString());
        }
    }
}
