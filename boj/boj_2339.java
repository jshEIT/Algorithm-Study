package day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2339 {
	public static int arr[] = new int[9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		all : for (int a = 0; a <= 8;a++) {
			for (int b = a + 1; b <= 8; b++) {
				for (int c = b + 1; c <= 8; c++) {
					for (int d = c + 1; d <= 8; d++) {
						for (int e = d + 1; e <= 8; e++) {
							for (int f = e + 1; f <= 8; f++) {
								for (int g = f + 1; g <= 8; g++) {
									if (arr[a]+ arr[b] + arr[c] + arr[d] +arr[e] + arr[f] +arr[g] == 100) {
										System.out.println(arr[a]);
										System.out.println(arr[b]);
										System.out.println(arr[c]);
										System.out.println(arr[d]);
										System.out.println(arr[e]);
										System.out.println(arr[f]);
										System.out.println(arr[g]);
										break all;
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
