import java.util.LinkedList;
import java.util.Queue;


public class Main {

    

    public static void main(String[] args) {

        ArvoreRN arvore = new ArvoreRN(new No());

        // Inserções


        System.out.println("=== Arvore apos insercoes ===");
        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(12);
        arvore.inserir(7);
        arvore.inserir(23);

        
        
       System.out.println("=== Arvore apos remoção ===");
       No noRemover = arvore.Buscar(23);
       
       arvore.Remover(noRemover );
    
      
    }
}