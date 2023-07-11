

import java.io.*;
import java.util.*;

public class Main{
	static void quick(ArrayList<Integer> arr, int start, int end) {
		if(start>=end)
			return;
		int pivot = end;
		int first = start;
		int last = end;
		end = end-1;
		
		while(start<end) {
			if((arr.get(start)>arr.get(pivot))&&arr.get(end)<arr.get(pivot)) {
				int temp = arr.get(start);
				arr.set(start,arr.get(end));
				arr.set(end, temp);
				start++; end--;
			}else if ((arr.get(start)<=arr.get(pivot))&&arr.get(end)<arr.get(pivot)) {
				start++;
			}else if ((arr.get(start)>arr.get(pivot))&&arr.get(end)>=arr.get(pivot)) {
				end--;
			}else {
				start++; end--;
			}		
		}
		if(arr.get(pivot) > arr.get(end)) {
			arr.add(end+1, arr.get(pivot));
			arr.remove(pivot+1);
			end = end+1;
		}else {
			arr.add(end, arr.get(pivot));
			arr.remove(pivot+1);
		}
		
		quick(arr, first, end-1);
		quick(arr, end+1, last);
	}
	
	public static void main(String[]args) throws IOException{
		
		// 입력. 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer  st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		// 퀵정렬
		quick(list, 0, N-1);
		System.out.println(list.toString());
	}
}
