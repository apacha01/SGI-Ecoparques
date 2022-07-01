
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.InOut.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Agustín Pacheco
 */
public abstract class Empleado implements Serializable{
    private String usuario;
    private String contra;
    private String nombre;
    private String direccion;
    private String telefono;
    private Date fechaIngreso;

    /**
     *
     * @param usuario
     * @param contra
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechaIngreso
     */
    public Empleado(String usuario, String contra, String nombre, String direccion, String telefono, Date fechaIngreso) {
        this.usuario = usuario;
        this.contra = contra;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    
    public boolean coincideUsuario(String usuario){
        return this.usuario.equals(usuario);
    }
    
    public boolean coincideContra(String contra){
        return this.contra.equals(contra);
    }
    /**
     *
     */
    public void printMenu(){
        printLine(SALIR_MENU + ". Salir");
        printLine(CONSULTAR_DATOS +  ". Consultar Datos");
    }
    
    /**
     *
     */
    public void mostrarDatos(){
        printLine("Nombre de Usuario: " + usuario);
        printLine("Contraseña: " + contra);
        printLine("Nombre Completo: " + nombre);
        printLine("Dirección: " + direccion);
        printLine("Telefono: " + telefono);
        printLine("Fecha de Ingreso al Sistema: " + fechaIngreso);
    }
    
    /**
     *
     * @param s
     */
    public abstract void consultarDatos(Sistema s);
    
    /**
     *
     * @param s
     * @return
     */
    public abstract boolean ingresar(Sistema s);
    
    /**
     *
     */
    public abstract void eliminarme();
}
