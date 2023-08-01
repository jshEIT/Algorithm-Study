package day0721;

import java.util.Arrays;
import java.util.Scanner;


public class boj_2798 {	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
//		System.out.println(Arrays.toString(arr));
		
		// 정렬
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

//		System.out.println(Arrays.toString(arr));
		
		int sum = 0;
		int count = 0;
		
		for (int i = N; i > 0; i--) {
			for (int j = i-1; j > 0; j--) {
				if (count == 3)
					break;
				
			}
		}
		
	}

}
