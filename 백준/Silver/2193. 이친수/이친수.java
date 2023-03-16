import java.util.*;
import java.io.*;


public class Main {

 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		long[] array = new long[input];
		
		if(input==0) {
			System.out.println("0");
			return;
		}
		
		if(input==1) {
			System.out.println("1");
			return;
		}
		
		array[0]=1;
		array[1]=1;
		for(int i=2; i<input; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		
		System.out.println(array[input-1]);
		
		
		
	}
}