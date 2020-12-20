package com.alaili.springbootlearnstuff.controller;

import com.alaili.springbootlearnstuff.service.ProductService;
import com.alaili.springbootlearnstuff.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2020-12-16 23:59
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/list")
    public DataVO list() {
        return productService.selectAllData();
    }
}
