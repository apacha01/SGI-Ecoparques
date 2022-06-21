
package clasesAuxiliares;

/**
 *
 * @author Agustin Pacheco
 */
public class Duracion {
    private int hora;
    private int minutos;
    private int segundos;

    public Duracion(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
        segundos = 0;
    }

    public Duracion(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    
    public String toStringDuracion(){
        return hora + (hora == 1 ? "h" : "hs") + " " + minutos + (minutos == 1 ? "min" : "mins");
    }
    
    public String toStringDuracionSeg(){
        return hora + (hora == 1 ? "h" : "hs") + " " + minutos + (minutos == 1 ? "min" : "mins") + " " +
                segundos + (segundos == 1 ? "seg" : "segs");
    }
}
