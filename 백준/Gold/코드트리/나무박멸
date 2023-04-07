package test;

import java.util.*;
import java.io.*;

public class Main {

	public static int size, year, rage, using;
	public static final int max_size = 20;
	public static int[][] array;
	public static int[][] next_array;
	public static int[][] medic = new int[max_size][max_size];
	public static int[] remove_point = new int[2];

	// 0. 나무 성장하기
	// 1. 나무 퍼지기
	// 2. 제거할 나무 선정하기
	// 3. 제거한 나무 점수 확인
	// 4. 제초제 뿌리기 다른 배열 선언해서 -1 해주기

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int[] ddx = { -1, -1, 1, 1 };
	public static int[] ddy = { -1, 1, 1, -1 };

	public static boolean over(int x, int y) {
		return x >= 0 && y >= 0 && x < size && y < size;

	}

	public static void clone_array() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = next_array[i][j];
			}
		}

	}

	public static void print() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");

	}

	// 0. 나무 성장하기
	public static void tree_grow() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				if (array[i][j] > 0) {
					int cnt = 0;
					for (int p = 0; p < 4; p++) {
						int mx = i + dx[p];
						int my = j + dy[p];

						if (over(mx, my) && array[mx][my] > 0) {
							cnt++;
						}

					}
					array[i][j] += cnt;

				}

			}
		}

	}

	// 1. 나무 퍼지기
	public static void tree_virous() {

		next_array = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				if (array[i][j] == -1) {
					next_array[i][j] = -1;
				}

				if (array[i][j] > 0) {
					int cnt = 0;
					next_array[i][j] = array[i][j];

					for (int p = 0; p < 4; p++) {
						int mx = i + dx[p];
						int my = j + dy[p];

						if (over(mx, my) && array[mx][my] == 0 && medic[mx][my] == 0) {
							cnt++;
						}

					}

					for (int p = 0; p < 4; p++) {
						int mx = i + dx[p];
						int my = j + dy[p];

						if (over(mx, my) && array[mx][my] == 0 && medic[mx][my] == 0) {
							next_array[mx][my] += (array[i][j] / cnt);
						}

					}

				}

			}
		}

		// 완료후 배열 복사
		clone_array();
	}

	// 2. 제거할 나무 선정 + 3. 점수
	public static int remove_tree() {
		int result = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				if (array[i][j] > 0) {
					int score = array[i][j];

					for (int p = 0; p < 4; p++) {
						int mx = i;
						int my = j;
						for (int t = 0; t < rage; t++) {

							mx = mx + ddx[p];
							my = my + ddy[p];

							if (over(mx, my)) {
								if (array[mx][my] == 0) {
									break;
								} else if (array[mx][my] == -1) {
									break;
								}
								score += array[mx][my];
							}
						}
					}

					if (result < score) {
						result = score;
						remove_point[0] = i;
						remove_point[1] = j;
						// 0,0 부터 체크해서 사실상 의미는 없지만 조건에 주어졌으니 추가했다.
					} else if (result == score) {
						if (remove_point[0] > i) {
							remove_point[0] = i;
							remove_point[1] = j;
						} else if (remove_point[0] == i) {
							remove_point[1] = Math.min(remove_point[1], j);
						}

					}

				}

			}
		}
		return result;
	}

	// 4. 제초제 뿌리기
	public static void spray() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (medic[i][j] > 0) {
					--medic[i][j];
				}
			}
		}

		for (int p = 0; p < 4; p++) {
			int mx = remove_point[0];
			int my = remove_point[1];
			for (int t = 0; t < rage; t++) {

				mx = mx + ddx[p];
				my = my + ddy[p];

				if (over(mx, my)) {
					medic[mx][my] = using;

					if (array[mx][my] == 0) {
						break;
					} else if (array[mx][my] == -1) {
						medic[mx][my] = -1;
						break;
					}

					array[mx][my] = 0;
				}

			}
		}

		array[remove_point[0]][remove_point[1]] = 0;
		medic[remove_point[0]][remove_point[1]] = using;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		size = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());
		rage = Integer.parseInt(st.nextToken());
		using = Integer.parseInt(st.nextToken());

		array = new int[size][size];
		next_array = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		for (int t = 0; t < year; t++) {
//		print();
			tree_grow();
//        print();
			tree_virous();
//		print();

			result += remove_tree();

			spray();

		}

		System.out.println(result);

	}
}
