import java.util.Vector;
public class Vectorpilha {
    public static void main(String [] args){
        Vector_Pilha p1 = new Vector_Pilha();
        p1.push(25); // Adiciona na pilha 25
        p1.push(30); // Adiciona na pilha 30
        System.out.println(p1.top()); // Printa qual elemento está no topo da pilha (30)
        p1.pop(); // O último elemento da pilha deve ser removido
        System.out.println(p1.top()); // Printa qual elemento está no topo da pilha (25)
        System.out.println(p1.size()); // Verifica o tamanho da pilha
        System.out.println(p1.isEmpty()); // Verificar se a pilha está vazia
       
    }
}