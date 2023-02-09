package co.jp.practise.utils;


import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

@Slf4j
public class IdGenerator {
    public static String generate() throws UnknownHostException {
        String id = "";
        // 本地机的域名和IP地址
        String hostName = InetAddress.getLocalHost().getHostName();
        String[] tokens = hostName.split("\\.");
        if (tokens.length > 0) {
            hostName = tokens[tokens.length - 1];
        }
        char[] randomChars = new char[8];
        int count = 0;
        Random random = new Random();
        while (count < 8) {
            int randomAscii = random.nextInt(122);
            // 0 - 9
            if (randomAscii >= 48 && randomAscii <= 57) {
                randomChars[count] = (char) ('0' + (randomAscii - 48));
                count++;
                // A - Z
            } else if (randomAscii >= 65 && randomAscii <= 90) {
                randomChars[count] = (char) ('A' + (randomAscii - 65));
                count++;
                // a - z
            } else if (randomAscii >= 97 && randomAscii <= 122) {
                randomChars[count] = (char) ('a' + (randomAscii - 97));
                count++;
            }
        }
        // id生成的规则： 本机名的最后一个字段-当前时间戳-8位的随机字符串
        id = String.format("%s-%d-%s", hostName, System.currentTimeMillis(), new String(randomChars));
        return id;
    }
}
