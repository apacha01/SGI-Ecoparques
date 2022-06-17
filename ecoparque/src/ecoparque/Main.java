
package ecoparque;

/**
 *
 * @author Agustín Pacheco
 * 
 * Consigna:
 *      Desarrolle un sistema para gestionar la información de un zoológico respecto a las especies que posee, 
 *  los empleados (cuidadores y guías) y los distintos itinerarios de visita que ofrece. La información está
 *  estructurada de la siguiente manera:
 *      • Especies: de las especies interesa saber el nombre en español, el nombre científico y una descripción 
 *  general. Hay que tener en cuenta que una especie puede vivir en diferentes hábitats naturales y que 
 *  un hábitat puede ser ocupado por diferentes especies. Las especies se encuentran en distintas zonas 
 *  del parque de manera que cada especie está en una zona y en una zona hay varias especies.
 *      • Hábitats: los diferentes hábitats naturales vienen definidos por el nombre, el clima y el tipo de 
 *  vegetación predominantes, así como el continente o continentes en los que se encuentran.
 *      • Zonas: las zonas del parque en las que se encuentran las distintas especies vienen definidas por el 
 *  nombre y la extensión que ocupan.
 *      • Itinerarios: los itinerarios discurren por distintas zonas del parque. La información de interés para 
 *  los itinerarios es: código de itinerario, la duración del recorrido, la longitud del itinerario, el máximo 
 *  número de visitantes autorizado y el número de distintas especies que visita. Tener en cuenta que 
 *  un itinerario recorre distintas zonas y que una zona puede ser recorrida por diferentes itinerarios.
 *      • Guías: los guías del parque vienen definidos por el nombre, dirección, teléfono y fecha en la que 
 *  comenzaron a trabajar en el zoo. Interesa saber qué guías llevan qué itinerarios, teniendo en cuenta 
 *  que un guía puede llevar varios itinerarios y que un itinerario puede ser asignado a diferentes guías 
 *  en diferentes horas, siendo éstas un dato de interés.
 *      • Cuidadores: los cuidadores vienen definidos por el nombre, dirección, teléfono y fecha de ingreso en 
 *  el parque. Hay que tener en cuenta que un cuidador puede estar a cargo de varias especies y que 
 *  una especie puede ser atendida por varios cuidadores, siendo de interés la fecha en la que un 
 *  cuidador se hace cargo de una especie.
 *      • Al sistema podrán acceder tres tipos de usuarios: guías y cuidadores (que sólo podrán consultar sus 
 *  respectivos datos) y administrador (que gestionará todo y listará a los demás por antigüedad).
 *  Para ello:
 *      • Analice los requerimientos anteriores
 *      • Determine los objetos requeridos para implementar ese sistema
 *      • Establezca los atributos que deben tener estos objetos
 *      • Fije los comportamientos que exhibirán estos objetos
 *      • Especifique la forma en que los objetos deben interactuar entre sí para cumplir con los 
 *  requerimientos del sistema
 *      El sistema deberá utilizar abstracción, encapsulamiento y persistencia (no BD). Opcionales: Herencia y 
 *  polimorfismo.
 *      La E/S del sistema será exclusivamente por consola (no GUI).
 * 
 */
public class Main {

    /**
     * @param args the command line arguments
     * Inicializa el sistema de gestión de información para el ecoparque
     */
    public static void main(String[] args) {
        SistemaSerializable s = new SistemaSerializable();
        s.ejecutar();
    }
}
