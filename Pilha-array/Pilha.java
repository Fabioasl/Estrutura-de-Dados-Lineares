import java.util.ArrayList;
public class Pilha implements Pilha_interface{
    private int tam;
    private Object[] array;
    private int top;
    public Pilha(int tam){
        this.tam = tam;
        array = new Object[tam];
        top = -1;
    }
    public int size(){
        return top + 1; // Função que retorna o tamanho da pilha
    }
    public boolean isEmpty(){ // Função que verifica se a pilha está ou não vazia
        return top == -1;
    }
    public Object top() throws EPilhavazia{ // Função que retorna o último elemento da pilha. Caso a pilha esteja vazia a função retornará Epilhavazia
        if (isEmpty() == true){
                throw new EPilhavazia("A pilha está vazia!");
        }
        return array[top];
    }
    public void push(Object o){ // Função para adicionar elementos na pilha. Caso a pilha esteja cheia aumenta a capacidade utilizando o método de dobrar o tamanho da pilha.
        if (top >= tam-1){
            Object [] novoarray = new Object[tam *= 2];
            for (int i = 0; i < array.length; i++){
                novoarray[i] =  array[i];
            }
            array = novoarray;

        }
        array[++top] = o;
    }
    public Object pop() throws EPilhavazia{ // Funçao que remove o último elemento da pilha. Caso a pilha estja vazia a função retornará Epilhavazia.
        if (isEmpty() == true){
            throw new EPilhavazia("A pilha está vazia!");
        }
        return array[top--];
    }
    public void Empty(){ // Função que serve para esvaziar a pilha por completo.
        for (int i = 0; i < top; i++){
            array[i] =  null;
        }
    top = -1;        
    }
}