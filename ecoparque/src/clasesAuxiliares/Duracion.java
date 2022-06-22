
package clasesAuxiliares;

import java.io.Serializable;

/**
 *
 * @author Agustin Pacheco
 */
public class Duracion implements Serializable{
    private int hora;
    private int minutos;
    private int segundos;

    /**
     *
     * @param hora
     * @param minutos
     */
    public Duracion(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
        segundos = 0;
    }

    /**
     *
     * @param hora
     * @param minutos
     * @param segundos
     */
    public Duracion(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    
    /**
     *
     * @return
     */
    public String toStringDuracion(){
        return (hora == 0 ? "" : hora + (hora == 1 ? "h" : "hs")) + " " + (minutos == 0 ? "" : minutos + (minutos == 1 ? "min" : "mins"));
    }
    
    /**
     *
     * @return
     */
    public String toStringDuracionSeg(){
        return hora + (hora == 1 ? "h" : "hs") + " " + minutos + (minutos == 1 ? "min" : "mins") + " " +
                segundos + (segundos == 1 ? "seg" : "segs");
    }
}
