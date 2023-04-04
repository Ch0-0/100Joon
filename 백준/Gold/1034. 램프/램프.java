import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] light = new String[N];
		for (int i = 0; i < N; i++) {
			light[i] = br.readLine();
		}
		int K = Integer.parseInt(br.readLine());
		
		int K2 = K % 2;
		boolean[] check = new boolean[N];
		for (int i = 0; i < N; i++) {
			int zero = 0;
			for (int j = 0; j < M; j++) {
				if(light[i].charAt(j) == '0')	zero++;
			}
			if(zero <= K && zero%2 == K2)	check[i] = true;
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if(!check[i]) continue;
			
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(light[i].equals(light[j])) {
					check[j] = false;
					cnt++;
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}