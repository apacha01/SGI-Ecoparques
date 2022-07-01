
package clasesAuxiliares;

import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.InOut.*;
import java.io.Serializable;

/**
 *
 * @author Agustin Pacheco
 */
public class Continente implements Serializable{
    
    private int continente;

    /**
     *
     * @param continente
     */
    public Continente(int continente) {
        if(isContinente(continente)) this.continente = continente;
        else { printError("ese continente no existe"); }
    }
    
    /**
     *
     * @param i
     * @return
     */
    public boolean isContinente(int i){
        return (i == AMERICA || i == AFRICA || i == ASIA || i == ANTARTIDA || i == OCEANIA || i == EUROPA);
    }
    
    /**
     *
     * @param cont
     * @return
     */
    public static String toStringContinente(int cont){
        switch(cont){
            case AMERICA: return "America";
            case AFRICA: return "Africa";
            case ASIA: return "Asia";
            case ANTARTIDA: return "Antartida";
            case OCEANIA: return "Oceania";
            case EUROPA: return "Europa";
            default: return "Error: No es un continente.";
        }
    }
    
    @Override
    public String toString(){
        switch(continente){
            case AMERICA: return "America";
            case AFRICA: return "Africa";
            case ASIA: return "Asia";
            case ANTARTIDA: return "Antartida";
            case OCEANIA: return "Oceania";
            case EUROPA: return "Europa";
            default: return "Error: No es un continente.";
        }
    }
    
}
