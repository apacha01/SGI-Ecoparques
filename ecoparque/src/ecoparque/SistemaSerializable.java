
package ecoparque;

import clasesAuxiliares.InOut;
import static clasesAuxiliares.Constantes.*;
import static clasesAuxiliares.InOut.*;
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
            
        } catch (Exception e) {
            
            printLine("Al ser la primera vez que se ingresa al sistema necesitaremos que introduzca sus datos personales "
                    + "Sr(a) Administrador(a).");
            
            //PIDO NOMBRE DE USUARIO DEL EMPLEADO
            String usuario = InOut.pedirUsuario();
            
            //PIDO CONTRASEÑA PARA EL USUARIO
            String contra = InOut.pedirContra();
            
            //PIDO NOMBRE DEL EMPLEADO
            String nombre = InOut.pedirNombreEmpleado();
            
            //PIDO DIRECCIÓN DEL EMPLEADO
            String direccion = InOut.pedirDireccion();
            
            //PIDO TELEFONO DEL EMPLEADO
            String telefono = InOut.pedirTelefono();
            
            //LA FECHA DE INGRESO ES LA FECHA AL MOMENTO DE REGISTRARSE
            Date fechaIngreso = new Date();
            
            s.agregarEmpleado(new Administrador(usuario,contra,nombre,direccion,telefono,fechaIngreso));
            
            try {
                s.serializar(NOMBRE_ARCHIVO);
                printLine("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            seguir = false;
        }

        while (seguir) {
            printLine("\n" + SEPARADOR_MEDIO + "SISTEMA DE GESTIÓN DE INFORMACIÓN PARA ECOPARQUES" + SEPARADOR_MEDIO);
            print("Ingrese el nombre de usuario: ");
            String usuario = InOut.leerString();
            
            print("Ingrese la contraseña: ");
            String contra = InOut.leerString();
            
            Empleado e = s.existeEmpleado(usuario,contra);

            if (e == null) {
                if (usuario.equals("0") && contra.equals("0")) {
                    break;
                }
                printError("La combinacion usuario/contraseña ingresada no es valida");
            } else {
                seguir = e.ingresar(s);
            }
        }
    }
}