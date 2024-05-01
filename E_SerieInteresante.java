import java.util.*;
class Main{
    static Scanner in = new Scanner(System.in);
    static int N = 10000;
    static int sieve[] = new int[N];
    
    static int pr[] = new int[1500];
    static int acc[] = new int[1500];
    static int pos = 0;
    public static void main(String[] args) {
        int n = in.nextInt();
        sieve();
        prefix();
        solve(n);
    }
    public static void sieve(){
        for(int i = 2; i*i < N; i++)
            if(sieve[i] == 0)
        for(int j = i*i; j < N; j+=i)
            sieve[j] = 1;
        
        for(int i = 2; i < N; i++)
            if(sieve[i] == 0)
                pr[pos++] = i;
    }
    public static void prefix(){
        acc[0] = pr[0];
        for(int i = 1; i < pos; i++)
            acc[i] = acc[i - 1] + pr[i];
    }
    public static void solve(int n){
        int pos = 1;
        int valor = 2;
        for(int i = 0; i < n; i++){
            System.out.print(" " + valor);
            valor += acc[pos++]; 
        }
    }
}
