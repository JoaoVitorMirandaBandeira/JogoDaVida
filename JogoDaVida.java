import java.util.*;
import java.util.Random;
import java.util.Arrays;

public class JogoDaVida {
   static Validacao validador = new Validacao();
   static Matriz matriz = new Matriz();
   static int[][] matrizAnterior ;
   static int[][] newMatriz ;

   // Declaração do método gerarNumerosAleatorios
   public static int gerarNumerosAleatorios() {
      Random rand = new Random();
      int random = rand.nextInt(2);
      return random;
   }
   // Declaração do método gerarNumerosAleatorios

   // Declaração do método preencherMatriz
   public static void preencherMatriz(int[][] matriz) {
      for (int i = 0; i < matriz.length; i++) {
         for (int j = 0; j < matriz[i].length; j++) {
            matriz[i][j] = gerarNumerosAleatorios();
         }
      }
   }

   // Declaração do método preencherMatriz
   public static int regrasDeAtualizacaoDaMatriz(int value, int somatorio) {
      if (value == 1) {
         if (somatorio < 2) {
            return 0;
         } else if (somatorio > 3) {
            return 0;
         }
      } else {
         if (somatorio == 3) {
            return 1;
         }
      }
      return value;
   }

   public static int[][] jogoDaVida(int[][] matriz, int k) {
      int contador = 0;
      k -= 1;
      System.out.println("N = " + k);
      for (int i = 0; i < matriz.length; i++) {
         for (int j = 0; j < matriz[i].length; j++) {
            // Valida onde esta sendo analisado a matriz, para fazer as tratativas coretas.
            if (validador.validacaoDasPontas(i, j, k)) {
               // Valida em qual canto esta sendo analisado
               if (validador.validaCantoSuperiorEsquerdo(contador)) {
                  // System.out.println("Estou no canto Superior Esquerdo");
                  int somatorio = matriz[i][k] + matriz[i][j + 1] + matriz[k][j] + matriz[i + 1][j];
                  matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador++;
               } else if (validador.validaCantoSuperiorDireito(contador)) {
                  // System.out.println("Estou no canto Superior Direito");
                  int somatorio = matriz[i][j - 1] + matriz[i][0] + matriz[k][j] + matriz[i + 1][j];
                  matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador++;
               } else if (validador.validaCantoInferiorEsquerdo(contador)) {
                  // System.out.println("Estou no canto Inferior Esquerdo");
                  int somatorio = matriz[i][k] + matriz[i][j + 1] + matriz[0][j] + matriz[i - 1][j];
                  matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador++;
               } else if (validador.validaCantoInferiorDireito(contador)) {
                  // System.out.println("Estou no canto Inferior Direito");
                  int somatorio = matriz[i][j - 1] + matriz[i][0] + matriz[0][j] + matriz[i - 1][j];
                  matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador = 0;
               } else {
                  System.out.println("ERRO NO CANTO! \n VERIFIQUE A CLASSE DE LOGICA");
               }
               // Valida em qual canto esta sendo analisado
            } else if (validador.validaBordaSuperior(i, j, k)) {
               // System.out.println("Estou na borda Superior");
               int somatorio = matriz[i][j - 1] + matriz[i][j+1] + matriz[k][j] + matriz[i + 1][j];
               matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
            } else if (validador.validaBordaInferior(i, j, k)) {
               int somatorio = matriz[i][j - 1] + matriz[i][j+1] + matriz[i-1][j] + matriz[0][j];
               matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
               // System.out.println("Estou na borda Inferior");
            } else if (validador.validaBordaEsquerda(i, j, k)) {
               int somatorio = matriz[i][k] + matriz[i][j+1] + matriz[i-1][j] + matriz[i+1][j];
               matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
               // System.out.println("Estou na borda Esquerda");
            } else if (validador.validaBordaDireita(i, j, k)) {
               int somatorio = matriz[i][0] + matriz[i][j-1] + matriz[i-1][j] + matriz[i+1][j];
               matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
               // System.out.println("Estou na borda Direita");
            } else {
               int somatorio = matriz[i][j-1] + matriz[i][j+1] + matriz[i-1][j] + matriz[i+1][j];
               matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
               // System.out.println("Estou no meio");
            }
            // Valida onde esta sendo analisado a matriz, para fazer as tratativas coretas.
         }
      }
      return matriz;
   }
   public static int[][] copiaMatriz(int[][] original) {
      int[][] copy = new int[original.length][original[0].length];
      for (int i = 0; i < original.length; i++) {
          for (int j = 0; j < original[i].length; j++) {
              copy[i][j] = original[i][j];
          }
      }
      return copy;
  }

   public static void main(String[] args) {
      // Variaveis
      matriz.definirDimencaoMatriz();
      // Variaveis
      matriz.preencherMatriz();
      // Chama o método formatarMatriz para imprimir a matriz formatada
      System.out.println(matriz.formatarMatriz());
      
do {
   Scanner scanner = new Scanner(System.in);
    matrizAnterior = copiaMatriz(matriz.getMatriz());
   //  System.out.println(matriz.formatarMatriz());
    newMatriz = jogoDaVida(matriz.getMatriz(), matriz.length());
    matriz.setMatriz(newMatriz);
    System.out.println(matriz.formatarMatriz());
    System.out.println(!Arrays.deepEquals(matrizAnterior, newMatriz));
    System.out.println("Pressione Enter para continuar...");
    scanner.nextLine(); // aguarda a entrada do usuário
} while (!Arrays.deepEquals(matrizAnterior, newMatriz));
   }
}