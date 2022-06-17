
package ecoparque;

import clasesAuxiliares.LecturaPorConsola;
import static clasesAuxiliares.Constantes.*;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Agustín Pacheco
 */
public class SistemaSerializable {
    
    /**
     *  Comienza la ejecución del sistema con serialización.
     *  Chequea si existe el archivo donde se guardan los datos, sino existe lo crea.
     */
    public void ejecutar() {

        Sistema s = new Sistema();
        boolean seguir = true;
        
        try {
            
            s = s.deSerializar(NOMBRE_ARCHIVO);
            System.out.println("SISTEMA DE GESTIÓN DE INFORMACIÓN PARA ECOPARQUES");
            
        } catch (Exception e) {
            
            System.out.println("Al ser la primera vez que se ingresa al sistema necesitaremos que introduzca sus datos personales "
                    + "Sr(a) Administrador(a).");
            
            //PIDO NOMBRE DE USUARIO DEL EMPLEADO
            String usuario = LecturaPorConsola.pedirUsuario();
            
            //PIDO CONTRASEÑA PARA EL USUARIO
            String contra = LecturaPorConsola.pedirContra();
            
            //PIDO NOMBRE DEL EMPLEADO
            String nombre = LecturaPorConsola.pedirNombreEmpleado();
            
            //PIDO DIRECCIÓN DEL EMPLEADO
            String direccion = LecturaPorConsola.pedirDireccion();
            
            //PIDO TELEFONO DEL EMPLEADO
            String telefono = LecturaPorConsola.pedirTelefono();
            
            //LA FECHA DE INGRESO ES LA FECHA AL MOMENTO DE REGISTRARSE
            Date fechaIngreso = new Date();
            
            s.getEmpleados().add(new Administrador(usuario,contra,nombre,direccion,telefono,fechaIngreso));
            
            try {
                s.serializar(NOMBRE_ARCHIVO);
                System.out.println("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            seguir = false;
        }

        while (seguir) {
            System.out.print("\nIngrese el nombre de usuario: ");
            String usuario = LecturaPorConsola.leerString();
            
            System.out.print("\nIngrese la contraseña: ");
            String contra = LecturaPorConsola.leerString();
            
            Empleado e = s.existeEmpleado(usuario,contra);

            if (e == null) {
                System.out.println("ERROR: La combinacion usuario/contraseña ingresada no es valida.\n");
            } else {
                if (usuario.equals("0") && contra.equals("0")) {
                    break;
                }
                seguir = e.ingresar(s);
            }
        }
    }
}