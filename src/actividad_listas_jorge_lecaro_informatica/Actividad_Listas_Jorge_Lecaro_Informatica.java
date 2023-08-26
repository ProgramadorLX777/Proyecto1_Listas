//ACTIVIDAD_LISTAS_JORGE_LECARO_INFORMÁTICA
package actividad_listas_jorge_lecaro_informatica;

//LIBRERÍAS IMPORTADAS:
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import model.Empleado;
import java.util.Scanner;
import db.Database;

public class Actividad_Listas_Jorge_Lecaro_Informatica {

    public static void main(String[] args) {

        //CREACIÓN DE LA MAIN PRINCIPAL:
        Database listaEmpleados = new Database();
        //Pruebas de Depuración:
        Empleado empleado_1 = new Empleado("jorge", "lecaro", LocalDate.of(2005, 2, 18), 500000);
        listaEmpleados.addItem(empleado_1);
//        Empleado empleado_2 = new Empleado("max", "2", LocalDate.of(2005, 2, 18), 500000);
//        listaEmpleados.addItem(empleado_2);
//        Empleado empleado_3 = new Empleado("ivan", "3", LocalDate.of(2005, 2, 18), 500000);
//        listaEmpleados.addItem(empleado_3);

        boolean salirMenu = false; // Control de salida del ciclo de Opciones

        while (!salirMenu) {
            int op = menuPrincipal();
            //OPCIONES DEL MENÚ DE OPCIONES:
            switch (op) {
                //Opción 1: Creación de Empleados
                case 1 -> {
                    limpiarPantalla();
                    listaEmpleados.addItem(crearEmpleado());
                }

                //Opción 2: Eliminación de Empleados
                case 2 -> {
                    imprimirLista(listaEmpleados);
                    Scanner leer = new Scanner(System.in);
                    System.out.print("Ingrese el ID del empleado: ");
                    int idAEliminar = leer.nextInt();

                    if (listaEmpleados.getSize() > 0) {
                        if (idAEliminar >= 0 && idAEliminar < listaEmpleados.getSize()) {
                            System.out.print("[-] Esta seguro que desea eliminar al empleado??: (1. SI (Borrar) | (2. NO (Salir): \n");
                            int opEliminar = Integer.parseInt(leer.next());//VALIDAR DATO
                            if (opEliminar != 1 || opEliminar != 2) {
                                if (opEliminar == 1) {
                                    System.out.println("[-] El empleado eliminado es: " + listaEmpleados.getItem(idAEliminar));
                                    listaEmpleados.deleteItem(idAEliminar);
                                    System.out.println("[*] El empleado reemplazado ahora es: " + listaEmpleados.getItem(idAEliminar));

                                }
                                System.out.println("=========================================================================================================\n");
                            } else {
                                System.out.println("¡¡La opción no es valida, Vuelva a intentarlo!!");

                            }
                        } else {
                            System.out.println("El ID no existe!! Vuelva a intentarlo...\n");
                        }
                    } else {
                        System.out.println("No hay items en la lista.....");
                    }
                }

                //Opción 3: Imprimir Listado de Empleados
                case 3 -> {
                    limpiarPantalla();
                    imprimirLista(listaEmpleados);
                }

                //Opción 4: Cierre del Programa
                case 4 -> {
                    limpiarPantalla();
                    System.out.println("====================================================");
                    System.out.println("/// SE REALIZO EL CIERRE DEL PROGRAMA CON EXITO!!! ///");
                    System.out.println("=====================================================");
                    salirMenu = true;
                    break;
                }
                default ->
                    System.out.println("La opcion seleccionada no es valida!! Por favor ingresar una opcion valida!!\n");
            }
        }
    }

    //Primer Método:
    private static int menuPrincipal() {
        System.out.println("=========== MENU DE OPCIONES ==========");
        System.out.println("// 1. Crear Empleado                 //");
        System.out.println("// 2. Eliminar Empleado              //");
        System.out.println("// 3. Mostrar lista de Empleados     //");
        System.out.println("// 4. Salir del programa             //");
        System.out.println("=======================================");
        Scanner entrada_datos = new Scanner(System.in);
        System.out.print("[*] Ingrese una opcion: ");
        return Integer.parseInt(entrada_datos.next());
    }

    //Segundo Método:
    private static Empleado crearEmpleado() {
        Scanner leer = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.print("Ingrese nombre del empleado: ");
        String nom = leer.next();
        System.out.print("Ingrese apellido del empleado: ");
        String ape = leer.next();
        System.out.println("=======================================");
        System.out.println("///////// FECHA DE NACIMIENTO /////////");
        System.out.println("=======================================");
        System.out.print("Ingrese el año: ");
        int year = Integer.parseInt(leer.next());
        System.out.print("Ingrese el mes: ");
        int month = Integer.parseInt(leer.next());
        System.out.print("Ingrese el dia: ");
        int day = Integer.parseInt(leer.next());
        System.out.print("Ingrese el salario minimo del empleado: ");
        double salario = leer.nextDouble();
        System.out.println("========================================");
        System.out.println("// EL EMPLEADO FUE CREADO CON EXITO!! //");
        System.out.println("========================================\n");

        Empleado empleado = new Empleado(nom, ape, LocalDate.of(year, month, day), salario);
        return empleado;
    }

    //Tercer Método:
    private static void imprimirLista(Database lista) {
        int cont = 0;
        System.out.println("=============================");
        System.out.println("///  EMPLEADOS EXISTENTES  /// ");
        System.out.println("==============================");
        while (cont < lista.getSize()) {
            System.out.println("ID: " + cont + " " + "Nombre: " + lista.getItem(cont).getNombre());
            cont = cont + 1;
        }
        System.out.println("==============================\n");
    }

    //Cuarto Método:
    private static void limpiarPantalla() {
        try {
            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando = new ArrayList();
            if (sistemaOperativo.contains("Windows")) {
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");
            } else {
                comando.add("clear");
            }
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrio un Error al limpiar la pantalla!!" + e.getMessage());
        }
    }
}
//FIN DEL CÓDIGO
