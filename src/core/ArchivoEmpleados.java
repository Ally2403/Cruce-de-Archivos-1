
package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoEmpleados {
    public String nombreArchivo;

    public ArchivoEmpleados(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public ArrayList<Empleado> leerArchivo(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int id = Integer.parseInt(partes[1]);
                String departamento = partes[2];
                String cargo = partes[3];
                float salario = Float.parseFloat(partes[4]);
                
                empleados.add(new Empleado(nombre, id, departamento, cargo, salario));
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la lista o el archivo no existe.");
        }
        return empleados;
    }
    
    public void mostrarArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int id = Integer.parseInt(partes[1]);
                String departamento = partes[2];
                String cargo = partes[3];
                float salario = Float.parseFloat(partes[4]);
                
                System.out.println("NOMBRE: " + nombre + "ID: " + id +", DEPARTAMENTO: " + departamento + ", CARGO: " + cargo + ", SALARIO: " + salario);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
    
    public void escribirArchivo(ArrayList<Empleado> empleados) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Empleado empleado : empleados) {
                bw.write(empleado.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
    
    public Empleado agregarEmpleado() {
        Scanner scanneri = new Scanner(System.in);
        Scanner scanners = new Scanner(System.in);
        Scanner scannerf = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ingrese los datos del Empleado a agregar");
        
        System.out.print("Ingrese el ID del Empleado: ");
        int id = scanneri.nextInt();
        scanneri.nextLine();
        
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanners.nextLine();
        scanners.nextLine(); 
        
        System.out.print("Ingrese el departamento del empleado: ");
        String departamento = scanners.nextLine();
        scanners.nextLine();
        
        System.out.print("Ingrese el cargo del empleado: ");
        String cargo = scanners.nextLine();
        scanners.nextLine();
        
        System.out.print("Ingrese el salario del empleado: ");
        float salario = scannerf.nextFloat();
        scannerf.nextLine();
        
        return new Empleado(nombre, id, departamento, cargo, salario);
    }
    
    public void agregarEmpleado2(ArrayList<Empleado> empleados) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Empleado empleado = agregarEmpleado();
            empleados.add(empleado);

            System.out.print("¿Desea agregar otro empleado? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.toLowerCase().equals("s")) {
                break;
            }
        }
    }
    
    public void imprimirEmpleados(ArrayList<Empleado> empleados) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Estos son los empleados que tiene registrados actualmente");
        escribirArchivo(empleados);
        mostrarArchivo();
    }
}
