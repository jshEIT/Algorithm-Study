package day0724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj_2851_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		
		// 배열 입력
		for (int i = 0; i < 10; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int sum = arr[0];
		int ans = 0;
		
		for (int i = 1; i < 10; i++) {
			sum += arr[i];
			if (sum == 100) {
				ans = sum;
				break;
			}
			
			if (sum > 100) {
				if (100 - (sum - arr[i]) < sum - 100) {
					ans = sum - arr[i];
				}
				else
					ans = sum;
				break;
			}
		}
		
		if (sum < 100)
			ans = sum;
		System.out.println(ans);
			
			
	}

}
