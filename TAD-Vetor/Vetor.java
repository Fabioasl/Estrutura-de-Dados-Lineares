
public class Vetor implements Vetor_interface{
    private int tamanho;
    private int capacidade;
    private Object [] array;
    public Vetor(int tam){
        this.tamanho = tam;
        this.capacidade = 0;
        this.array = new Object[tam];
    }
    public boolean isEmpty(){
        return capacidade == 0;
    }
    public int size(){
        return this.tamanho;
    }
    public Object elementAtrank(int index) throws Evetorfora{
        if (index >= this.array.size()) throw new Evetorfora('O índice está fora do vetor!');
        return this.array[index];
    }
    public Object replaceAtrank(int index, Object r){
        if (index >= capacidade) aumenta_cap();
    }
    public void aumenta_cap(){
        this.capacidade*=2;
        Object [] novo_array = new Object[capacidade];
        for (int i = 0; i < array.length(); i++){
            novo_array[i] = array[i];
        }
        array = novo_array;
    }
    public void insertAtrank(int r, Object o){
        if (r >= array.size() || this.tam == this.capacidade) aumenta_cap(); 
        int antigo = array[r], proximo = array[r + 1];
        array[r] = o;
        for (int i = r + 1; i < array.size(); i++){
            proximo = array[i];
            array[i] = antigo;
            antigo = proximo;
        }
        this.capacidade++;
    }
    public Object removeAtrank(int index) throws new Evetorfora{
        if (index >= this.array.size()) throw new Evetorfora("O índice está fora do vetor!");
        for (int i = r; i < array.size() - 1; i++){
            array[i] = array[i+1]; 
        }
        this.capacidade--;
        return array[index];
    }
} 