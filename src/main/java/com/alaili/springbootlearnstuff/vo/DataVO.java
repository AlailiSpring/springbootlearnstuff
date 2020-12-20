package com.alaili.springbootlearnstuff.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2020-12-16 23:12
 */
@Data
public class DataVO<T> implements Serializable {
    private static final long serialVersionUID = 948108404840812341L;
    private String code;
    private String msg;
    private Integer count;
    private List<T> data;
}
