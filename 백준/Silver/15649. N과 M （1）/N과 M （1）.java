import java.util.*;
import java.io.*;

import java.util.*;

public class Main {

	static int N, M;
	static int[] pick;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pick = new int[M];
		visited = new boolean[N];
		dfs(0, 0);
		System.out.println(sb);
	}

	public static void dfs(int start, int depth) {

		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(pick[i]).append(' ');
			}
				sb.append('\n');
			return;
		}

		else {
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					pick[depth] = i + 1;
					dfs(start + 1, depth + 1);
					visited[i] = false;
				}
			}
		}

	}

}
