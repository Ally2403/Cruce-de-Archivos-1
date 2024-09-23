package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoProyectos {

    public String nombreArchivo;

    public ArchivoProyectos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public ArrayList<Proyecto> leerArchivo() {
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre1 = partes[0];
                int id1 = Integer.parseInt(partes[1]);
                LocalDate inicio = LocalDate.parse(partes[2]);
                LocalDate finalizacion = LocalDate.parse(partes[3]);
                float presupuesto = Float.parseFloat(partes[4]);

                proyectos.add(new Proyecto(nombre1, id1, inicio, finalizacion, presupuesto));
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la lista o el archivo no existe.");
        }
        return proyectos;
    }

    public void mostrarArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre1 = partes[0];
                int id1 = Integer.parseInt(partes[1]);
                LocalDate inicio = LocalDate.parse(partes[2]);
                LocalDate finalizacion = LocalDate.parse(partes[3]);
                float presupuesto = Float.parseFloat(partes[4]);

                System.out.println("NOMBRE: " + nombre1 + "ID: " + id1 + ", INICIO: " + inicio + ", FINALIZACION: " + finalizacion + ", PRESUPUESTO: " + presupuesto);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    public void escribirArchivo(ArrayList<Proyecto> proyectos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Proyecto proyecto : proyectos) {
                bw.write(proyecto.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }

    public Proyecto agregarProyecto() {
        Scanner scanneri = new Scanner(System.in);
        Scanner scanners = new Scanner(System.in);
        Scanner scannerf = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ingrese los datos del proyecto a agregar");

        System.out.print("Ingrese el ID del proyecto: ");
        int id1 = scanneri.nextInt();
        scanneri.nextLine();

        System.out.print("Ingrese el nombre del proyecto: ");
        String nombre1 = scanners.nextLine();
        scanners.nextLine();

        System.out.print("Ingrese el inicio del proyecto: ");
        LocalDate inicio = LocalDate.parse(scanners.nextLine());
        scanners.nextLine();

        System.out.print("Ingrese el final del proyecto: ");
        LocalDate finalizacion = LocalDate.parse(scanners.nextLine());
        scanners.nextLine();

        System.out.print("Ingrese el presupuesto del proyecto: ");
        float presupuesto = scannerf.nextFloat();
        scannerf.nextLine();

        return new Proyecto(nombre1, id1, inicio, finalizacion, presupuesto);
    }

    public void agregarProyecto2(ArrayList<Proyecto> proyectos) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Proyecto proyecto = agregarProyecto();
            proyectos.add(proyecto);

            System.out.print("¿Desea agregar otro proyecto? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.toLowerCase().equals("s")) {
                break;
            }
        }
    }

    public void superarPresupuesto(ArrayList<Proyecto> proyectos) {
        Scanner scannerf = new Scanner(System.in);
        System.out.println("Ingrese el presupuesto al que se le buscarán los proyectos: ");
        float presupuesto1 = scannerf.nextFloat();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre1 = partes[0];
                float presupuesto = Float.parseFloat(partes[4]);

                if (presupuesto > presupuesto1) {
                    System.out.println(nombre1 + ", " + presupuesto);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    public void imprimirProyectos(ArrayList<Proyecto> proyectos) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Estos son los proyectos que tiene registrados actualmente");
        escribirArchivo(proyectos);
        mostrarArchivo();
    }
}
