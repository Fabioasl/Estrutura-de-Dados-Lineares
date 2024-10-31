public interface Pilhae_interface{ // Criando uma interface de pilha encadeada
    public int size();
    public boolean isEmpty();
    public Object top() throws Epilhavazia;
    public void push(Object o);
    public Object pop() throws Epilhavazia;
}