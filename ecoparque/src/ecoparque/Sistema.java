
package ecoparque;

import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.InOut.*;
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
    
    /**
     *
     */
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
     * @param e empleado a agregar en el sistema
     */
    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }
    
    /**
     *
     * @return true si hay especies en el sistema, false sino
     */
    public boolean hayEspecies(){
        return especies.isEmpty();
    }

    /**
     *
     * @param e especie a agregar en el sistema
     */
    public void agregarEspecie(Especie e) {
        especies.add(e);
    }
    
    /**
     *
     * @return true si hay habitats en el sistema, false sino
     */
    public boolean hayHabitats(){
        return habitats.isEmpty();
    }
    
    /**
     *
     * @param h habitat a agregar en el sistema
     */
    public void agregarHabitat(Habitat h) {
        habitats.add(h);
    }

    /**
     *
     * @return true si hay zonas en el sistema, false sino
     */
    public boolean hayZonas(){
        return zonas.isEmpty();
    }
    
    /**
     *
     * @param z zona a agregar en el sistema
     */
    public void agregarZona(Zona z) {
        zonas.add(z);
    }
    
    /**
     *
     * @return true si hay zonas en el sistema, false sino
     */
    public boolean hayIntinerarios(){
        return ints.isEmpty();
    }
    
    /**
     *
     * @param i intinerario a agregar en el sistema
     */
    public void agregarIntinerario(Intinerario i) {
        ints.add(i);
    }
    
    /**
     *
     * @param nomUsuario nombre de usuario del que intenta ingresar
     * @param contra contraseña del usuario que intenta ingresar
     * @return el empleado si emcontro, null si no esta.
     */
    public Empleado existeEmpleado(String nomUsuario, String contra){
        for (Empleado emp: empleados) {
            if (emp.coincideUsuario(nomUsuario) && emp.coincideContra(contra)){
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
            if (emp.coincideUsuario(nomUsuario)){
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
        e.eliminarme();
        empleados.remove(e);
    }
    
    /**
     * Devuelve todos los cuidadores en el sistema
     * @return un arraylist de cuidadores dentro del sistema
     */
    private ArrayList<Cuidador> obtenerCuidadores(){
        ArrayList<Cuidador> cuidadores = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado instanceof Cuidador) {
                cuidadores.add((Cuidador)empleado);
            }
        }
        return cuidadores;
    }
    
    public boolean hayCuidadores(){
        return obtenerCuidadores().isEmpty();
    }
    
    /**
     *
     * @param nomUsuario el nombre de usuario a buscar en el sistema
     * @return al cuidador si lo encontro, null en otro caso
     */
    public Cuidador existeCuidador(String nomUsuario){
        ArrayList<Cuidador> cuidadores = obtenerCuidadores();
        
        for (Cuidador cuidador : cuidadores) {
            if (cuidador.coincideUsuario(nomUsuario)) {
                return cuidador;
            }
        }
        
        return null;
    }
    
    /**
     * Devuelve todos los guias en el sistema
     * @return un arraylist de guias dentro del sistema
     */
    private ArrayList<Guia> obtenerGuias(){
        ArrayList<Guia> guias = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado instanceof Guia) {
                guias.add((Guia)empleado);
            }
        }
        return guias;
    }
    
    public boolean hayGuias(){
        return obtenerGuias().isEmpty();
    }
    
    /**
     *
     * @param usuario
     * @return
     */
    public Guia existeGuia(String usuario){
        ArrayList<Guia> guias = obtenerGuias();
        for (Guia guia : guias) {
            if (guia.coincideUsuario(usuario)) {
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
            if (esp.coincideNomCientifico(nomCientifico)){
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
        e.eliminarme();
        especies.remove(e);
    }
    
    /**
     *
     * @param nombre
     * @return
     */
    public Zona existeZona(String nombre){
        for (Zona zona: zonas) {
            if (zona.coincideNombre(nombre)){
                return zona;
            }
        }
        return null;
    }
    
    /**
     *
     * @param z
     */
    public void eliminarZona(Zona z){
        if (z == null) return;
        //LE SACO LA ZONA A LAS ESPECIES QUE TENIAN ESTA ZONA
        z.eliminarme();
        zonas.remove(z);
    }
    
    /**
     *
     * @param s
     * @return
     */
    public Habitat existeHabitat(String s){
        for (Habitat h: habitats) {
            if (h.coincideNombre(s)){
                return h;
            }
        }
        return null;
    }
    
    /**
     *
     * @param h
     */
    public void eliminarHabitat(Habitat h){
        if (h == null) return;
        for (Especie especie : especies) {
            especie.quitarHabitat(h);
        }
        habitats.remove(h);
    }
    
    /**
     *
     * @param cod
     * @return
     */
    public Intinerario existeIntinerario(String cod){
        for (Intinerario intinerario : ints) {
            if (intinerario.coincideCodigo(cod)) {
                return intinerario;
            }
        }
        return null;
    }
    
    /**
     *
     * @param i
     */
    public void eliminarIntinerario(Intinerario i){
        if (i == null) return;
        if (i.isOcupado()) {
            for (Guia guia : obtenerGuias()) {
                if (guia.tieneIntinerario(i)) {
                    guia.quitarIntinerario(i);
                }
            }
        }
        ints.remove(i);
    }
    
    /**
     * Muestra los empleados en el sistema por consola
     */
    public void mostrarEmpleados(){
        printLine("\n" + SEPARADOR_MEDIO + "Empleados" + SEPARADOR_MEDIO);
        for (int i = 0; i < empleados.size(); i++) {
            empleados.get(i).mostrarDatos();
            printLine(SEPARADOR);
        }
    }
    
    /**
     * Muestra los cuidadores en el sistema por consola
     */
    public void mostrarCuidadores(){
        printLine("\n" + SEPARADOR_MEDIO + "Cuidadores" + SEPARADOR_MEDIO);
        ArrayList<Cuidador> cuidadores = obtenerCuidadores();
        
        for (int i = 0; i < cuidadores.size(); i++) {
            cuidadores.get(i).mostrarDatos();
            printLine(SEPARADOR);
        }
    }
    
    /**
     * Muestra los guias en el sistema por consola
     */
    public void mostrarGuias(){
        printLine("\n" + SEPARADOR_MEDIO + "Guias" + SEPARADOR_MEDIO);
        ArrayList<Guia> guias = obtenerGuias();
        
        for (Guia guia : guias) {
            guia.mostrarDatos();
            printLine(SEPARADOR);
        }
    }
    
    /**
     * Muestra las especies en el sistema por consola
     */
    public void mostrarEspecies() {
        printLine("\n" + SEPARADOR_MEDIO + "Especies" + SEPARADOR_MEDIO);
        if (especies.isEmpty()) {
            printLine("No hay especies registradas en el sistema.");
        } else {
            for (Especie especie : especies) {
                especie.mostrarDatos();
                printLine(SEPARADOR);
            }
        }
    }
    
    /**
     * Muestra los habitats en el sistema por consola
     */
    public void mostrarHabitats (){
        printLine("\n" + SEPARADOR_MEDIO + "Habitats" + SEPARADOR_MEDIO);
        if (habitats.isEmpty()) {
            printLine("No hay habitats registradas en el sistema.");
        } else {
            for (Habitat habitat : habitats) {
                habitat.mostrarDatos();
                printLine(SEPARADOR);
            }
        }
    }
    
    /**
     * Muestra las zonas en el sistema por consola
     */
    public void mostrarZonas (){        
        printLine("\n" + SEPARADOR_MEDIO + "Zonas" + SEPARADOR_MEDIO);
        if (zonas.isEmpty()) {
            printLine("No hay zonas registradas en el sistema.");
        } else {
            for (Zona zona : zonas) {
                zona.mostrarDatos();
                printLine(SEPARADOR);
            }
        }
    }
    
    /**
     * Muestra los intinerarios en el sistema por consola
     */
    public void mostrarIntinerarios (){
        printLine("\n" + SEPARADOR_MEDIO + "Intinerarios" + SEPARADOR_MEDIO);
        if (ints.isEmpty()) {
            printLine("No hay intinerarios registradas en el sistema.");
        } else {
            for (Intinerario int1 : ints) {
                int1.mostrarDatos();
                printLine(SEPARADOR);
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
