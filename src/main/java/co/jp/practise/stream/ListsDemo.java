package co.jp.practise.stream;

import com.google.common.collect.Lists;

import java.util.List;

public class ListsDemo {

    public static void main(String[] args) {
        List list1 = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List list2 = Lists.newArrayList(3, 4, 6);
        // 按指定个数分组
        List<List<Integer>> partitionList = Lists.partition(list1, 3);
        partitionList.stream().forEach(System.out::println);
        System.out.println("------");
        // 集合顺序反转
        List<Integer> reverseList = Lists.reverse(list1);
        reverseList.stream().forEach(System.out::println);
        System.out.println("------");
    }
}
