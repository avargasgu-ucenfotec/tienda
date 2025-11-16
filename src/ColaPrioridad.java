import java.util.PriorityQueue;

public class ColaPrioridad {

    //Clase "ColaPrioridad" que representa la cola de clientes esperando a ser atendidos en la tienda en línea.

    //Atributos
    private final PriorityQueue<Cliente> cola;

    //Métodos
    //Constructor
    public ColaPrioridad() {
        cola = new PriorityQueue<>();
    }

    //Agregar cliente a la cola
    public void agregarCliente(Cliente cliente) {
        cola.add(cliente);
    }

    //Agregar cliente a la cola
    public void agregarCliente(String nombre, String cedula, int prioridad) {
        Cliente cliente = new Cliente(nombre, cedula, prioridad);
        cola.add(cliente);
    }

    //Remover cliente de la cola
    public void removerCliente(Cliente cliente) {
        cola.remove(cliente);
    }

    //Acceder al siguiente cliente en la cola a ser atendido
    public String accederCliente() {
        if (cola.peek() != null) {
            return cola.peek().getNombre();
        } else
            return "No hay clientes en la cola.";
    }

    //Retornar el siguiente cliente en la cola a ser atendido
    public Cliente retornarCliente() {
        if (cola.peek() != null) {
            return cola.poll();
        } else {
            System.out.println("No hay clientes en la cola.");
            return null;
        }
    }

    //Imprimir cola de clientes
    public void imprimirCola() {
        System.out.print("Clientes en espera: ");
        System.out.println(cola);
        System.out.print("Siguiente cliente a ser atendido: ");
        System.out.println(accederCliente());
    }
}
