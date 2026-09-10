public class Main {

    public static void main(String[] args) {

        MiListaCircular lista = new MiListaCircular();

        System.out.println("====================================");
        System.out.println("    PRUEBA DE MiListaCircular");
        System.out.println("====================================");


        // ====================================
        // 1. isEmpty()
        // ====================================

        System.out.println("\n--- 1. isEmpty() ---");

        System.out.println("¿Está vacía?: " + lista.isEmpty());


        // ====================================
        // 2. getSize()
        // ====================================

        System.out.println("\n--- 2. getSize() ---");

        System.out.println("Tamaño inicial: " + lista.getSize());


        // ====================================
        // 3. insertHead()
        // ====================================

        System.out.println("\n--- 3. insertHead() ---");

        lista.insertHead(20);
        lista.insertHead(10);

        System.out.println("Lista:");
        System.out.println(lista);


        // ====================================
        // 4. insertTail()
        // ====================================

        System.out.println("\n--- 4. insertTail() ---");

        lista.insertTail(30);
        lista.insertTail(40);

        System.out.println("Lista:");
        System.out.println(lista);


        // ====================================
        // 5. add()
        // ====================================

        System.out.println("\n--- 5. add() ---");

        lista.add(50);

        System.out.println("Lista:");
        System.out.println(lista);


        // ====================================
        // 6. getHead()
        // ====================================

        System.out.println("\n--- 6. getHead() ---");

        System.out.println("Cabeza: " + lista.getHead());


        // ====================================
        // 7. getTail()
        // ====================================

        System.out.println("\n--- 7. getTail() ---");

        System.out.println("Cola: " + lista.getTail());


        // ====================================
        // 8. getSize()
        // ====================================

        System.out.println("\n--- 8. getSize() ---");

        System.out.println("Tamaño actual: " + lista.getSize());


        // ====================================
        // 9. get()
        // ====================================

        System.out.println("\n--- 9. get() ---");

        Node nodo30 = lista.search(30);

        System.out.println("Nodo encontrado: " + nodo30);
        System.out.println("Dato del nodo: " + lista.get(nodo30));


        // ====================================
        // 10. search()
        // ====================================

        System.out.println("\n--- 10. search() ---");

        Node encontrado = lista.search(40);

        if (encontrado != null) {
            System.out.println("Se encontró el nodo: "
                    + encontrado.dato);
        } else {
            System.out.println("No se encontró.");
        }


        // ====================================
        // 11. contains()
        // ====================================

        System.out.println("\n--- 11. contains() ---");

        System.out.println("¿Contiene 30?: "
                + lista.contains(30));

        System.out.println("¿Contiene 100?: "
                + lista.contains(100));


        // ====================================
        // 12. insert(Node, Object)
        // ====================================

        System.out.println("\n--- 12. insert(Node, Object) ---");

        Node nodo20 = lista.search(20);

        lista.insert(nodo20, 25);

        System.out.println("Lista después de insertar 25:");
        System.out.println(lista);


        // ====================================
        // 13. insert(Object, Object)
        // ====================================

        System.out.println("\n--- 13. insert(Object, Object) ---");

        lista.insert(30, 35);

        System.out.println("Lista después de insertar 35:");
        System.out.println(lista);


        // ====================================
        // 14. set()
        // ====================================

        System.out.println("\n--- 14. set() ---");

        Node nodo40 = lista.search(40);

        lista.set(nodo40, 45);

        System.out.println("Lista después de cambiar 40 por 45:");
        System.out.println(lista);


        // ====================================
        // 15. toArray()
        // ====================================

        System.out.println("\n--- 15. toArray() ---");

        Object[] arreglo = lista.toArray();

        System.out.println("Elementos:");

        for (Object elemento : arreglo) {
            System.out.print(elemento + " ");
        }

        System.out.println();


        // ====================================
        // 16. toArray(Object[])
        // ====================================

        System.out.println("\n--- 16. toArray(Object[]) ---");

        Object[] arreglo2 = new Object[20];

        lista.toArray(arreglo2);

        System.out.println("Elementos:");

        for (Object elemento : arreglo2) {

            if (elemento != null) {
                System.out.print(elemento + " ");
            }
        }

        System.out.println();


        // ====================================
        // 17. Comprobar circularidad
        // ====================================

        System.out.println("\n--- 17. Comprobar circularidad ---");

        Node cabeza = lista.cabeza;

        Node cola = cabeza;

        while (cola.siguiente != cabeza) {
            cola = cola.siguiente;
        }

        System.out.println("Cabeza: " + cabeza.dato);
        System.out.println("Cola: " + cola.dato);

        System.out.println(
                "¿La cola apunta a la cabeza?: "
                        + (cola.siguiente == cabeza)
        );


        // ====================================
        // 18. subList()
        // ====================================

        System.out.println("\n--- 18. subList() ---");

        Node desde = lista.search(20);
        Node hasta = lista.search(45);

        MiListaCircular sublista =
                lista.subList(desde, hasta);

        System.out.println("Sublista desde 20 hasta 45:");
        System.out.println(sublista);


        // ====================================
        // 19. remove()
        // ====================================

        System.out.println("\n--- 19. remove() ---");

        Node nodo25 = lista.search(25);

        System.out.println("Antes:");
        System.out.println(lista);

        lista.remove(nodo25);

        System.out.println("Después:");
        System.out.println(lista);


        // ====================================
        // 20. Comprobar circularidad después
        // ====================================

        System.out.println("\n--- 20. Circularidad después de remove() ---");

        cabeza = lista.cabeza;

        cola = cabeza;

        while (cola.siguiente != cabeza) {
            cola = cola.siguiente;
        }

        System.out.println("Cabeza: " + cabeza.dato);
        System.out.println("Cola: " + cola.dato);

        System.out.println(
                "¿La cola sigue apuntando a la cabeza?: "
                        + (cola.siguiente == cabeza)
        );


        // ====================================
        // 21. sortList()
        // ====================================

        System.out.println("\n--- 21. sortList() ---");

        MiListaCircular listaOrdenada =
                new MiListaCircular();

        listaOrdenada.add(50);
        listaOrdenada.add(10);
        listaOrdenada.add(40);
        listaOrdenada.add(20);
        listaOrdenada.add(30);

        System.out.println("Antes de ordenar:");
        System.out.println(listaOrdenada);

        listaOrdenada.sortList();

        System.out.println("Después de ordenar:");
        System.out.println(listaOrdenada);


        // ====================================
        // 22. clear()
        // ====================================

        System.out.println("\n--- 22. clear() ---");

        lista.clear();

        System.out.println("Lista después de clear():");
        System.out.println(lista);

        System.out.println("¿Está vacía?: "
                + lista.isEmpty());

        System.out.println("Tamaño: "
                + lista.getSize());


        // ====================================
        // 23. FIN
        // ====================================

        System.out.println("\n====================================");
        System.out.println("        FIN DE LAS PRUEBAS");
        System.out.println("====================================");
    }
}