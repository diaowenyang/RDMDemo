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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        File file = new File("/Users/wen/Pictures/文档/after_JP_LANGUAGE.txt");
        String content;
        if (!file.exists()) {
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        File newFile = new File("/Users/wen/Pictures/文档/new_after_JP_LANGUAGE.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8"));
        Set<String> existSet = Sets.newHashSet();
        // Queue<String> fifo = EvictingQueue.create(20);
        while (StringUtils.isNotBlank(content = bufferedReader.readLine())) {
            // 如果后缀有 downloading 也不输出
            if (content.trim().endsWith("downloading")) {
                continue;
            }
            // 如果不包含中文，也不输出
            if (!isContainChinese(content)) {
                continue;
            }
            String[] strIng = content.trim().split("\\.");
            if (strIng.length >= 2) {
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

    private static boolean isContainChinese(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Pattern p = Pattern.compile("[\u4E00-\u9FA5|\\！|\\，|\\。|\\（|\\）|\\《|\\》|\\“|\\”|\\？|\\：|\\；|\\【|\\】]");
        Matcher m = p.matcher(str);
        return m.find();
    }
}
