public class Inventario {

    //Clase "Inventario" que representa todos los álbumes de música disponibles para la venta.
    //Esta clase se representa mediante un árbol binario de búsqueda.

    //Atributos
    private Producto raiz;

    //Métodos
    //Constructor
    public Inventario() {
        this.raiz = null;
    }

    //Insertar producto al inventario
    public void insertar(String titulo, float precio, String genero, String fechaLanzamiento, int cantidad) {
        raiz = insertarProducto(raiz, titulo, precio, genero, fechaLanzamiento, cantidad);
    }

    public Producto insertarProducto(Producto raiz, String titulo, float precio, String genero, String fechaLanzamiento, int cantidad) {
        if (raiz == null) {
            raiz = new Producto(titulo, precio, genero, fechaLanzamiento, cantidad);
            return raiz;
        }
        int comparar = titulo.compareTo(raiz.getTitulo());
        if (comparar < 0)
            raiz.setIzquierdo(insertarProducto(raiz.getIzquierdo(), titulo, precio, genero, fechaLanzamiento, cantidad));
        else if (comparar > 0)
            raiz.setDerecho(insertarProducto(raiz.getDerecho(), titulo, precio, genero, fechaLanzamiento, cantidad));

        return raiz;
    }

    //Buscar producto en el inventario
    public boolean buscar(String titulo) {
        return buscarProducto(raiz, titulo);
    }

    public boolean buscarProducto(Producto raiz, String titulo) {
        if (raiz == null)
            return false;
        if (raiz.getTitulo().equals(titulo))
            return true;
        int comparar = raiz.getTitulo().compareTo(titulo);
        if (comparar < 0)
            return buscarProducto(raiz.getDerecho(), titulo);
        return buscarProducto(raiz.getIzquierdo(), titulo);
    }

    //Retornar producto en el inventario
    public Producto retornar(String titulo) {
        return retornarProducto(raiz, titulo);
    }

    public Producto retornarProducto(Producto raiz, String titulo) {
        if (raiz == null)
            return null;
        if (raiz.getTitulo().equals(titulo))
            return raiz;
        int comparar = raiz.getTitulo().compareTo(titulo);
        if (comparar < 0)
            return retornarProducto(raiz.getDerecho(), titulo);
        return retornarProducto(raiz.getIzquierdo(), titulo);
    }

    //Imprimir todos los productos del inventario
    public void imprimir() {
        if (raiz == null) {
            System.out.println("Inventario vacío.\n");
            System.out.println("\n");
        }
        imprimirInventario(raiz);
        System.out.println("\n");
    }

    public void imprimirInventario(Producto raiz) {
        if (raiz != null) {
            imprimirInventario(raiz.getIzquierdo());
            imprimirInventario(raiz.getDerecho());
            System.out.print(raiz.getTitulo() + ", ");
        }
    }

    //Imprimir reporte de costos totales
    public void reportar() {
        String tablaSuperior = "| %-40s | %-10.1f | %-8d | %-10.1f |%n";
        String tablaSeparador = "+------------------------------------------+------------+----------+------------+%n";
        String tablaTitulos = "| Título                                   | Precio     | Cantidad | Total      |%n";
        String tablaEncabezado = "| Inventario                               |            |          |            |%n";
        System.out.format(tablaSeparador);
        System.out.format(tablaEncabezado);
        System.out.format(tablaSeparador);
        System.out.format(tablaTitulos);
        System.out.format(tablaSeparador);
        if (raiz == null) {
            System.out.format(tablaSuperior, "N/A", 0.0f, 0, 0.0f);
        }
        reportarInventario(raiz);
        System.out.format(tablaSeparador);
        System.out.print("\n");
    }

    public void reportarInventario(Producto raiz) {
        String tablaSuperior = "| %-40s | %-10.1f | %-8d | %-10.1f |%n";
        float contadorProducto;
        if (raiz != null) {
            reportarInventario(raiz.getIzquierdo());
            reportarInventario(raiz.getDerecho());
            contadorProducto = raiz.getCantidad() * raiz.getPrecio();
            System.out.format(tablaSuperior, raiz.getTitulo(), raiz.getPrecio(), raiz.getCantidad(), contadorProducto);
        }
    }

    //Imprimir toda la información de un producto del inventario
    public void detalle(String titulo) {
        detalleProducto(raiz, titulo);
    }

    public void detalleProducto(Producto raiz, String titulo) {
        if (raiz == null) {
            System.out.println("El álbum " + titulo + " no está en el inventario.\n");
            return;
        }
        if (raiz.getTitulo().equals(titulo)) {
            System.out.println(raiz);
            return;
        }
        int comparar = raiz.getTitulo().compareTo(titulo);
        if (comparar < 0) {
            detalleProducto(raiz.getDerecho(), titulo);
        } else {
            detalleProducto(raiz.getIzquierdo(), titulo);
        }
    }

    //Agregar ruta de imágenes a un producto
    public void agregar(String titulo, String ruta) {
        agregarRuta(raiz, titulo, ruta);
    }

    public void agregarRuta(Producto raiz, String titulo, String ruta) {
        if (raiz == null) {
            System.out.println("El álbum " + titulo + " no está en el inventario.\n");
            return;
        }
        if (raiz.getTitulo().equals(titulo)) {
            raiz.setListaImagenes(ruta);
            return;
        }
        int comparar = raiz.getTitulo().compareTo(titulo);
        if (comparar < 0) {
            agregarRuta(raiz.getDerecho(), titulo, ruta);
        } else {
            agregarRuta(raiz.getIzquierdo(), titulo, ruta);
        }
    }
}
