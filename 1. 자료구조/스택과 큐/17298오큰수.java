// 백준 온라인 저지 17298번

/* 문제 해석
 * 최대 100만개의 숫자가 있는데, 각 수의 크기는 100만 이하이다.
 * O(n) 시간복잡도로 풀어야 하며, 수는 int형으로 정할 수 있다. 
 * 
 * 스택을 사용해 풀어야 한다.
 * 0번 숫자를 스택에 넣고, 1번 숫자와 비교해 0번이 더 크면 1번을 스택에 쌓는다.
 * 1번이 더 크면 0을 pop 시킨 다음 0번째 배열의 값을 1번 숫자로 바꾼다. 그 후 스택에 1번 숫자를 넣는다.
 * 이를 반복함.
 * 
 */

import java.io.*;
import java.util.*;

public class Main{
	
	static void okensu(int[]arr) {
		
	}
	public static void main(String[]args) throws IOException{

		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 계산 
		int ans[] = new int[N];
		for(int i=0;i<N;i++) {
			ans[i] = -1;
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i=1;i<N;i++) {
			if(!stack.isEmpty() && (arr[i] <= arr[stack.peek()])) {
				stack.push(i);
			}else {
				while( !stack.isEmpty() && (arr[stack.peek()] < arr[i])) {
					ans[stack.pop()] = arr[i];
				}
				stack.push(i);
			}
		}
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<N;i++) {
			bw.write(ans[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}
}
