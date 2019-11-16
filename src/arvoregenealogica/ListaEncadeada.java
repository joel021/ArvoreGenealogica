package arvoregenealogica;

// lista comum

import arvoregenealogica.ArvoreGenealogica.Elemento;
import java.util.ArrayList;

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
   
    
    public ArrayList<T> paraArrayList(){
        Objeto aux = primeiro;
        
        if(aux == null)
            return null;
        
        ArrayList<T> lista = new ArrayList();
        
        do {
            lista.add(aux.elemento);
            aux = aux.prox;
        }while(aux != null);

        return lista;
    }
    
}
