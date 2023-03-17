import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] array = new int[input.length()];
		
		
		
		//대문자 65~90 소문자97~122
		
		for(int i=0; i<input.length(); i++) {
			int c = input.charAt(i)-0;
			array[i] = c;
		}
		
	
		
		int result = 0;
		boolean check = false;
		for(int i=0; i<input.length(); i++) {
			
			//소문자 
			if(array[i]>96) {
				// 대문자였던 상태라면 
				if(check) {
					if(i+1<input.length() && array[i+1] > 96) {
						check = false;
					}
					result += 2;
				}else {
				result++;
				}
				//대문자 
			}else if(array[i]<91) {
					// 소문자였던 상태라면 
					if(!check) {
						if(i+1<input.length() && array[i+1] < 91) {
							check = true;
						}
						result += 2;
					}else {
					result++;
					}
				}
			
			
			
		}
	
		

		
		System.out.println(result);
		
	}

}
