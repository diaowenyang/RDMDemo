package co.jp.practise.business;

import co.jp.practise.bo.Sku;
import co.jp.practise.domian.CartService;
import co.jp.practise.enums.SkuCategoryEnum;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
//@SpringBootTest
public class StreamOperator {
    private List<Sku> list;

    @Before
    public void init() {
        list = CartService.getSkuList();
    }

    @Test
    public void filterTest() {
        System.out.println("----"+JSON.toJSONString(list));
        list.stream()
                .filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }
}




















