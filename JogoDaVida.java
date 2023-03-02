import java.util.*;
import java.util.Random;

public class JogoDaVida {
   static Validacao validador = new Validacao();
   static Matriz matriz = new Matriz();

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
                  System.out.println("Estou no canto Superior Esquerdo");
                  int somatorio = matriz[i][k] + matriz[i][j + 1] + matriz[k][j] + matriz[i + 1][j];
                  matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador++;
               } else if (validador.validaCantoSuperiorDireito(contador)) {
                  System.out.println("Estou no canto Superior Direito");
                  int somatorio = matriz[i][j - 1] + matriz[i][0] + matriz[k][j] + matriz[i + 1][j];
                  matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador++;
               } else if (validador.validaCantoInferiorEsquerdo(contador)) {
                  System.out.println("Estou no canto Inferior Esquerdo");
                  int somatorio = matriz[i][k] + matriz[i][j + 1] + matriz[0][j] + matriz[i - 1][j];
                  matriz[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador++;
               } else if (validador.validaCantoInferiorDireito(contador)) {
                  System.out.println("Estou no canto Inferior Direito");
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
               System.out.println("Estou no meio");
            }
            // Valida onde esta sendo analisado a matriz, para fazer as tratativas coretas.
         }
      }
      return matriz;
   }

   public static void main(String[] args) {
      // Variaveis
      Scanner leia = new Scanner(System.in);
      matriz.definirDimencaoMatriz();
      // Variaveis
      matriz.preencherMatriz();
      // Chama o método formatarMatriz para imprimir a matriz formatada
      System.out.println(matriz.formatarMatriz());
      System.out.println(matriz.length());
      System.out.println(matriz.getMatriz());
      matriz.setMatriz(jogoDaVida(matriz.getMatriz(), matriz.length()));
      System.out.println(matriz.formatarMatriz());
   }
}