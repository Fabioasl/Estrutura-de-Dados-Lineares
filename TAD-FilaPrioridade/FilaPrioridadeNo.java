class No{
    private Object chave;
    private Object elemento;
    public No(Object chave, Object elemento){
        this.chave = null;
        this.elemento = null;
    }
}
public class FilaPrioridadeNo{
    private Object tamanho;
    private No no;
    private No raiz
    public FilaPrioridadeNo(){
        this.tamanho = 0;
        this.no = null;
        this.raiz = null;
    }
public void insert(){
    if (raiz == null){
        this.raiz = this.no;
        this.tamanho++;
    }
}
public void removeMin(){    


}
public int size(){
    return this.tamanho;
}
public boolean isEmpty(){
    return raiz == null;
}
}