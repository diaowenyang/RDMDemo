package co.jp.practise.lambda;

import java.io.IOException;
import java.util.function.Consumer;

public class Demo {
    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();
        fileService.print("/Users/wen/Movies/告别996，开启Java高效编程之门/目录.txt",
                fileContent -> {
                    System.out.println(fileContent);
                });
    }

    public void test1() {
        // 方法引用的语法格式     目标引用::方法名
        // 1.指向静态方法的方法引用
        Consumer<String> c1 = (String number) -> Integer.parseInt(number);
        Consumer<String> c2 = Integer::parseInt;
        // 2.指向任意类型实例方法的方法引用
        Consumer<String> c3 = (String str) -> str.length();
        Consumer<String> c4 = String::length;
        // 3.指向现有对象的实例方法的方法引用
        StringBuilder sbi = new StringBuilder();
        Consumer<String> c5 = (String str) -> sbi.append(str);
        Consumer<String> c6 = sbi::append;
    }
}
