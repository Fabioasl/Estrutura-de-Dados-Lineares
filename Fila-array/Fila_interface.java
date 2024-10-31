public interface Fila_interface{ // Criando a interface para a fila
    public int size();
    public boolean isEmpty();
    public Object inicio();
    public void enqueue(Object o);
    public Object dequeue() throws EFilavazia;
    
}