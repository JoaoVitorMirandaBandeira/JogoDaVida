import java.util.*;
import java.util.Random;
import java.util.Arrays;

public class JogoDaVida {
   private Validacao validador = new Validacao();
   private Matriz matriz = new Matriz();
   private int[][] matrizAnterior ;
   private int[][] newMatriz ;
   
   //Responsavel por pegar todos os metodos do objeto matriz
   public Matriz getMetodosMatriz(){
    return matriz;
   }
   //responsavel por pegar o atributo matriz do objeto Matriz
   public int[][] getMatriz(){
      return matriz.getMatriz();
   }
   public int[][] getMatrizAnterior(){
      return matrizAnterior;
   }
   public int[][] getNewMatriz(){
      return newMatriz;
   }
   public void setMatrizAnterior(int[][] matriz){
      this.matrizAnterior = matriz;
   }
   public void setNewMatriz(int[][] matriz){
      this.newMatriz = matriz;
   }

   public int regrasDeAtualizacaoDaMatriz(int value, int somatorio) {
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

   public int[][] jogoDaVida(int[][] matriz, int k) {
      int contador = 0;
      k -= 1;
      int[][] matrizTemporaria = copiaMatriz(matriz);
      //System.out.println("N = " + k);
      for (int i = 0; i < matriz.length; i++) {
         for (int j = 0; j < matriz[i].length; j++) {
            // Valida onde esta sendo analisado a matriz, para fazer as tratativas coretas.
            if (validador.validacaoDasPontas(i, j, k)) {
               // Valida em qual canto esta sendo analisado
               if (validador.validaCantoSuperiorEsquerdo(contador)) {
                  // System.out.println("Estou no canto Superior Esquerdo");
                  int somatorio = matriz[i][k] + matriz[i][j + 1] + matriz[k][j] + matriz[i + 1][j];
                  matrizTemporaria[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador++;
               } else if (validador.validaCantoSuperiorDireito(contador)) {
                  // System.out.println("Estou no canto Superior Direito");
                  int somatorio = matriz[i][j - 1] + matriz[i][0] + matriz[k][j] + matriz[i + 1][j];
                  matrizTemporaria[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador++;
               } else if (validador.validaCantoInferiorEsquerdo(contador)) {
                  // System.out.println("Estou no canto Inferior Esquerdo");
                  int somatorio = matriz[i][k] + matriz[i][j + 1] + matriz[0][j] + matriz[i - 1][j];
                  matrizTemporaria[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador++;
               } else if (validador.validaCantoInferiorDireito(contador)) {
                  // System.out.println("Estou no canto Inferior Direito");
                  int somatorio = matriz[i][j - 1] + matriz[i][0] + matriz[0][j] + matriz[i - 1][j];
                  matrizTemporaria[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
                  somatorio = 0;
                  contador = 0;
               } else {
                  System.out.println("ERRO NO CANTO! \n VERIFIQUE A CLASSE DE LOGICA");
               }
               // Valida em qual canto esta sendo analisado
            } else if (validador.validaBordaSuperior(i, j, k)) {
               // System.out.println("Estou na borda Superior");
               int somatorio = matriz[i][j - 1] + matriz[i][j+1] + matriz[k][j] + matriz[i + 1][j];
               matrizTemporaria[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
            } else if (validador.validaBordaInferior(i, j, k)) {
               int somatorio = matriz[i][j - 1] + matriz[i][j+1] + matriz[i-1][j] + matriz[0][j];
               matrizTemporaria[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
               // System.out.println("Estou na borda Inferior");
            } else if (validador.validaBordaEsquerda(i, j, k)) {
               int somatorio = matriz[i][k] + matriz[i][j+1] + matriz[i-1][j] + matriz[i+1][j];
               matrizTemporaria[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
               // System.out.println("Estou na borda Esquerda");
            } else if (validador.validaBordaDireita(i, j, k)) {
               int somatorio = matriz[i][0] + matriz[i][j-1] + matriz[i-1][j] + matriz[i+1][j];
               matrizTemporaria[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
               // System.out.println("Estou na borda Direita");
            } else {
               int somatorio = matriz[i][j-1] + matriz[i][j+1] + matriz[i-1][j] + matriz[i+1][j];
               matrizTemporaria[i][j] = regrasDeAtualizacaoDaMatriz(matriz[i][j], somatorio);
               somatorio = 0;
               // System.out.println("Estou no meio");
            }
            // Valida onde esta sendo analisado a matriz, para fazer as tratativas coretas.
         }
      }
      return matrizTemporaria;
   }
   public int[][] copiaMatriz(int[][] original) {
      int[][] copy = new int[original.length][original[0].length];
      for (int i = 0; i < original.length; i++) {
          for (int j = 0; j < original[i].length; j++) {
              copy[i][j] = original[i][j];
          }
      }
      return copy;
   }
}