// 백준 온라인 저지 1253번

/* 문제 해석
 * 수의 개수는 2천개 이하, 각 수는 10억 이하의 자연수이므로 숫자 두 개를 합해도 int 형으로 담을 수 있다.
 * 2초 이하로 해결해야 하므로 시간 복잡도는 O(n^2) 이하여야 한다.
 * 
 * 배열을 정렬한 후, 투 포인터로 해결한다.
 * 예를 들어 arr[4]를 구하기 위해
 * arr[0] + arr[3]과 비교하여 값이 같으면 count++, break;
 * arr[4]가 더 크다면 arr[1] + arr[3];
 * arr[4]가 더 작다면 arr[0] + arr[2];
 * ...
 * 이런 식으로 arr[2~N-1] 중에서 좋은 수를 찾는다.
 * 중요한 것은, 투 포인터로 계산할 때 last 인덱스를 뒤에 두는 것이다.
 * 포인터의 위치를 어디다 둬야 할지가 문제의 관건.
 */

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[]args) throws IOException{

		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // array.sort 시간복잡도는 최악의 경우 O(n^2)라 사용 가능.
		
		// N이 1, 2이라면
		if((N==1) || (N==2)) {
			System.out.println(0);
			return;
		}
		
		// 계산하기.
		int count = 0;
		//result_ind는 두 수의 합의 결과가 있는 index
		for(int result_ind = 2;result_ind<N;result_ind++) {
			int first = 0, last = N-1;
			while(first<last) {
				if((arr[first] + arr[last]) == arr[result_ind]) {
					if((first!=result_ind) && (last!=result_ind)) {
						count++;
						break;
					}else if (first==result_ind) {
						first++;
					}else {
						last--;
					}
				}else if ((arr[first] + arr[last]) > arr[result_ind]) {
					last--;
				}else
					first++;
			}
		}
				
		System.out.println(count);		
		
	}
}
