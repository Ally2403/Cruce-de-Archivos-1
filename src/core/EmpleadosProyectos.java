
package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpleadosProyectos {
    public String nombreArchivo;

    public EmpleadosProyectos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public ArrayList<EmpleadosProyectosClass> leerArchivo(){
        ArrayList<EmpleadosProyectosClass> empleadosProyectos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int idEmpleado = Integer.parseInt(partes[0]);
                String nombreEmpleado = partes[1];
                int idProyecto = Integer.parseInt(partes[2]);
                String nombreProyecto = partes[3];
                
                empleadosProyectos.add(new EmpleadosProyectosClass(idEmpleado, nombreEmpleado, idProyecto, nombreProyecto));
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la lista o el archivo no existe.");
        }
        return empleadosProyectos;
    }
    
    public void mostrarArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int idEmpleado = Integer.parseInt(partes[0]);
                String nombreEmpleado = partes[1];
                int idProyecto = Integer.parseInt(partes[2]);
                String nombreProyecto = partes[3];
                
                System.out.println("ID_EMPLEADO: " + idEmpleado + ", NOMBRE_EMPLEADO: " + nombreEmpleado +", ID_PROYECTO: " + idProyecto + ", NOMBRE_PROYECTO: " + nombreProyecto);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
    
    public void escribirArchivo(ArrayList<EmpleadosProyectosClass> empleadosProyectos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (EmpleadosProyectosClass empleadoProyecto : empleadosProyectos) {
                bw.write(empleadoProyecto.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
    
    public void asignarEmpleadoAProyecto(ArrayList<EmpleadosProyectosClass> empleadosProyectos, ArrayList<Empleado> empleados, ArrayList<Proyecto> proyectos){
        Scanner scanneri = new Scanner(System.in);
        System.out.print("Ingrese el id del empleado que quiere asignar: ");
        int idEmpleado = scanneri.nextInt();
        System.out.println("¿A qué proyecto lo quiere asignar? Ingrese el id del proyecto");
        int idProyecto = scanneri.nextInt();
        for(Empleado empleado : empleados){
            for(Proyecto proyecto : proyectos){
                if(empleado.id == idEmpleado && proyecto.id1 == idProyecto){
                    empleadosProyectos.add(new EmpleadosProyectosClass(idEmpleado, empleado.nombre, idProyecto, proyecto.nombre1));
                }
            }
        }
    }
    
    public void empleadosPorProyecto(){
        Scanner scanneri = new Scanner(System.in);
        System.out.println("Ingrese el id del proyecto al cual le quiere buscar los empleados: ");
        int idProyecto1 = scanneri.nextInt();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombreEmpleado = partes[1];
                int idProyecto = Integer.parseInt(partes[2]);
                if(idProyecto == idProyecto1){
                    System.out.println(nombreEmpleado);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
    
    public void imprimirEmpleadosProyectos(ArrayList<EmpleadosProyectosClass> empleadosProyectos) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Estos son los proyectos que tiene registrados actualmente");
        escribirArchivo(empleadosProyectos);
        mostrarArchivo();
    }
}
