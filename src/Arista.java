class Arista {

    //Clase "Arista" que representa un camino entre dos ubicaciones.

    //Atributos
    private final String destino; //Nombre de la ubicación de llegada
    private final int peso;       //Distancia, en kilómetros, entre dos ubicaciones

    //Métodos
    //Constructor
    public Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    //Getters
    public String getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
}
