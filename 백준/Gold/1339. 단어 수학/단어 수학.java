import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());
		int[] array = new int[26];
		
		for(int i=0; i<repeat; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				array[str.charAt(j)-'A'] += Math.pow(10, str.length()-j-1);

			}
		}

		Arrays.sort(array);
		
		
		int result = 0;
		int count = 9;
		
		for(int i=25; i>=0; i--) {
			
			if(array[i]==0) continue;
			
			result += array[i]*count;
			count--;
		}
		
		System.out.println(result);
		
//		for(int i=0; i<10; i++) {
//			System.out.println(array[i]);
//		}

	}

}
