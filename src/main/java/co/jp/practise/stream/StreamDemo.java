package co.jp.practise.stream;

import co.jp.practise.bo.Sku;
import co.jp.practise.domian.CartService;
import co.jp.practise.enums.SkuCategoryEnum;
import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        StreamDemo.cardHandler();
    }

    public static void cardHandler() {
        // 定义，原子引用类，可以保证多线程安全，防止多线程技术冲突
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));
        List<String> skuNameList = CartService.getSkuList()
                // 1.建立Stream流
                .stream()
                // 2.打印所有商品
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                // 3.筛选非图书
                .filter(sku -> !sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS))
                // 4.按照价格排序，从大到小(默认从小到大，所以这里 reversed)
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                // 5.取出前两条
                .limit(2)
                // 6.累加商品总金额
                .peek(sku -> {
                    money.set(money.get() + sku.getTotalPrice());
                })
                // 7.取出商品名称集合
                .map(sku -> sku.getSkuName())
                // 8.收集结果
                .collect(Collectors.toList());
        System.out.println("商品总价:" + money.get());
        System.out.println("商品名称为：" + JSON.toJSONString(skuNameList, true));
    }
}
