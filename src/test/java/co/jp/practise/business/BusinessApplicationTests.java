package co.jp.practise.business;

import co.jp.practise.utils.IdGenerator;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.util.Set;

@SpringBootTest
class BusinessApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws UnknownHostException {
        System.out.println("-------------");
        System.out.println(IdGenerator.generate());

    }


    // /Users/wen/Pictures/g_dirFile_copy_1_1.txt
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/wen/Pictures/G_pan/NOT_IT.txt");
        String content;
        if (!file.exists()) {
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        File newFile = new File("/Users/wen/Pictures/G_pan/after_NOT_IT.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8"));
        Set<String> existSet = Sets.newHashSet();
        // Queue<String> fifo = EvictingQueue.create(20);
        while (StringUtils.isNotBlank(content = bufferedReader.readLine())) {
            if (content.endsWith("downloading")) {
                continue;
            }
            String[] strIng = content.trim().split("\\.");
            if (strIng.length >= 2
//                    && (strIng[strIng.length - 1].equals("html")
//                    || strIng[strIng.length - 1].equals("pdf")
//                    || strIng[strIng.length - 1].equals("m4a")
//                    || strIng[strIng.length - 1].equals("mp3")
//                    || strIng[strIng.length - 1].equals("mp4"))
            ) {
                //int i = content.lastIndexOf(".");
                // 去掉文件后缀名的部分
                String filePartName = content.substring(0, content.lastIndexOf("."));
                if (existSet.contains(filePartName)) {
                    continue;
                }
                bufferedWriter.write(content);
                bufferedWriter.write("\n");
                existSet.add(filePartName);
            } else {
                bufferedWriter.write(content);
                bufferedWriter.write("\n");
            }
        }
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
        bufferedWriter.close();
    }
}
