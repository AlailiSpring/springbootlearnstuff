package com.alaili.springbootlearnstuff.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2020-12-04 17:39
 */
@Data
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = -1950550197069559155L;

    private Integer id;

    private String name;
}
