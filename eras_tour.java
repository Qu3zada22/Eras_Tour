//Jonathan alejandro y anggie quezada

import java.util.*;

/**
 * Clase principal del sistema Eras Tour que administra la interacción con los compradores y las localidades de boletos.
 */
public class eras_tour {
    private Buyer activeBuyer;
    private List<Locality> localities;

    /**
     * Constructor que inicializa el sistema con las localidades disponibles.
     */
    public eras_tour() {
        localities = new ArrayList<>();
        localities.add(new Locality("Localidad 1", 100, 20));
        localities.add(new Locality("Localidad 5", 500, 20));
        localities.add(new Locality("Localidad 10", 1000, 20));
    }

    /**
     * Método principal que muestra el menú del sistema y maneja las opciones seleccionadas por el usuario.
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Eras Tour System Menu");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Código Especial");
            System.out.println("7. Salir");
            System.out.print("Ingrese su elección: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createNewBuyer();
                    break;
                case 2:
                    if (activeBuyer != null) {
                        activeBuyer.requestTickets();
                    } else {
                        System.out.println("¡Debe crear un comprador primero!");
                    }
                    break;
                case 3:
                    displayTotalAvailability();
                    break;
                case 4:
                    displayIndividualAvailability();
                    break;
                case 5:
                    displayTotalRevenue();
                    break;
                case 6:
                    useSpecialCode();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (choice != 7);
    }

    private void createNewBuyer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del comprador: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el correo electrónico del comprador: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el presupuesto máximo del comprador: ");
        int budget = scanner.nextInt();
        activeBuyer = new Buyer(name, email, budget);
        System.out.println("Comprador creado exitosamente.");
    }

    private void displayTotalAvailability() {
        System.out.println("Disponibilidad total en cada localidad:");
        for (Locality locality : localities) {
            System.out.println(locality.getName() + ": " + locality.getAvailableTickets() + " boletos disponibles");
        }
    }

    private void displayIndividualAvailability() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la localidad: ");
        String localityName = scanner.nextLine();

        Locality selectedLocality = findLocality(localityName);

        if (selectedLocality != null) {
            System.out.println("Disponibilidad en " + selectedLocality.getName() + ": " + selectedLocality.getAvailableTickets() + " boletos disponibles");
        } else {
            System.out.println("Localidad no encontrada.");
        }
    }

    private void displayTotalRevenue() {
        int totalRevenue = 0;
        for (Locality locality : localities) {
            totalRevenue += locality.getSoldTickets() * locality.getPrice();
        }
        System.out.println("Total generado de dinero: $" + totalRevenue);
    }

    private void useSpecialCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código especial: ");
        int code = scanner.nextInt();

        if (isFibonacci(code)) {
            if (activeBuyer != null) {
                activeBuyer.setSpecialCode(code);
                System.out.println("Código especial aplicado correctamente.");
            } else {
                System.out.println("¡Debe crear un comprador primero!");
            }
        } else {
            System.out.println("Código especial inválido.");
        }
    }

    private boolean isFibonacci(int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        int a = 0, b = 1, c = a + b;
        while (c <= n) {
            if (c == n) {
                return true;
            }
            a = b;
            b = c;
            c = a + b;
        }
        return false;
    }

    private Locality findLocality(String name) {
        for (Locality locality : localities) {
            if (locality.getName().equalsIgnoreCase(name)) {
                return locality;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        eras_tour tourSystem = new eras_tour();
        tourSystem.displayMenu();
    }
}

/**
 * Clase que representa a un comprador interesado en comprar boletos.
 */
class Buyer {
    private String name;
    private String email;
    private int budget;
    private int ticketsToBuy;
    private int specialCode;
    private List<Ticket> activeTickets;

    public Buyer(String name, String email, int budget) {
        this.name = name;
        this.email = email;
        this.budget = budget;
        activeTickets = new ArrayList<>();
    }

    public void requestTickets() {
        // Implementar lógica para solicitar boletos aquí
    }

    public void updateBudget(int amount) {
        budget -= amount;
    }

    public void addTicket(Ticket ticket) {
        activeTickets.add(ticket);
    }

    public void setSpecialCode(int code) {
        specialCode = code;
    }
}

/**
 * Clase que representa un boleto emitido para un comprador.
 */
/**
 * Clase que representa un boleto emitido para un comprador.
 */
class Ticket {
    private int ticketNumber;
    private boolean valid;
    private Locality locality;

    /**
     * Constructor que inicializa un boleto con su número y localidad.
     */
    public Ticket(int ticketNumber, Locality locality) {
        this.ticketNumber = ticketNumber;
        this.valid = true; // Por defecto, un boleto nuevo se considera válido
        this.locality = locality;
    }

    /**
     * Verifica si el boleto es válido.
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Cambia el estado de validez del boleto.
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     * Obtiene la localidad asociada con el boleto.
     */
    public Locality getLocality() {
        return locality;
    }
}

/**
 * Clase que representa una localidad de boletos con su respectivo precio y disponibilidad.
 */
/**
 * Clase que representa una localidad de boletos con su respectivo precio y disponibilidad.
 */
class Locality {
    private String name;
    private int price;
    private int availableTickets;
    private int soldTickets;

    /**
     * Constructor que inicializa una localidad con su nombre, precio y cantidad de boletos disponibles.
     */
    public Locality(String name, int price, int availableTickets) {
        this.name = name;
        this.price = price;
        this.availableTickets = availableTickets;
        soldTickets = 0;
    }

    /**
     * Obtiene la cantidad de boletos disponibles en esta localidad.
     */
    public int getAvailableTickets() {
        return availableTickets;
    }

    /**
     * Verifica si hay suficientes boletos disponibles para la cantidad solicitada.
     */
    public boolean isAvailable(int numTickets) {
        return availableTickets >= numTickets;
    }

    /**
     * Vende la cantidad especificada de boletos y actualiza la disponibilidad.
     */
    public void sellTickets(int numTickets) {
        availableTickets -= numTickets;
        soldTickets += numTickets;
    }

    /**
     * Obtiene el nombre de la localidad.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la cantidad de boletos vendidos en esta localidad.
     */
    public int getSoldTickets() {
        return soldTickets;
    }
}

