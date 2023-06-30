// 백준 온라인 저지 1546번
//https://velog.io/@hong030/%EB%B0%B1%EC%A4%80-1546

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[]args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		long max = 0;
		long sum = 0;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			if(max < num)
				max = num;
		}
		System.out.println((sum* 100.0)/N/max);
		
	}
}
