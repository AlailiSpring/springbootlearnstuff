package com.alaili.springbootlearnstuff.service;

import com.alaili.springbootlearnstuff.vo.DataVO;
import com.alaili.springbootlearnstuff.vo.ProductVO;

public interface ProductService {
    DataVO<ProductVO> selectAllData();
}
