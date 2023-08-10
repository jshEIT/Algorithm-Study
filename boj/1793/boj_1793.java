package day0810;


import java.util.Scanner;
import java.math.BigInteger;

public class boj_1793 {
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
				
		BigInteger[] dp = new BigInteger[251];
		
		dp[0] = BigInteger.valueOf(1);
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(3);
		
		for (int i = 3; i < 251; i++) {
			dp[i] = dp[i-1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
		}
		
		while (sc.hasNextInt()) {
			System.out.println(dp[sc.nextInt()]);
		}
		
	}
}
