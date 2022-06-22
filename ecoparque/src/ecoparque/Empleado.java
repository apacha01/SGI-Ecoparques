
package ecoparque;

import static clasesAuxiliares.Constantes.*;
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
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @return
     */
    public String getContra() {
        return contra;
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
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @return
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    
    /**
     *
     */
    public void printMenu(){
        System.out.println(SALIR_MENU + ". Salir");
        System.out.println(CONSULTAR_DATOS +  ". Consultar Datos");
    }
    
    /**
     *
     */
    public void mostrarDatos(){
        System.out.println("Nombre de Usuario: " + usuario);
        System.out.println("Contraseña: " + contra);
        System.out.println("Nombre Completo: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Telefono: " + telefono);
        System.out.println("Fecha de Ingreso al Sistema: " + fechaIngreso);
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
}
