
package arvoregenealogica;

import arvoregenealogica.ArvoreGenealogica.Elemento;
import arvoregenealogica.controlador_view.TelaInicial;
import java.util.Date;

 
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
