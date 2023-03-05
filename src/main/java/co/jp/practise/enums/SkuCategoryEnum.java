package co.jp.practise.enums;

public enum SkuCategoryEnum {
    CLOTHING(10, "服装类"),
    ELECTRONICS(20, "电子类"),
    SPROTS(30, "运动类"),
    BOOKS(40, "图书类");

    private final Integer code;//码值
    private final String name;//名称

    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
