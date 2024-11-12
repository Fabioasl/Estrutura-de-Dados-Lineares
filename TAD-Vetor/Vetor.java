public class Vetor implements Vetor_interface{
    //Atibutos
    private int tam;
    private Object [] array;
    private int capacidade;
    public Vetor(int tam){
        this.capacidade = tam;
        this.tam = tam;
        this.array =  new Object[tam];
    }
    public boolean isEmpty(){
        return this.array[0] == null;
    }
    public int size(){
        return this.size;
    }
    

}