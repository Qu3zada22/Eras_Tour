/**
 * Esta clase representa a un comprador que puede comprar boletos de localidades.
 */
public class Comprador {
    private String nombre;          // Nombre del comprador
    private String email;           // Correo electrónico del comprador
    private int presupuesto;        // Presupuesto disponible del comprador
    private int boletosComprados;   // Cantidad de boletos comprados por el comprador

    /**
     * Constructor para crear un objeto Comprador con la información básica.
     *
     * @param nombre     El nombre del comprador.
     * @param email      El correo electrónico del comprador.
     * @param presupuesto El presupuesto disponible del comprador.
     */
    public Comprador(String nombre, String email, int presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.presupuesto = presupuesto;
    }

    /**
     * Obtiene el nombre del comprador.
     *
     * @return El nombre del comprador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el correo electrónico del comprador.
     *
     * @return El correo electrónico del comprador.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene el presupuesto disponible del comprador.
     *
     * @return El presupuesto disponible del comprador.
     */
    public int getPresupuesto() {
        return presupuesto;
    }

    /**
     * Obtiene la cantidad de boletos que el comprador ha comprado.
     *
     * @return La cantidad de boletos comprados por el comprador.
     */
    public int getBoletosComprados() {
        return boletosComprados;
    }

    /**
     * Realiza la compra de boletos de una localidad específica.
     *
     * @param localidad La localidad de la cual se comprarán los boletos.
     * @param cantidad  La cantidad de boletos a comprar.
     */
    public void comprarBoletos(Localidad localidad, int cantidad) {
        localidad.venderBoletos(cantidad);
        boletosComprados += cantidad;
        presupuesto -= localidad.getPrecio() * cantidad;
    }
}
