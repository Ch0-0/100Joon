
import java.util.*;
import java.io.*;


public class Main {

 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());


		int[] p = new int[input + 1];
		p[1] = 0;
		for(int i = 2; i <= input; i++) {
			p[i] = p[i - 1] + 1;
			if(i % 2 == 0 && p[i] > p[i / 2] + 1) {
				p[i] = p[i / 2] + 1;
			}
			if(i % 3 == 0 && p[i] > p[i / 3] + 1) {
				p[i] = p[i / 3] + 1;
			}
		}
		System.out.println(p[input]); 
		
		
	}
}