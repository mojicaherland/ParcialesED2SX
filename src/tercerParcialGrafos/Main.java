package tercerParcialGrafos;

public class Main {
    public static void main(String[] args) {
        /*
         HAY MAS CODIGOS
         DE GRAFOS EN LA CARPETA GRAFOS DE
         ED2VargasPracticas
        */
        Grafo grafo = new Grafo();

        grafo.insertarNodo("A");
        grafo.insertarNodo("B");
        grafo.insertarArco("A", "B", 2);
        grafo.insertarArco("D", "E", 1);
        grafo.mostrarGrafo();
        //System.out.println(grafo.cantidadArcos());
    }
}
