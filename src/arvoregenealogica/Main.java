package arvoregenealogica;

import arvoregenealogica.controlador_view.TelaInicial;


public class Main {
    ArvoreGenealogica arvore;
    
    public static void main(String[] args) {
        
        Main m = new Main();
        
    }
    
    public Main(){
        arvore = new ArvoreGenealogica();
        
        // incia a primeeira tela
        TelaInicial telaInicial = new TelaInicial(arvore);
        telaInicial.setVisible(true);
        
    }
    
    
}
