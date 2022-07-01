
package clasesAuxiliares;

import static clasesAuxiliares.Constantes.*;
import java.io.Serializable;

/**
 *
 * @author agust
 */
public class Clima implements Serializable{    
    private int climaActual;

    /**
     *
     * @param climaActual
     */
    public Clima(int climaActual){
        if(isClima(climaActual)) this.climaActual = climaActual;
        else { System.err.println("Error: ese clima no existe."); climaActual = 0; }
    }
    
    /**
     *
     * @param i
     * @return
     */
    public boolean isClima(int i){
        return (i == SOLEADO || i == NUBLADO || i == LLUVIA || i == TORMENTA || i == TEMPLADO);
    }
    
    /**
     * Get the value of climaActual
     *
     * @return the value of climaActual
     */
    public int getClimaActual() {
        return climaActual;
    }
    
    /**
     *
     * @param clima
     * @return
     */
    public static String toStringClima(int clima){
        switch(clima){
            case SOLEADO: return "Soleado";
            case NUBLADO: return "Nublado";
            case LLUVIA: return "Lluvia";
            case TORMENTA: return "Tormenta";
            case TEMPLADO: return "Templado";
            default: return "";
        }
    }
    
    @Override
    public String toString(){
        switch(climaActual){
            case SOLEADO: return "Soleado";
            case NUBLADO: return "Nublado";
            case LLUVIA: return "Lluvia";
            case TORMENTA: return "Tormenta";
            case TEMPLADO: return "Templado";
            default: return "";
        }
    }

}
