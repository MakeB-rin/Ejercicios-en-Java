import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args){        
    
        Scanner lee = new Scanner(System.in);
        int cnt = 0;
        String cadena = "";
 
        ArrayList<Integer> numeros = new ArrayList<>();
 
        while(lee.hasNext()){
            cadena = lee.nextLine();
            if(!cadena.equals("Final de archivo"))
                numeros.add(Integer.parseInt(cadena));
            else
                break;
        }
 
        for(int i = 0; i < numeros.size(); i++){
            
            if(numeros.get(i) == 0){
                if(numeros.get(i-1) >  0 && numeros.get(i+1) < 0 ){
                    cnt++;
            
                }
            }
        }
 
        System.out.println(cnt);
    }
}
