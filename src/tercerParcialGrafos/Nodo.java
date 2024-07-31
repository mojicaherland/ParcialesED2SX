package tercerParcialGrafos;

public class Nodo {
    public String name;
    public Nodo prox;
    public Arco prim;
    public Arco ult;
    public int cantArcos;

    public Nodo(String name){
        this.name = name;
        prox = null;
        prim = ult = null;
        cantArcos = 0;
    }
    public void insertarUlt(Nodo pDest, int valor){
        if (prim == null && ult == null) {
            prim = ult = new Arco(pDest,valor);
        }else{
            ult.prox = new Arco(pDest, valor);
            ult = ult.prox;
        }
        cantArcos++;
    }
}
