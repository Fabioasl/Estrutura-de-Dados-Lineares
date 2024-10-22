import java.util.Vector;

public class Vector_Pilha implements Pilhad_interface{
    private Vector<Object> vetor = new Vector<>();
    public int size(){
        return vetor.size();
    }
   public boolean isEmpty(){
     return vetor.isEmpty(); // Utiliza a função pronta do Vector para verificar se a lista está vazia.
   }
    public void push(Object o ){
        vetor.addElement(o); // Utiliza a função pronta do Vector para adicionar um elemento no final da pilha.
    }
    public Object top(){
        return vetor.get(vetor.size()-1); // Utiliza a função pronta do Vector para retornar o elemento final da pilha.
    }
    public Object pop(){
        return vetor.remove(vetor.size()-1); // Utiliza a função pronta do Vector para remover o último elemento da lista.
    }
}