class Matriz{
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
   //Declaração do método preencherMatriz
}
