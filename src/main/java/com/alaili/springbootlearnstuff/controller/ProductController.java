package com.alaili.springbootlearnstuff.controller;

import com.alaili.springbootlearnstuff.service.ProductService;
import com.alaili.springbootlearnstuff.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2020-12-16 23:59
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(Integer page,Integer limit) {
        return productService.selectAllData(page,limit);
    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        return url;
    }
}
