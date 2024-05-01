import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        
        String str = in.nextLine();
        String ans = f(str);
        System.out.println(ans);
    }
    
    public static String f(String s){
        String ans = "";
        int n = s.length();
        for(int i = 0; i < n; i++){
            String aux = "";
            int vocales = 0;
            while(i < n && s.charAt(i) != ' '){
                if(isVocal(s.charAt(i))){
                    vocales++;
                }
                aux += s.charAt(i++);
            }
            if(vocales%2 == 1){
                ans += elimina(aux, vocales) + " ";
            }else{
                ans += aux + " ";
            }
        }
        return ans;
    }
    public static boolean isVocal(char x){
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }
    public static String elimina(String s, int v){
        String ans = "";
        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n ; i++){
            if(isVocal(s.charAt(i)))
                cnt++;
            if(cnt != v/2 + 1 || !isVocal(s.charAt(i)))
                ans +=  s.charAt(i);
        }
        return ans;
    }
    
}
