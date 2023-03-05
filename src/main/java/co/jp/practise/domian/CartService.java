package co.jp.practise.domian;

import co.jp.practise.bo.Sku;
import co.jp.practise.enums.SkuCategoryEnum;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    /**
     * 匿名内部类，有内存泄漏的风险，不在生产项目中引用，只是为了后边引用出来lambda表达式
     */
    private static final List<Sku> skuList = new ArrayList<Sku>() {
        {
            add(new Sku(2020001, "无人机", 999.00, 1, 999.11, SkuCategoryEnum.ELECTRONICS));
            add(new Sku(2020002, "T-shirt", 50.00, 2, 100.22, SkuCategoryEnum.CLOTHING));
            add(new Sku(2020003, "人生的枷锁", 30.00, 1, 30.33, SkuCategoryEnum.BOOKS));
            add(new Sku(2020004, "老人与海", 20.00, 1, 20.44, SkuCategoryEnum.BOOKS));
            add(new Sku(2020005, "剑指高效编程", 288.00, 1, 288.55, SkuCategoryEnum.BOOKS));
            add(new Sku(2020006, "大头皮鞋", 300.00, 1, 300.66, SkuCategoryEnum.CLOTHING));
            add(new Sku(2020007, "杠铃", 2000.00, 1, 2000.77, SkuCategoryEnum.SPROTS));
            add(new Sku(2020008, "ThinkPad", 5000.00, 1, 5000.88, SkuCategoryEnum.ELECTRONICS));
        }

    };

    public static List<Sku> getSkuList() {
        return skuList;
    }

    /**
     * versionTestA
     * 找出购物车中所有电子产品
     * <p>
     * 注意for 循环
     * for (Sku sku: skuList) 的使用
     *
     * @return
     */
    public static List<Sku> getElectronicsSkuList(List<Sku> skuList) {
        List<Sku> lElectronicsList = new ArrayList<Sku>();
        for (Sku sku : skuList) {
            if (sku.getSkuCategory().equals(SkuCategoryEnum.ELECTRONICS)) {
                lElectronicsList.add(sku);
            }
        }

        return lElectronicsList;
    }


}
