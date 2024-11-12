public interface Vetor_interface{ // Criando interface vetor
    public boolean isEmpty();
    public int size();
    public Object elementAtrank(int r);
    public Object replaceAtrank(int r, Object o );
    public void insertAtrank(int r, Object o);
    public Object removeAtrank(int r);
}