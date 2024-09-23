
package core;

public class EmpleadosProyectosClass {
    public int idEmpleado;
    public String nombreEmpleado;
    public int idProyecto;
    public String nombreProyecto;

    public EmpleadosProyectosClass(int idEmpleado, String nombreEmpleado, int idProyecto, String nombreProyecto) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
    }

    @Override
    public String toString() {
        return idEmpleado + "," + nombreEmpleado + "," + idProyecto + "," + nombreProyecto;
    }
    
}
