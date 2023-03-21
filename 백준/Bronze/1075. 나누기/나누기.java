import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		a = (a/100) * 100;
		int result = 0;
		while(true) {
			if(a%b==0) {
				result = a%100; 
				
				if(result<10) {
					System.out.println("0"+result);
				}else {
					System.out.println(result);
				}
			return;
			}
			
			
			a++;
		}


	}
}