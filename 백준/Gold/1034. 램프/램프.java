import java.util.*;
import java.io.*;



public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int depth = Integer.valueOf(st.nextToken());
		int wide = Integer.valueOf(st.nextToken());
		String[] str = new String[depth];
		for (int i = 0; i < depth; i++) {
			st = new StringTokenizer(in.readLine());
			str[i] = st.nextToken();
		}
		st = new StringTokenizer(in.readLine());
		int K = Integer.valueOf(st.nextToken());
		int oddEven=K%2;
		if(K>50) {
			K=50;
		}
		int max =0;
		int idx=-1;
		for(int i=0; i<depth; i++) {
			int zeroNum=0;
			String tmp = str[i];
			for(int j=0; j<wide; j++) {
				if(tmp.charAt(j) == '0')
					zeroNum++;
			}
			if(zeroNum%2 != oddEven) {
				continue;
			}
			int patern =1;
			for(int k=0; k<depth; k++) {
				if(k!=i && tmp.equals(str[k])) {
					patern++;
				}
			}
			if(zeroNum<=K && patern > max) {
				max = patern;
				idx = i;
			}
		}
		if(idx!=-1) {
			System.out.println(max);
		}else {
			System.out.println(0);
		}
	}
}