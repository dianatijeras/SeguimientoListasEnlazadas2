package Escenario1;

public class Cola <T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tam;

    public Cola(){
        inicio = null;
        fin = null;
        tam = 0;
    }


    /**
     * agregar turno
     * @param valor
     */
    public void agregarTurno(T valor){
        Nodo<T> newElement = new Nodo<>(valor);
        if(inicio == null && fin == null && tam == 0){
            inicio = newElement;
            fin = newElement;
        }else{
            fin.setProximo(newElement);
            fin = newElement;
        }
        tam++;
    }

    /**
     * quitar turno del inicio
     */
    public void eliminarTurno(){
        if(!(inicio == null && fin == null && tam == 0)){
            inicio = inicio.getProximo();
            tam--;
        }
    }

    /**
     *  is vacia
     */
    public boolean isVacia(){
        boolean flag = false;
        if(inicio == null && fin == null && tam == 0){
            flag = true;
        }
        return flag;
    }

    /**
     * ver turno del inicio
     */
    public T obtenerInicio(){
        return inicio.getValor();
    }

}
