package com.alaili.springbootlearnstuff.service.impl;

import com.alaili.springbootlearnstuff.entity.Product;
import com.alaili.springbootlearnstuff.entity.ProductCategory;
import com.alaili.springbootlearnstuff.mapper.ProductCategoryMapper;
import com.alaili.springbootlearnstuff.mapper.ProductMapper;
import com.alaili.springbootlearnstuff.service.ProductService;
import com.alaili.springbootlearnstuff.vo.DataVO;
import com.alaili.springbootlearnstuff.vo.ProductVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2020-12-16 23:28
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public DataVO<ProductVO> selectAllData(Integer page,Integer limit) {
        DataVO dataVO = new DataVO();
        int count = productMapper.selectCount(null);
        dataVO.setCode("0");
        //dataVO.setCount(count);
        dataVO.setMsg("");

        IPage<Product> productIPage = new Page<>(page, limit);
        IPage<Product> result = productMapper.selectPage(productIPage, null);
        dataVO.setCount(result.getTotal());

        List<Product> productList = result.getRecords();
        List<ProductVO> dataList = new ArrayList<>();
        for (Product product : productList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product, productVO);
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", product.getCategoryleveloneId());
            ProductCategory productCategory = productCategoryMapper.selectOne(queryWrapper);
            if (productCategory != null) {
                productVO.setCategorylevelone(productCategory.getName());
            }
            queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", product.getCategoryleveltwoId());
            productCategory = productCategoryMapper.selectOne(queryWrapper);
            if (productCategory != null) {
                productVO.setCategoryleveltwo(productCategory.getName());

            }
            queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", product.getCategorylevelthreeId());
            productCategory = productCategoryMapper.selectOne(queryWrapper);
            if (productCategory != null) {
                productVO.setCategorylevelthree(productCategory.getName());

            }
            dataList.add(productVO);
        }

        dataVO.setData(dataList);
        return dataVO;
    }
}
