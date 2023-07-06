// 백준 온라인 저지 12891번

/* 슬라이딩 윈도우
 * 
 *  투 포인터로 범위를 지정하고,
 *  범위를 유지한 채 포인터를 이동해 문제를 해결.
 */

/* 문제 해석
 * 
 * 최대 100만자리 문자열에서
 * 1~100만 자리의 암호를 추출하고자 한다.
 * 시간 복잡도가 O(n)이어야 하므로 투포인터를 활용한다.
 */


import java.io.*;
import java.util.*;

public class Main {
	static 	int ACGT[] = new int[4];
	static 	int acgtSUM[] = new int[4];

	public static void add(char c) {
		switch(c) {
		case 'A': acgtSUM[0]++; break;
		case 'C': acgtSUM[1]++; break;
		case 'G': acgtSUM[2]++; break;
		case 'T': acgtSUM[3]++; break;
		}
	}
	
	public static void sub(char c) {
		switch(c) {
		case 'A': acgtSUM[0]--; break;
		case 'C': acgtSUM[1]--; break;
		case 'G': acgtSUM[2]--; break;
		case 'T': acgtSUM[3]--; break;
		}
	}
	
	public static boolean check() {
		if((ACGT[0] <= acgtSUM[0])&&(ACGT[1] <= acgtSUM[1])
				&&(ACGT[2] <= acgtSUM[2])&&(ACGT[3] <= acgtSUM[3]))
			return true;
		else
			return false;
		
	}
	
	public static void main(String[]args) throws IOException {
		
		//입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		//전체 길이 S와 부분 길이 P
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		//전체 문자열
		String str = bf.readLine();
		char arr[] = str.toCharArray();
		//ACGT 최소 개수
		st = new StringTokenizer(bf.readLine());		
		for(int i=0;i<4;i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		}
		
		//투 포인터 만들기
		int count = 0;
		for(int i=0;i<P;i++) {
			add(arr[i]);
		}
		if(check()) count++;
		//계산하기.
		for(int last=P;last<S;last++) {
			int first = last-P;
			add(arr[last]);
			sub(arr[first]);
			first++;
			if(check()) count++;
		}
		System.out.println(count);
	}
}
