
public class Main{
    public static void main(String[] args) throws EPilhavazia{
        Pilha p1 = new Pilha(2); // Cria uma pilha de tamanho 2
        p1.push(1); // Adiciona 1 a essa pilha
        System.out.println(p1.isEmpty()); // Verifica se a pilha está vazia
        System.out.println(p1.top()); // Retorna o último elemento da pilha
        p1.pop(); // Apaga o último elemento da pilha
        p1.push(1); // Adiciona 1 a pilha
        p1.push(2); // Adiciona 2 a pilha
        p1.push(3); // Adiciona 3 a pilha
        System.out.println(p1.size()); // Verifica o tamanho da pilha
        System.out.println(p1.isEmpty()); // Verificar novamente se a pilha está vazia
        p1.Empty(); // Esvaziand a pilha
        System.out.println(p1.isEmpty()); // Verifica mais uma vez se a pilha está vazia
    }
}