public interface Pilha_interface{ // Criando uma interface pilha
    public int size();
    public boolean isEmpty();
    public Object top() throws EPilhavazia;
    public void push(Object o);
    public Object pop() throws EPilhavazia;
}