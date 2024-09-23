
package core;

import java.time.LocalDate;

public class Proyecto {
    //https://www.baeldung.com/java-8-date-time-intro
    public String nombre1;
    public int id1;
    public LocalDate inicio;
    public LocalDate finalizacion;
    public float presupuesto;

    public Proyecto(String nombre1, int id1, LocalDate inicio, LocalDate finalizacion, float presupuesto) {
        this.nombre1 = nombre1;
        this.id1 = id1;
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return nombre1 + "," + id1 + "," + inicio + "," + finalizacion + "," + presupuesto;
    }
}
