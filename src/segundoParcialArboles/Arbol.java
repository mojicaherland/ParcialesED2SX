package segundoParcialArboles;

import java.util.List;

public class Arbol {
    public Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    //insertar
    public void insertar(int x) {
        raiz = insertarRecursivo(raiz, x);
    }

    private Nodo insertarRecursivo(Nodo nodo, int x) {
        if (nodo == null) {
            return new Nodo(x);
        }
        if (x < nodo.elem) {
            nodo.izq = insertarRecursivo(nodo.izq, x);
        } else {
            nodo.der = insertarRecursivo(nodo.der, x);
        }
        return nodo;
    }

    //recorrido Inorden
    public void recInOrden() {
        recInOrdenRecursivo(raiz);
    }

    private void recInOrdenRecursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        recInOrdenRecursivo(nodo.izq);
        System.out.print(nodo.elem + " ");
        recInOrdenRecursivo(nodo.der);
    }

    //ejer1 --> se encuentra
    public boolean seEncuentra(int x) {
        return seEncuentraRecursivo(raiz, x);
    }

    private boolean seEncuentraRecursivo(Nodo nodo, int x) {
        if (nodo == null) {
            return false;
        }
        if (nodo.elem == x) {
            return true;
        }
        if (x < nodo.elem) {
            return seEncuentraRecursivo(nodo.izq, x);
        } else {
            return seEncuentraRecursivo(nodo.der, x);
        }
    }

    //2 --> metodo de que devuelve la cantidad de nodos en el arbol
    public int cantidad() {
        return cantidadRecursivo(raiz);
    }

    private int cantidadRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return cantidadRecursivo(nodo.izq) + cantidadRecursivo(nodo.der) + 1;
    }

    //3-> metodo que devuelve la cantidad de nodo terminales en el arbol
    public int cantidadTerm() {
        return cantidadTermRecursivo(raiz);
    }

    private int cantidadTermRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if ((nodo.izq == null) && (nodo.der == null)) {
            return 1;
        }
        return cantidadTermRecursivo(nodo.izq) + cantidadTermRecursivo(nodo.der);
    }

    //4 -> mostrar los nodos terminales de mayor a menor
    public void mostrarTerm() {
        mostrarTermRecursivo(raiz);
    }

    private void mostrarTermRecursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        mostrarTermRecursivo(nodo.der);
        System.out.print(nodo.elem + " ");
        mostrarTermRecursivo(nodo.izq);
    }

    //5 --> sumar los elementos de los nodos terminales
    public int sumaElementosTerminales() {
        return sumaElementosTerminalesRecursivo(raiz);
    }

    private int sumaElementosTerminalesRecursivo(Nodo nodo) {
        int suma = 0;
        if (nodo == null) {
            return 0;
        }
        if ((nodo.izq == null) && (nodo.der == null)) {
            suma = suma + nodo.elem;
        } else {
            suma = suma + sumaElementosTerminalesRecursivo(nodo.izq) + sumaElementosTerminalesRecursivo(nodo.der);
        }
        return suma;
    }

    //Eliminar
    public void eliminar(int x) { //eliminar un elemento del nodo
        this.raiz = eliminarRecursivo(raiz, x);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int x) {
        if (nodo == null) {
            return null;
        }
        if (x == nodo.elem) {
            return eliminarNodo(nodo);
        }
        if (x < nodo.elem) {
            nodo.izq = eliminarRecursivo(nodo, x);
        } else {
            nodo.der = eliminarRecursivo(nodo, x);
        }
        return nodo;
    }

    public Nodo eliminarNodo(Nodo nodo) {
        if (nodo.izq == null && nodo.der == null) {
            return null;
        }
        if (nodo.izq != null && nodo.der == null) {
            return nodo.izq;
        }
        if (nodo.izq == null && nodo.der != null) {
            return nodo.der;
        }
        Nodo q = nodo.izq;
        while (q.der != null) {
            q = q.der;
        }
        int y = q.elem;
        eliminar(y);
        nodo.elem = y;
        return nodo;
    }

    private Nodo buscarNodo(Nodo nodo, int x) {
        if (nodo == null || nodo.elem == x) {
            return nodo;
        }
        if (x < nodo.elem) {
            return buscarNodo(nodo.izq, x);
        } else {
            return buscarNodo(nodo.der, x);
        }
    }
    /*
    * A1.eliminarHojas() : Método que elimina los nodos hoja de árbol A1.
      A1.eliminarPares() : Método que elimina los elementos pares del árbol A1.
    A1.eliminar(L1) : Método que elimina los elementos de la lista L1 que se encuentran en el árbol A1.
    A1.eliminarMenor(): Método que elimina el elemento menor del árbol A1.
    A1.eliminarMayor(): Método que elimina el elemento mayor del árbol A1.
*/

    //ejer 1
    public void eliminarHojas() {
        raiz = eliminarHojasRecursivo(raiz);
    }

    private Nodo eliminarHojasRecursivo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.izq == null && nodo.der == null) {
            return null;
        }
        nodo.izq = eliminarHojasRecursivo(nodo.izq);
        nodo.der = eliminarHojasRecursivo(nodo.der);
        return nodo;
    }

    //ejer 2
    public void eliminarPares() {
        raiz = eliminarParesRecursivo(raiz);
    }

    private Nodo eliminarParesRecursivo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        nodo.izq = eliminarParesRecursivo(nodo.izq);
        nodo.der = eliminarParesRecursivo(nodo.der);
        if (nodo.elem % 2 == 0) {
            nodo = eliminarNodo(nodo);
        }
        return nodo;
    }
    //ejer 3
    public void eliminarLista(List<Integer> l1){
        for (int x: l1){
            eliminar(x);
        }
    }
    //ejer 4
    public void eliminarMenor() {
        raiz = eliminarMenorRecursivo(raiz);
    }
    private Nodo eliminarMenorRecursivo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.izq == null) {
            return nodo.der;
        }
        nodo.izq = eliminarMenorRecursivo(nodo.izq);
        return nodo;
    }
    //ejer5
    public void eliminarMayor() {
        raiz = eliminarMayorRecursivo(raiz);
    }
    private Nodo eliminarMayorRecursivo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.der == null) {
            return nodo.izq;
        }
        nodo.der = eliminarMayorRecursivo(nodo.der);
        return nodo;
    }
}
