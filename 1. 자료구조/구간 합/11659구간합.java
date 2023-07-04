// 백준 온라인 저지 11659번

/* 문제 해석
 * 
 * 입력은 수의 개수 N과 합을 구해야 하는 횟수 M 이며,
 * N, M은 1보다 크거나 같고 10만보다 작거나 같다.
 * 즉, 최악의 경우 10만개의 숫자배열에서 10만번의 합을 일일히 구해야 하므로 연산 횟수가 1억을 훨씬 넘는다.
 * 따라서 단순히 for 문으로 모두 계산하면 안되고, 구간합을 사용해야 한다.
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[]args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		//데이터의 개수와 질의 개수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//구간합 배열. 
		int S[] = new int[N+1];
		S[0] = 0;
		int sum = 0;
		st = new StringTokenizer(bf.readLine());		
		for(int i=1;i<=N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			sum+= temp;
			S[i] = sum;
		}
		
		//질의
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			System.out.println(S[second] - S[first-1]);
		}
		
	}
}
