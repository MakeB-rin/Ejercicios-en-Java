import java.util.Scanner;
import java.util.ArrayList;
 
public class Main {
    
    static final int N = (int)1e5 + 10;
    static ArrayList <Boolean> primos = new ArrayList<>();
    static ArrayList<Integer> vec = new ArrayList<>();
 
    public static void numerosPrimos(){
        for(int i = 0; i < N; i++){
            primos.add(true);
        }
        
        primos.set(0, false);        
        primos.set(1, false);
        
        for(int i = 2; i*i < N; i++){
            if(primos.get(i) == true){
                for(int j = i*i; j < N; j+=i){
                    primos.set(j, false);
                }       
            }
        }
        
        for(int i = 0; i < N; i++){
            if(primos.get(i) == true){
                vec.add(i);
            }
        }
    }
        
    public static void main(String[] args){
 
        Scanner l = new Scanner(System.in);        
        numerosPrimos();
 
        int numero = l.nextInt();
        int[][] mat = new int[numero][numero];
        int cnt = 0, fn = 0, cn = 0;
        fn = numero - 1;
        
        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < numero; j++) {
                mat[i][j] = 0;
            }
        }
 
 
        for (int i = 0; i < numero; i++) {                 
            mat[fn][i] = vec.get(i);
            cnt++;
            cn++;
            fn--;
        }
        
        fn = 0;
        for (int j = 1; j < numero; j++){
            mat[j][cn-1] = (vec.get(cnt));
            cnt++;
            fn++;
        } 
 
        for (int j = cn - 2; j >= 1; j--){
            mat[fn][j] = (vec.get(cnt));
            cnt++; 
        }
 
        for (int j = fn - 1; j >= 1; j--){
            mat[j][0] = (vec.get(cnt));
            cnt++; 
        }
        
        for (int j = 0; j < numero-1; j++){
            mat[0][j] = (vec.get(cnt));
            cnt++;
        }
        
        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < numero; j++) {
                if(j == numero - 1){
                    System.out.println(mat[i][j]);
                }else{
                    System.out.print(mat[i][j] + " ");
                }
            }
        }
    }   
}
