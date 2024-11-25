/*UNIVERSIDAD DE LAS AMÉRICAS
 * Estudiante Encargado: Josué Chiriboga, Jean Carlos Gómez
 * Asignatura: Programacion II
 * Actividad: Gestión de Reservas en un Hotel
 * Fecha: 25/11/2024*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(10);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestion De Reservas De Hotel" + '\n' +
                    "1. Crear Una Nueva Reserva" + '\n' +
                    "2. Consultar Disponibilidad De Una Habitacion" + '\n' +
                    "3. Mostrar Reservas Registradas" + '\n' +
                    "4. Cancelar Una Reserva" + '\n' +
                    "5. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    scanner.nextLine();
                    String cliente = scanner.nextLine();
                    System.out.print("Ingrese el numero de habitacion: ");
                    int numeroHabitacion = scanner.nextInt();
                    if (hotel.crearReserva(cliente, numeroHabitacion)) {
                        System.out.println("Reserva Exitosa");
                    } else {
                        System.out.println("Habitacion Ocupada o No Existe");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el numero de habitacion: ");
                    numeroHabitacion = scanner.nextInt();
                    if (hotel.consultarDisponibilidad(numeroHabitacion)) {
                        System.out.println("Habitacion Disponible");
                    } else {
                        System.out.println("Habitacion Ocupada");
                    }
                    break;

                case 3:
                    System.out.println("Reservas Registradas:");
                    hotel.mostrarReservas();
                    break;

                case 4:
                    System.out.print("Ingrese el numero de habitacion para cancelar la reserva: ");
                    int numeroHabitacionCancelar = scanner.nextInt();
                    hotel.cancelarReserva(numeroHabitacionCancelar);
                    break;

                case 5:
                    System.out.println("\nSaliendo del Gestor de Reservas...");
                    break;

                default://error
                    System.out.println("\nOpcion Incorrecta. Ingrese nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
