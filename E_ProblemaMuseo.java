package ejemplo;
import java.util.*;

public class Ejercicio {
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(j != matriz[i].length - 1){
                    System.out.print(matriz[i][j] + " ");
                }else{
                    System.out.println(matriz[i][j]);

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
        int n = lee.nextInt();
        Map<Integer, List<int[][]>> resultados = new HashMap<>();
        int max = -10000000;
        while(n --> 0){

            int a,b, valor, suma = 0;
            a = lee.nextInt();
            b = lee.nextInt();
            int [][] mt = new int[a][b];

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    mt[i][j] = lee.nextInt();
                    suma += mt[i][j];
                }
            }

            if(suma > max){
                max = suma;
            }
            resultados
                    .computeIfAbsent(suma, k -> new ArrayList<>())
                    .add(mt);

        }

        if(resultados.containsKey(max)){
            List<int[][]> matrices = resultados.get(max);
            for (int [][] matriz : matrices){
                mostrarMatriz(matriz);
                System.out.println();
            }
        }
    }
}
