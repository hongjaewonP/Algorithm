//https://velog.io/@hong030/%EC%9E%90%EB%B0%94%EB%A1%9C-%EB%B0%B1%EC%A4%80-2750-%ED%92%80%EA%B8%B0


// 백준 온라인 저지 1253번

/* 문제 해석
 * 
 * 제한 시간이 1초이고, 주어진 수 N은 1000개 이하이므로 O(n^2)인 버블 정렬을 사용해도 풀 수 있다.
 */


// 백준 온라인 저지 1253번

/* 문제 해석
 * 
 * 
 */

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[]args) throws IOException{
		
		// 입력. 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		// 버블 정렬
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<N-i-1;j++) {
				//swap(arr[j], arr[j+1]);
				int max = arr[j]>arr[j+1]?arr[j]:arr[j+1];
				int min = arr[j]<arr[j+1]?arr[j]:arr[j+1];
				arr[j] = min;
				arr[j+1] = max;
			}
		}
		

		for(int i=0;i<N;i++) {
			System.out.println(arr[i]);
		}
	}
}
