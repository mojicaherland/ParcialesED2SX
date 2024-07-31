package primerParcialArraySimpleDoble.listaVector;

public class ListaVector {
    private int max;
    private int cantElement;
    private int[] arreglo;

    //Constructor
    public ListaVector(int max) {
        this.max = max;
        this.cantElement = 0;
        this.arreglo = new int[max];
    }

    //imprimir la lista
    public String toString() {
        String s1 = "[";
        int i = 0;
        while (i < this.cantElement) {
            if (i == this.cantElement - 1) {
                s1 = s1 + this.arreglo[i];
            } else {
                s1 = s1 + this.arreglo[i] + ", ";
            }
            i++;
        }
        return s1 + "]";
    }

    //Metodos Esenciales

    //1.metodo para insertar un elemento en la posicion i de la lista
    public void insertarIesimo(int x, int i) {
        int k = this.cantElement - 1;//ultima pos
        while (k >= i) {
            this.arreglo[k + 1] = this.arreglo[k];
            k--;
        }
        this.arreglo[i] = x;
        this.cantElement++;
    }

    //2.metodo para insertar en la primera posicion
    public void insertarPrimero(int x) {
        insertarIesimo(x, 0);
    }

    //3.metodo para insertar en la ultima posicion
    public void insertarUltimo(int x) {
        insertarIesimo(x, this.cantElement);
    }

    //4.metodo para eliminar el elemento de la posicion i
    public void eliminarIesimo(int i) {
        int k = i + 1;
        while (k < this.cantElement) {
            this.arreglo[k - 1] = this.arreglo[k];
            k++;
        }
        this.cantElement--;
    }

    //5.metodo para eliminar el primer elemento de la lista
    public void eliminarPrimero() {
        this.eliminarIesimo(0);
    }

    //6.metodo para eliminar el ultimo elemento de la lista
    public void eliminarUltimo() {
        this.eliminarIesimo(this.cantElement - 1);
    }

    //Metodos para practicar para mi parcial

    //1.metodo que elimina todos los elementos repetidos de la lista
    public void eliminarTodoRepetidos(int x) {
        int i = 0;
        while (i < this.cantElement - 1) {
            if (this.arreglo[i] == x) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //2.metodo para eliminar pares
    public void eliminarPares() {
        int i = 0;
        while (i < this.cantElement - 1) {
            if (this.arreglo[i] % 2 == 0) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //3.metodo para insertar los elementos de la l2 al principio de la l1
    public void insertarPrim(ListaVector l2) {
        for (int i = l2.cantElement - 1; i >= 0; i--) {
            this.insertarPrimero(l2.arreglo[i]);
        }
    }

    //4.metodo para insertar los elementos de la l2 al final de la l1
    public void insertarUlt(ListaVector l2) {
        for (int i = 0; i < l2.cantElement; i++) {
            this.insertarUltimo(l2.arreglo[i]);
        }
    }

    //5.metodo para insertar los elementos de la l2 desde una posicion especifica
    public void insertarIesimo2(ListaVector l2, int i) {
        int j = 0;
        while (j < l2.cantElement) {
            this.insertarIesimo(l2.arreglo[j], i);
            j++;
        }
    }
}
