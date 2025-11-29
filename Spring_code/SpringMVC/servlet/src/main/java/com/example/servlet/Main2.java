package com.example.servlet;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-16 10:16:28
 */
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        int n,m;
        int flag = 0;//食物链数
        int[] in = new int[100000];
        int[] out = new int[200000];
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] numList = str.split("\\s");
        n = Integer.parseInt(numList[0]);
        m = Integer.parseInt(numList[1]);
//        System.out.println(m);
        for(int i=0;i<m;i++){
            //m条能量流动
            String substr  = sc.nextLine();
            String[] subnumList = substr.split("\\s");
            for(String s:subnumList){
                in[i] = Integer.parseInt(s);
            }

        }

//        System.out.println(3);
    }
}
