import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int depth = Integer.parseInt(st.nextToken());
		int wide = Integer.parseInt(st.nextToken());

		int result = 1;

		if (depth == 1) {
			System.out.println("1");

			return;
		}
		

		if (depth == 2) {
			if(wide<8) {
			if(wide%2==1) {
				result = wide/2;
				result ++;
					
			}else {
			result = wide/2;
			}
			System.out.println(result);
			}else {
				System.out.println("4");
			}
			

			return;
		}

		if (depth > 2 && wide < 8) {
			switch (wide) { // 조건
			case 1: // 값 불일치(미실행)
				System.out.println("1");
				break;
			case 2: // 값 일치
				System.out.println("2"); // 실행
				break; // 종료
			case 3: // 값 불일치(미실행)
				System.out.println("3");
				break;
			case 4: // 값 일치
				System.out.println("4"); // 실행
				break; // 종료
			case 5:
				System.out.println("4");
				break;
			case 6:
				System.out.println("4");
				break;
			case 7:
				System.out.println("5");
				break;
			}
		} else {
			result = wide - 2;
			System.out.println(result);
		}



	}
}