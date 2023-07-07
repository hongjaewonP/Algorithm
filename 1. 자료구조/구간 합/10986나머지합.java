// 백준 온라인 저지 10986번

/* 문제 해석
 * 주어진 수 N개는 최대 10^6개이고 각 수는 최대 10^9이다. 
 * 이대로 덧셈을 진행하면 크기가 너무 커서 int 변수 안에 안담기므로,
 * M으로 미리 나눠 구간합을 구해야 한다.
 * 
 * 구간합 배열은 최대 10^6 이므로 O(n) 시간복잡도 알고리즘을 써야 한다.
 * 
 * 구간합 배열을 오름차순 정렬하고, 나머지가 똑같은 것들의 수를 구하여 조합을 계산하자. 

 * 예를 들어 입력이
 * 5 3
 * 1 2 3 1 2 일 경우, 나머지 구간합 배열은
 * S={0, 1, 0, 0, 1, 0} 이다.
 * 0이 4개, 1이 2개이므로 4C2 + 2C2 = 7의 답이 나온다. 
 * 
 * 이 때, 숫자의 개수가 10^6개 이므로 자칫하면 10^6C2를 해야 할 수도 있다.
 * 이는 int 형에 수가 담기지 않기 때문에, long으로 선언해야 한다.
 */

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[]args) throws IOException{

		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 구간합 배열 만들기.
		int arr[] = new int[N+1];
		st = new StringTokenizer(bf.readLine());
		for(int i=1;i<=N;i++) {
			int temp = Integer.parseInt(st.nextToken())%M;
			arr[i] = (temp+arr[i-1])%M;
		}
		
		//나머지 개수 구하기.
		long mod[] = new long[M];
		for(int i=0;i<=N;i++) {
			int temp = arr[i];
			mod[temp]++;
		}
	
		long count = 0;
		for(int i=0;i<M;i++) {
			count += mod[i]*(mod[i]-1)/2;
		}
		
		System.out.println(count);
		
	}
}
