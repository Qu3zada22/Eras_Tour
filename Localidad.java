/**
 * Esta clase representa una localidad de eventos donde se venden boletos.
 */
public class Localidad {
    private int numeroLocalidad;      // Número identificador de la localidad
    private int precio;               // Precio de los boletos en esta localidad
    private int espacioDisponible;    // Espacio disponible para boletos en esta localidad
    private int boletosVendidos;      // Cantidad de boletos vendidos en esta localidad

    /**
     * Constructor para crear una nueva localidad.
     *
     * @param numeroLocalidad   El número identificador de la localidad.
     * @param precio            El precio de los boletos en esta localidad.
     * @param espacioDisponible El espacio disponible para boletos en esta localidad.
     */
    public Localidad(int numeroLocalidad, int precio, int espacioDisponible) {
        this.numeroLocalidad = numeroLocalidad;
        this.precio = precio;
        this.espacioDisponible = espacioDisponible;
    }

    /**
     * Obtiene el número identificador de la localidad.
     *
     * @return El número identificador de la localidad.
     */
    public int getNumeroLocalidad() {
        return numeroLocalidad;
    }

    /**
     * Obtiene el precio de los boletos en esta localidad.
     *
     * @return El precio de los boletos en esta localidad.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Obtiene el espacio disponible para boletos en esta localidad.
     *
     * @return El espacio disponible para boletos en esta localidad.
     */
    public int getEspacioDisponible() {
        return espacioDisponible;
    }

    /**
     * Obtiene la cantidad de boletos vendidos en esta localidad.
     *
     * @return La cantidad de boletos vendidos en esta localidad.
     */
    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    /**
     * Valida si hay espacio disponible para más boletos en esta localidad.
     *
     * @return true si hay espacio disponible, false en caso contrario.
     */
    public boolean validarEspacio() {
        return espacioDisponible > 0;
    }

    /**
     * Valida si hay suficiente espacio disponible para la cantidad especificada de boletos.
     *
     * @param cantidad La cantidad de boletos a validar.
     * @return true si hay suficiente espacio disponible, false en caso contrario.
     */
    public boolean validarDisponibilidad(int cantidad) {
        return espacioDisponible >= cantidad;
    }

    /**
     * Valida si el precio de la localidad es aceptable para el presupuesto dado.
     *
     * @param presupuesto El presupuesto del comprador.
     * @return true si el precio es aceptable, false en caso contrario.
     */
    public boolean validarPrecio(int presupuesto) {
        return precio <= presupuesto;
    }

    /**
     * Vende la cantidad especificada de boletos en esta localidad.
     *
     * @param cantidad La cantidad de boletos a vender.
     */
    public void venderBoletos(int cantidad) {
        espacioDisponible -= cantidad;
        boletosVendidos += cantidad;
    }
}
