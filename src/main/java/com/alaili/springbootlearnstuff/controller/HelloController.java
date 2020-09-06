package com.alaili.springbootlearnstuff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author Alaili Lee
 * @Date 2020/9/6 20:29
 * @Details:
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public  String  hello(){
        return System.getProperty("user.dir")+java.io.File.separator+"tmp";
    }

    @RequestMapping("/download")
    public void download() {

    }
}
