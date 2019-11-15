package arvoregenealogica;

import java.util.Date;

// classe modelo

public class ArvoreGenealogica {
    Elemento raiz;
    
    public ArvoreGenealogica(Elemento raiz){
        raiz.pai = null; // inicio da arvore
    }
    
    public boolean adicionarElemento(Elemento e){
        
        return false;
    }
    
    // dois Elementos podem ter o mesmo primeiro nome, então adiciona-se nome com o sobrenome
    public Elemento buscaPorNome(Elemento aux, String nome){
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
    
    // busca por cidade modifica a lista de resultados, pois dois elementos podem estar na mesma cidade
    public void buscaPorCidade(Elemento aux, ListaEncadeada<Elemento> lista, String cidade){
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
        }
        
    }
}
