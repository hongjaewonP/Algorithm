// 백준 온라인 저지 11660번

/* 문제 해석
 * 
 * 배열 각 칸에 구간합을 더한 값을 넣는다.
 * arr[1][1] 에는 맨 처음 입력받은 값,
 * arr[1][2] 에는 arr[1][1] + 입력받은 값,
 * arr[1][3] 에는 arr[1][2] + 입력받은 값,
 * ...
 * arr[2][3]에는 arr[1][3] + arr[2][2] - arr[1][2] + 입력받은 값... 
 * 
 * 만약 (2,2)~(3,4)의 합을 구하고 싶다면
 * 구간합 배열에서 (3,4)의 값 - (3,1) - (1,4) + (1,1) 의 값을 구하면 된다. 
 */

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[]args) throws IOException{

		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); //표의 크기
		int M = Integer.parseInt(st.nextToken()); //연산 횟수
		
		// 표 생성
		int arr[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<=N;j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}
		
		//연산할 좌표 표 생성
		int loc[][] = new int[M][4];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<4;j++) {
				loc[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 구간 합 출력하기
		for(int i=0;i<M;i++) {
			int x1 = loc[i][0];
			int y1 = loc[i][1];
			int x2 = loc[i][2];
			int y2 = loc[i][3];
			System.out.println(arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1]);
		}
	}
}
