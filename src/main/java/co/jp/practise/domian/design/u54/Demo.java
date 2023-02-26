package co.jp.practise.domian.design.u54;

public class Demo {
    public static void main(String[] args) {
        Integer i1 = 56;
        Integer i2 = 56;
        Integer i3 = 129;
        Integer i4 = 129;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);

        String s1 = "哈哈哈";
        String s2 = "哈哈哈";
        String s3 = "哈哈哈";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
