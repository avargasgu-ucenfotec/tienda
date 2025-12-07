public class Tienda {

    //Clase "Tienda" que representa la tienda en línea.

    //Atributos
    private final Inventario inventario;
    private final ColaPrioridad cola;
    private String ubicacion;

    //Métodos
    //Constructor
    public Tienda() {
        this.inventario = new Inventario();
        this.cola = new ColaPrioridad();
        this.ubicacion = "";
    }

    //Getters
    public Inventario getInventario() {
        return inventario;
    }

    public ColaPrioridad getCola() {
        return cola;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    //Setters
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
