package Escenario4;

public class ListaCircularDoblementeEnlazada<T> {
    private NodoDoble<T> actual;
    private int tam;

    public ListaCircularDoblementeEnlazada(int tam) {
        this.actual = null;
        this.tam = 0;
    }

    /**
     * metodo que agrega un jugador
     * @param valor
     */
    public void agregarJugador(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (actual == null) {
            actual = nuevo;
            actual.setProximo(actual);
            actual.setAnterior(actual);
        } else {
            NodoDoble<T> ultimo = actual.getAnterior();

            ultimo.setProximo(nuevo);
            nuevo.setAnterior(ultimo);

            nuevo.setProximo(actual);
            actual.setAnterior(nuevo);
        }
        tam++;
    }

    /**
     * metodo que muestra el siguiente jugador
     */
    public void siguienteJugador() {
        if (actual != null) {
            actual = actual.getProximo();
            System.out.println("Turno: " + actual.getValor());
        }
    }

    /**
     * metodo que muestra el jugador anterior
     */
    public void anteriorJugador() {
        if (actual != null) {
            actual = actual.getAnterior();
            System.out.println("Turno: " + actual.getValor());
        }
    }

    /**
     * Metodo que elimina un jugador
     * @param valor
     */
    public void eliminarJugador(T valor) {
        if (actual == null) return;
        NodoDoble<T> aux = actual;

        do {
            if (aux.getValor().equals(valor)) {
                if (aux.getProximo() == aux) {
                    actual = null;
                } else {
                    aux.getAnterior().setProximo(aux.getProximo());
                    aux.getProximo().setAnterior(aux.getAnterior());

                    if (aux == actual) {
                        actual = aux.getProximo();
                    }
                }
                tam--;
                return;
            }
            aux = aux.getProximo();
        } while (aux != actual);
    }

    /**
     * Metodo que muestra los jugadores
     */
    public void mostrarJugadores() {
        if (actual == null) {
            System.out.println("No hay jugadores");
            return;
        }
        NodoDoble<T> aux = actual;

        do {
            System.out.println(aux.getValor());
            aux = aux.getProximo();
        } while (aux != actual);
    }
}
