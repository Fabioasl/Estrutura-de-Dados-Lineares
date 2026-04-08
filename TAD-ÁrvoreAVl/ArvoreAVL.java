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
    public No Buscar(int x){
        No temp = this.raiz;

        while (temp != null){
            if (temp.valor == x){
                    break;
            } else if (temp.valor > x){
                temp = temp.esquerdo;
            } else {
                temp = temp.direito;
            }
        }
        return temp;
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
    public void Inserir(int valor){
        No temp =  new No(); // usado apenas para percorrer na árvore
        No novoNo = new No(); // nó que vai ser inserido
        int gambiarra = 0;
        novoNo.valor = valor;
        if (isEmpty()){
            temp = novoNo;
        }
        while (temp != null){
            if (temp.valor > valor){
                if (temp == null) break;
                temp = temp.esquerdo
                gambiarra = 1;
            }else {
                if (temp == null ) break;
                temp = temp.direito;
                gambiarra = 0;
            }
            novoNo.setPai(temp);     
            No pai = novoNo.getPai() // Pai do nó pq precisa avisar pra ele que agr ele vai ter um filho para direita ou para a esquerda
            if (gambiarra == 1){
                pai.setEsquerdo(novoNo);
            }else{
                pai.setDireito(novoNo);
            }
        }
        AtualizarFB();
        
    }
    public void Remover(No no){
        No buscar = new node();
        no pai = buscar.getPai();
        int gambiarra = 0;
        if (isEmpty()){
            buscar = raiz;
        }
        while (buscar.valor != no.valor){
            if (buscar.valor > no.valor){
                buscar = buscar.esquerdo;
                gambiarra = 1;
            } else{
                buscar = buscar.direito;
                gambiarra = 0;
            }
        }
        if (buscar.esquerdo == null && buscar.direito == null){ // 1 caso
            buscar = null;
            buscar.setPai(null);
            if (gambiarra == 1){
                pai.setEsquerdo(null);
            } else{
                pai.setDireito(null);
            }    
        } else if (buscar.esquerdo == null && buscar.direito != null){ // 2 caso
                No pai = buscar.getPai() // 15
                no novoEsquerdo = buscar.getDireito() // 13
                novoEsquerdo.setPai(pai);
                pai.setEsquerdo(novoEsquerdo);
                
        }
        
        // 3 caso
        AtualizarFB()

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
    public No getRaiz(){
        return raiz;
    }
    public void setRaiz(No novaRaiz){
        this.raiz = raiz(novaRaiz);
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