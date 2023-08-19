import java.util.ArrayList;
import java.util.Random;

public class TicketManager {
    private ArrayList<Localidad> localidades;
    private Comprador compradorActivo;

    public TicketManager() {
        localidades = new ArrayList<>();
        localidades.add(new Localidad(1, 100, 20));
        localidades.add(new Localidad(5, 500, 20));
        localidades.add(new Localidad(10, 1000, 20));
    }

    public void nuevoComprador(String nombre, String email, int presupuesto) {
        compradorActivo = new Comprador(nombre, email, presupuesto);
    }

    public void nuevaSolicitudBoletos(int cantidad) {
        if (compradorActivo != null) {
            int ticket = new Random().nextInt(15000) + 1;
            int a = new Random().nextInt(15000) + 1;
            int b = new Random().nextInt(15000) + 1;

            for (Localidad localidad : localidades) {
                if (localidad.validarEspacio() && localidad.validarDisponibilidad(cantidad) &&
                        localidad.validarPrecio(compradorActivo.getPresupuesto())) {
                    if (ticket >= Math.min(a, b) && ticket <= Math.max(a, b)) {
                        compradorActivo.comprarBoletos(localidad, cantidad);
                        System.out.println("¡Compra exitosa!");
                        return;
                    }
                }
            }
            System.out.println("Compra fallida. No cumplió con los requisitos.");
        } else {
            System.out.println("No hay comprador activo. Use la opción 1 para agregar un comprador.");
        }
    }

    public void disponibilidadTotal() {
        for (Localidad localidad : localidades) {
            System.out.println("Localidad " + localidad.getNumeroLocalidad() +
                    ": Boletos vendidos: " + localidad.getBoletosVendidos() +
                    ", Boletos disponibles: " + localidad.getEspacioDisponible());
        }
    }

    public void disponibilidadIndividual(int numeroLocalidad) {
        for (Localidad localidad : localidades) {
            if (localidad.getNumeroLocalidad() == numeroLocalidad) {
                System.out.println("Localidad " + localidad.getNumeroLocalidad() + ": Boletos vendidos: " + localidad.getBoletosVendidos() + ", Boletos disponibles: " + localidad.getEspacioDisponible());
                return;
            }
        }
        System.out.println("Localidad no encontrada.");
    }

    public void reporteCaja() {
        int totalVentas = 0;
        for (Localidad localidad : localidades) {
            totalVentas += localidad.getPrecio() * localidad.getBoletosVendidos();
        }
        System.out.println("Total de ventas: $" + totalVentas);
    }

    public void codigoEspecial(int codigo) {
        if (esFibonacci(codigo)) {
            for (Localidad localidad : localidades) {
                if (localidad.getNumeroLocalidad() == 10) {
                    if (localidad.validarEspacio() && localidad.validarPrecio(20000)) {
                        compradorActivo.comprarBoletos(localidad, 1);
                        System.out.println("¡Compra especial exitosa!");
                        return;
                    } else {
                        System.out.println("Compra especial fallida. No cumple con los requisitos.");
                        return;
                    }
                }
            }
        } else {
            System.out.println("Código especial no válido.");
        }
    }
    
    private boolean esFibonacci(int num) {
        return secuenciaFibonacci(num, 0, 1);
    }
    
    private boolean secuenciaFibonacci(int num, int a, int b) {
        if (b == num) {
            return true;
        } else if (b > num) {
            return false;
        }
        return secuenciaFibonacci(num, b, a + b);
    }
    
}
