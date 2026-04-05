package Escenario2;

public class ListaDoblementeEnlazada<T> {
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int tam;

    public ListaDoblementeEnlazada(int tam) {
        inicio = null;
        fin = null;
        this.tam = 0;
    }

    /**
     * agregar pagina al inicio
     * @param valor
     */
    public void agregarPaginaInicio(T valor){
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.setProximo(inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }

        tam++;
    }

    /**
     * agregar pagina al final
     * @param valor
     */
    public void agregarPaginaFinal(T valor){
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if(fin == null){
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setProximo(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }

        tam++;
    }

    /**
     * eliminar la pagina al inicio
     */
    public void eliminarPaginaInicio(){
        if(inicio == null){
            return;
        }

        if(inicio == fin){
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }

        tam--;
    }

    /**
     * eliminar la pagina del final
     */
    public void eliminarPaginaFinal(){
        if(fin == null){
            return;
        }

        if(inicio == fin){
            inicio = null;
            fin = null;
        } else {
            fin = fin.getAnterior();
            fin.setProximo(null);
        }

        tam--;
    }
}
