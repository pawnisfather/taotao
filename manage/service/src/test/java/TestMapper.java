import com.taotao.pojo.TbItemParam1;
import com.taotao.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className TestMapper
 * @Description
 * @date 2019/1/4 上午12:40
 */
@Service
public class TestMapper {
    @Autowired
    private TestService testService;


    @Test
    public void test1(){
        String s = testService.queryNow();
        System.out.println(s);
    }


}
