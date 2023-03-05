package co.jp.practise.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sku {
    private Integer skuId;      //商品编号
    private String skuName;     //商品名称
    private Double skuPrice;    //商品单价
    private Integer totalNum;   //商品个数
    private Double totalPrice;  //商品总价
    private Enum skuCategory;   //枚举类型 商品类型
}