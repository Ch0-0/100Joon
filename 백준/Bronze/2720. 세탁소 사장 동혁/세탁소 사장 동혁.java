import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());
		
		for(int i=0; i<repeat; i++) {
			int money = Integer.parseInt(br.readLine());
			int Q = money / 25;
			money -= Q*25;
			System.out.print(Q+" ");
			Q = money /10 ;
			money -= Q*10;
			System.out.print(Q+" ");
			Q=money /5 ;
			money -= Q*5;
			System.out.println(Q+" "+money);
			
			
			
			
		}
		
	}

}
