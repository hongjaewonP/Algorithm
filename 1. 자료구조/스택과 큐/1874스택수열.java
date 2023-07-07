// 백준 온라인 저지 1874번


/* 문제 해석
 * 
 * 입력은 10만개 이하의 숫자들이며, 시간 복잡도는 O(nlogn) 이하여야 한다.
 * 
 * 1. 처음에 N를 꺼내오고 싶다면, 빈 스택에 object를 넣는다.
 * object는 처음에 1로 시작하여, 4와 같아질 때까지 push한다.
 * 
 * 2. 스택의 top object가 N과 같아지면 스택에서 pop을 하고, N 다음의 숫자를 본다.
 * 
 * 3. 그다음 숫자와 스택 top object를 비교해 숫자가 더 크면
 * 그만큼 push를 반복하고, 같다면 pop을 하고, 만약 숫자가 더 작다면
 * 수열을 만들기 불가능하니 NO를 출력하고 그대로 끝낸다.
 */


import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void push(int obj) {
		list.add(obj);
		sb.append("+\n");
	}
	public static void pop() {
		list.remove(list.size()-1);
		sb.append("-\n");
	}
	public static void main(String[]args) throws IOException {
		
		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		// 스택 만들기
		list.add(0);
		int top = 0;
		int obj = 0;
		while(top<N) {
			if(arr[top]>list.get(list.size()-1)) {
				obj++;
				push(obj);
			}else if (arr[top]==list.get(list.size()-1)) {
				pop();	
				top++;

			}else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
		
		
	}
}
