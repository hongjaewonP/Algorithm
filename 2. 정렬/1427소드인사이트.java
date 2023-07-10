
// 백준 온라인 저지 1253번

/* 문제 해석
 * 
 * int 형에는 20억 정도 이하의 숫자를 받을 수 있다. 때문에 10억 이하의 자연수인 N을 int로 받을 수 있다.
 * 그러나 자릿수 하나하나 분리해야 하므로 string으로 받는 것이 이번 문제 계산에 더욱 효율적이다.
 * 자릿수는 10개 이하이므로 시간 복잡도는 O(n^2) 여도 가능하여, 선택정렬을 사용하겠다.
 */

import java.io.*;
import java.util.Arrays;

public class Main{
	public static void main(String[]args) throws IOException{
		
		// 입력. 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char ar[] = bf.readLine().toCharArray();
		int arr[] = new int[ar.length];
		for(int i=0;i<arr.length;i++) {
			arr[i] = ar[i]-'0';
		}
		
		// 정렬.
		for(int i=0;i<arr.length-1;i++) {
			int min = 0;
			int temp = 0;
			for(int j=0;j<arr.length-i;j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			temp = arr[min];
			arr[min] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		// 출력.
		for(int i=0;i<arr.length;i++) {
			System.out.printf("%d", arr[i]);
		}
	}
}
