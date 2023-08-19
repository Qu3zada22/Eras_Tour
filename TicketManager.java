import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase gestiona la venta y administración de boletos de localidades.
 */
public class TicketManager {
    private ArrayList<Localidad> localidades; // Lista de localidades disponibles
    private Comprador compradorActivo;        // Comprador activo

    /**
     * Constructor para inicializar el gestor de boletos con algunas localidades predeterminadas.
     */
    public TicketManager() {
        localidades = new ArrayList<>();
        localidades.add(new Localidad(1, 100, 20));
        localidades.add(new Localidad(5, 500, 20));
        localidades.add(new Localidad(10, 1000, 20));
    }

    /**
     * Crea un nuevo comprador activo.
     *
     * @param nombre     El nombre del comprador.
     * @param email      El correo electrónico del comprador.
     * @param presupuesto El presupuesto disponible del comprador.
     */
    public void nuevoComprador(String nombre, String email, int presupuesto) {
        compradorActivo = new Comprador(nombre, email, presupuesto);
    }

    /**
     * Crea una nueva solicitud de compra de boletos.
     *
     * @param cantidad La cantidad de boletos que se intentarán comprar.
     */
    public void nuevaSolicitud(int cantidad) {
        if (compradorActivo != null) {
            int ticket = new Random().nextInt(15000) + 1;
            int a = new Random().nextInt(15000) + 1;
            int b = new Random().nextInt(15000) + 1;

            int localidadAleatoria = new Random().nextInt(localidades.size());
            Localidad localidad = localidades.get(localidadAleatoria);

            if (localidad.validarEspacio() && localidad.validarDisponibilidad(cantidad) && localidad.validarPrecio(compradorActivo.getPresupuesto())) {
                if (ticket >= Math.min(a, b) && ticket <= Math.max(a, b)) {
                    compradorActivo.comprarBoletos(localidad, cantidad);
                    System.out.println("Compra exitosa");
                    return;
                }
            }
            System.out.println("No cumplió con los requisitos.");
        } else {
            System.out.println("No hay comprador activo.");
        }
    }

    /**
     * Muestra la disponibilidad total de boletos en todas las localidades.
     */
    public void disponibilidadTotal() {
        for (Localidad localidad : localidades) {
            System.out.println("Localidad " + localidad.getNumeroLocalidad() + ": Boletos vendidos: " + localidad.getBoletosVendidos() + ", Boletos disponibles: " + localidad.getEspacioDisponible());
        }
    }

    /**
     * Muestra la disponibilidad de boletos en una localidad específica.
     *
     * @param numeroLocalidad El número de la localidad para la cual se mostrará la disponibilidad.
     */
    public void disponibilidadIndividual(int numeroLocalidad) {
        for (Localidad localidad : localidades) {
            if (localidad.getNumeroLocalidad() == numeroLocalidad) {
                System.out.println("Localidad " + localidad.getNumeroLocalidad() + ": Boletos vendidos: " + localidad.getBoletosVendidos() + ", Boletos disponibles: " + localidad.getEspacioDisponible());
                return;
            }
        }
        System.out.println("Localidad no encontrada.");
    }

    /**
     * Genera un reporte de las ventas totales en todas las localidades.
     */
    public void reporteCaja() {
        int totalVentas = 0;
        for (Localidad localidad : localidades) {
            totalVentas += localidad.getPrecio() * localidad.getBoletosVendidos();
        }
        System.out.println("Total de ventas: $" + totalVentas);
    }

    /**
     * Intenta realizar una compra especial usando un código.
     *
     * @param codigo El código especial para la compra.
     */
    public void codigoEspecial(int codigo) {
        if (esFibonacci(codigo)) {
            for (Localidad localidad : localidades) {
                if (localidad.getNumeroLocalidad() == 10) {
                    if (localidad.validarEspacio() && localidad.validarPrecio(20000)) {
                        compradorActivo.comprarBoletos(localidad, 1);
                        System.out.println("¡Compra especial exitosa!");
                        return;
                    } else {
                        System.out.println("Compra especial fallida.");
                        return;
                    }
                }
            }
        } else {
            System.out.println("Código especial no válido.");
        }
    }

    /**
     * Verifica si un número dado es parte de la secuencia de Fibonacci.
     *
     * @param num El número a verificar.
     * @return true si el número es parte de la secuencia de Fibonacci, false en caso contrario.
     */
    private boolean esFibonacci(int num) {
        return secuenciaFibonacci(num, 0, 1);
    }

    /**
     * Verifica si un número dado es parte de la secuencia de Fibonacci.
     *
     * @param num El número a verificar.
     * @param a   El valor anterior en la secuencia de Fibonacci.
     * @param b   El valor actual en la secuencia de Fibonacci.
     * @return true si el número es parte de la secuencia de Fibonacci, false en caso contrario.
     */
    private boolean secuenciaFibonacci(int num, int a, int b) {
        if (b == num) {
            return true;
        } else if (b > num) {
            return false;
        }
        return secuenciaFibonacci(num, b, a + b);
    }
}
