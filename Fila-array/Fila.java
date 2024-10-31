public class Fila implements Fila_interface{
    // Atributos da fila
    private int ini;
    private int fim;
    private int capacidade;
    private Object [] fila;

    // Construtor da fila
        public Fila(int capacidade){
            this.ini = 0;
            this.fim = 0;
            this.capacidade = capacidade;
            this.fila = new Object[capacidade];
    }
    
    // Métodos da fila
    public int size(){ // Método para retonar o tamanho da fila
        return (capacidade - ini + fim) % capacidade;
    }
    public boolean isEmpty(){ // Método para verificar se a fila está vazia
        return ini == fim; // Se o inicio da fila for igual ao fim quer dizer que eles estão na mesma posição logo a fila está vazia
    }
    public Object inicio(){ // Método para retonar o primeiro elemento da fila.
        return fila[ini];
    }
    public void enqueue(Object o){ // Método para adicionar elementos na fila
        if (this.fim - this.ini == capacidade) aumentar_cap(); // Caso a diferença do fim e do inicio for igual a capacidade aumenta o tamanho da fila
        this.fila[fim % capacidade] = o;
        this.fim++;
    }
    public Object dequeue() throws EFilavazia{ // Método para remover o primeiro elemento da fila
        if (isEmpty()){ // Exceção para verificar se a fila está vazia
            throw new EFilavazia("A fila está vazia!");
        } 
        this.ini++;
        return this.fila[(ini - 1) % capacidade];
    }
    public void aumentar_cap(){ // Método para aumentar o tamanho da fila caso ela se encontre cheia
        this.capacidade*=2; // Dobra a capacidade 
        Object [] nova_lista =  new Object[capacidade*=2]; // cria uma nova fila com o dobro da capacidade
        for (int i = 0; i < fila.length; i++){ // Copiando os elemtentos da outra fila para a nova
                nova_lista[i] = fila[i];
        }
        fila = nova_lista; // A nova fila agora é igual a antiga fila
    }
}