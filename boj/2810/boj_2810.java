package day0724;

import java.util.Scanner;

public class boj_2810 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		char[] arr = new char[50];
		int maxSeat = n + 1;
		int numL = 0;
		
		for (int i = 0; i < n; i++)
			arr[i] = str.charAt(i);
		
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'L')
				numL++;
		}
		
		int totalSeat = maxSeat - numL / 2;
		
		if (totalSeat > n)
			System.out.println(n);
		else
			System.out.println(totalSeat);
	}

}
