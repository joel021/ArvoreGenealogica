package arvoregenealogica;

import java.util.Date;


public class ArvoreGenealogica {
    Elemento raiz;
    
    public class Elemento {
        
        Elemento pai; // aponta para um ponteiro que é o pai, o pai do pai é o avô e o atributo conjuge desse é a avó
        Elemento irmao; // -> se tiver irmão, aponta para ele, esse ponteiro pode ser uma lista simplesmente encadeada
        Elemento filho; // aponta para o primeiro filho -> pode ser uma lista se o filho tiver um irmão
        
        
        String name;
        String cidade;
        String conjuge;
        Date nascimento;
        String profissao;
        
    }
    
    
    public boolean adicionarElemento(int age, String name){
        return false;
    }
    
    public Elemento buscaPorNome(Elemento aux, String nome){
        return null;
    }
    
    public Elemento buscaPorCidade(Elemento aux, String cidade){
        return null;
    }
    
}
