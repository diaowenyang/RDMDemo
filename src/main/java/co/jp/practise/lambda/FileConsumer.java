package co.jp.practise.lambda;

/**
 * 接口中只有一个抽象方法，可以应用lambda表达式
 * <p>
 * 加入注解
 * <p>
 * 文件处理函数式接口
 */
@FunctionalInterface
public interface FileConsumer {

    /**
     * 函数式接口抽象方法
     *
     * @param fileContent
     */
    void fileHandler(String fileContent);
}
