package co.jp.practise.stream;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapsDemo {
    public static void main(String[] args) {
        // 返回一个活动的map, 键值为给定的set中的值, value为通过给定Function计算后的值
        Map map1 = Maps.asMap(
                new HashSet<Object>() {{
                    add("a");
                    add("b");
                }},
                (x) -> x.hashCode()
        );

        // 返回两个给定map之间的差异
        MapDifference mapDifference1 = Maps.difference(
                new HashMap<String, String>() {{
                    put("a", "a");
                    put("b", "1");
                    put("c", "c");
                }},
                new HashMap<String, String>() {{
                    put("a", "a");
                    put("b", "2");
                    put("d", "d");
                }}
        );
        System.out.println(mapDifference1.entriesDiffering().entrySet());  // 输出: [b=(1, 2)]
        System.out.println(mapDifference1.entriesInCommon().entrySet());  // 输出: [a=a]
        System.out.println(mapDifference1.entriesOnlyOnLeft().entrySet());  // 输出: [c=c]
        System.out.println(mapDifference1.entriesOnlyOnRight().entrySet());  // 输出: [d=d]

        // 返回给定Map中的Entry值通过给定Predicate过滤后的map映射
        Map filterEntriesMap1 = Maps.filterEntries(
                new HashMap<String, String>() {{
                    put("a", "1");
                    put("b", "2");
                    put("c", "3");
                }},
                (x) -> x.getKey().hashCode() >= "b".hashCode() && x.getValue().hashCode() > "2".hashCode()
        );
        System.out.println(filterEntriesMap1.entrySet());  // 输出: [c=3]

        // 返回给定Map中的Key值通过给定Predicate过滤后的map映射
        Map filterKeysmap1 = Maps.filterKeys(
                new HashMap<String, String>() {{
                    put("a", "1");
                    put("b", "2");
                    put("c", "3");
                }},
                (x) -> x.hashCode() >= "b".hashCode()
        );
        System.out.println(filterKeysmap1.entrySet());  // 输出: [b=2, c=3]

        // 返回给定Map中的Value值通过给定Predicate过滤后的map映射
        Map filterValuesmap1 = Maps.filterValues(
                new HashMap<String, String>() {{
                    put("a", "1");
                    put("b", "2");
                    put("c", "3");
                }},
                (x) -> x.hashCode() >= "3".hashCode()
        );
        System.out.println(filterValuesmap1.entrySet());  // 输出: [c=3]

        // 返回一个Map映射, 其Entry为给定fromMap.Entry通过给定EntryTransformer转换后的值
        Map transformEntriesmap1 = Maps.transformEntries(
                new HashMap<String, String>() {{
                    put("a", "1");
                    put("b", "2");
                    put("c", "3");
                }},
                (Maps.EntryTransformer<String, String, Object>) (key, value) -> key.toUpperCase()
        );
        System.out.println(transformEntriesmap1.entrySet());  // 输出: [a=A, b=B, c=C]

        // 返回一个Map映射, 其value为给定Map中value通过Function转换后的值
        Map transformValuesmap1 = Maps.transformValues(
                new HashMap<String, Integer>() {{
                    put("a", 1);
                    put("b", 2);
                    put("c", 3);
                }},
                (x) -> x + 10
        );
        System.out.println(transformValuesmap1.entrySet());  // 输出: [a=11, b=12, c=13]

        // toMap()有(Iterable, Function)与(Iterator, Function)两种参数类型
        // 返回一个不可变的ImmutableMap实例, 其键值为给定keys中去除重复值后的值, 其值为键被计算了Function后的值
        ImmutableMap immutableMap1 = Maps.toMap(
                new ArrayList<Object>() {{
                    add("a");
                    add("b");
                    add("b");
                    add("c");
                }},
                (x) -> x.hashCode()
        );
        System.out.println(immutableMap1.entrySet());  // 输出: [a=97, b=98, c=99]
    }
}
