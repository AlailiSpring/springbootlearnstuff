package com.alaili.springbootlearnstuff.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author Alaili Lee
 * @Date 2020/9/6 21:32
 * @Details:
 */
@Data
public class FilePropVo implements Serializable {

    private static final long serialVersionUID = -8357720660037255137L;

    private String filePath;

    private String fileName;
}
