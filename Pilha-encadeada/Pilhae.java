class No {
    Object valor;
    No proximo;
    public No(){
        this.proximo = null;
    }
}
public class Pilhae implements Pilhae_interface{
    private No topo; // Nó que se refere ao topo da pilha
    private int tam; // tamanho da pilha
    public Pilhae(){
        this.topo = null;
        this.tam = -1;
    }
    public int size(){
        return tam;
    }
    public boolean isEmpty(){
        return topo == null;
    }
    public Object top() throws Epilhavazia{
        if (this.topo == null){
            throw new Epilhavazia("A pilha está vazia!");
        }
        return this.topo.valor;
    }
    public void push(Object o){
        No novoNo =  new No(); // Criando um novo nó 
        if (tam == 0){
            novoNo.valor = o;
            this.topo = novoNo;
        }
        novoNo.valor = o; // Atribuindo um valor para esse novo nó
        novoNo.proximo = this.topo; // O proximo será o que estava no antigo topo
        this.topo = novoNo; // Esse novo nó agora é o topo da pilha
        this.tam++; // Aumenta o tamanho da pilha
    }
    public Object pop() throws Epilhavazia{
        if (isEmpty()) throw new Epilhavazia("A pilha está vazia!");
        Object valor_antigo = this.topo.valor; // Salvando o valor que estava no topo
        this.topo = this.topo.proximo; // Alterando o valor do topo
        return valor_antigo; // Retornando o valor que foi removido da  pilha encadeada
    }
}