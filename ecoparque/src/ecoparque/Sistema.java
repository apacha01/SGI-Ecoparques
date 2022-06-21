
package ecoparque;

import static clasesAuxiliares.Constantes.*;
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
    private ArrayList<Zona> zonas;
    private ArrayList<Intinerario> ints;
    
    public Sistema() {
        empleados = new ArrayList<>();
        especies = new ArrayList<>();
        habitats = new ArrayList<>();
        zonas = new ArrayList<>();
        ints = new ArrayList<>();
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

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public ArrayList<Intinerario> getInts() {
        return ints;
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
     *
     * @param nomUsuario el nombre de usuario a buscar en el sistema
     * @return al empleado si lo encontro, null en otro caso
     */
    public Empleado existeEmpleado(String nomUsuario){
        for (Empleado emp: empleados) {
            if (emp.getUsuario().equals(nomUsuario)){
                return emp;
            }
        }
        return null;
    }
    
    /**
     *  Elimina un empleado del sistema
     * @param e el empleado a eliminar
     */
    public void eliminarEmpleado(Empleado e){
        if (e == null) return;
        //Si es un cuidador elimino dentro de la especie a dicho cuidador
        if (e instanceof Cuidador) {
            for (Especie especieCuidada : ((Cuidador) e).getEspeciesCuidadas()) {
                especieCuidada.quitarCuidador((Cuidador) e);
            }
        }
        //Si es un guia libero el intinerario, ya que solo un guia a la vez lo puede usar
        if (e instanceof Guia) {
            for (Intinerario intinerario : ((Guia) e).getIntinerarios()) {
                ((Guia) e).quitarIntinerario(intinerario);
            }
        }
        empleados.remove(e);
    }
    
    /**
     * Devuelve todos los cuidadores en el sistema
     * @return un arraylist de cuidadores dentro del sistema
     */
    public ArrayList<Cuidador> obtenerCuidadores(){
        ArrayList<Cuidador> cuidadores = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado instanceof Cuidador) {
                cuidadores.add((Cuidador)empleado);
            }
        }
        return cuidadores;
    }
    
    /**
     *
     * @param nomUsuario el nombre de usuario a buscar en el sistema
     * @return al cuidador si lo encontro, null en otro caso
     */
    public Cuidador existeCuidador(String nomUsuario){
        ArrayList<Cuidador> cuidadores = obtenerCuidadores();
        
        for (Cuidador cuidador : cuidadores) {
            if (cuidador.getUsuario().equals(nomUsuario)) {
                return cuidador;
            }
        }
        
        return null;
    }
    
    /**
     * Devuelve todos los guias en el sistema
     * @return un arraylist de guias dentro del sistema
     */
    public ArrayList<Guia> obtenerGuias(){
        ArrayList<Guia> guias = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado instanceof Guia) {
                guias.add((Guia)empleado);
            }
        }
        return guias;
    }
    
    public Guia existeGuia(String usuario){
        ArrayList<Guia> guias = obtenerGuias();
        for (Guia guia : guias) {
            if (guia.getUsuario().equals(usuario)) {
                return guia;
            }
        }
        return null;
    }
    
    
    /**
     *
     * @param nomCientifico el nombre cientifico de la especie que se esta buscando
     * @return la especie si se encontro, null en otro caso
     */
    public Especie existeEspecie(String nomCientifico){
        for (Especie esp: especies) {
            //IGNORO CASE - LOS NOMBRES CIENTIFICOS SON COMPLICADOS
            if (esp.getNomCientifico().equalsIgnoreCase(nomCientifico)){
                return esp;
            }
        }
        return null;
    }
    
    /**
     * Elimina una especie del sistema
     * @param e especie a eliminar del sistema
     */
    public void eliminarEspecie(Especie e){
        if (e == null) return;
        //ELIMINO LA ESPECIE DE LOS CUIDADORES QUE LA CUIDAN
        for (Cuidador cuidador : e.getCuidadores()) {
            cuidador.quitarEspecie(e);
        }
        if (e.getZona() != null) {
            e.getZona().quitarEspecie(e);
        }
        especies.remove(e);
    }
    
    public Zona existeZona(String nombre){
        for (Zona zona: zonas) {
            if (zona.getNombre().equalsIgnoreCase(nombre)){
                return zona;
            }
        }
        return null;
    }
    
    public void eliminarZona(Zona z){
        if (z == null) return;
        //LE SACO LA ZONA A LAS ESPECIES QUE TENIAN ESTA ZONA
        for (Especie especie : z.getEspecies()) {
            especie.quitarZona();
        }
        zonas.remove(z);
    }
    
    public Habitat existeHabitat(String s){
        for (Habitat h: habitats) {
            if (h.getNom().equals(s)){
                return h;
            }
        }
        return null;
    }
    
    public void eliminarHabitat(Habitat h){
        if (h == null) return;
        habitats.remove(h);
    }
    
    public Intinerario existeIntinerario(String cod){
        for (Intinerario intinerario : ints) {
            if (intinerario.getCodigo().equals(cod)) {
                return intinerario;
            }
        }
        return null;
    }
    
    public void eliminarIntinerario(Intinerario i){
        if (i == null) return;
        ints.remove(i);
    }
    
    /**
     * Muestra los empleados en el sistema por consola
     */
    public void mostrarEmpleados(){
        System.out.println("\n" + SEPARADOR_MEDIO + "Empleados" + SEPARADOR_MEDIO);
        for (int i = 0; i < empleados.size(); i++) {
            empleados.get(i).mostrarDatos();
            System.out.println(SEPARADOR);
        }
    }
    
    /**
     * Muestra los cuidadores en el sistema por consola
     */
    public void mostrarCuidadores(){
        System.out.println("\n" + SEPARADOR_MEDIO + "Cuidadores" + SEPARADOR_MEDIO);
        ArrayList<Cuidador> cuidadores = obtenerCuidadores();
        
        for (int i = 0; i < cuidadores.size(); i++) {
            cuidadores.get(i).mostrarDatos();
            System.out.println(SEPARADOR);
        }
    }
    
    /**
     * Muestra los guias en el sistema por consola
     */
    public void mostrarGuias(){
        System.out.println("\n" + SEPARADOR_MEDIO + "Guias" + SEPARADOR_MEDIO);
        ArrayList<Guia> guias = obtenerGuias();
        
        for (int i = 0; i < guias.size(); i++) {
            guias.get(i).mostrarDatos();
            System.out.println(SEPARADOR);
        }
    }
    
    /**
     * Muestra las especies en el sistema por consola
     */
    public void mostrarEspecies() {
        System.out.println("\n" + SEPARADOR_MEDIO + "Especies" + SEPARADOR_MEDIO);
        if (especies.isEmpty()) {
            System.out.println("No hay especies registradas en el sistema.");
        } else {
            for (int i = 0; i < especies.size(); i++) {
                especies.get(i).mostrarDatos();
                System.out.println(SEPARADOR);
            }
        }
    }
    
    /**
     * Muestra los habitats en el sistema por consola
     */
    public void mostrarHabitats (){
        System.out.println("\n" + SEPARADOR_MEDIO + "Habitats" + SEPARADOR_MEDIO);
        if (habitats.isEmpty()) {
            System.out.println("No hay habitats registradas en el sistema.");
        } else {
            for (int i = 0; i < habitats.size(); i++) {
                habitats.get(i).mostrarDatos();
                System.out.println(SEPARADOR);
            }
        }
    }
    
    /**
     * Muestra las zonas en el sistema por consola
     */
    public void mostrarZonas (){
        System.out.println("\n" + SEPARADOR_MEDIO + "Zonas" + SEPARADOR_MEDIO);
        if (zonas.isEmpty()) {
            System.out.println("No hay zonas registradas en el sistema.");
        } else {
            for (int i = 0; i < zonas.size(); i++) {
              zonas.get(i).mostrarDatos();
              System.out.println(SEPARADOR);
            }
        }
    }
    
    /**
     * Muestra los intinerarios en el sistema por consola
     */
    public void mostrarIntinerarios (){
        System.out.println("\n" + SEPARADOR_MEDIO + "Intinerarios" + SEPARADOR_MEDIO);
        if (ints.isEmpty()) {
            System.out.println("No hay intinerarios registradas en el sistema.");
        } else {
            for (int i = 0; i < ints.size(); i++) {
              ints.get(i).mostrarDatos();
              System.out.println(SEPARADOR);
            }
        }
    }
    
    /**
    *  @param a es el nombre del archivo del que se deserializa 
     * @return sistema que deserializo del archivo
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
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
     * @throws java.io.IOException 
    */
    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }
}
