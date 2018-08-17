package com.xsc.test.SHANGTAN2018;

import java.util.Scanner;

/**
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 * 现在给一串数字，给出有多少种可能的译码结果。
 * <p>
 * 输入例子1:
 * 12
 * <p>
 * 输出例子1:
 * 2
 * <p>
 * 例子说明1:
 * 2种可能的译码结果（”ab” 或”l”）
 *
 * @author shichao.xia
 * @date 2018/8/17 下午3:26
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] integers = new String[str.length()];
            for (int i = 0; i < str.length(); i++) {
                integers[i] = String.valueOf(str.charAt(i));
            }
            if (str.charAt(0) == '0' || check(integers)) {
                System.out.println(0);
            } else {
                int result = 1;
                for (int i = 0; i < integers.length; i++) {
                    if (Integer.parseInt(integers[i]) <= 2 && Integer.parseInt(integers[i]) > 0) {
                        int temp = 1;
                        int mark = Integer.parseInt(integers[i]);
                        for (int j = i + 1; j < integers.length; j++) {
                            if (Integer.parseInt(integers[j]) != 0 && Integer.parseInt(integers[j - 1] + integers[j]) <= 26) {
                                temp++;
                                i++;
                            } else {
                                break;
                            }
                        }
                        result *= fabc(temp);
                    }
                }
                System.out.println(result);
            }
        }
    }

    public static boolean check(String[] strings) {
        boolean flag = false;
        for (int i = 1; i < strings.length; i++) {
            if ("0".equals(strings[i]) && "0".equals(strings[i - 1])) {
                flag = true;
                break;
            } else if ("0".equals(strings[i]) && Integer.parseInt(strings[i - 1]) > 2) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static int fabc(int level) {
        int result = 0;
        int pre = 1;
        int next = 2;
        if (level == 1) {
            return pre;
        } else if (level == 2) {
            return next;
        } else {
            for (int i = 2; i < level; i++) {
                result = pre + next;
                pre = next;
                next = result;
            }
        }
        return result;
    }
}