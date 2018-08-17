package com.xsc.test.DIDI2018;

import java.util.Scanner;

/**
 * 给定无序整数序列，求连续子串最大和，例如{-23 17 -7 11 -2 1 -34}，子串为{17,-7,11}，最大和为21
 *
 * @author shichao.xia
 * @date 2018/8/17 上午11:34
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            Integer[] integers = new Integer[strings.length];
            for (int i = 0; i < strings.length; i++) {
                integers[i] = Integer.parseInt(strings[i]);
            }
            int max = integers[0];
            for (int i = 1; i < integers.length; i++) {
                if (integers[i] > 0) {
                    int temp = integers[i];
                    for (int j = i-1; j >= 0; j--) {
                        temp += integers[j];
                        if (temp > max){
                            max = temp;
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}