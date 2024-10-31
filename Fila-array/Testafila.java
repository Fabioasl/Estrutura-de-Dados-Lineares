
public class Testafila{
    public static void main(String [] args) throws EFilavazia{
        Fila f1 = new Fila(2); // Cria uma nova fila com tamanho igual a 2
        f1.enqueue(2); // Adicione 2 a fila
        f1.enqueue(3); // Adicione 3 a fila
        System.out.println(f1.isEmpty()); // Verifique se a fila está vazia
        System.out.println(f1.inicio()); // Mostre o inicio da fila
        f1.dequeue(); // Remova o primeiro elemento da fila (2)
        System.out.println(f1.inicio()); // Mostre o inicio da fila
        f1.enqueue(4); // Adicione 4 a fila (para testar se o método de dobrar array funciona)
        f1.enqueue(5); // Adicione 5 a fila (para testar se o método de dobrar array funciona)
    }
}