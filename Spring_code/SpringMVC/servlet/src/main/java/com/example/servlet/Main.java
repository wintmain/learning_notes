package com.example.servlet;

import java.util.*;
/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-16 9:48:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start="";
        int[] LOVE = new int[4];
        int T = sc.nextInt();
        long sum;
        int temp;
        while (T-- >0) {
            sum = 0;
            for (int i = 0; i < 4; i++) {
                LOVE[i] = -1;
            }
            start = sc.next();
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i)=='L')
                    LOVE[0] = i;
                if (start.charAt(i)=='O')
                    LOVE[1] = i;
                if (start.charAt(i)=='V')
                    LOVE[2] = i;
                if (start.charAt(i)=='E')
                    LOVE[3] = i;
                temp = Math.min(Math.min(LOVE[0],LOVE[1]), Math.min(LOVE[2],LOVE[3]));
                if (temp != -1)
                    sum += temp+1;
            }
            System.out.println(sum);
        }
    }
}