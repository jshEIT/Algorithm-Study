package day0725;

import java.util.Scanner;

/*
8
0 1 1 1 0 1 0 1
1 
2 3
 * */

public class boj_1244_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		int t = sc.nextInt();
		
		for (int x = 0; x < t; x++) {
			int gen = sc.nextInt();
			int num = sc.nextInt();
			
			if (gen == 1) {//남성인 경우
				for (int i = num - 1; i < n; i += num)
					arr[i] = arr[i] == 0 ? 1:0;
			} 
			if (gen == 2) { // 여성인 경우
				int count = 1;
				int idx = num - 1; // 기준 인덱스
				arr[idx] = arr[idx] == 0 ? 1:0;;
				while (true) {
					if ((idx - count < 0) || (idx + count >= n))
						break;
					
					if (arr[idx + count] == arr[idx - count]) {
						arr[idx - count] = arr[idx - count]== 0 ? 1:0;
						arr[idx + count] = arr[idx + count]== 0 ? 1:0;
						count++;
					}
					else 
						break;

				}
			}
//			System.out.println(Arrays.toString(arr));

		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
	}
			

}