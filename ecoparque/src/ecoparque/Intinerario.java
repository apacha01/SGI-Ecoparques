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

    public Intinerario(String codigo, Duracion duracion, double longitud, int maxVisitantes, int numEspeciesVisita) {
        this.codigo = codigo;
        this.duracion = duracion;
        this.longitud = longitud;
        this.maxVisitantes = maxVisitantes;
        this.numEspeciesVisita = numEspeciesVisita;
        ocupado = false;
    }
    
    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    /**
     * Get the value of numEspeciesVisita
     *
     * @return the value of numEspeciesVisita
     */
    public int getNumEspeciesVisita() {
        return numEspeciesVisita;
    }


    /**
     * Get the value of maxVisitantes
     *
     * @return the value of maxVisitantes
     */
    public int getMaxVisitantes() {
        return maxVisitantes;
    }


    /**
     * Get the value of longitud
     *
     * @return the value of longitud
     */
    public double getLongitud() {
        return longitud;
    }


    /**
     * Get the value of duracion
     *
     * @return the value of duracion
     */
    public Duracion getDuracion() {
        return duracion;
    }
    
    /**
     * Get the value of codigo
     *
     * @return the value of codigo
     */
    public String getCodigo() {
        return codigo;
    }
    
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
