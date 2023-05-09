import java.util.*;
import java.io.*;





public class Main {
	
	
	public static int re(int a, int b) {
		int result = 1;
		
		for(int j=0; j<b; j++) {
			result = (result * a) % 10;
			
		}
		
		if(result==0) result = 10; 
		
		return result;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());
		
		for(int i=0; i<repeat; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		System.out.println(re(a,b));

		
		}

		
		
	}

}
