package day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11399 {
	public static final int MAX_N = 1000;
	public static int[] arr = new int[MAX_N];
	public static int n;
	
	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int pivot = start;
		int left = start + 1;
		int right = end;
		
		while (left <= right) {
			while (left <= end && arr[pivot] >= arr[left] ) 
				left++;
			while (right > start && arr[pivot] <= arr[right])
				right--;
			if (left > right) {
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
			}
			else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			quickSort(arr,start,right - 1);
			quickSort(arr,right + 1, end);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(arr,0,n-1);
//		Arrays.sort(arr,0,n);
		
		int sum = 0;
		int culSum = 0;
		
		for (int i = 0; i < n ; i++) {
			sum = sum + arr[i];
			culSum += sum;
		}
		System.out.println(culSum);
	}
}
