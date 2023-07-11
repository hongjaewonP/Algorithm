//https://velog.io/@hong030/%EC%9E%90%EB%B0%94%EB%A1%9C-%EB%B0%B1%EC%A4%80-1377-%ED%92%80%EA%B8%B0
// 백준 온라인 저지 1377

/* 문제 해석
 * 
 * 숫자는 50만개 이하로 주어지며, 각 숫자는 100만 이하, 0 이상의 자연수이다.
 * 
 * 출력값은 버블 소트로 몇 번만에 정렬됐는지를 말한다.
 * 예제 1에선 i가 3일때 정렬 끝(i=1일때 10 정렬, i=2일 때 5 정렬, i=3일때 정렬 끝)
 * 
 * 예제 2에선 i가 1일때 정렬 끝(i=1일때 정렬 끝)
 * 
 * 최악의 경우 i가 50만일 때 정렬이 끝날 수 있으며, 버블 소트는 O(n^2) 시간복잡도이므로
 * 버블 정렬 그대로 쓰면 시간이 초과된다. 정렬 자체는 O(nlogn) 인 자바 내부 sort 함수를 사용하자.
 * 
 * 계산 방법은,
 * 정렬 후 index - 정렬 전 index에서 가장 큰 값 + 1 이 답이다.
 * index가 달라졌다는 것은 그만큼 for문을 통해 자리 이동을 했다는 뜻이다.
 * 예를 들어 정렬 전 index가 0이었는데 정렬 후 index가 2이라면 2번 for문을 통해 움직였다는 것이다.
 * 
 * int arr = [10, 1, 3, 2, 5] 가 있다고 하자.
 * 정렬 전 index는 0,1,2,3,4 이고,
 * 정렬 후 index는 1,3,2,4,0 이 된다.
 * 정렬 후 - 전 index 값은 1, 2, 0, 1, -4 이다.
 * 최댓값은 2이므로 i는 2+1=3이 된다.
 * 
 * 코드 구현 방법:
 * 입력받은 값 뿐만 아니라 값의 index까지 저장해야 하므로 클래스를 따로 만든다.
 * 클래스에서 value값을 오름차순 정렬하기 위해 compareTo 함수를 따로 오버라이딩 해야 한다.
 */

import java.io.*;
import java.util.Arrays;
class Group implements Comparable<Group>{
	int value;	
	int id;
	public Group(int value, int id){
		this.value = value;
		this.id = id;
	}
	@Override
	public int compareTo(Group a) {
		return this.value - a.value;
	}
	
}

public class Main{
	public static void main(String[]args) throws IOException{
		
		// 입력. 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Group arr[] = new Group[N];
		for(int i=0;i<N;i++) {
			arr[i] = new Group(Integer.parseInt(bf.readLine()), i);
		}
		
		// 계산.		
		Arrays.sort(arr);
		
		int max = 0;
		for(int i=0;i<N;i++) {
			if(max < (arr[i].id-i)) {
				max = arr[i].id-i;
			}
		}
		System.out.println(max+1);
	}
}
