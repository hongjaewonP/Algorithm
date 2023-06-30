// 백준 온라인 저지 11720번
//https://velog.io/@hong030/%EC%9E%90%EB%B0%94%EB%A1%9C-%EB%B0%B1%EC%A4%80-11720-%ED%92%80%EA%B8%B0

import java.io.*;

public class Main {
	public static void main(String[]args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int sum = 0;
		String str = bf.readLine();
		
		char array[] = new char[N];
		array = str.toCharArray();
		
		for(int i=0;i<N;i++) {
			sum += (array[i]-48);
		}
		System.out.println(sum);
	}
}
