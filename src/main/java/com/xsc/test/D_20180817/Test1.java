package com.xsc.test.D_20180817;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author shichao.xia
 * @date 2018/8/17 上午11:14
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            Iterable<String> iterable = Splitter.on(' ').split(str1);
            List<Integer> list = Lists.newArrayList();
            for (String s: iterable){
                list.add(Integer.parseInt(s));
            }
            Integer k = scanner.nextInt();
            List<Integer> sortList = list.stream().sorted(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            }).collect(Collectors.toList());
            System.out.println(sortList.get(k-1));
        }
    }
}
