import java.util.LinkedList;
import java.util.Queue;


public class Main {

    // Função pra imprimir a árvore (lado direito primeiro pra ficar visual)
    public static void imprimirArvore(No raiz) {
       if (raiz == null) return;

    Queue<No> fila = new LinkedList<>();
    fila.add(raiz);

    while (!fila.isEmpty()) {
        int tamanhoNivel = fila.size();

        for (int i = 0; i < tamanhoNivel; i++) {
            No atual = fila.poll();

            System.out.print(atual.getValor() + "(" + atual.getCor() + ") ");

            if (atual.getEsquerdo() != null) {
                fila.add(atual.getEsquerdo());
            }
            if (atual.getDireito() != null) {
                fila.add(atual.getDireito());
            }
        }

        System.out.println(); // quebra linha por nível
    }
    }

    public static void main(String[] args) {

        ArvoreRN arvore = new ArvoreRN(new No());

        // Inserções


        System.out.println("=== Arvore apos insercoes ===");
        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(12);
        imprimirArvore(arvore.getRaiz());
        arvore.inserir(7);
        

        imprimirArvore(arvore.getRaiz());
        System.out.println("teste:" + arvore.getRaiz().getValor());

        // Remoções
       // System.out.println("\nRemovendo 3...");
       // arvore.Remover(new No() {{ setValor(3); }});

       // System.out.println("Removendo 20...");
       // arvore.Remover(new No() {{ setValor(20); }});

       // System.out.println("\n=== Arvore apos remocao ===");
        //imprimirArvore(arvore.raiz(), 0);
    }
}