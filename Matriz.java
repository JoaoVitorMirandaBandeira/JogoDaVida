import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Matriz {
    Scanner leia = new Scanner(System.in);
    private int n;
    private int[][] matriz;

    public void definirDimencaoMatriz() {
        System.out.println("Qual tamanho da Matriz?");
        n = leia.nextInt();
        this.matriz = new int[n][n];
    }
    public int length(){
      return this.matriz.length;
    }
    public int[][] getMatriz(){
      return this.matriz;
    }
    public void setMatriz(int[][] matriz){
      this.matriz = matriz;
    }
    // Declaração do método formatarMatriz
    public String formatarMatriz() {
        String matrizFormatada = "";
        for (int[] i : matriz) {
            for (int j : i) {
                matrizFormatada += j + " ";
            }
            matrizFormatada += "\n";
        }
        return matrizFormatada;
    }
    // Declaração do método formatarMatriz

    // Declaração do método gerarNumerosAleatorios
    public int gerarNumerosAleatorios() {
        Random rand = new Random();
        int random = rand.nextInt(2);
        return random;
    }
    // Declaração do método gerarNumerosAleatorios

    // Declaração do método preencherMatriz
    public void preencherMatriz() {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                matriz[i][j] = gerarNumerosAleatorios();
            }
        }
    }
    // Declaração do método preencherMatriz
}