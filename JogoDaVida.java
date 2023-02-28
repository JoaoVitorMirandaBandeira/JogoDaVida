import java.util.*;
import java.util.Random;

public class JogoDaVida{
   static int n;
   static int[][] matriz = new int[n][n];
	
   //Declaração do método formatarMatriz
   public static String formatarMatriz(int[][] matriz){
      String matrizFormatada = "";
      for(int[] i : matriz){
         for(int j : i){
            matrizFormatada += j + " "; 
         }
         matrizFormatada += "\n";
      }
      return matrizFormatada;
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
   
   public static boolean validacaoDasPontas(int i, int j,int k) {
   
	   if( (i == 0 && j == 0) || (i == 0 && j == k) || (i == k && j == 0 ) || ( i== k && j == k )){
         return true;
      }else{
         return false;
      }
   }
   public static boolean validaBordaSuperior(int i, int j,int k) {
      if((i == 0 && j != 0) && j != k){
         return true;
      }else{
         return false;
      }
   }
   public static boolean validaBordaInferior(int i, int j,int k) {
      if( (i == k && j != 0) && j != k){
         return true;
      }else{
         return false;
      }
   }
   public static boolean validaBordaEsquerda(int i, int j,int k) {
      if( (j == 0 && i != 0) && i != k){
         return true;
      }else{
         return false;
      }
   }
   public static boolean validaBordaDireita(int i, int j,int k) {
      if( (j == k && i != 0) && i != k){
         return true;
      }else{
         return false;
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
   public static void jogoDaVida(int[][] matriz,int k){
      k-=1;
      System.out.println("N = "+ k);
       for(int i = 0; i < matriz.length; i++){
         for(int j = 0; j < matriz[i].length; j++){
             if(validacaoDasPontas(i,j,k)){
               System.out.println("Estou no canto");
             }else if(validaBordaSuperior(i,j,k)){
               System.out.println("Estou na borda Superior");
             }else if(validaBordaInferior(i,j,k)){
               System.out.println("Estou na borda Inferior");
             }else if(validaBordaEsquerda(i,j,k)){
               System.out.println("Estou na borda Esquerda");
             }else if(validaBordaDireita(i,j,k)){
               System.out.println("Estou na borda Direita");
             }else{
               System.out.println("Estou no meio");
             }
         }
      }
   
   }
   
   public static void main(String[] args){
      //Variaveis
      Scanner leia = new Scanner(System.in);
      
      //Variaveis
      
      //Declara o tamnho da Matriz
      System.out.println("Qual tamanho da Matriz?");
      int n = leia.nextInt();
      matriz = new int[n][n];
      //Declara o tamnho da Matriz
      preencherMatriz(matriz);
      //Chama o método formatarMatriz para imprimir a matriz formatada
      System.out.println(formatarMatriz(matriz));
      jogoDaVida(matriz,matriz.length);
   }
}