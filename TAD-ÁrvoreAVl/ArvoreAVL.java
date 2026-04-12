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
            if (temp.getValor() == x){
                    break;
            } else if (temp.getValor()  > x){
                temp = temp.getEsquerdo();
            } else {
                temp = temp.getDireito();
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
        No pai = novoNo.getPai() // Pai do nó pq precisa avisar pra ele que agr ele vai ter um filho para direita ou para a esquerda
        int gambiarra = 0;
        novoNo.setValor() = valor;
        if (isEmpty()){
            temp = novoNo;
        }
        while (temp != null){
            if (temp.getValor() > valor){
                if (temp == null) break;
                temp = temp.getEsquerdo();
                gambiarra = 1;
            }else {
                if (temp == null ) break;
                temp = temp.getDireito();
                gambiarra = 0;
            }
            novoNo.setPai(temp);     
            if (gambiarra == 1){
                pai.setEsquerdo(novoNo);
            }else{
                pai.setDireito(novoNo);
            }
        }
        AtualizarFBInsercao(novoNo);
        
    }
    public void Remover(No no){
        No buscar = raiz;
        no pai = null;
        while (buscar != null && buscar.getValor() != no.getValor()){
            pai = buscar;
            if (buscar.getValor()  > no.getValor()){
                buscar = buscar.getEsquerdo();    
            } else{
                buscar = buscar.getDireito(); 
            }
        }
        if (buscar == null) return;

        if (isExternal(buscar)){ // 1 caso
            if (pai == null){
                raiz = null;
            } else if (pai.getEsquerdo() == buscar){
                pai.setEsquerdo(null);
            } else{
                pai.setDireito(null);
            }     
        } else if (buscar.getEsquerdo() != null && buscar.getDireito() == null || (buscar.getDireito() != null && buscar.getEsquerdo() == null)) { // 2 caso
                No substituido;
                if (pai == null) {
                    raiz = substituido;
                    substituido.setPai(null);
                }
                if (buscar.getEsquerdo() != null ) {
                    substituido = buscar.getEsquerdo();
                } else {
                    substituido = buscar.getDireito();
                }
                if (pai != null ){
                    if (pai.getDireito() == buscar){
                        pai.setDireito(substituido);
                        substituido.setPai(pai);
                    } else{
                        pai.setEsquerdo(substituido);
                        substituido.setPai(pai);
                    }
                }
        } else { // 3 caso
            No sucessor = Sucessor(buscar);
            buscar.setValor(sucessor.getValor());
            Remover(sucessor);
        }
        
        AtualizarFBRemocao(no);

    }
    public void AtualizarFBInsercao(No no){
        if (no == raiz) return;
        No antecessor = no.getPai();
        while (antecessor != null){
            if (antecessor.getEsquerdo() == no ){ // se inserção do nó foi a esquerda o fb vai subindo e aumentanto mais 1
                antecessor.setFB(antecessor.getFB() + 1);
            } else { // se não foi a esquerda foi para direita então vai subindo e diminuindo -1
                antecessor.setFB(antecessor.getFB() - 1);
            } 
            if (antecessor.getFB() == 0) break;

            // Verifica os FB para fazer as rotações caso quebre a árvore
            if (antecessor.getFB() == 2) {
                No temp = antecessor.getEsquerdo();
                    if (temp.getFB() >= 0) {
                        rotacionarDireita(antecessor); // LL
                    } else {
                        RotacaoDuplaDireita(antecessor); // LR
                    }
                    break;
                } 
                            
            if (antecessor.getFB() == -2){
                No temp = antecessor.getDireito();
                 if (temp.getFB() <= 0){
                    rotacionarEsquerda(antecessor); 
                } else {
                    RotacaoDuplaEsquerda(antecessor);
                }     
               break;
            } 
                     
            no = antecessor;
            antecessor = antecessor.getPai(); // tem que mudar o valor de antecessor pra ele ir subindo na árvore
        }  
    }


    public void AtualizarFBRemocao(No no){
        if (no == raiz) return;
        No antecessor = no.getPai();
        while (antecessor != null){ }

        
           
       
        no = antecessor;
        antecessor = antecessor.getPai();
    }
    public No Sucessor(No no){ // o no que foi atribuido e o mesmo que foi removido
        if (no == null || no.getDireito() == null) return null;
        No sucessor = no.getDireito(); // ponto de partida do while
        while (sucessor.getEsquerdo() != null ){
            sucessor = sucessor.getEsquerdo();
        }
        return sucessor;
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
    public int getValor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor = valor;
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