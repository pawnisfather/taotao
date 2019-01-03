package com.taotao.fastdfs;

import com.taotao.controller.FastDFSClient;

/**
 * @author apple
 * @version V1.0
 * @className Test
 * @Description
 * @date 2019/1/2 下午3:16
 */

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        FastDFSClient fastDFSClient = new FastDFSClient();
        String s = fastDFSClient.uploadFile("/Users/zl/Downloads/b1f5d381cc5311068b1aadcfe59d49b3.jpg");
        System.out.println(s);

    }
}
