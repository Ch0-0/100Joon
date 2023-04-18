import java.util.*;
import java.io.*;

public class Main {

	public static int size, people, time;
	public static int array[][];
	public static int array_next[][];
	public static int wall[][];
	public static int s_spin[][];
	public static int ex, ey;
	public static int sx, sy, ss;
	public static int result = 0;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	// 격자 넘어가는지 체크
	public static boolean over(int x, int y) {
		return x >= 0 && y >= 0 && x < size && y < size;
	}

	// 탈출구와의 거리
	public static int fall(int x, int y) {
		return Math.abs(ex - x) + Math.abs(ey - y);
	}

	public static boolean canGo(int x, int y) {

		if (over(x, y)) {
			return wall[x][y] == 0;
		}

		return false;

	}
	
	public static boolean exit(int x, int y) {
		
		return ex==x && ey==y;
	}
	
	public static void print() {

		System.out.println("--------------print-------------");

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == ex && j == ey) {
					System.out.print(" E ");
				} else if(array[i][j]>0) {
					System.out.print(array[i][j]+"X ");
				} else {
					System.out.print(" "+wall[i][j] + " ");		
				}
			}
			System.out.println();
		}
		System.out.println();
		
		
	}

//	public static void print() {
//
//		System.out.println("--------------print-------------");
//
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//				if (i == ex && j == ey) {
//					System.out.print("X ");
//				} else {
//					System.out.print(array[i][j] + " ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		
//		System.out.println("---------wall_print-------------");
//
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//					System.out.print(wall[i][j] + " ");			
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//	}
	
	
	public static void print_spin() {

		System.out.println("---------spin_print-------------");

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == ex && j == ey) {
					System.out.print("X ");
				} else {
					System.out.print(array_next[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();

	}

	public static void move() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				if (array[i][j] > 0) {
					boolean check = false;
					for (int p = 0; p < 4; p++) {
						int mx = i + dx[p];
						int my = j + dy[p];
						if (canGo(mx, my) && (fall(i, j) - fall(mx, my)) == 1) {
							array_next[mx][my] += array[i][j];
							//System.out.println("x: "+mx+" y: "+my+" 에 "+array[i][j]);
							check = true;
							result += array[i][j];
							
							array[i][j] = 0;
							if(exit(mx,my)) { people -= array_next[mx][my];
								array_next[mx][my] = 0;
							}
							
							break; // 나중에 뺴보기
						}
					}
					if (!check) {
						array_next[i][j] += array[i][j];
					}
				}
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = array_next[i][j];
				array_next[i][j] = 0;
			}
		}

	}

	public static boolean people_Check(int x, int y, int size) {
		for (int i = x; i <= x + size; i++) {
			for (int j = y; j <= y + size; j++) {
				if (array[i][j] > 0) {
					return true;
				}
			}
		}

		return false;

	}

	public static void choose() {

		for (int s = 1; s <= size; s++) {
			for (int i = ex - s; i <= ex; i++) {
				if (i < 0)
					continue;
				for (int j = ey - s; j <= ey; j++) {
					if (j < 0)
						continue;
					if (over(i, j) && over(i + s, j + s)) {
						if (people_Check(i, j, s)) {
							sx = i;
							sy = j;
							ss = s+1;
							return;
						}
					}
				}
			}
		}
		
	}
	
	
	public static void spin() {
		//벽 내구도--
		 for(int x = sx; x < sx + ss; x++) {
		        for(int y = sy; y < sy + ss; y++) {
		            if(wall[x][y]>0) wall[x][y]--;
		        }
		 }

		 s_spin = new int[ss][ss];
		 wall[ex][ey] = -1;
		 
		 for(int i=0; i<ss; i++) {
			for(int j=0; j<ss; j++) {
				array_next[j][ss-i-1] = array[i+sx][j+sy];
				s_spin[j][ss-i-1] = wall[i+sx][j+sy];
			}
		 }

		 for(int i=0; i<ss; i++) {
			 for(int j=0; j<ss; j++) {
				 array[i+sx][j+sy] = array_next[i][j];
				 array_next[i][j] = 0;
				 if(s_spin[i][j]==-1) {
					ex=i+sx;
					ey=j+sy;
					s_spin[i][j]=0;
				 }
				 wall[i+sx][j+sy] = s_spin[i][j];
				 

			 }
		 }

		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		size = Integer.parseInt(st.nextToken());
		people = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());

		array = new int[size][size];
		array_next = new int[size][size];
		wall = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < people; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			array[x][y]++;
		}

		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		// result 초기화.
		
	//	print();

		for(int t=0; t<time; t++) {
		//System.out.print("중간 결과: "+result+" -> ");
		move();
	//	System.out.println(result);
		if(people==0) break;
		//System.out.println("사람이동후  남은사람: "+people);
	//	print();
		choose();
		//System.out.println("회전꼭지점"+sx+" "+sy+" "+ss);
		spin();
	//	System.out.println("회전 후   진행시간: "+t);
	//	print();
		
		}
		System.out.println(result);
		System.out.println((ex+1)+" "+(ey+1));

	}
}
