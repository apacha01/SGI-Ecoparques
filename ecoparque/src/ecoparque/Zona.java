
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

    public Zona(String nombre, double extension) {
        this.nombre = nombre;
        this.extension = extension;
        especies = new ArrayList<>();
    }

    public Zona(String nombre, double extension, ArrayList<Especie> especies) {
        this.nombre = nombre;
        this.extension = extension;
        this.especies = especies;
        for (Especie esp : especies) {
            try {
                esp.getZona().quitarEspecie(esp);   //Quito la especie de la zona en la q estaba (ya que solo puede estar en 1)
            }catch(NullPointerException ex) {}      //Si no tiene zona, zona == null. Asiq trato la excepcion
            esp.asignarZona(this);                  //La agrego en la que acaban de ingresar
        }
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
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Agrega una especie a la zona
     * @param e especie a agregar en la lista de la zona
     */
    public void agregarEspecie(Especie e){
        especies.add(e);
    }
    
    public void quitarEspecie(Especie e){
        especies.remove(e);
    }
    
    /**
     * Get the value of especies
     *
     * @return the value of especies
     */
    public ArrayList<Especie> getEspecies(){
        return especies;
    }
    
    /**
     *  Muestra por consola las especies que estan en la zona
     */
    public void mostrarEspeciesEnZona(){
        for (Especie especie : especies) {
            especie.mostrarDatos();
        }
    }
    
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
}
