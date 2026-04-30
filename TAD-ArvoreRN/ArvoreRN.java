class No{
	int valor;
    String cor;
	No esquerdo;
	No direito;
    No pai;
	public No(){
		this.esquerdo = null;
		this.direito = null;
        this.pai = null;
        this.cor = "rubro";
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
    public int getValor(){
        return valor;
    public String getCor(){
        return cor;
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
    public void setCor(String cor){
        this.cor = cor;
    }
    }
    }

public class ArvoreRN{
    No raiz;
    public ArvoreRN(No raiz){
        this.raiz = raiz;
        this.cor = "negro";
    }
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
        return noNovo;
    }

    public No rotacionarDireita(No no){
        No paiNo = no.getPai();
        No noNovo = no.getEsquerdo();
        int fbNo = no.getFB();
        int fbNoNovo = noNovo.getFB();
        if (noNovo.getDireito() != null){
            No direito = noNovo.getDireito();
            no.setEsquerdo(direito);
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
    public void verificarCor(No no){
        No pai = no.getPai(); // pegando o pai do no
        No vo = pai.getPai(); // pegando o avo apartir do pai do no
        No tio = new No();
        if (vo.getDireito() == pai ) { // Caso o filho direito do vo for igual ao pai quer dizer que o tio sera o filho esquerdo do vo
            tio = vo.getEsquerdo();
        } else {
            tio = vo.getDireito();
        }
    }
    if (no.getCor() == "rubro" && pai.getCor() == "negro") { // Caso 01: se eu inserir e meu pai for negro 
        break; // então não precisa trocar minha cor.
    } else if (no.getCor() == "rubro" && pai.getCor() == "rubro" && tio.getCor == "rubro") { // Caso 02: se eu for rubro, pai rubro, tio rubro
        if (vo == raiz) { // Vo é raiz então ele mantém a cor e seus filhos viram negros.
            tio.setCor("negro");
            pai.setCor("negro");
        } else { // Vo não é raiz então ele vira rubro e seus filhos negros.
            vo.setCor("rubro");
            pai.setCor("negro");
            tio.setCor("negro")
        }
    } else { // Caso 03: eu sou rubro, pai rubro, vo negro e tio negro
        if (vo.getDireito().getCor()  == "rubro" && vo.getEsquerdo().getCor()  == "negro"  && no.getCor()  == "rubro"){ // rotacionar para a esquerda
            pai.setCor("negro");
            vo.setCor("rubro");
            rotacionarEsquerda(pai);
        } else if (vo.getDireito().getCor() == "negro" && vo.getEsquerdo().getCor()  == "rubro"  && no.getCor()  == "rubro"){ // rotacionar para a direita
            pai.setCor("negro");
            vo.setCor("rubro");
            rotacionarDireita(pai);
        } else if (vo.getCor() == "negro" && tio.getCor() == "negro" && pai.getCor() == "rubro" && pai.getEsquerdo().getCor() == "rubro" ){ // Rotação direita dupla
            no.setCor("negro");
            vo.setCor("rubro")
            RotacaoDuplaDireita(no);
        } else{ // Rotação dupla esquerda
            no.setCor("negro");
            vo.setCor("rubro")
            RotacaoDuplaEsquerda(no);
        }
 
    }
        
    
    public void inserir (int valor){
        No novoNo = new No();
        if (isEmpty()) { // se a árvore tiver vazia novo no é o raiz.
            raiz = novoNo;
            return;
        }
        No pai = null;
        No temp = raiz;

        while (temp != null){
            pai = temp; // Sempre que eu andar para um lado eu atualizo o pai 
            if (valor > temp.getValor() ){ // Se o valor é maior que o valor atual então ele está para a direita
                temp = temp.getDireito();
            } else {
                temp = temp.getEsquerdo();
            }
        }
        novoNo.setPai(pai);

        if (valor < pai.getValor()){ // isso daqui só  pra avisar pro pai para qual lado ta o filho dele
            pai.setEsquerdo(novoNo);
        } else {
            pai.setDireito(novoNo);
        }
    }
    verificarCor(novoNo);

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
            No sucessor = Sucessor(buscar);
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
        if (no.getCor() == "rubro" && buscar.getCor() == "rubro"){
            return
        } else if (no.getCor() == "negro" && buscar.getCor() == "rubro"){
            buscar.setCor("rubro");
            return;
        } else if (no.getCor() == "negro" && buscar.getCor() == "negro"){
            situacao03(buscar);
        } else if (no.getCor() == "rubro" && buscar.getCor() == "negro"){
            buscar.setCor("rubro");
            situacao03(buscar)
        }
        
    }
    public void situacao03(No v){ // No removido
        No filho = Sucessor(v); // No sucessor
        No pai = x.getPai(); // Pai do sucessor
        No irmao = new No(); // irmão do sucessor
        if (pai.getEsquerdo == x){
            irmao = pai.getDireito()
        } else {
            irmao = pai.getEsquerdo()
        }
        if (filho.getCor() == "negro" && irmao.getCor() == "rubro" && pai.getCor() == "negro"){ // caso 01
            rotacionarEsquerda(irmao);
            irmao.setCor("negro"); // o irmão agora é o pai
            pai.setCor("rubro"); // e o pai virou filho esquerdo do irmão
            situacao03()
        
        }
        else if (filho.getCor() == "negro" && irmao.getCor() == "negro" && pai.getCor() == "negro"){ // caso 2a
            irmao.setCor("rubro");
            if (pai.getPai() != null) {situacao03(pai);} // esse pai.getpai() é uma gambiarra mas ele basicamente se o pai desse pai for null quer dizer q ele é a raiz então não tem pra onde ir
        } 
        else if (filho.getCor() == "negro" && irmao.getCor() == "negro" && pai.getCor() == "rubro"){ // caso 2b
            irmao.setCor("rubro");
            pai.setCor("negro");
            return;
        }
        caso3
        else {
            rotacionarEsquerda(irmao); //rotacione a esquerda
            irmao.setCor(pai.getCor()); // o irmao que vai virar o pai vai ter a cor do seu antigo pai
            irmao.getDireito().setCor("negro"); // filho direito do irmao vira negro
        }
        return;
    public No Sucessor(No no){ // o no que foi atribuido e o mesmo que foi removido
        if (no == null || no.getDireito() == null) return null;
        No sucessor = no.getDireito(); // ponto de partida do while
        while (sucessor.getEsquerdo() != null ){
            sucessor = sucessor.getEsquerdo();
        }
        return sucessor;
    }

    }
}