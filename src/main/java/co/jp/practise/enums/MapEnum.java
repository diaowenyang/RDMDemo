package co.jp.practise.enums;

public enum MapEnum {
    A("a"),
    B("b"),
    C("c");

    private final String code;

    MapEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
