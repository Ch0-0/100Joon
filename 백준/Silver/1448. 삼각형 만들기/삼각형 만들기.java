
import java.util.*;
import java.io.*;

import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());
		Integer[] array = new Integer[repeat];

		for (int i = 0; i < repeat; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array, Collections.reverseOrder());

		int result = -1;
		for (int i = 0; i < repeat - 2; i++) {
				if (array[i] < (array[i + 1] + array[i + 2])) {
					result = array[i]+array[i+1]+array[i+2];
					break;
				}
			

		}
		
		System.out.println(result);

	}

}