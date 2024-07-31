package tercerParcialGrafos;

public class Arco {
    public int elem;
    public Nodo pDest;
    public Arco prox;

    public Arco(Nodo pDest, int elem){
        this.pDest = pDest;
        this.elem = elem;
        prox = null;
    }
}
