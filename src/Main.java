import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void menuPrincipal(Tienda tienda, Grafo grafo) throws Exception {
        byte opcion = -1;

        do {
            System.out.println("\n --- Menú principal ---");
            System.out.println("[ 1] Insertar producto al inventario");
            System.out.println("[ 2] Insertar cliente a la cola");
            System.out.println("[ 3] Atender cliente");
            System.out.println("[ 4] Imprimir estado de la tienda");
            System.out.println("[ 5] Insertar ubicación");
            System.out.println("[ 6] Insertar camino entre dos ubicaciones");
            System.out.println("[ 7] Imprimir rutas");
            System.out.println("[ 0] Salir");
            System.out.print("\nSeleccione una opción del menú: ");
            try {
                opcion = Byte.parseByte(leerTexto());
            } catch (Exception e) {
                System.out.println("Lo sentimos, estamos experimentando problemas técnicos.");
            }
            procesarOpcion(opcion, tienda, grafo);
        } while (opcion != 0);
    }

    public static String leerTexto() throws IOException {
        return in.readLine();
    }

    public static void procesarOpcion(byte opcion, Tienda tienda, Grafo grafo) throws Exception {
        boolean debug = true;

        if (debug) {
            //Insertar productos al inventario
            tienda.getInventario().insertar("Sgt. Pepper's Lonely Hearts Club Band", 10077.1f, "Rock", "1967", 10);
            tienda.getInventario().insertar("Thriller", 19635.0f, "Pop", "1982", 15);
            tienda.getInventario().insertar("Nevermind", 7052.5f, "Grunge", "1991", 20);
            tienda.getInventario().insertar("The Number of the Beast", 5500.9f, "Metal", "1982", 5);
            tienda.getInventario().insertar("Kind of Blue", 3000.7f, "Jazz", "1959", 35);

            //Agregar vértices
            grafo.agregarVertice("San José");
            grafo.agregarVertice("Alajuela");
            grafo.agregarVertice("Cartago");
            grafo.agregarVertice("Heredia");
            grafo.agregarVertice("Guanacaste");

            //Agregar aristas
            grafo.agregarArista("San José", "Alajuela", 17);
            grafo.agregarArista("San José", "Cartago", 40);
            grafo.agregarArista("Alajuela", "Cartago", 60);
            grafo.agregarArista("Alajuela", "Heredia", 10);
            grafo.agregarArista("Cartago", "Heredia", 49);
            grafo.agregarArista("Cartago", "Guanacaste", 197);
            grafo.agregarArista("Heredia", "Guanacaste", 147);
        }

        switch (opcion) {
            case 1:
                insertarProducto(tienda);
                break;
            case 2:
                insertarCliente(tienda);
                break;
            case 3:
                atenderCliente(tienda);
                break;
            case 4:
                tienda.getInventario().reportar();
                tienda.getCola().imprimirCola();
                break;
            case 5:
                insertarVertice(grafo);
                break;
            case 6:
                insertarArista(grafo);
                break;
            case 7:
                grafo.mostrarGrafo();
                break;
            case 0:
                System.out.println("Cerrando el programa...");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public static void insertarProducto(Tienda tienda) throws Exception {
        String titulo;
        float precio;
        String genero;
        String fechaLanzamiento;
        int cantidad;

        System.out.print("Ingrese el título del álbum: ");
        titulo = leerTexto();
        System.out.print("Ingrese el precio unitario del álbum: ");
        precio = Float.parseFloat(leerTexto());
        System.out.print("Ingrese el género musical del álbum: ");
        genero = leerTexto();
        System.out.print("Ingrese la fecha de lanzamiento del álbum: ");
        fechaLanzamiento = leerTexto();
        System.out.print("Ingrese la cantidad de unidades del álbum: ");
        cantidad = Integer.parseInt(leerTexto());

        tienda.getInventario().insertar(titulo, precio,genero, fechaLanzamiento, cantidad);
    }

    public static void insertarCliente(Tienda tienda) throws Exception {
        String nombre;
        String cedula;
        int prioridad;

        String nombreAlbum;
        int cantidad;

        String opcion;

        //Obtener los detalles del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        nombre = leerTexto();
        System.out.print("Ingrese el número de cédula del cliente: ");
        cedula = leerTexto();
        System.out.print("Ingrese la prioridad del cliente [1/2/3]: ");
        prioridad = Integer.parseInt(leerTexto());

        //Instanciar cliente
        Cliente cliente = new Cliente(nombre, cedula, prioridad);

        //Obtener lo detalles de la compra del cliente
        do {
            System.out.print("Ingrese el nombre de álbum que desea agregar al carrito: ");
            nombreAlbum = leerTexto();
            System.out.print("Ingrese la cantidad de álbumes que desea adquirir: ");
            cantidad = Integer.parseInt(leerTexto());

            //Instanciar producto que se agrega al carrito de compras
            Producto producto = new Producto(nombreAlbum,
                    tienda.getInventario().retornar(nombreAlbum).getPrecio(),
                    tienda.getInventario().retornar(nombreAlbum).getGenero(),
                    tienda.getInventario().retornar(nombreAlbum).getFechaLanzamiento(),
                    cantidad);

            //Insertar producto al carrito de compras del cliente
            cliente.insertar(producto);

            //Actualizar inventario
            int cantidadActual = tienda.getInventario().retornar(nombreAlbum).getCantidad();
            tienda.getInventario().retornar(nombreAlbum).setCantidad(cantidadActual - cantidad);

            System.out.print("¿Desea agregar otro producto a su carrito de compras? [si/no] ");
            opcion = leerTexto();

        } while (opcion.equals("si"));

        //Insertar cliente a la cola
        tienda.getCola().agregarCliente(cliente);
    }

    public static void atenderCliente(Tienda tienda) {
        System.out.print("Atendiendo al cliente: ");
        System.out.println(tienda.getCola().accederCliente());

        Cliente cliente = tienda.getCola().retornarCliente();

        cliente.facturar();
    }

    public static void insertarVertice(Grafo grafo) throws Exception {
        String vertice;

        System.out.print("Ingrese el nombre de la ubicación: ");
        vertice = leerTexto();

        grafo.agregarVertice(vertice);
    }

    public static void insertarArista(Grafo grafo) throws Exception {
        String origen;
        String destino;
        int peso;

        System.out.print("Ingrese el nombre de la ubicación origen: ");
        origen = leerTexto();
        System.out.print("Ingrese el nombre de la ubicación destino: ");
        destino = leerTexto();
        System.out.print("Ingrese la distancia entre ambas ubicaciones: ");
        peso = Integer.parseInt(leerTexto());

        grafo.agregarArista(origen, destino, peso);
    }

    public static void main(String[] args) throws Exception {

        //Inicializar tienda
        Tienda miTienda = new Tienda();

        //Inicializar grafo
        Grafo miGrafo = new Grafo();

        //Ejecutar el menú principal
        menuPrincipal(miTienda, miGrafo);
    }
}