package com.alaili.springbootlearnstuff.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    void test() {
        this.testIdInfo();
    }

    void selectAll(){
        productMapper.selectList(null).forEach(System.out::println);
    }

    void testIdInfo() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", 733);
        System.out.println(productMapper.selectOne(wrapper));
    }
}