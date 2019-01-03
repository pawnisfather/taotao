package com.taotao.controller;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import com.taotao.util.EasyUIDataGridResult;
import com.taotao.util.JsonUtils;
import com.taotao.util.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @version V1.0
 * @className ItemController
 * @Description
 * @date 2018/12/23 下午11:37
 */

@Controller
public class ItemController {

    @Value("${TAOTAO_IMAGE_SERVER_URL}")
    private String TAOTAO_IMAGE_SERVER_URL;



    @Autowired
    private ItemService itemService;


    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getAllList(Integer page,Integer rows){
//        1.引入服务
//        2。注入服务
//        3.调用服务的方法

        return itemService.getItemList(page,rows);

    }

    @RequestMapping(value="/pic/upload",produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    //就需要将字符串转成jONS 格式的字符串就可以了
    public String uploadImage(MultipartFile uploadFile){
        try {
            // 1.获取元文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            // 2.获取文件的字节数组
            byte[] bytes = uploadFile.getBytes();
            // 3.通过fastdfsclient的方法上传图片（参数要求有 字节数组 和扩展名 不包含"."）
            FastDFSClient client = new FastDFSClient("classpath:properties/client.conf");
            // 返回值：group1/M00/00/00/wKgZhVk4vDqAaJ9jAA1rIuRd3Es177.jpg
            String string = client.uploadFile(bytes, extName);
            //拼接成完整的URL
            //"http://192.168.25.133/"
            String path = 	TAOTAO_IMAGE_SERVER_URL+string;
            // 4.成功时，设置map
            Map<String, Object> map = new HashMap<>();
            map.put("error", 0);
            map.put("url", path);
            // 6.返回map
            return JsonUtils.objectToJson(map);
        } catch (Exception e) {
            // 5.失败时，设置map
            Map<String, Object> map = new HashMap<>();
            map.put("error", 1);
            map.put("message", "上传失败");
            return JsonUtils.objectToJson(map);
        }
    }

    @RequestMapping(value="/item/save", method=RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem item, String desc) {
        TaotaoResult result = itemService.createItem(item, desc);
        return result;
    }

}
