public class MiListaCircular implements ListInterface {

    Node cabeza;

    @Override
    public boolean isEmpty() {

        return this.cabeza == null;
    }

    @Override
    public int getSize() {

        if (this.cabeza == null) {
            return 0;
        }

        Node iterador = this.cabeza;

        int contador = 0;

        do {

            contador++;

            iterador = iterador.siguiente;

        } while (iterador != this.cabeza);

        return contador;
    }

    @Override
    public void clear() {

        this.cabeza = null;
    }

    @Override
    public Object getHead() {

        if (this.cabeza == null) {
            return null;
        }

        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {

        if (this.cabeza == null) {
            return null;
        }

        Node iterador = this.cabeza;

        while (iterador.siguiente != this.cabeza) {

            iterador = iterador.siguiente;
        }

        return iterador.dato;
    }

    @Override
    public Object get(Node node) {

        if (node == null) {
            return null;
        }

        return node.dato;
    }

    @Override
    public Node search(Object object) {

        if (this.cabeza == null) {
            return null;
        }

        Node iterador = this.cabeza;

        do {

            if (iterador.dato.equals(object)) {
                return iterador;
            }

            iterador = iterador.siguiente;

        } while (iterador != this.cabeza);

        return null;
    }

    @Override
    public boolean add(Object object) {

        return insertTail(object);
    }

    @Override
    public boolean insert(Node node, Object object) {

        if (node == null || this.cabeza == null) {
            return false;
        }

        Node nuevoNodo = new Node(object);

        nuevoNodo.siguiente = node.siguiente;

        node.siguiente = nuevoNodo;

        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {

        if (this.cabeza == null) {
            return false;
        }

        Node iterador = this.cabeza;

        do {

            if (iterador.dato.equals(objectRef)) {

                Node nuevoNodo = new Node(object);

                nuevoNodo.siguiente = iterador.siguiente;

                iterador.siguiente = nuevoNodo;

                return true;
            }

            iterador = iterador.siguiente;

        } while (iterador != this.cabeza);

        return false;
    }

    @Override
    public boolean insertHead(Object object) {

        Node nuevaCabeza = new Node(object);

        // Caso: lista vacía
        if (this.cabeza == null) {

            this.cabeza = nuevaCabeza;

            nuevaCabeza.siguiente = this.cabeza;

            return true;
        }

        // Buscar el último nodo
        Node cola = this.cabeza;

        while (cola.siguiente != this.cabeza) {

            cola = cola.siguiente;
        }

        // La nueva cabeza apunta a la antigua cabeza
        nuevaCabeza.siguiente = this.cabeza;

        // La cola apunta a la nueva cabeza
        cola.siguiente = nuevaCabeza;

        // Actualizar cabeza
        this.cabeza = nuevaCabeza;

        return true;
    }

    @Override
    public boolean insertTail(Object object) {

        Node nuevoNodo = new Node(object);

        // Caso: lista vacía
        if (this.cabeza == null) {

            this.cabeza = nuevoNodo;

            nuevoNodo.siguiente = this.cabeza;

            return true;
        }

        // Buscar la cola
        Node cola = this.cabeza;

        while (cola.siguiente != this.cabeza) {

            cola = cola.siguiente;
        }

        // El nuevo nodo pasa a ser la cola
        cola.siguiente = nuevoNodo;

        // La cola apunta nuevamente a la cabeza
        nuevoNodo.siguiente = this.cabeza;

        return true;
    }

    @Override
    public boolean set(Node node, Object object) {

        if (node == null) {
            return false;
        }

        node.dato = object;

        return true;
    }

    @Override
    public boolean remove(Node node) {

        if (node == null || this.cabeza == null) {
            return false;
        }

        // Caso: solo hay un nodo
        if (this.cabeza == node &&
                this.cabeza.siguiente == this.cabeza) {

            this.cabeza = null;

            return true;
        }

        // Caso: eliminar cabeza
        if (this.cabeza == node) {

            Node cola = this.cabeza;

            while (cola.siguiente != this.cabeza) {

                cola = cola.siguiente;
            }

            // La cola ahora apunta a la nueva cabeza
            this.cabeza = this.cabeza.siguiente;

            cola.siguiente = this.cabeza;

            return true;
        }

        // Buscar el nodo anterior
        Node anterior = this.cabeza;

        while (anterior.siguiente != this.cabeza) {

            if (anterior.siguiente == node) {

                anterior.siguiente = node.siguiente;

                return true;
            }

            anterior = anterior.siguiente;
        }

        return false;
    }

    @Override
    public boolean contains(Object object) {

        return search(object) != null;
    }

    @Override
    public Object[] toArray() {

        Object[] arreglo = new Object[getSize()];

        if (this.cabeza == null) {
            return arreglo;
        }

        Node iterador = this.cabeza;

        int posicion = 0;

        do {

            arreglo[posicion] = iterador.dato;

            posicion++;

            iterador = iterador.siguiente;

        } while (iterador != this.cabeza);

        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {

        if (this.cabeza == null) {
            return object;
        }

        Node iterador = this.cabeza;

        int posicion = 0;

        do {

            if (posicion >= object.length) {
                break;
            }

            object[posicion] = iterador.dato;

            posicion++;

            iterador = iterador.siguiente;

        } while (iterador != this.cabeza);

        return object;
    }

    @Override
    public MiListaCircular subList(Node from, Node to) {

        MiListaCircular nuevaLista = new MiListaCircular();

        if (from == null || to == null || this.cabeza == null) {
            return nuevaLista;
        }

        Node iterador = from;

        do {

            nuevaLista.insertTail(iterador.dato);

            if (iterador == to) {
                break;
            }

            iterador = iterador.siguiente;

        } while (iterador != from);

        return nuevaLista;
    }

    @Override
    public MiListaCircular sortList() {

        if (this.cabeza == null ||
                this.cabeza.siguiente == this.cabeza) {

            return this;
        }

        Node actual = this.cabeza;

        do {

            Node siguiente = actual.siguiente;

            while (siguiente != this.cabeza) {

                if ((Integer) actual.dato >
                        (Integer) siguiente.dato) {

                    Object temporal = actual.dato;

                    actual.dato = siguiente.dato;

                    siguiente.dato = temporal;
                }

                siguiente = siguiente.siguiente;
            }

            actual = actual.siguiente;

        } while (actual != this.cabeza);

        return this;
    }

    @Override
    public String toString() {

        if (this.cabeza == null) {
            return "MiListaCircular{}";
        }

        String resultado = "MiListaCircular{";

        Node iterador = this.cabeza;

        do {

            resultado += iterador.dato;

            iterador = iterador.siguiente;

            if (iterador != this.cabeza) {
                resultado += " -> ";
            }

        } while (iterador != this.cabeza);

        resultado += " -> cabeza}";

        return resultado;
    }
}
