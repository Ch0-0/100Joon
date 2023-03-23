
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int repeat = Integer.parseInt(br.readLine());

		for (int k = 0; k < repeat; k++) {
			int n = Integer.parseInt(br.readLine());
			int[] array = new int[11];

			array[1] = 1;
			array[2] = 2;
			array[3] = 4;

			for (int i = 4; i <= n; i++) {
				array[i] = array[i - 1] + array[i - 2] + array[i - 3];
			}
			
			System.out.println(array[n]);
		}
	}
}