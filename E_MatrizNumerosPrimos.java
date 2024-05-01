import java.util.*;
public class Main{
    static Scanner in = new Scanner(System.in);
    static int N = 350;
    static int sieve[] = new int[N];
    
    static int pr[] = new int[80];
    public static void main(String[] args){
        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        for(int i = 2; i*i < N; i++)
            if(sieve[i] == 0)
                for(int j = i*i; j < N; j+=i)
                    sieve[j] = 1;
        
        int cnt = 0;
        for(int i = 2; i < N; i++)
            if(sieve[i] == 0)
                pr[cnt++] = i;
        
        int sum = 0;
        for(int i = 0; i < cnt; i++)
            sum += pr[i];
            
        int v[][] = new int[n + 1][m + 1];
        int i = 0, j = -1;
        int aux = 1, pos = 0;
        while(i < n && j < m){
            int primo = pr[pos++];
            for(int k = 0; k <= primo; k++){
                j++;
                if(j == m){
                    i++;
                    j = 0;
                }
            }
            if(i < n && j <= m){
                v[i][j] = aux++;
            }
        }
        for(i = 0; i < n; i++){
            for(j = 0; j < m; j++)
                System.out.print(" "+ v[i][j]);
            System.out.println(" ");
        
        }
    }
    
}
