public class Vetor implements Vetor_interface{
    //Atibutos
    private int tam;
    private int capacidade;
    private Object [] array;
    public Vetor(int tam){
        this.capacidade = 0;
        this.tam = tam;
        this.array =  new Object[tam];
    }
    public boolean isEmpty(){
        return capacidade == 0;
    }
    public int size(){
        return this.tam;
    }
    public Object elementAtrank(int r) throws Evetorfora{
        if (r >= size()) throw new Evetorfora('Índice inválido para esse vetor!');
        return this.array[r];
    }
    public Object replaceAtrank(int r, Object o){
        if (r >= array.size()) aumenta_cap();
        array[r] = o;
        return array[r];
    }
    public void insertAtrank(int r, Object o){
        if (r >= array.size() || this.tam == this.capacidade) aumenta_cap(); 
        if (r == array.size() - 1) array[r] = o;
        int antigo = array[r], proximo = array[r + 1];
        array[r] = o;
        for (int i = r + 1; i < array.size(); i++){
            proximo = array[i];
            array[i] = antigo;
            antigo = proximo;
        }
        this.capacidade++;
    }
    public Ojbect removeAtrank(int r) throws Evetorfora{
            if (r >= array.size()) throw new Evetorfora('Índice inválido para esse vetor!');
            for (int i = r; i < array.size() - 1; i++){
                array[r] = array[r+1];
            }
            this.capacidade--;
    }
    public void aumenta_cap(){
        this.capacidade *= 2;
        Object novo_array = new Object[capacidade];
        for (int i = 0; i < array.size(); i++){
            novo_array[i] = array[i];
        }
        array = novo_array;
    }
}