package com.taotao.service.Impl;

import com.taotao.mapper.TestMapper;
import com.taotao.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author apple
 * @version V1.0
 * @className ServiceImpl
 * @Description
 * @date 2018/12/20 下午3:32
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    /**
     * 测试查询时间
     * @return
     */
    @Override
    public String queryNow() {
        return testMapper.queryNow();
    }
}
