import java.util.*;
import java.util.Random;
import java.util.Arrays;

public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      JogoDaVida jogo = new JogoDaVida();
      //jogo.getMatriz();
      jogo.getMetodosMatriz().definirDimencaoMatriz();
      jogo.getMetodosMatriz().preencherMatriz();
      // Chama o método formatarMatriz para imprimir a matriz formatada
      System.out.println(jogo.getMetodosMatriz().formatarMatriz());
      System.out.println("Pressione Enter para continuar...");
      scanner.nextLine(); // aguarda a entrada do usuário
      do {
         jogo.setMatrizAnterior(jogo.copiaMatriz(jogo.getMatriz()));
         jogo.setNewMatriz(jogo.jogoDaVida(jogo.getMatriz(), jogo.getMetodosMatriz().length()));
         jogo.getMetodosMatriz().setMatriz(jogo.getNewMatriz());
         System.out.println(jogo.getMetodosMatriz().formatarMatriz());
         if (Arrays.deepEquals(jogo.getMatrizAnterior(), jogo.getNewMatriz())) {
           System.out.println("Matriz idêntica à anterior\nPressione Enter para continuar ou 'q' para sair...");
           String input = scanner.nextLine();
           if (input.equalsIgnoreCase("q")) {
              break;
           }
         }else{
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine(); // aguarda a entrada do usuário
         }
      } while (true);
      System.out.println("Fim de Jogo...");
   }
}