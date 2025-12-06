class Vertice {

    //Clase "Vertice" que representa una ubicación en un mapa.

    //Atributos
    private final String nombre;  //Nombre de la ubicación
    private final int distancia;  //Distancia, en kilómetros, entre dos ubicaciones

    //Métodos
    //Constructor
    public Vertice(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getDistancia() {
        return distancia;
    }
}
