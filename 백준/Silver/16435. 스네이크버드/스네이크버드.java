import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int repeat = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(st.nextToken());
		int[] array = new int[repeat];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<repeat; i++ ) {
			array[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(array);
		
		for(int i=0; i<repeat; i++ ) {
			if(array[i]<=size) {
				size++;
			}else {
				break;
			}
		}

		System.out.println(size);
			
		
	}

}
