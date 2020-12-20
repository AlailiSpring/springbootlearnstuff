package com.alaili.springbootlearnstuff.service;

import com.alaili.springbootlearnstuff.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    void selectAllData() {
        DataVO dataVo = service.selectAllData();
        int i=0;
    }
}