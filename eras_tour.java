import java.util.Scanner;

/**
 * Esta clase representa un programa de gestión de venta de boletos para un tour.
 */
public class Eras_tour {
    private TicketManager ticketManager = new TicketManager(); // Administrador de boletos
    private Scanner scanner = new Scanner(System.in);

    /**
     * Punto de entrada del programa.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Eras_tour eras_tour = new Eras_tour();
        eras_tour.mostrarMenu();
        eras_tour.scanner.close();
    }

    /**
     * Muestra el menú principal del programa y maneja las opciones seleccionadas por el usuario.
     */
    public void mostrarMenu() {
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Código Especial");
        System.out.println("7. Salir");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nombre del comprador: ");
                String nombre = scanner.nextLine();
                System.out.print("Email del comprador: ");
                String email = scanner.nextLine();
                System.out.print("Presupuesto del comprador: ");
                int presupuesto = scanner.nextInt();
                ticketManager.nuevoComprador(nombre, email, presupuesto);
                break;
            case 2:
                System.out.print("Cantidad de boletos a comprar: ");
                int cantidadBoletos = scanner.nextInt();
                ticketManager.nuevaSolicitud(cantidadBoletos);
                break;
            case 3:
                ticketManager.disponibilidadTotal();
                break;
            case 4:
                System.out.print("Ingrese el número de localidad: ");
                int numeroLocalidad = scanner.nextInt();
                ticketManager.disponibilidadIndividual(numeroLocalidad);
                break;
            case 5:
                ticketManager.reporteCaja();
                break;
            case 6:
                System.out.print("Ingrese el código especial: ");
                int codigoEspecial = scanner.nextInt();
                ticketManager.codigoEspecial(codigoEspecial);
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        mostrarMenu();
    }
}
