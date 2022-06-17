
package clasesAuxiliares;

import static clasesAuxiliares.Constantes.*;

/**
 *
 * @author Agustin Pacheco
 */
public class Continente {
    
    private int continente;

    public Continente(int continente) {
        if(isContinente(continente)) this.continente = continente;
        else { System.err.println("Error: ese continente no existe."); continente = 0; }
    }
    
    /**
     * Get the value of continente
     *
     * @return the value of continente
     */
    public int getContinente() {
        return continente;
    }

    /**
     * Set the value of continente
     *
     * @param continente new value of continente
     */
    public void setContinente(int continente) {
        this.continente = continente;
    }
    
    public boolean isContinente(int i){
        return (i == AMERICA || i == AFRICA || i == ASIA || i == ANTARTIDA || i == OCEANIA || i == EUROPA);
    }
    
    public static String toStringContinente(int cont){
        switch(cont){
            case AMERICA: return "America";
            case AFRICA: return "Africa";
            case ASIA: return "Asia";
            case ANTARTIDA: return "Antartida";
            case OCEANIA: return "Oceania";
            case EUROPA: return "Europa";
            default: return "";
        }
    }
    
}
