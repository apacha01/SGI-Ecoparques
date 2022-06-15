
package ecoparque;

import java.io.Serializable;

/**
 *
 * @author Agustín Pacheco
 */
public class Zona implements Serializable{
    
    private String nombre;
    private double extension;

    public Zona(String nombre, double extension) {
        this.nombre = nombre;
        this.extension = extension;
    }

    /**
     * Get the value of extension
     *
     * @return the value of extension
     */
    public double getExtension() {
        return extension;
    }

    /**
     * Set the value of extension
     *
     * @param extension new value of extension
     */
    public void setExtension(double extension) {
        this.extension = extension;
    }

    /**
     * Get the value of nomrbre
     *
     * @return the value of nomrbre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nomrbre
     *
     * @param nombre new value of nomrbre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
