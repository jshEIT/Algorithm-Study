package day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2339_2 {
	public static int[] arr = new int[9];
	public static boolean[] selected = new boolean[9];
	public static int count = 0;
	
	public static void comb(int[] arr, boolean[] selected, int start, int i, int r) {
		// 기저 조건
		if (i == r) {
			int sum = 0;
			for (int k = 0; k < arr.length; k++) {
				if (selected[k]) {
					sum += arr[k];
				}
			}
			if (sum == 100 && count == 0) {
				count++;
				for (int x = 0; x < arr.length; x++) {
					if (selected[x]) {
						System.out.println(arr[x]);
					}
				}
			}
			return;
		}
		
		// 유도 조건
		for (int j = start; j < arr.length; j++) {
			selected[j] = true;
			comb(arr,selected, j+1,i+1,r);
			selected[j] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int q = 0; q < 9; q++) {
			arr[q] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int r = 7;
		
		comb(arr,selected,0,0,r);
	}

}
