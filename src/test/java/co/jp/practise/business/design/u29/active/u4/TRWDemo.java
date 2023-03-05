package co.jp.practise.business.design.u29.active.u4;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TRWDemo {

    /**
     * 把一个文件拷贝到另一个文件 BeforeJDK7Demo
     */
    @Test
    public void copyBeforeJDK7DemoTest() {
        String fileInputStreamUrl = "/Users/wen/Movies/告别996，开启Java高效编程之门/目录.txt";
        String fileOutputStreamUrl = "/Users/wen/Movies/告别996，开启Java高效编程之门/目录1.txt";
        // 1.创建输入输出流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(fileInputStreamUrl);
            fileOutputStream = new FileOutputStream(fileOutputStreamUrl);
            // 读取字节的信息
            int content;
            // 2.把目标文件的内容循环输出到对象文件
            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3.关闭文件流，先关闭输出，再关闭输入
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 把一个文件拷贝到另一个文件 BeforeJDK7Demo
     */
    @Test
    public void copyAfterJDK7DemoTest() {
        String fileInputStreamUrl = "/Users/wen/Movies/告别996，开启Java高效编程之门/目录.txt";
        String fileOutputStreamUrl = "/Users/wen/Movies/告别996，开启Java高效编程之门/目录1.txt";
        // 1.创建输入输出流
        try (FileInputStream fileInputStream = new FileInputStream(fileInputStreamUrl);
             FileOutputStream fileOutputStream = new FileOutputStream(fileOutputStreamUrl);
        ) {
            // 读取字节的信息
            int content;
            // 2.把目标文件的内容循环输出到对象文件
            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

















