import java.util.ArrayList;

public class Producto {

    //Clase "Producto" que representa un álbum de música.
    //Esta clase se representa mediante un nodo de un árbol binario de búsqueda.

    //Atributos
    private String titulo;                          //Título del álbum
    private float precio;                           //Precio unitario del álbum
    private String genero;                          //Género musical del álbum
    private String fechaLanzamiento;                //Año de lanzamiento del álbum
    private int cantidad;                           //Cantidad de álbumes de un mismo título disponibles en el inventario
    private final ArrayList<String> listaImagenes;  //Lista de rutas a las imágenes del álbum
    private Producto izquierdo;                     //Hijo izquierdo
    private Producto derecho;                       //Hijo derecho
    private Producto siguiente;                     //Siguiente producto en la lista enlazada simple

    //Métodos
    //Constructor
    public Producto(String titulo, float precio, String genero, String fechaLanzamiento, int cantidad) {
        this.titulo = titulo;
        this.precio = precio;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.cantidad = cantidad;
        this.listaImagenes = new ArrayList<>();
        this.izquierdo = null;
        this.derecho = null;
        this.siguiente = null;
    }

    public Producto() {
        this.listaImagenes = new ArrayList<>();
        this.izquierdo = null;
        this.derecho = null;
        this.siguiente = null;
    }

    //Getters
    public String getTitulo() {
        return titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public String getGenero() {
        return genero;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<String> getListaImagenes() {
        return listaImagenes;
    }

    public Producto getIzquierdo() {
        return izquierdo;
    }

    public Producto getDerecho() {
        return derecho;
    }

    public Producto getSiguiente() {
        return siguiente;
    }

    //Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setListaImagenes(String ruta){
        listaImagenes.add(ruta);
    }

    public void setIzquierdo(Producto izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(Producto derecho) {
        this.derecho = derecho;
    }

    public void setSiguiente(Producto siguiente) {
        this.siguiente = siguiente;
    }

    //toString()
    public String toString(){
        return "Título del álbum: " + titulo +
                "\nPrecio unitario: " + precio +
                "\nGénero musical: " + genero +
                "\nFecha de lanzamiento: " + fechaLanzamiento +
                "\nCantidad en inventario: " + cantidad +
                "\nImágenes del álbum: " + listaImagenes +
                "\n";
    }
}
