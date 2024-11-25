public class Reserva {
    private String cliente;
    private int numeroHabitacion;

    public Reserva(String cliente, int numeroHabitacion) {
        this.cliente = cliente;
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getCliente() {
        return cliente;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }
}
