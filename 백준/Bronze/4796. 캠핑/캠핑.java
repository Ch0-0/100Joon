import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        int count = 1;
        while(L!=0 || P!=0 || V!=0) {
        int result = 0;
        result += (V/P) * L;
        V = V % P;
        
        if(L>=V) {
        	result += V;
        }else {
        	result += L;
        }
        
        System.out.println("Case "+count+": " + result);
        count++;
        st= new StringTokenizer(br.readLine(), " ");
        
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        }

  
    }
}