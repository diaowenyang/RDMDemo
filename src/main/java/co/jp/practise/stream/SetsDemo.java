package co.jp.practise.stream;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class SetsDemo {

    public static void main(String[] args) {
        Set set1 = Sets.newHashSet(1, 2, 3);
        Set set2 = Sets.newHashSet(3, 4, 6);
        // 取集合并集
        Set<Integer> unionSet = Sets.union(set1, set2);
        unionSet.stream().forEach(System.out::println);
        System.out.println("------");
        // 取集合交集
        Set<Integer> intersectionSet = Sets.intersection(set1, set2);
        intersectionSet.stream().forEach(System.out::println);
        System.out.println("------");
        // 取集合差集(注意前后顺序)
        Set<Integer> differenceSet = Sets.difference(set1, set2);
        // 属于set1，并且不属于set2
        differenceSet.stream().forEach(System.out::println);
        System.out.println("------");
        // 相对差集：属于A而且不属于B，或者属于B而且不属于A
        Set<Integer> symmetricDifferenceSet = Sets.symmetricDifference(set1, set2);
        // 属于A而且不属于B，或者属于B而且不属于A
        symmetricDifferenceSet.stream().forEach(System.out::println);
        System.out.println("------");
        // 返回集合的所有可能子集的集合
        Set<Set<Integer>> powerSetSet = Sets.powerSet(set2);
        powerSetSet.stream().forEach(System.out::println);
        System.out.println("------");
        // 返回两个集合的笛卡尔积
        Set<List<Integer>> cartesianProductSet = Sets.cartesianProduct(set1, set2);
        cartesianProductSet.stream().forEach(System.out::println);
    }
}
