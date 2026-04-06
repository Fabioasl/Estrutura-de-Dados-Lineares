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
    public void rotacionarEsquerda(No no){ // "5" 
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
        FB_no_novo = no.getFB() + 1 + min(noNovo.getFB(),0);
        FB_noNovo_novo = noNovo.getFB() - 1 + max(FB_no_novo,0);

        no.setFB(FB_no_novo);
        noNovo.setFB(FB_noNovo_novo);
    }

    public void rotacionarDireita(No no){
        No paiNo = no.getPai();
        no noNovo = no.getEsquerdo()
        if (noNovo.getEsquerdo != null){
            No direito = noNovo.getDireito();
            direito.setPai(no);
        } else{
            noNovo.setEsquerdo(null);
        }
        if (paiNo != null) {
            if (paiNo.getDireito() == no) {
                paiNo.setDireito(noNovo);
            } else {
                paiNo.setEsquerdo(noNovo);
            }
        }
        noNovo.setPai(noPai);
        noNovo.setDireito(no);

        FB_no_novo = no.getFB - 1 - max(noNovo.fb, 0);
        FB_noNovo_novo = noNovo.getFB - 1 + min(FB_no_novo, 0);

        no.setFB(FB_no_novo);
        noNovo.setFB(FB_noNovo_novo);

    }
    public void RotacaoDuplaEsquerda(No no){ // -2 e +1 = RDE
        no.setDireito(rotacionarDireita(no.getDireita())); // Falando pro no que vai rotacionar e que sua nova direita vai ser o resultado da rotação do seu filho a direita
        rotacionarEsquerda(no);
    }
    public void RotacaoDuplaDireita(No no){ // +2 e -1 = RDD
        no.setEsquerdo(rotacionarEsquerda(no.getEsquerdo())); // Falando pro no que vai rotacionar que sua nova esquerda vai ser o resultado da rotação do seu filho a esquerda
        rotacionarDireita(no);
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
    public int getFB(){
        return fb;
    }
    public void setFB(int fb){
        this.fb = fb;
    }
    public void setPai(No noPai){
        this.noPai = noPai;
    }

    public void setEsquerdo(No no){
        this.no = no;
    }

    public void setDireito(No no){
        this.no = no;
    }
}