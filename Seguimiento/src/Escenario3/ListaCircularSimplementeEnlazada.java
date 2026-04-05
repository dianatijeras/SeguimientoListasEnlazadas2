package Escenario3;

public class ListaCircularSimplementeEnlazada<T extends Comparable<T>> {
    private Nodo<T> inicial;
    private int tam;

    /**
     * constructor
     */
    public ListaCircularSimplementeEnlazada(){
        inicial = null;
        tam = 0;
    }

    /**
     * metodo que agrega una cancion
     * @param valor
     * @return
     */
    public boolean agregarCancion(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if(inicial == null && tam == 0) {
            inicial = nuevo;
            inicial.setProximo(inicial);
            tam++;
            return true;
        }
        Nodo<T> tempo = inicial;

        while (tempo.getProximo() != inicial){
            tempo = tempo.getProximo();
        }

        tempo.setProximo(nuevo);
        nuevo.setProximo(inicial);
        tam++;
        return true;
    }

    /**
     * metodo que elimina una cancion
     */
    public void eliminarCancion(){

        if(inicial == null){
            return;
        }

        if(tam == 1){
            inicial = null;
        }else{
            Nodo<T>  tempo = inicial;
            while(tempo.getProximo() != inicial){
                tempo = tempo.getProximo();
            }
            tempo.setProximo(inicial.getProximo());
            inicial = inicial.getProximo();
        }
        tam--;
    }

    /**
     * Metodo que muestra las canciones
     */
    public void mostrarCancion() {
        if (inicial == null) return;
        Nodo<T> aux = inicial;

        do {
            System.out.println(aux.getValor());
            aux = aux.getProximo();

        } while (aux != inicial);
    }

    /**
     * Metodo que reproduce la siguiente cancion
     */
    public void siguienteCancion() {
        if (inicial != null) {
            inicial = inicial.getProximo();
            System.out.println("Reproduciendo: " + inicial.getValor());
        }
    }

    /**
     * metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "listaSimple.ListaSimplementeEnlazada{" +
                "inicial = " + inicial +
                '}';
    }
}
