
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());
		int[][] array = new int[repeat][2];
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < repeat; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(array, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
//		for(int i=0; i<repeat; i++) {
//			System.out.println(array[i][0]+" "+array[i][1]);
//		}

		q.offer(array[0][1]);

		int result = 1;

		for (int i = 1; i < repeat; i++) {
			int t = q.poll();

			if (array[i][0] >= t) {
				q.offer(array[i][1]);
			} else {
				q.offer(t);
				q.offer(array[i][1]);
				result++;
			}

	

		}
		System.out.print(result);

	}

}
