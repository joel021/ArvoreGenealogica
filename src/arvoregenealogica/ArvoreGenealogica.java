package arvoregenealogica;

import java.util.Date;

// classe modelo

public class ArvoreGenealogica {
    Elemento raiz;
    
    public ArvoreGenealogica(String nome, Date nascimento){
        
        raiz        = new Elemento(nome, nascimento, null);
    }
    
    // só será possível adicionar um filho
    public boolean adicionarElemento(String nome, String cidade, String mae, Date nascimento, String nomePai, Elemento pai){
        // o parâmetro para adicionar um elemento é o atributo pai
        
        if(pai == null){
            // busca o pai
            pai = buscaPorNome(raiz, nomePai); // pega o pai dele
        }
        
        Elemento novoFilho  = new Elemento(nome, nascimento, pai); //nasceu o(a) menino(a)!
        
        // esse filho tem que ter uma mãe cadastrada na arvore, a unica forma é a associação com seu pai
        if(pai.conjuge.equals("")){
            pai.conjuge = mae;
        }
        
        //adicionar o filho na arvore
        
        Elemento irmaos = pai.filho;
        while(irmaos.irmao != null){
            // percorre a lista de irmãos
            irmaos = irmaos.irmao;
        }
        
        irmaos.irmao = novoFilho;  // agora o novo é o ultimo irmão
        
        return true;
    }
    
    public Elemento buscaPorNome(String nome){
        return buscaPorNome(raiz, nome);
    }
    
    
    // dois Elementos podem ter o mesmo primeiro nome, então adiciona-se nome com o sobrenome
    private Elemento buscaPorNome(Elemento aux, String nome){
        // O aux inicialmente é raiz!
        
        if(aux!= null){
            if(aux.nome.equals(nome)){
                return aux;
            }else{
                Elemento e = buscaPorNome(aux.irmao, nome); // busca por todos os filhos desse elemento.
                
                if(e != null){
                    return e; // retorna o valor encontrado
                }else{
                    return buscaPorNome(aux.filho, nome); // desce mais um nivel na arvore e percorre todos os irmaos
                }
            }
        }
        
        return null;
    }
    
    public ListaEncadeada<Elemento> buscaPorCidade(String cidade){
        ListaEncadeada<Elemento> lista = new ListaEncadeada<>();
        buscaPorCidade(raiz, lista, cidade);
        
        return lista;
    }
    
    // busca por cidade modifica a lista de resultados, pois dois elementos podem estar na mesma cidade
    private void buscaPorCidade(Elemento aux, ListaEncadeada<Elemento> lista, String cidade){
        // O aux inicialmente é raiz!
        
        if(aux!= null){
            if(aux.cidade.equals(cidade)){
                lista.adicionar(aux);
            }
            
            buscaPorCidade(aux.irmao, lista, cidade); // busca por todos os filhos desse elemento.
               
            buscaPorCidade(aux.pai, lista, cidade); // desce mais uma vez na arvore e busca por todos irmãos
        }
    }
    
    public class Elemento {
        
        private Elemento pai; // aponta para um ponteiro que é o pai, o pai do pai é o avô e o atributo conjuge desse é a avó
        private Elemento irmao; // se tiver irmão, aponta para ele, esse ponteiro pode ser uma lista simplesmente encadeada
        private Elemento filho; // aponta para o primeiro filho -> pode ser uma lista se o filho tiver um irmão
        
        
        private String nome;
        private String cidade;
        private String conjuge;
        private Date nascimento;
        private String profissao;

        public Elemento getPai() {
            return pai;
        }

        public void setPai(Elemento pai) {
            this.pai = pai;
        }

        public Elemento getIrmao() {
            return irmao;
        }

        public void setIrmao(Elemento irmao) {
            this.irmao = irmao;
        }

        public Elemento getFilho() {
            return filho;
        }

        public void setFilho(Elemento filho) {
            this.filho = filho;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getConjuge() {
            return conjuge;
        }

        public void setConjuge(String conjuge) {
            this.conjuge = conjuge;
        }

        public Date getNascimento() {
            return nascimento;
        }

        public void setNascimento(Date nascimento) {
            this.nascimento = nascimento;
        }

        public String getProfissao() {
            return profissao;
        }

        public void setProfissao(String profissao) {
            this.profissao = profissao;
        }
        
        
        public Elemento(String nome, Date nascimento, Elemento pai){
            this.nome       = nome;
            this.pai        = pai;
            this.nascimento = nascimento;
            
            conjuge = "";
            profissao = "";
            
            filho = null;
            irmao = null;
        }
        
    }
}
