package segundoParcialArboles;

import java.util.ArrayList;

public class ListaArbol {
    Arbol arbol;
    ArrayList<Arbol> lista;

    public ListaArbol(int cantidad) {
        lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add(new Arbol());
        }
    }

    public void insertardato(int pos, int x) {
        lista.get(pos).insertar(x);
    }

    public void recinorden(int pos) {
        lista.get(pos).recInOrden();
    }

    //ejer1
    public boolean seEncuentra(int pos, int x) {
        return lista.get(pos).seEncuentra(x);
    }

    //ejer2
    public int cantidad(int pos) {
        return lista.get(pos).cantidad();
    }

    //ejer3
    public int cantTerm(int pos) {
        return lista.get(pos).cantidadTerm();
    }

    //ejer4
    public void mostrarTerm(int pos) {
        lista.get(pos).mostrarTerm();
    }

    //ejer5
    public int sumaEleTerminales(int pos) {
        return lista.get(pos).sumaElementosTerminales();
    }

    public static void main(String[] args) {
        ListaArbol listaArbol = new ListaArbol(3);
        listaArbol.insertardato(0, 100);
        listaArbol.insertardato(0, 80);
        listaArbol.insertardato(0, 90);
        listaArbol.recinorden(0);
    }
}
