package arvoregenealogica;

// lista comum
public class ListaEncadeada <T> {
    private Objeto primeiro;
    private int tamanho;
    
    public class Objeto {
        private T elemento;
        private Objeto prox;
        
        public Objeto(T elemento){
            tamanho         = 0;
            this.elemento   = elemento;
        }
    }
    
    public void adicionar(T novo){
        Objeto novoE = new Objeto(novo);
        
        if(primeiro == null){
            primeiro = novoE;
            
        }else{
            novoE.prox  = primeiro;
            primeiro    = novoE;
        }
        
        tamanho++;
    }
}
