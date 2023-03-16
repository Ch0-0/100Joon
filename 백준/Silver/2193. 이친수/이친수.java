import java.util.*;
import java.io.*;


public class Main {

 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		long[] array = new long[3];
		
		array[0]=1;
		array[1]=1;
		
		if(input<3) {
			System.out.println("1");
			return;
		}
//		
//		if(input==1) {
//			System.out.println("1");
//			return;
//		}
//		

//		for(int i=2; i<input; i++) {
//			array[i] = array[i-1] + array[i-2];
//		}
		
		
		
		
		for(int i=2; i<input; i++) {
		array[2] = array[0] + array[1];
		array[0] = array[1];
		array[1] = array[2];
	}
		
		System.out.println(array[2]);
		
		
		
	}
}