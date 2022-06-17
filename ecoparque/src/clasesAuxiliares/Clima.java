
package clasesAuxiliares;

import static clasesAuxiliares.Constantes.*;

/**
 *
 * @author agust
 */
public class Clima {    
    private int climaActual;

    public Clima(int climaActual){
        if(isClima(climaActual)) this.climaActual = climaActual;
        else { System.err.println("Error: ese clima no existe."); climaActual = 0; }
    }
    
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
     * Set the value of climaActual
     *
     * @param climaActual new value of climaActual
     */
    public void setClimaActual(int climaActual) {
        this.climaActual = climaActual;
    }
    
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

}
