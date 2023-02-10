package co.jp.practise.domian.idgenerator;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;


public class RandomIdGenerator implements LogTraceIdGenerator {

    @Override
    public String generate() {
        String substrOfHostName = getLastfieldOfHostName();
        String randomString = generateRandomAlphameric(8);
        return String.format("%s-%d-%s",
                substrOfHostName,
                System.currentTimeMillis(),
                randomString);
    }

    /**
     * 本机名的最后一个名称
     *
     * @return
     */
    private String getLastfieldOfHostName() {
        String substrOfHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            substrOfHostName = tokens[tokens.length - 1];
            return substrOfHostName;
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
        return substrOfHostName;
    }

    /**
     * 指定长度的 数字大小写字符字符串
     *
     * @param length
     * @return
     */
    private String generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }

}
