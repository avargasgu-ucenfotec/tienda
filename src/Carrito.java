public class Carrito {

    //Clase "Carrito" que representa el carrito de compras de un cliente.
    //Esta clase se representa mediante una lista enlazada simple.

    //Atributos
    private Producto primero;

    //Métodos
    //Constructor
    public Carrito() {
        this.primero = null;
    }

    //Getters
    public Producto getPrimero() {
        return primero;
    }

    //Setters
    public void setPrimero(Producto primero) {
        this.primero = primero;
    }

    //Insertar producto al carrito
    public void insertarProductoInicio(Producto producto) {
        producto.setSiguiente(primero);
        setPrimero(producto);
    }

    //Imprimir productos del carrito
    public void mostrarLista(){
        if(primero == null){
            System.out.println("Carrito vacío.\n");
            return;
        }
        Producto productoActual = primero;
        while(productoActual != null){
            System.out.println(productoActual);
            productoActual = productoActual.getSiguiente();
        }
    }

    //Imprimir factura
    public void imprimirReporte(){
        String tablaSuperior = "| %-40s | %-10.1f | %-8d | %-10.1f |%n";
        String tablaSeparador = "+------------------------------------------+------------+----------+------------+%n";
        String tablaInferior = "| %-40s | %-10s | %-8s | %-10.1f |%n";
        String tablaTitulos = "| Título                                   | Precio     | Cantidad | Total      |%n";
        String tablaEncabezado = "| Factura                                  |            |          |            |%n";
        System.out.format(tablaSeparador);
        System.out.format(tablaEncabezado);
        System.out.format(tablaSeparador);
        System.out.format(tablaTitulos);
        System.out.format(tablaSeparador);
        if(primero == null){
            System.out.format(tablaSuperior, "N/A", 0.0f, 0, 0.0f);
            System.out.format(tablaSeparador);
            System.out.format(tablaInferior, "", "", "", 0.0f);
            System.out.format(tablaSeparador);
            return;
        }
        float contadorProducto;
        float contadorTotal = 0.0f;
        Producto productoActual = primero;
        while(productoActual != null){
            contadorProducto = productoActual.getCantidad() * productoActual.getPrecio();
            System.out.format(
                    tablaSuperior,
                    productoActual.getTitulo(),
                    productoActual.getPrecio(),
                    productoActual.getCantidad(),
                    contadorProducto
            );
            productoActual = productoActual.getSiguiente();
            contadorTotal += contadorProducto;
        }
        System.out.format(tablaSeparador);
        System.out.format(tablaInferior, "", "", "", contadorTotal);
        System.out.format(tablaSeparador);
    }
}
