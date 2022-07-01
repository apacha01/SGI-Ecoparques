
package ecoparque;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Agustín Pacheco
 */
public class Zona implements Serializable{
    
    private String nombre;
    private double extension;
    private ArrayList<Especie> especies;

    /**
     *
     * @param nombre
     * @param extension
     */
    public Zona(String nombre, double extension) {
        this.nombre = nombre;
        this.extension = extension;
        especies = new ArrayList<>();
    }

    /**
     *
     * @param nombre
     * @param extension
     * @param especies
     */
    public Zona(String nombre, double extension, ArrayList<Especie> especies) {
        this.nombre = nombre;
        this.extension = extension;
        this.especies = especies;
        for (Especie esp : especies) {
            esp.asignarZona(this);                  //La agrego en la que acaban de ingresar
        }
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    public boolean coincideNombre(String nom){
        return nombre.equalsIgnoreCase(nom);
    }
    
    /**
     * Agrega una especie a la zona
     * @param e especie a agregar en la lista de la zona
     */
    public void agregarEspecie(Especie e){
        especies.add(e);
    }
    
    /**
     *
     * @param e
     */
    public void quitarEspecie(Especie e){
        especies.remove(e);
    }
    
    /**
     *  Muestra por consola las especies que estan en la zona
     */
    public void mostrarEspeciesEnZona(){
        for (Especie especie : especies) {
            especie.mostrarDatos();
        }
    }
    
    /**
     *
     */
    public void mostrarDatos(){
        System.out.println("Nombre de la Zona: " + nombre);
        System.out.println("Extensión de la Zona: " + extension + " m2");
        if (!especies.isEmpty()) {
            System.out.println("Esta zona esta habitada por las siguientes especies:");
            for (Especie especie : especies) {
                System.out.println("\t" + especie.getNomEspecie() + " (" + especie.getNomCientifico() + ")");
            }
        }
    }
    
    public void eliminarme(){
        for (Especie especie : especies) {
            especie.quitarZona();
        }
    }
}
