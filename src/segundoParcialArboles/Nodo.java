package segundoParcialArboles;

public class Nodo {
    public int elem;
    public Nodo izq;
    public Nodo der;

    public Nodo(int elem){
        this.elem = elem;
        this.izq = null;
        this.der = null;
    }
}
