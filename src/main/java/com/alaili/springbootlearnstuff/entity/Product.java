package com.alaili.springbootlearnstuff.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2020-12-01 23:32
 */
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = -8378636561436458596L;
    private Integer id;
    private String name;
    private String description;
    private Float price;
    private Integer stock;
    private Integer categoryleveloneId;
    private Integer categoryleveltwoId;
    private Integer categorylevelthreeId;
    private String fileName;
}
