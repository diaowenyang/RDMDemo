package co.jp.practise.business;

import co.jp.practise.utils.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.UnknownHostException;

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

}
