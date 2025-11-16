public class Tienda {

    //Clase "Tienda" que representa la tienda en línea.

    //Atributos
    private final Inventario inventario;
    private final ColaPrioridad cola;

    //Métodos
    //Constructor
    public Tienda() {
        this.inventario = new Inventario();
        this.cola = new ColaPrioridad();
    }

    //Getters
    public Inventario getInventario() {
        return inventario;
    }

    public ColaPrioridad getCola() {
        return cola;
    }
}
