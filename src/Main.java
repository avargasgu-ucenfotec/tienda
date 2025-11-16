import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void menuPrincipal(Tienda tienda) throws Exception {
        byte opcion = -1;

        do {
            System.out.println("\n --- Menú principal ---");
            System.out.println("[ 1] Insertar producto al inventario");
            System.out.println("[ 2] Insertar cliente a la cola");
            System.out.println("[ 3] Atender cliente");
            System.out.println("[ 4] Imprimir estado de la tienda");
            System.out.println("[ 0] Salir");
            System.out.print("\nSeleccione una opción del menú: ");
            try {
                opcion = Byte.parseByte(leerTexto());
            } catch (Exception e) {
                System.out.println("Lo sentimos, estamos experimentando problemas técnicos.");
            }
            procesarOpcion(opcion, tienda);
        } while (opcion != 0);
    }

    public static String leerTexto() throws IOException {
        return in.readLine();
    }

    public static void procesarOpcion(byte opcion, Tienda tienda) throws Exception {
        boolean debug = false;

        if (debug) {
            //Insertar productos al inventario
            tienda.getInventario().insertar("Sgt. Pepper's Lonely Hearts Club Band", 10077.1f, "Rock", "1967", 10);
            tienda.getInventario().insertar("Thriller", 19635.0f, "Pop", "1982", 15);
            tienda.getInventario().insertar("Nevermind", 7052.5f, "Grunge", "1991", 20);
            tienda.getInventario().insertar("The Number of the Beast", 5500.9f, "Metal", "1982", 5);
            tienda.getInventario().insertar("Kind of Blue", 3000.7f, "Jazz", "1959", 35);
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

    public static void main(String[] args) throws Exception {

        //Inicializar tienda
        Tienda miTienda = new Tienda();

        //Ejecutar el menú principal
        menuPrincipal(miTienda);
    }
}