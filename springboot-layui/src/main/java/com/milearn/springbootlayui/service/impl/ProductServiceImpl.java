package com.milearn.springbootlayui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.milearn.springbootlayui.entity.Product;
import com.milearn.springbootlayui.entity.ProductCategory;
import com.milearn.springbootlayui.mapper.ProductCategoryMapper;
import com.milearn.springbootlayui.mapper.ProductMapper;
import com.milearn.springbootlayui.service.ProductService;
import com.milearn.springbootlayui.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public DataVo<ProductVo> findData(Integer page,Integer limit) {
        DataVo dataVo = new DataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");
//        Integer count = productMapper.selectCount(null);
//        dataVo.setCount(count);

        //分页
        IPage<Product> productIPage = new Page<>(page,limit);
        IPage<Product> result = productMapper.selectPage(productIPage, null);
        dataVo.setCount(result.getTotal());
        List<Product> productList = result.getRecords();

        //List<Product> productList = productMapper.selectList(null);
        List<ProductVo> productVoList = new ArrayList<>();

        for (Product product : productList) {
            ProductVo productVo = new ProductVo();
            BeanUtils.copyProperties(product,productVo);

            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveloneId());
            //productVo.setCategorylevelone(productCategoryMapper.selectOne(wrapper).getName());
            ProductCategory productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null) {
                productVo.setCategorylevelone(productCategory.getName());
            }

            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveltwoId());
            //productVo.setCategoryleveltwo(productCategoryMapper.selectOne(wrapper).getName());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null) {
                productVo.setCategoryleveltwo(productCategory.getName());
            }

            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategorylevelthreeId());
            //productVo.setCategorylevelthree(productCategoryMapper.selectOne(wrapper).getName());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null) {
                productVo.setCategorylevelthree(productCategory.getName());
            }

            productVoList.add(productVo);
        }
        dataVo.setData(productVoList);
        return dataVo;
    }

    //将productBarVo封装为BarVo
    @Override
    public BarVo getBarVo() {

        List<ProductBarVo> list = productMapper.findAllProductBarVo();
        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for (ProductBarVo productBarVo : list) {
            names.add(productBarVo.getName());
            values.add(productBarVo.getCount());
        }

        BarVo barVo =  new BarVo();
        barVo.setNames(names);
        barVo.setValues(values);

        return barVo;
    }

    @Override
    public List<PieVo> getPieVo() {

        List<ProductBarVo> list = productMapper.findAllProductBarVo();
        List<PieVo> pieVoList = list.stream()
                .map(e -> new PieVo(
                        e.getCount(),
                        e.getName()
                )).collect(Collectors.toList());
        return pieVoList;
    }

}
