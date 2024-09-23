
package core;

public class Empleado {
    public String nombre;
    public int id;
    public String departamento;
    public String cargo;
    public float salario;

    public Empleado(String nombre, int id, String departamento, String cargo, float salario) {
        this.nombre = nombre;
        this.id = id;
        this.departamento = departamento;
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nombre + "," + id + "," + departamento + "," + cargo + "," + salario;
    }
}
