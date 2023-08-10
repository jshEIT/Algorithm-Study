package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class swea_1208 {
	public static void insertionSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dump = Integer.parseInt(st.nextToken());
			int[] arr = new int[100];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) 
				arr[i] = Integer.parseInt(st.nextToken());

			insertionSort(arr);
			
			while (dump-- > 0) {
				if (arr[99] - arr[0] <=1)
					break;
				arr[99]--;
				arr[0]++;
				insertionSort(arr);
			}
//			System.out.println(Arrays.toString(arr));
			System.out.println("#" + tc + " " + (arr[99]-arr[0]));
			
		}
		
	}
}
