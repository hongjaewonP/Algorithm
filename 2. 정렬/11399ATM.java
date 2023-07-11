
// 백준 온라인 저지 11399번

/* 문제 해석
 * 
 * 1000 이하의 숫자 N이 주어지고 각 숫자는 1000 이하의 자연수이다.
 * 최소의 합을 구하려면, 오름차순으로 정렬해 가장 큰 시간이 최대한 적게 포함되게 해야 한다.
 * 즉, 이번 문제는 입력 값을 오름차순으로 정렬한다음 합을 구하는 문제이다.
 * 정렬에는 O(n^2) 코드가 쓰여도 되지만 합을 구하는 데에는 시간이 조금 걸릴 수 있으므로 구간합 알고리즘을 사용하겠다.
 * 
 * 최악의 경우 합이 1000만 이하로 나오는데 이는 int형에 포함되는 범위다.
 */

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[]args) throws IOException{
		
		// 입력. 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(arr);
		
		//구간합
		int S[]=new int[N+1];
		for(int i=1;i<=N;i++) {
			S[i] = S[i-1] + arr[i-1];
		}
		int sum = 0;
		for(int i=0;i<=N;i++) {
			sum+=S[i];
		}
		System.out.println(sum);
	}
}
