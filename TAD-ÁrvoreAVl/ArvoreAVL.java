class No{
	int valor;
    int fb;
	No esquerdo;
	No direito;
    No pai;
	public No(){
		this.esquerdo = null;
		this.direito = null;
        this.pai = null;
        this.fb = 0;
	}
}

public class Arvore{
	No raiz;
	public Arvore(){
		this.raiz = null;
    }
    public No raiz(){
        return raiz;
    }
    public  boolean isEmpty(){
	    return raiz == null;
    }
    public void isExternal(No x){
	    if (x.esquerdo == null && x.direito == null){
		    return true;
	    } else{
		    return false;
	}
}
    public No buscar(int x, No no){
	    if (no == null) {
		    return null;
	    }
	    if (no.valor == x){
		    return no;
	    } 
	    if (x < no.valor){
		    return buscar(x, no.esquerdo);
	    } else{
		    return buscar(x,no.direito);
	    }
    }
    public No rotacionarEsquerda(No no){

    }

    public No rotacionarDireita(No no){

    }

    // Get e Set
    public No getEsquerdo(){
        return No.esquerdo;
    }

    public No getDireto(){
        return No.direito;
    }

    public No getPai(){
        return No.pai;
    }

    public void setPai(No noPai){
        this.noPai = noPai;
    }

    public void setEsquerdo(No no, int valor){
        this.no = no;
        this.valor = valor;
    }

        public void setDireito(No no, int valor){
        this.no = no;
        this.valor = valor;
    }
}