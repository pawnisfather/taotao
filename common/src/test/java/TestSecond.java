import org.junit.Test;

import java.util.Random;

/**
 * @author apple
 * @version V1.0
 * @className TestSecond
 * @Description
 * @date 2019/1/3 下午12:00
 */

public class TestSecond {
    @Test
    public void test() throws InterruptedException {
        while (true){
            long l = System.currentTimeMillis();
            long l1 = System.nanoTime();
            Random random = new Random();
            int i = random.nextInt(99);
            System.out.println(l+" "+i);
            Thread.currentThread().sleep(100);


        }

    }
}
