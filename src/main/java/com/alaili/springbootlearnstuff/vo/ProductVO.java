package com.alaili.springbootlearnstuff.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2020-12-16 17:32
 */
@Data
public class ProductVO implements Serializable {
    private static final long serialVersionUID = -8421236505849550088L;
    private Integer id;
    private String name;
    private String description;
    private Float price;
    private Integer stock;
    private String categorylevelone;
    private String categoryleveltwo;
    private String categorylevelthree;
    private String fileName;
}
