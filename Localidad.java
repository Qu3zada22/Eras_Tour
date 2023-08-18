public class Localidad {
    private int numeroLocalidad;
    private int precio;
    private int espacioDisponible;
    private int boletosVendidos;

    public Localidad(int numeroLocalidad, int precio, int espacioDisponible) {
        this.numeroLocalidad = numeroLocalidad;
        this.precio = precio;
        this.espacioDisponible = espacioDisponible;
    }

    public int getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getEspacioDisponible() {
        return espacioDisponible;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public boolean validarEspacio() {
        return espacioDisponible > 0;
    }

    public boolean validarDisponibilidad(int cantidad) {
        return espacioDisponible >= cantidad;
    }

    public boolean validarPrecio(int presupuesto) {
        return precio <= presupuesto;
    }

    public void venderBoletos(int cantidad) {
        espacioDisponible -= cantidad;
        boletosVendidos += cantidad;
    }
}

