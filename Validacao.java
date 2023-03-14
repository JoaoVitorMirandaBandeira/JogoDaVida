class Validacao{
//Classe responsavel por todas as validações grandes do tabuleiro.
   //Metodo para validar se o jogo esta analizando uma das 4 bordas da matriz
   public static boolean validacaoDasPontas(int linha, int coluna,int length) {
	   if( ( linha == 0 && coluna == 0) || ( linha == 0 && coluna == length) || ( linha == length && coluna == 0 ) || ( linha == length && coluna == length )){
         return true;
      }else{
         return false;
      }
   }
   //Metodo para validar se o jogo esta na PRIMEIRA LINHA da matriz e não esta em uma das bordas
   public static boolean validaBordaSuperior(int linha, int coluna,int length) {
      if(( linha == 0 && coluna != 0) && coluna != length){
         return true;
      }else{
         return false;
      }
   }
   //Metodo para validar se o jogo esta na ULTIMA LINHA da matriz e não esta em uma das bordas
   public static boolean validaBordaInferior(int linha, int coluna,int length) {
      if( ( linha == length && coluna != 0) && coluna != length){
         return true;
      }else{
         return false;
      }
   }
   //Metodo para validar se o jogo esta na PRIMEIRA COLUNA da matriz e não esta em uma das bordas
   public static boolean validaBordaEsquerda(int linha, int coluna,int length) {
      if( (coluna == 0 &&  linha != 0) &&  linha != length){
         return true;
      }else{
         return false;
      }
   }
   //Metodo para validar se o jogo esta na ULTIMA COLUNA da matriz e não esta em uma das bordas
   public static boolean validaBordaDireita(int linha, int coluna,int length) {
      if( (coluna == length &&  linha != 0) &&  linha != length){
         return true;
      }else{
         return false;
      }
   }
   //Valida se a analise esta no CANTO SUPERIOR ESQUERDO
   public static boolean validaCantoSuperiorEsquerdo(int contador){
      if(contador == 0){
         return true;
      }
      return false;
   }
   //Valida se a analise esta no CANTO SUPERIOR DIREITO
   public static boolean validaCantoSuperiorDireito(int contador){
      if(contador == 1){
         return true;
      }
      return false;
   }
   //Valida se a analise esta no CANTO INFERIOR ESQUERDO
   public static boolean validaCantoInferiorEsquerdo(int contador){
      if(contador == 2){
         return true;
      }
      return false;
   }
   ////Valida se a analise esta no CANTO INFERIOR DIREITO
   public static boolean validaCantoInferiorDireito(int contador){
      if(contador == 3){
         return true;
      }
      return false;
   }
}