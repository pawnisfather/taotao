import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author apple
 * @version V1.0
 * @className TestLog
 * @Description
 * @date 2018/12/21 下午3:01
 */

public class TestLog {
    private static Logger logger = LoggerFactory.getLogger(TestLog.class.getName());


    public static void main(String[] args) {
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");

    }
}
