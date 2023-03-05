package co.jp.practise.stream;

import co.jp.practise.bo.Sku;
import co.jp.practise.domian.CartService;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.List;

public class ChangeAbleCollection {

    public static void main(String[] args) {
        changUnableGuava();
    }

    private static void changAble() {
        List<Sku> skuNameList = CartService.getSkuList();
        System.out.println(skuNameList.size());
        skuNameList.remove(0);
        System.out.println(skuNameList.size());
    }

    private static void changUnableJDK() {
        List<Sku> skuNameList = CartService.getSkuList();
        System.out.println(skuNameList.size());
        List<Sku> list2 = Collections.unmodifiableList(skuNameList);
        for (Sku sku : list2) {
            sku.setSkuPrice(1.0);
        }
        // list2.remove(0);
        System.out.println(JSON.toJSONString(list2, true));
    }

    private static void changUnableGuava() {
        List<Sku> skuNameList = CartService.getSkuList();
        System.out.println(skuNameList.size());
        ImmutableSet<Sku> immutableSet = ImmutableSet.copyOf(skuNameList);
//        for (Sku sku:immutableSet) {
//            sku.setSkuPrice(1.0);
//        }
        immutableSet.remove(0);
        System.out.println(JSON.toJSONString(skuNameList, true));
    }

}
