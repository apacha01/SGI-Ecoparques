/*
 * código de itinerario, la duración del recorrido, la longitud del itinerario, el máximo 
 *  número de visitantes autorizado y el número de distintas especies que visita.
 */
package ecoparque;

import clasesAuxiliares.Duracion;
import java.io.Serializable;

/**
 *
 * @author Agustin Pacheco
 */
public class Intinerario implements Serializable{
    
    private String codigo;
    private Duracion duracion;
    private double longitud;
    private int maxVisitantes;
    private int numEspeciesVisita;
    private boolean ocupado;

    /**
     *
     * @param codigo
     * @param duracion
     * @param longitud
     * @param maxVisitantes
     * @param numEspeciesVisita
     */
    public Intinerario(String codigo, Duracion duracion, double longitud, int maxVisitantes, int numEspeciesVisita) {
        this.codigo = codigo;
        this.duracion = duracion;
        this.longitud = longitud;
        this.maxVisitantes = maxVisitantes;
        this.numEspeciesVisita = numEspeciesVisita;
        ocupado = false;
    }
    
    /**
     *
     * @return
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     *
     * @param ocupado
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    /**
     * Get the value of codigo
     *
     * @return the value of codigo
     */
    public String getCodigo() {
        return codigo;
    }
    
    public boolean coincideCodigo(String cod){
        return codigo.equals(cod);
    }
    
    /**
     *
     */
    public void mostrarDatos(){
        System.out.println("Codigo del intinerario: " + codigo);
        System.out.println("Duracion del intinerario: " + duracion.toStringDuracion());
        System.out.println("Longitud del intinerario: " + longitud + " m");
        System.out.println("Numero maximo de visitantes del intinerario: " + maxVisitantes);
        System.out.println("Cantidad de especies que visita el intinerario: " + numEspeciesVisita);
        System.out.println("¿Se puede hacer este recorrido en este momento? " + 
                (ocupado ? "Si" : "No, en este momento ningun guia realiza este recorrido"));
    }
    
}
