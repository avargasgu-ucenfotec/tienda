public class Cliente implements Comparable<Cliente> {

    //Clase "Cliente" que representa una persona que hace una compra en la tienda en línea.

    //Atributos
    private String nombre;      //Nombre completo del cliente
    private String cedula;      //Número de cédula del cliente
    private int prioridad;      //Grado de prioridad asignado a su atención
    private final Carrito carrito;    //Carrito de compras del cliente

    //Métodos
    //Constructor
    public Cliente(String nombre, String cedula, int prioridad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.prioridad = prioridad;
        this.carrito = new Carrito();
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getPrioridad() {
        return prioridad;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    //Insertar producto al carrito
    public void insertar(Producto producto) {
        carrito.insertarProductoInicio(producto);
    }

    //Mostrar productos del carrito
    public void mostrar() {
        carrito.mostrarLista();
    }

    //Imprimir factura
    public void facturar() {
        carrito.imprimirReporte();
    }

    //toString()
    public String toString(){
        return "\nNombre completo: " + nombre +
                ", Número de cédula: " + cedula +
                ", Prioridad: " + prioridad;
    }

    //compareTo
    public int compareTo(Cliente otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }
}
