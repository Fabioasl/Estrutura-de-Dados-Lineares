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
    // Get e Set
    public No getEsquerdo(){
        return esquerdo;
    }
    public No getDireito(){
        return direito;
    }
    public No getPai(){
        return pai;
    }
    public int getFB(){
        return fb;
    }
    public int getValor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public void setFB(int fb){
        this.fb = fb;
    }
    public void setPai(No noPai){
        this.pai = noPai;
    }

    public void setEsquerdo(No no){
        this.esquerdo = no;
    }

    public void setDireito(No no){
        this.direito = no;
    }
}

public class ArvoreAVL{
	No raiz;
	public ArvoreAVL(No raiz){
		this.raiz = raiz;
    }
    public No raiz(){
        return this.raiz;
    }
    public  boolean isEmpty(){
	    return this.raiz == null;
    }
    public boolean isExternal(No x){
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
    public No rotacionarEsquerda(No no){ // "5" 
        No paiNo = no.getPai(); //  pai do no  "5"
        No noNovo = no.getDireito(); // no "10" é o que vai subir
        int fbNo = no.getFB();
        int fbNoNovo = noNovo.getFB();

        if (noNovo.getEsquerdo() != null ){ // Caso se o nó que for subir tiver um filho esquerdo
            No noNovoEsquerdo = noNovo.getEsquerdo();
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
        } else {
            raiz = noNovo;
        }
        
        noNovo.setPai(paiNo);
        noNovo.setEsquerdo(no);
        no.setPai(noNovo);
        no.setFB(fbNo + 1 - Math.min(fbNoNovo, 0));
        noNovo.setFB(fbNoNovo + 1 + Math.max(no.getFB(), 0));

        return noNovo;
    }

    public No rotacionarDireita(No no){
        No paiNo = no.getPai();
        No noNovo = no.getEsquerdo();
        int fbNo = no.getFB();
        int fbNoNovo = noNovo.getFB();
        if (noNovo.getEsquerdo() != null){
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
        noNovo.setPai(paiNo);
        noNovo.setDireito(no);

        no.setFB(fbNo - 1 - Math.max(fbNoNovo, 0));
        noNovo.setFB(fbNoNovo - 1 + Math.min(no.getFB(), 0));

        return noNovo;

    }
    public void RotacaoDuplaEsquerda(No no){ // -2 e +1 = RDE
        no.setDireito(rotacionarDireita(no.getDireito())); // Falando pro no que vai rotacionar e que sua nova direita vai ser o resultado da rotação do seu filho a direita
        rotacionarEsquerda(no);
    }
    public void RotacaoDuplaDireita(No no){ // +2 e -1 = RDD
        no.setEsquerdo(rotacionarEsquerda(no.getEsquerdo())); // Falando pro no que vai rotacionar que sua nova esquerda vai ser o resultado da rotação do seu filho a esquerda
        rotacionarDireita(no);
    }
    public void Inserir(int valor){
        No temp = raiz;
        No pai = null;
        No novoNo = new No();
        novoNo.setValor(valor);

        if (isEmpty()){
            raiz = novoNo;
            return;
        }

        while (temp != null){
            pai = temp; 

            if (valor < temp.getValor()){
                temp = temp.getEsquerdo();
            } else {
                temp = temp.getDireito();
            }
        }

        novoNo.setPai(pai);

        if (valor < pai.getValor()){
            pai.setEsquerdo(novoNo);
        } else {
            pai.setDireito(novoNo);
        }

        AtualizarFBInsercao(novoNo);
    }
    public void Remover(No no){
        No buscar = raiz;
        No pai = null;
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
                No substituido = new No();
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
            // System.out.println("valor a ser removido:" + buscar.getValor());

            No sucessor = Sucessor(buscar);
            // System.out.println("sucessor:" + sucessor.getValor());

            // copia o valor
            buscar.setValor(sucessor.getValor());

            No paiSucessor = sucessor.getPai();
            No filho = sucessor.getDireito(); // único filho possível
            if (buscar.getDireito() == sucessor) {
                buscar.setDireito(filho);

                if (filho != null) {
                    filho.setPai(buscar);
                }

            } else { 
                paiSucessor.setEsquerdo(filho);

                if (filho != null) {
                    filho.setPai(paiSucessor);
                }
            }
        }
        
        AtualizarFBRemocao(no);

    }
    public void AtualizarFBInsercao(No no){
        if (no == raiz) return;
        No antecessor = no.getPai();
        while (antecessor != null){
            // caso eu queria ver os fbs e so descomentar essa linha System.out.println("Visitando: " + antecessor.getValor() + " FB: " + antecessor.getFB());
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
                        rotacionarDireita(antecessor); 
                    } else {
                        RotacaoDuplaDireita(antecessor); 
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
            antecessor = no.getPai(); // tem que mudar o valor de antecessor pra ele ir subindo na árvore
        }  
    }


    public void AtualizarFBRemocao(No no){
        if (no == raiz) return;
        No antecessor = no.getPai();
        while (antecessor != null){ 
            // caso eu queria ver os fbs e so descomentar essa linha System.out.println("Visitando: " + antecessor.getValor() + " FB: " + antecessor.getFB());
            if (antecessor.getEsquerdo() == no){ // remoçao no lado esquerdo
                antecessor.setFB(antecessor.getFB() - 1);
            } else{
                antecessor.setFB(antecessor.getFB() + 1);
            }
            if (antecessor.getFB() != 0) break;

            if (antecessor.getFB() == 2){
                No temp = antecessor.getEsquerdo();
                if (temp.getFB() >= 0 ){
                    rotacionarEsquerda(antecessor);
                } else{
                    RotacaoDuplaEsquerda(no);
                }
                break;
            }

            if (antecessor.getFB() == -2){
                No temp = antecessor.getDireito();
                if (temp.getFB() <= 0){
                    rotacionarDireita(antecessor);
                } else {
                    RotacaoDuplaDireita(antecessor);
                }
            }
        }

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
    // get e set
    public No getRaiz(){
        return raiz;
    }
    public void setRaiz(No novaRaiz){
        this.raiz = novaRaiz;
    }
}