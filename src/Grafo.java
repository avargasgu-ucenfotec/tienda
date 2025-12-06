import java.util.*;

public class Grafo {

    //Clase "Grafo" que representa ubicaciones en un mapa.

    //Atributos
    private final Map<String, List<Arista>> listaAdyacencia;

    //Métodos
    //Constructor
    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    //Funcionales
    public void agregarVertice(String vertice) {
        listaAdyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino, int peso) {
        listaAdyacencia.putIfAbsent(origen, new ArrayList<>());
        listaAdyacencia.putIfAbsent(destino, new ArrayList<>());
        listaAdyacencia.get(origen).add(new Arista(destino, peso));
        listaAdyacencia.get(destino).add(new Arista(origen, peso));
    }

    public void mostrarGrafo() {
        for (Map.Entry<String, List<Arista>> entry : listaAdyacencia.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Arista arista : entry.getValue()) {
                System.out.print(arista.getDestino() + " ");
            }
            System.out.println();
        }
    }

    public void algoritmoDijkstra(String inicio, Map<String, Integer> distancias, Map<String, String> predecesores) {
        //Inicializa cola de prioridad (funcionalidad min-heap) para explorar los vértices
        PriorityQueue<Vertice> colaVertices = new PriorityQueue<>(Comparator.comparingInt(Vertice::getDistancia));

        //Inicialización
        for (String vertice : listaAdyacencia.keySet()) {
            distancias.put(vertice, Integer.MAX_VALUE); //Distancias son infinitas por defecto
            predecesores.put(vertice, null);
        }

        distancias.put(inicio, 0);  //Distancia al vértice de inicio es 0 por defecto
        colaVertices.add(new Vertice(inicio, 0));

        while (!colaVertices.isEmpty()) {
            Vertice v = colaVertices.poll();
            String verticeActual = v.getNombre();

            //Explorar todos los vecinos
            for (Arista arista : listaAdyacencia.get(verticeActual)) {
                String vecino = arista.getDestino();
                int nuevaDistancia = distancias.get(verticeActual) + arista.getPeso();

                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia);
                    predecesores.put(vecino, verticeActual);
                    colaVertices.add(new Vertice(vecino, nuevaDistancia));
                }
            }
        }
    }

    public List<String> reconstruirCamino(String inicio, String destino, Map<String, String> predecesores) {
        List<String> camino = new ArrayList<>();

        for (String verticeActual = destino; verticeActual != null; verticeActual = predecesores.get(verticeActual)) {
            camino.add(verticeActual);
        }

        Collections.reverse(camino);
        if (camino.get(0).equals(inicio)) {
            return camino;
        }

        return new ArrayList<>();
    }
}
