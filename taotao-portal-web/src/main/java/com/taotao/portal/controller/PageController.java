package com.taotao.portal.controller;

import com.taotao.centent.service.ContentService;
import com.taotao.pojo.TbContent;
import com.taotao.portal.pojo.Ad1Node;
import com.taotao.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示首页
 * @title PageController.java
 * <p>description</p>
 * <p>company: www.itheima.com</p>
 * @author ljh 
 * @version 1.0
 */
@Controller
public class PageController {

	@Autowired
	private ContentService contentService;

	@Value("${AD_CATGORY_ID}")
    Long adCatgoryId;

    @Value("${AD_winth}")
    String adWinth;

    @Value("${AD_winthb}")
    String adWinthB;
	
	
	/**
	 * 展示首页
	 * @return
	 */
//    private String srcB;//pic2
//    private String height;
//    private String alt;//subtitle中获取
//    private String width;
//    private String src;//pic
//    private String widthB;
//    private String href;//url
//    private String heightB;

	//接收URL的请求http://localhost:8082/index.html
	@RequestMapping("/index")
	public String showIndex(Model model){
        List<TbContent> contentByCatId = contentService.getContentByCatId(adCatgoryId);
        List<Ad1Node> ad1Nodes = new ArrayList<>();

        for (TbContent tbContent : contentByCatId){
            Ad1Node ad1Node = new Ad1Node();
            ad1Node.setAlt(tbContent.getSubTitle());
            ad1Node.setSrc(tbContent.getPic());
            ad1Node.setSrcB(tbContent.getPic2());
            ad1Node.setHeight("240");
            ad1Node.setHeightB("240");
            ad1Node.setHref(tbContent.getUrl());
            ad1Node.setWidth(adWinth);
            ad1Node.setWidthB(adWinthB);
            ad1Nodes.add(ad1Node);

        }
        model.addAttribute("ad1", JsonUtils.objectToJson(ad1Nodes));

        return "index";//响应jsp
	}
}
