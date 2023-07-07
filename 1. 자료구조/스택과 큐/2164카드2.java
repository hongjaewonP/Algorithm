// 백준 온라인 저지 2164번

/* 문제 해석
 * 
 * 입력 N의 크기는 50만 이하이다. 해당 문제는 큐로 해결할 수 있다.
 * 먼저 1~N이 담겨있는 큐를 생성하고,
 * 큐의 사이즈가 1이 될 때까지 poll과 add를 반복하면 된다.
 */

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[]args) throws IOException{

		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		// 큐 만들기
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		
		// 큐 계산하기
		if(queue.size()==1) {
			System.out.println(queue.poll());
			return;
		}else {
			while(queue.size()!=1) {
				queue.poll();
				int temp = queue.peek();
				queue.poll();
				queue.add(temp);
			}
			System.out.println(queue.poll());
		}
		
	}
}
