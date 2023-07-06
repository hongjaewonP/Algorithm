// 백준 온라인 저지 12891번

/* 슬라이딩 윈도우
 * 
 *  투 포인터로 범위를 지정하고,
 *  범위를 유지한 채 포인터를 이동해 문제를 해결.
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

public class Main {
	public static void main(String[]args) throws IOException {

		//배열 랜덤 생성.
		int arr1[] = new int [10000];
		Random rand = new Random();		
		for(int i=0;i<100;i++) {
			arr1[i] = rand.nextInt(100000)+1;
		}

		ArrayList<Integer> list1 = new ArrayList<>();
		for(int i=0;i<100;i++) {
			list1.add(rand.nextInt(100000)+1);
		}
				
		// 배열의 arrays.sort()
		long arr1Before = System.currentTimeMillis();		
		Arrays.sort(arr1);
		long arr1After = System.currentTimeMillis(); 
		long arr1Time = (arr1After - arr1Before);
		System.out.println("배열에 Arrays.sort()를 쓴 경우 : "+arr1Time + "\n");
		
		// 리스트의 Collectionis.sort()
		
		long list1Before = System.currentTimeMillis();		
		Collections.sort(list1);
		long list1After = System.currentTimeMillis(); 
		long list1Time = (arr1After - arr1Before);
		System.out.println("배열에 Arrays.sort()를 쓴 경우 : "+list1Time + "\n");
		
	}
}
