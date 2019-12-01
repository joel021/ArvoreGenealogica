package arvoregenealogica;

import java.util.ArrayList;

// classe modelo

public class ArvoreGenealogica {
    Elemento raiz;
    
    public ArvoreGenealogica(String nome, String nascimento){
        
        raiz        = new Elemento(nome, nascimento, null);
    }
    
    public ArvoreGenealogica(){
        
        raiz        = null;
    }
    
    // só será possível adicionar um filho
    public Elemento getRaiz(){
        return raiz;
    }
    public void adicionarElemento(ArvoreRequisicoes contexto, String nome, String cidade, String mae, String nascimento, Elemento pai){
                
        // o parâmetro para adicionar um elemento é o atributo pai
        Elemento novoFilho  = new Elemento(nome, nascimento, pai); //nasceu o(a) menino(a)!
        novoFilho.setCidade(cidade);
        novoFilho.setConjuge("Solteiro");
        novoFilho.setProfissao("Desempregado");
        
        // caso inicial
        if(pai == null) {
            
            // pode ser que ele realmente quer colocar o primogenito
            if(raiz == null){
                raiz = novoFilho;
                
                // resultado
                ArrayList<Elemento> lista = elementos().paraArrayList();
                
                contexto.rAdicionar("Esse é o primogenito", lista);
                return;
            }else{
                System.out.println("raiz não nulo");
                // pode ser que ele não selecionou o pai na lista fornecida
                
                // resultado
                ArrayList<Elemento> lista = elementos().paraArrayList();
                contexto.rAdicionar("Não foi possível adicionar esse elemento porque você não disse quem é o pai e ele não é o primogenito.", lista);
                return;
            }
        }
        
        // caso geral
        
        
        // esse filho tem que ter uma mãe cadastrada na arvore, a unica forma é a associação com seu pai
        pai.conjuge = mae;
        
        //adicionar o filho na arvore
        
        Elemento irmaos = pai.filho;
        if(irmaos != null){
            
       //     System.out.println("Tem irmão");
            
            while(irmaos != null){
                
                System.out.println("irmao: "+irmaos.getNome());
                // percorre a lista de irmãos
                if(irmaos.irmao == null){
     //               System.out.println("Foi adicionado!");
                    irmaos.irmao = novoFilho;  // agora o novo é o ultimo irmão
                    break;
                }
                irmaos = irmaos.irmao;
            }
            
        }else{
   //         System.out.println("Não tem irmão! Adicionou!");
            pai.filho = novoFilho;
        }
        
        ArrayList<Elemento> lista = elementos().paraArrayList();
        contexto.rAdicionar("Pessoa adicionada na árvore com sucesso!", lista);
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
            
            buscaPorCidade(aux.filho, lista, cidade); 
               
            buscaPorCidade(aux.irmao, lista, cidade); 
        }
    }
    
    //LISTA DE TODOS OS ELEMENTOS
    public ListaEncadeada<Elemento> elementos(){
        
        
        ListaEncadeada<Elemento> lista = new ListaEncadeada<>();
        elementos(raiz, lista);
        
        return lista;
    }
    
    // busca por cidade modifica a lista de resultados, pois dois elementos podem estar na mesma cidade
    private void elementos(Elemento aux, ListaEncadeada<Elemento> lista){
        // O aux inicialmente é raiz!
        
        if(aux!= null){
            lista.adicionar(aux);
            
            elementos(aux.irmao, lista); // busca por todos os filhos desse elemento.
               
            elementos(aux.filho, lista); // desce mais uma vez na arvore e busca por todos irmãos
        }
        
    
        
    }
    
    public String getAvo(Elemento pessoa){
        buscaPorNome(pessoa.getNome());
        return "";
    }
    
    
    public void getPrimogenio(){
        System.out.println("Nome: " +raiz.getNome()+ ", Cidade: " + raiz.getCidade() + ", Conjugue: " + raiz.getConjuge());
    }
    
    public class Elemento {
        
        private Elemento pai; // aponta para um ponteiro que é o pai, o pai do pai é o avô e o atributo conjuge desse é a avó
        private Elemento irmao; // se tiver irmão, aponta para ele, esse ponteiro pode ser uma lista simplesmente encadeada
        private Elemento filho; // aponta para o primeiro filho -> pode ser uma lista se o filho tiver um irmão
        
        
        private String nome;
        private String cidade;
        private String conjuge;
        private String nascimento;
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

        public String getNascimento() {
            return nascimento;
        }

        public void setNascimento(String nascimento) {
            this.nascimento = nascimento;
        }

        public String getProfissao() {
            return profissao;
        }

        public void setProfissao(String profissao) {
            this.profissao = profissao;
        }
        
        
        public Elemento(String nome, String nascimento, Elemento pai){
            this.nome       = nome;
            this.pai        = pai;
            this.nascimento = nascimento;
            
            conjuge = "";
            profissao = "";
            
            filho = null;
            irmao = null;
        }
        
    }
    
    public interface ArvoreRequisicoes {
        
        // esse método recebe o resultado do pedido de adicionar
        public void rAdicionar(String msg, ArrayList<Elemento> elementos);
        
    }
}
