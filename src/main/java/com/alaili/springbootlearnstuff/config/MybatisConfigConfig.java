package com.alaili.springbootlearnstuff.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 加入支持mybatis的分页配置类
 * @Author: LiBaoDeng
 * @Date: 2020-12-20 22:46
 */
@Configuration
public class MybatisConfigConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
