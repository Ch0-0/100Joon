import java.util.*;
import java.io.*;


public class Main {

 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int count = 0;
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {input,0});
		
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] position = q.poll();
			input = position[0];
			count = position[1];
	//		System.out.println(input+" "+count);
			
			if(input == 1) {
				if(min>count) {
					min = count;
				}
				continue;
			}else if(count>=min) {
			//	continue;
                break;
			}
			
			if(input%2==0) {
				q.offer(new int[] {input/2,count+1});
			}
			
			if(input%3==0) {
				q.offer(new int[] {input/3,count+1});
			}
			
			if(input>1 ) {
				q.offer(new int[] {input-1,count+1});
			}
		}
		System.out.println(min);
	}
}