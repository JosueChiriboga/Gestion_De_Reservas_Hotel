import java.util.ArrayList;

public class Hotel {
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;

    public Hotel(int cantidadHabitaciones) {
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();

        for (int i = 1; i <= cantidadHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public boolean crearReserva(String cliente, int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion && habitacion.isDisponible()) {
                habitacion.setDisponible(false);
                reservas.add(new Reserva(cliente, numeroHabitacion));
                return true;
            }
        }
        return false;
    }

    public boolean consultarDisponibilidad(int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion) {
                return habitacion.isDisponible();
            }
        }
        return false;
    }

    public void mostrarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getCliente() + ", Habitacion: " + reserva.getNumeroHabitacion());
        }
    }

    public boolean cancelarReserva(int numeroHabitacion) {
        for (Reserva reserva : reservas) {
            if (reserva.getNumeroHabitacion() == numeroHabitacion) {
                for (Habitacion habitacion : habitaciones) {
                    if (habitacion.getNumero() == numeroHabitacion) {
                        habitacion.setDisponible(true);
                        break;
                    }
                }
                reservas.remove(reserva);
                System.out.println("Reserva Cancelada Con Exito");
                return true;
            }
        }
        System.out.println("No existe ninguna reserva para la habitacion " + numeroHabitacion);
        return false;
    }


}
