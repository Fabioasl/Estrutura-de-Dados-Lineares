class Aluno{
    private int ra = -1; // -1 pois inicialmente ele está vazio, caso tenha sido preenchido mas removido o valor -2 será atribuido
    private string nome = " ";
    public Aluno(int ra, string nome){
        this.ra = ra;
        this.nome = nome;
    }
public int getRa(){
    return this.ra;
}
public string getNome(){
    return this.nome;
}
} 

public class Hash{
    public int max_items;
    private int max_position;
    public int qtd_items;
    public Aluno [] alunos;
    public Hash(int max_items, int max_position){
        this.max_items = max_items; // Quantos itens terão no máximo
        this.max_position = max_position; // Tamanho da tabela hash
        this.qtd_items =  0; // Quantos espaçoes estão ocupados
        alunos =  new Aluno[max_position];
    }
public int funcaoHash(Aluno aluno){ //Função de espaçamento
    return  (this.aluno.getRa() % max_position);
}
public bool isFull(){
    return qtd_items == max_items;
}
public int tamanho(){
    return qtd_items;
}
public void inserir(Aluno aluno){
    int local = funcaoHash(aluno);
    while (alunos[local].getRa() > 0){
        local = (local + 1) % max_position;
    }
    alunos[local] = aluno;
    qtd_items++;
    
}
public void deletar(Aluno aluno){
    int local = funcaoHash(aluno);
    bool teste = false;
    while (alunos[local].getRa() != -1){
        if (alunos[local].getRa()  == aluno.getRa()){
            alunos[local] = Aluno(-2, " ");
            qtd_items--;
            teste  = true;
            break;
        }  
        local = (local + 1) % max_position;
    }
    // envia mensagem avisando que não foi encontrado
    // if (!teste){
    // }
}
public void buscar(Aluno aluno, bool busca){
    int local = funcaoHash(aluno);
    busca = false;
    while (alunos[local].getRa() != -1){
        if (alunos[local].getRa == aluno.getRa()){
            busca = true;
            aluno = alunos[local];
            break;
        }
        local = (local + 1) % max_position;
    }
}