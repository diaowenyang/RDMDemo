package co.jp.practise.lambda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件服务类
 */
public class FileService {
    /**
     * 根据url获取文件，打印文件内容
     */
    public void print(String url, FileConsumer fileConsumer) throws IOException {

        //流读取
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(url)));

        //定义行变量和内容sb
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();

        //循环读取文件内容
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }

        //调用函数式接口方法，将文件内容传递给lambda表达式
        fileConsumer.fileHandler(stringBuilder.toString());

    }
}
