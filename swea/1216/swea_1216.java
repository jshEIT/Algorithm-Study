package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class swea_1216 {
    public static boolean inRange(int idx) {
        return 0 <= idx && idx < 100;
    }
     
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
             
            char[][] arr2d = new char[100][100];
         
            for (int i = 0; i < 100; i++) {
                String temp = br.readLine();
                arr2d[i] = temp.toCharArray();
            }
             
            // 최대 회문 길이
            int ans = 0;
             
            // 가로방향 회문 검사
            for (int i = 0; i < 100; i++) {
//              int temp = 1; // 기본적인 회문의 길이
//              int s = 1;
                for (int j = 0; j < 100; j++) {
                    int temp1 = 1; // 기본적인 홀수 회문의 길이
                    int s = 1;
                     
                    while (true) {
                        if (!inRange(j + s) || !inRange(j-s) || arr2d[i][j + s] != arr2d[i][j - s]) 
                            break;
                        temp1 += 2;
                        s++;
                    }
                     
                    int temp2 = 0; // 기본적인 짝수 회문의 길이
                    int l = j, r = j + 1;
                    s = 0;
                     
                    while (true) {
                        if (!inRange(r) || !inRange(l - s) || !inRange(r + s) || arr2d[i][l - s] != arr2d[i][r + s])
                            break;
                        temp2 += 2;
                        s++;
                    }
                     
                     
                     
                    int temp = Math.max(temp1, temp2);
                    if (temp >= ans)
                        ans = temp;
                }
//              if (temp > ans)
//                  ans = temp;
                 
            }
             
             
            // 세로 방향 회문 검사
            for (int i = 0; i < 100; i++) {
//              int temp = 1; // 기본적인 회문의 길이
//              int s = 1;
                for (int j = 0; j < 100; j++) {
                    int temp1 = 1; // 기본적인 홀수 회문의 길이
                    int s = 1;
                     
                    while (true) {
                        if (!inRange(j + s) || !inRange(j - s) ||arr2d[j + s][i] != arr2d[j - s][i]) 
                            break;
                        temp1 += 2;
                        s++;
                    }
                     
                    int temp2 = 0; // 기본적인 짝수 회문의 길이
                    int l = j, r = j + 1;
                    s = 0;
                     
                    while (true) {
                        if (!inRange(r) || !inRange(l - s) || !inRange(r + s) || arr2d[l - s][i] != arr2d[r + s][i])
                            break;
                        temp2 += 2;
                        s++;
                    }
                     
                    int temp = Math.max(temp1, temp2);
                    if (temp >= ans)
                        ans = temp;
                     
                }
//              if (temp > ans)
//                  ans = temp;
                 
            }
             
            System.out.println("#" + t + " " + ans);
             
             
             
             
        }
         
         
         
         
    }
}