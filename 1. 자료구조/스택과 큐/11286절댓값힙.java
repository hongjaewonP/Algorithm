// 백준 온라인 저지 11286번

/* 우선순위 큐 정렬 기준 세우기
 * 
 * 정렬 기준은 먼저 와야 할 상대가 음수 값을 가지고, 뒤에 올 상대가 양수 값을 가지게 선언한다.
 * 만약 오름차순으로 1,2,3,4.. 정렬을 하려면,
 * 1은 -값, 2는 +값을 가지게 선언하자.
 * return a>b ? 1:-1 >> a가 b보다 크므로 우선순위가 떨어짐, 1을 가짐. b가 작으니 우선순위가 높음, -1을 가짐.
 * return a-b >> a-b가 양수라면 a가 크므로 우선순위가 떨어짐, a-b가 음수라면 b가 크므로 a의 우선순위가 높음.
 */

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

		// 우선순위 큐 만들기.
		PriorityQueue<Integer> queue = new PriorityQueue<>(
				(a, b)->{
					int A = Math.abs(a);
					int B = Math.abs(b);
					//절대값이 같은 수 중 작은 애가 음수를 가짐.
					if(A == B) {
						return a>b? 1:-1;
					}
					//만약 A가 B보다 작으면 리턴이 음수이므로 A가 우선순위를 가짐.  
					return A - B;
				});
		
		// 입력받고 출력하기.
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(bf.readLine());
			if (input==0) {
				if(queue.size()==0)
					System.out.println(0);
				else
					System.out.println(queue.remove());			
			}else {
				queue.add(input);
			}
		}
		
	}
}
