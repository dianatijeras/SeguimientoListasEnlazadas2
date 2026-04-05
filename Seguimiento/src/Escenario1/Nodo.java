package Escenario1;
public class Nodo<T> {
    private T valor;
    private Nodo<T> proximo;

    public Nodo(T valor) {
        this.valor = valor;
        proximo = null;
    }

    public T getValor() {
        return valor;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "listaSimple.Nodo{" +
                "valor=" + valor +
                ", proximo=" + proximo +
                '}';
    }
}
