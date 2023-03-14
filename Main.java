import java.util.*;
import java.util.Random;
import java.util.Arrays;

public class Main {
   public static void main(String[] args) {
      JogoDaVida jogo = new JogoDaVida();
      //jogo.getMatriz();
      jogo.getMetodosMatriz().definirDimencaoMatriz();
      jogo.getMetodosMatriz().preencherMatriz();
      // Chama o método formatarMatriz para imprimir a matriz formatada
      System.out.println(jogo.getMetodosMatriz().formatarMatriz());
      
      do {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Pressione Enter para continuar...");
         scanner.nextLine(); // aguarda a entrada do usuário
         jogo.setMatrizAnterior(jogo.copiaMatriz(jogo.getMatriz()));
         jogo.setNewMatriz(jogo.jogoDaVida(jogo.getMatriz(), jogo.getMetodosMatriz().length()));
         jogo.getMetodosMatriz().setMatriz(jogo.getNewMatriz());
         System.out.println(jogo.getMetodosMatriz().formatarMatriz());
      } while (!Arrays.deepEquals(jogo.getMatrizAnterior(), jogo.getNewMatriz()));
      System.out.println("Fim de Jogo...");
   }
}