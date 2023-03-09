import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		Queue<long[]> q = new LinkedList<>();
		
		q.offer(new long[] {start,1});
		
		long result=99999999;
		while(!q.isEmpty()) {
			long[] arr = q.poll();
			long point = arr[0];
			long count = arr[1];
			if(point==target) {
				if(result>count) {
					result=count;
				}
			}

			if((point*10)+1<=target) {
				q.offer(new long[] {(point*10)+1,count+1});
			}
			
			if(point*2<=target) {
				q.offer(new long[] {point*2,count+1});
			}
		}
		if(result==99999999) {
			result=-1;
		}
		System.out.println(result);
		
			//System.out.println(repeat-result);
			
		
	}

}
