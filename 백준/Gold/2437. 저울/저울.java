import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int[] array = new int[repeat];
        
        for(int i=0; i<repeat; i++) {
        	array[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(array);
        
        int sum = 0;
        
        for(int i=0; i<repeat; i++) {
        	if(sum+1>=array[i]) {
        		sum += array[i];
        	}else {
        		break;
        	}
        	
        }

        
        System.out.println(sum+1);
		

  
    }
}