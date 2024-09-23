package core;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*Enunciado del Ejercicio de Cruce de Archivos: Gestión de Empleados y Proyectos

    Imagina que trabajas en una empresa que lleva un registro detallado de los empleados y los proyectos en los que están involucrados. Se requiere desarrollar un programa en Java que permita gestionar esta información a través de archivos. Las operaciones que se deben implementar son las siguientes:

    AGREGAR EMPLEADOS
    Permite registrar un empleado con los siguientes atributos:

    Nombre
    ID de empleado
    Departamento
    Cargo
    Salario
    AGREGAR PROYECTOS
    Permite registrar un proyecto con los siguientes atributos:

    Nombre del proyecto
    ID de proyecto
    Fecha de inicio
    Fecha de finalización
    Presupuesto
    ASIGNAR EMPLEADOS A PROYECTOS
    Permite asignar uno o más empleados a un proyecto específico, especificando el ID del empleado y el ID del proyecto. Esta asignación debe ser guardada en un archivo que registre qué empleados están involucrados en cada proyecto.

    IMPRIMIR EMPLEADOS POR PROYECTO
    Muestra una lista de los empleados asignados a un proyecto específico, dado el ID del proyecto.

    CANTIDAD DE EMPLEADOS ASIGNADOS POR PROYECTO EN UN RANGO DE FECHAS
    Muestra la cantidad de empleados que han sido asignados a proyectos que iniciaron entre dos fechas específicas.

    MOSTRAR PROYECTOS EN LOS QUE EL PRESUPUESTO SUPERA UN MONTO ESPECÍFICO
    Muestra una lista de todos los proyectos cuyo presupuesto supera un monto dado.

    EMPLEADOS CON SALARIO SUPERIOR AL PROMEDIO DE LOS EMPLEADOS ASIGNADOS A UN PROYECTO
    Dado el ID de un proyecto, muestra los empleados que están asignados a ese proyecto cuyo salario es mayor que el salario promedio de todos los empleados asignados a ese proyecto.*/
    public static void main(String[] args) {
        ArchivoEmpleados archivoEmpleados = new ArchivoEmpleados("C:\\Users\\Allison Ruiz\\Documents\\NETBEANS\\Cruce de archivos estudiar\\src\\core\\empleados.txt");
        ArrayList<Empleado> empleados = archivoEmpleados.leerArchivo();
        ArchivoProyectos archivoProyectos = new ArchivoProyectos("C:\\Users\\Allison Ruiz\\Documents\\NETBEANS\\Cruce de archivos estudiar\\src\\core\\proyectos.txt");
        ArrayList<Proyecto> proyectos = archivoProyectos.leerArchivo();
        EmpleadosProyectos ArchivoEmpleadosProyectos = new EmpleadosProyectos("C:\\Users\\Allison Ruiz\\Documents\\NETBEANS\\Cruce de archivos estudiar\\src\\core\\empleadosProyectos.txt");
        ArrayList<EmpleadosProyectosClass> empleadosProyectos = ArchivoEmpleadosProyectos.leerArchivo();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea entrar a gestión de empleados(0) o desea entrar a gestion de proyectos(1)");
        String opcion = scanner.nextLine();
        if (opcion.equals("0")) {
            while (true) {
                System.out.println("-----------------------------------------------------------");
                System.out.println("Bienvenido a la gestion de empleados");
                System.out.println("Escoja una de las siguientes acciones para realizar");
                System.out.println("1. Agregar empleado");
                System.out.println("2. Imprimir empleados");
                System.out.println("3. Salir");
                System.out.println("-----------------------------------------------------------");
                String op1 = scanner.nextLine();

                switch (op1) {
                    case "1":
                        archivoEmpleados.agregarEmpleado2(empleados);
                        archivoEmpleados.imprimirEmpleados(empleados);
                        break;
                    case "2":
                        archivoEmpleados.imprimirEmpleados(empleados);
                        break;
                    case "3":
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        } else {
            while (true) {
                System.out.println("-----------------------------------------------------------");
                System.out.println("Bienvenido a la gestion de proyectos");
                System.out.println("Escoja una de las siguientes acciones para realizar");
                System.out.println("1. Agregar proyecto");
                System.out.println("2. Imprimir proyectos");
                System.out.println("3. Asignar empleados a proyectos");
                System.out.println("4. Imprimir empleados por proyecto");
                System.out.println("5. Imprimir proyectos que superan un presupuesto");
                System.out.println("6. Salir");
                System.out.println("-----------------------------------------------------------");
                String op1 = scanner.nextLine();

                switch (op1) {
                    case "1":
                        archivoProyectos.agregarProyecto2(proyectos);
                        archivoProyectos.imprimirProyectos(proyectos);
                        break;
                    case "2":
                        archivoProyectos.imprimirProyectos(proyectos);
                        break;
                    case "3":
                        ArchivoEmpleadosProyectos.asignarEmpleadoAProyecto(empleadosProyectos, empleados, proyectos);
                        ArchivoEmpleadosProyectos.imprimirEmpleadosProyectos(empleadosProyectos);
                        break;
                    case "4":
                        ArchivoEmpleadosProyectos.empleadosPorProyecto();
                        break;
                    case "5":
                        archivoProyectos.superarPresupuesto(proyectos);
                        break;
                    
                    default:
                        System.exit(0);
                        break;
                }
            }
        }
    }
}
