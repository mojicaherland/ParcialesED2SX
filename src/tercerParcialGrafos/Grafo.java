package tercerParcialGrafos;

import java.util.LinkedList;

public class Grafo {
    public Nodo prim;
    public Nodo ult;
    public int cantN;

    public Grafo() {
        prim = ult = null;
        cantN = 0;
    }

    public Nodo Buscar(String name) {
        if (prim == null && ult == null) {
            return null;
        } else {

            Nodo p = prim;
            while (p != null) {

                if (p.name == name) {
                    return p;
                }
                p = p.prox;
            }

        }
        return null;
    }

    public boolean seEncuentra(String name) {
        if (prim == null && ult == null) {
            return false;
        } else {

            Nodo p = prim;
            while (p != null) {

                if (p.name == name) {
                    return true;
                }
                p = p.prox;
            }

        }
        return false;
    }

    public void insertarUlt(String name) {
        if (prim == null && ult == null) {
            prim = ult = new Nodo(name);
        } else {
            ult.prox = new Nodo(name);
            ult = ult.prox;
        }
        cantN++;
    }

    public void mostrarGrafo() {
        Nodo p = prim;
        while (p != null) {
            Arco a = p.prim;
            String s = p.name;
            while (a != null) {
                s += "|" + a.elem + "|";
                a = a.prox;
            }
            System.out.println(s);
            p = p.prox;
        }
    }

    public void insertarNodo(String name){
        if (!seEncuentra(name)) {
            insertarUlt(name);
        }
    }

    public void insertarArco(String name1, String name2, int valor){
        Nodo pOrigen = Buscar(name1);
        Nodo pDest = Buscar(name2);

        if (pOrigen == null) {
            insertarNodo(name1);
            insertarArco(name1, name2, valor);
        }
        if (pDest == null) {
            insertarNodo(name2);
            insertarArco(name1, name2, valor);
        }
        pOrigen.insertarUlt(pDest, valor);

    }

    ////////////////////////////////////////

    //1
    public int cantLlegadas(String name) {
        Nodo p = prim;
        int cant = 0;
        while (p != null) {
            Arco a = p.prim;
            while (a != null) {
                if (a.pDest.name == name) {
                    cant++;
                }
                a = a.prox;
            }

            p = p.prox;
        }
        return cant;
    }
    //2
    public void mostrarNodosBucles() {
        Nodo p = prim;
        String name = p.name;

        while (p != null) {
            Arco a = p.prim;
            while (a != null) {
                if (a.pDest.name == name) {
                    System.out.println(p.name);
                }
                a = a.prox;
            }

            p = p.prox;
        }
    }
    //3
    public int mayorArcoValor() {
        Nodo p = prim;
        int may = p.prim.elem;

        while (p != null) {
            Arco a = p.prim;
            while (a != null) {
                if (a.elem > may) {
                    may = a.elem;
                }
                a = a.prox;
            }

            p = p.prox;
        }
        return may;
    }
    //4
    public boolean mismosNodos(Grafo G2) {
        Nodo p = G2.prim;
        while (p != null) {
            if (!this.seEncuentra(p.name)) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
    //5
    public void mostrarNodosIslas() {

        Nodo p = prim;
        while (p != null) {
            if (p.cantArcos == 0 && cantLlegadas(p.name) == 0) {
                System.out.println(p.name);
            }
            p = p.prox;
        }

    }

    //////////////////////////////////////////////////
    public boolean seEncuentra(LinkedList<Nodo> L1, Nodo p) {
        int i = 0;
        while (i <= L1.size() - 1) {
            if (p == L1.get(i)) {
                return true;
            }
            i++;
        }
        return false;
    }
    //1
    public void mostrarCamino(String name1, String name2) {
        Nodo pOrigen = Buscar(name1);
        Nodo pDest = Buscar(name2);

        if (pOrigen == null && pDest == null) {
            return;
        }

        LinkedList<Nodo> L1 = new LinkedList<>();
        L1.add(pOrigen);

        mostrarCamino(L1, pOrigen, pDest);

    }

    private void mostrarCamino(LinkedList<Nodo> L1, Nodo pOrigen, Nodo pDest) {

        if (seEncuentra(L1, pOrigen)) {
            return;
        }

        if (pOrigen == pDest) {
            System.out.println(L1);
        }

        Arco p = pOrigen.prim;
        while (p != null) {
            L1.add(p.pDest);
            mostrarCamino(L1, p.pDest, pDest);
            L1.removeLast();
            p = p.prox;
        }

    }

    //2
    public void longitud(String name1, String name2, int k) {
        Nodo pOrigen = Buscar(name1);
        Nodo pDest = Buscar(name2);

        if (pOrigen == null && pDest == null) {
            return;
        }

        LinkedList<Nodo> L1 = new LinkedList<>();
        L1.add(pOrigen);

        longitud(L1, pOrigen, pDest, k);

    }

    private void longitud(LinkedList<Nodo> L1, Nodo pOrigen, Nodo pDest, int k) {

        if (seEncuentra(L1, pOrigen)) {
            return;
        }

        if (pOrigen == pDest && (L1.size() - 1) <= k) {
            System.out.println(L1);
        }

        Arco p = pOrigen.prim;
        while (p != null) {
            L1.add(p.pDest);
            longitud(L1, p.pDest, pDest, k);
            L1.removeLast();
            p = p.prox;
        }

    }

    //3
    public void costoTotal(String name1, String name2) {
        Nodo pOrigen = Buscar(name1);
        Nodo pDest = Buscar(name2);

        if (pOrigen == null && pDest == null) {
            return;
        }

        LinkedList<Nodo> L1 = new LinkedList<>();
        L1.add(pOrigen);

        costoTotal(L1, 0, pOrigen, pDest);

    }

    private void costoTotal(LinkedList<Nodo> L1, int sum, Nodo pOrigen, Nodo pDest) {

        if (seEncuentra(L1, pOrigen)) {
            return;
        }

        if (pOrigen == pDest) {
            System.out.println(L1 + " Costo Total:" + sum);
        }

        Arco p = pOrigen.prim;
        while (p != null) {
            L1.add(p.pDest);
            costoTotal(L1, sum + p.elem, p.pDest, pDest);
            L1.removeLast();
            p = p.prox;
        }

    }

    //4
    public boolean idaVuelta(String name1, String name2) {
        Nodo pOrigen = Buscar(name1);
        Nodo pDest = Buscar(name2);

        if (pOrigen == null && pDest == null) {
            return false;
        }

        LinkedList<Nodo> L1 = new LinkedList<>();
        L1.add(pOrigen);

        return idaVuelta(L1, pOrigen, pDest) && idaVuelta(L1, pDest, pOrigen);
    }

    private boolean idaVuelta(LinkedList<Nodo> L1, Nodo pOrigen, Nodo pDest) {

        if (seEncuentra(L1, pOrigen)) {
            return true;
        }

        if (pOrigen == pDest) {
            return true;
        }
        boolean b = false;
        Arco p = pOrigen.prim;
        while (p != null) {
            L1.add(p.pDest);
            b = idaVuelta(L1, p.pDest, pDest);
            L1.removeLast();
            p = p.prox;
        }
        return b;
    }

    //5
    public void CiHamiltoniano(String name1, String name2) {
        Nodo pOrigen = Buscar(name1);
        Nodo pDest = Buscar(name2);

        if (pOrigen == null && pDest == null) {
            return;
        }

        LinkedList<Nodo> L1 = new LinkedList<>();
        L1.add(pOrigen);

        CiHamiltoniano(L1, pOrigen, pDest);
    }

    private void CiHamiltoniano(LinkedList<Nodo> L1, Nodo pOrigen, Nodo pDest) {

        if (seEncuentra(L1, pOrigen)) {
            System.out.println(L1);
            return;
        }
        Arco p = pOrigen.prim;
        while (p != null) {
            L1.add(p.pDest);
            CiHamiltoniano(L1, p.pDest, pDest);
            L1.removeLast();
            p = p.prox;
        }
    }
}
