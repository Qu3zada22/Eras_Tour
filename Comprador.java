public class Comprador {
    private String nombre;
    private String email;
    private int presupuesto;
    private int boletosComprados;

    public Comprador(String nombre, String email, int presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public int getBoletosComprados() {
        return boletosComprados;
    }

    public void comprarBoletos(Localidad localidad, int cantidad) {
        localidad.venderBoletos(cantidad);
        boletosComprados += cantidad;
        presupuesto -= localidad.getPrecio() * cantidad;
    }
}
