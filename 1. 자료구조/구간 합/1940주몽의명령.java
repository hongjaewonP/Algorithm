// 백준 온라인 저지 1940번

/* 자바의 배열 정렬
 * 
 * Arrays.sort()은 퀵 정렬 기반이다.
 * 평균 O(nlogn), 최악 O(n^2)
 * 
 * Collections.sort()은 병합 정렬 기반이다. 
 * 평균 최악 둘다 O(nlogn)
 * 
 * 최악의 상황에선 퀵이 느리지만, 보통은 퀵이 병합보다 빠르고
 * 병합은 메모리 차지를 많이 하므로, 적절히 맞는 걸 골라서 쓰자. 
 */

/* 문제 해석
 * 
 * 주어진 재료 N개는 15000개 이하이고, 
 * 이를 통해 만들 숫자 M은 1천만 이하이다.
 * 숫자 두 개의 합이 M이 되는 가짓수를 구해야 하는데,
 * 단순히 for문을 쓰면 최악의 경우 10억번의 연산을 해야 한다.
 * 따라서 주어진 배열을 정렬한 후(시간복잡도 O(nlogn))
 * 오름차순 정렬된 배열을 투포인터로 해결할 것이다.
 */

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[]args) throws IOException {
		
		//입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());		
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		//배열 정렬하기. 
		Collections.sort(list);
		
		//투 포인터 만들기.
		int first = 0, last = N-1;
		int sum = list.get(first) + list.get(last);
		int count = 0;
				
		//값 찾기.
		while(last!=first) {
			if(sum < M) {
				sum -= list.get(first);
				first++;
				sum += list.get(first);
			}
			else if (sum > M) {
				sum -= list.get(last);
				last--;
				sum += list.get(last);
			}
			else {
				count++;
				sum -= list.get(first);
				first++;
				sum += list.get(first);
			}
		}
		System.out.println(count);
		
	}
}
