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
	public Arvore(No raiz){
		this.raiz = raiz;
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
    // Utilizei os valores 5 10 e 9 para ajudar na compreensão do código
    public No rotacionarEsquerda(No no){ // "5" 
        No paiNo = no.getPai() //  pai do no  "5"
        No noNovo = no.getDireito() // no "10" é o que vai subir

        if (noNovo.getEsquerdo != null ){ // Caso se o nó que for subir tiver um filho esquerdo
            noNovoEsquerdo = noNovo.getEsquerdo();
            no.setDireito(noNovoEsquerdo);
            noNovoEsquerdo.setPai(no);
        } else{
            no.setDireito(null);
        }

        if (paiNo != null) {
            if (paiNo.getEsquerdo() == no) {
                paiNo.setEsquerdo(noNovo);
            } else {
                paiNo.setDireito(noNovo);
            }
        }
        
        noNovo.setPai(paino);
        noNovo.setEsquerdo(no);

        return noNovo;
    }

    public No rotacionarDireita(No no){

    }
    public void AtualizarFB(){
        
    }
    // Get e Set
    public No getEsquerdo(){
        return No.esquerdo;
    }

    public No getDireito(){
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