import java.util.*;
import java.util.Random;

public class JogoDaVida{
   //Declaração do método formatarMatriz
   public static String formatarMatriz(int[][] matriz){
      String matrizFormatada = "";
      for(int[] i : matriz){
         for(int j : i){
            matrizFormatada += j + " "; 
         }
         matrizFormatada += "\n";
      }
      return matrizFormatada;-
   }
   //Declaração do método formatarMatriz
   
   //Declaração do método gerarNumerosAleatorios
   public static int gerarNumerosAleatorios(){
      Random rand = new Random();
      int random = rand.nextInt(2);
      return random;
   }
   //Declaração do método gerarNumerosAleatorios
   
   //Declaração do método preencherMatriz
   public static void preencherMatriz(int[][] matriz){
      for(int i = 0; i < matriz.length; i++){
         for(int j = 0; j < matriz[i].length; j++){
            matriz[i][j] = gerarNumerosAleatorios(); 
         }
      }
   }
   //Declaração do método preencherMatriz
   
   
   /*
   C = Teremos 4 validações para os cantos matriz[0][0] matriz[0][3] matriz[3][0] matriz[3][3]
   F = Teremos 4 validações para as faces do canto 
   M = Teremos validação para a meiuca 
   
   C F F C
   F M M F
   F M M F
   C F F C 
   
   */
   
   public static void main(String[] args){
      //Variaveis
      Scanner leia = new Scanner(System.in);
      int n;
      //Variaveis
      
      //Declara o tamnho da Matriz
      System.out.println("Qual tamanho da Matriz?");
      n = leia.nextInt();
      int[][] matriz = new int[n][n];
      //Declara o tamnho da Matriz
      preencherMatriz(matriz);
      //Chama o método formatarMatriz para imprimir a matriz formatada
      System.out.println(formatarMatriz(matriz));  
   }
}