import java.util.LinkedList;
import java.util.Queue;
public class Main {
    public static void main(String[] args) {

        ArvoreAVL arvore = new ArvoreAVL(null);

        // ========================
        // TESTE DE INSERÇÃO
        // ========================
        System.out.println("=== Inserindo valores ===");

        int[] valoresInserir = {10, 20, 30, 40, 50, 52, 9, 55};

        for (int v : valoresInserir) {
            System.out.println("Inserindo: " + v);
            arvore.Inserir(v);
        }

        System.out.println("Raiz: " + arvore.getRaiz().getValor());

        // ========================
        // TESTE DE BUSCA
        // ========================
        System.out.println("\n=== Teste de busca ===");

        int[] valoresBuscar = {10, 9, 40 ,100};

        for (int v : valoresBuscar) {
            No encontrado = arvore.Buscar(v);

            if (encontrado != null) {
                System.out.println("Valor " + v + " encontrado!");
            } else {
                System.out.println("Valor " + v + " não encontrado!");
            }
        }
        // ========================
        // TESTE DE REMOÇÃO
        // ========================

        System.out.println("\n=== Teste de remoção ===");

        int[] valoresRemover = {9, 20, 40, 100};

        for (int v : valoresRemover) {
            No noRemover = arvore.Buscar(v);

            if (noRemover != null) {
                System.out.println("Removendo: " + v);
                arvore.Remover(noRemover);
                System.out.println("Remoção realizada com sucesso!");
            } else {
                System.out.println("Valor " + v + " não encontrado para remoção.");
            }
        }

    }
}