package segundoParcialArboles;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(45);
        arbol.insertar(23);
        arbol.insertar(65);
        arbol.insertar(2);
        arbol.insertar(38);
        arbol.insertar(52);
        arbol.insertar(96);
        arbol.insertar(7);
        arbol.insertar(48);
        arbol.recInOrden();
        System.out.println();
        System.out.println(arbol.sumaElementosTerminales());
    }
}
