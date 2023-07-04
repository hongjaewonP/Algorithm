// 백준 온라인 저지 2018번

/* 투 포인터
 * 시간복잡도가 O(n) 이다.
 * 리스트에 순차적으로 접근해야 할 때 두 개의 점 위치를 기록하며 처리한다.
 * 일차원 배열에서 포인터 두 개를 사용하는 방식.
 */

/* 문제 해석
 * 
 * 입력받은 자연수 N은 1천만보다 작거나 같은 수이다.
 * 이를 해결하려면 O(nlogn) 알고리즘도 위험하다!!
 * 때문에 O(n) 복잡도인 투포인터로 해결해보자.
 */

import java.io.*;

public class Main {
	public static void main(String[]args) throws IOException {
		
		//입력.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		//배열과 투 포인터 만들기.
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}
		int first = 0, last = 0;
		
		//연속된 자연수의 합과 입력받은 N을 비교하는 과정.
		int count = 1;
		int sum = 1;
		while((first != (N-1)) || (last != (N-1))) {
			if(sum < N) {
				last ++;
				sum += arr[last];
			}else if (sum > N) {
				sum -= arr[first];
				first ++;
			}else {
				count++;
				last++;
				sum += arr[last];
			}			
		}
		
		System.out.println(count);
		
	}
}

