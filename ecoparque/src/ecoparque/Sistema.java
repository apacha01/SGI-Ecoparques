
package ecoparque;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Agustín Pacheco
 */
public class Sistema implements Serializable {
    private ArrayList<Empleado> empleados;
    private ArrayList<Especie> especies;
    private ArrayList<Habitat> habitats;
    //private ArrayList<Zona> zonas;
    
    public Sistema() {
        empleados = new ArrayList<>();
        especies = new ArrayList<>();
        habitats = new ArrayList<>();
        //zonas = new ArrayList<>();
    }
    
    /**
     *
     * @return empeleados
     * Devuelve el arraylist de empleados en el sistema
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     *
     * @param empleados arraylist de empleados que se quiere cargar
     */
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     *
     * @return array list de especies en el sistema
     */
    public ArrayList<Especie> getEspecies() {
        return especies;
    }

    /**
     *
     * @param especies arrarlist para setear las especies del sistema
     */
    public void setEspecies(ArrayList<Especie> especies) {
        this.especies = especies;
    }

    public ArrayList<Habitat> getHabitats() {
        return habitats;
    }

    public void setHabitats(ArrayList<Habitat> habitats) {
        this.habitats = habitats;
    }
    
    /**
     *
     * @param nomUsuario nombre de usuario del que intenta ingresar
     * @param contra contraseña del usuario que intenta ingresar
     * @return el empleado si emcontro, null si no esta.
     */
    public Empleado existeEmpleado(String nomUsuario, String contra){
        for (Empleado emp: empleados) {
            if (emp.getUsuario().equals(nomUsuario) && emp.getContra().equals(contra)){
                return emp;
            }
        }
        return null;
    }
    
    /**
    *  @param a es el nombre del archivo del que se deserializa 
     * @return sistema que deserializo del archivo
    */
    public Sistema deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema s = (Sistema) o.readObject();
        o.close();
        f.close();
        return s;
    }

    /**
    *  @param a es el nombre del archivo en el que se serializa 
    */
    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }
}
