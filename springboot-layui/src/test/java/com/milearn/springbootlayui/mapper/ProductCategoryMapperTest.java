package com.milearn.springbootlayui.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryMapperTest {

    @Resource
    private ProductCategoryMapper mapper;

    @Test
    void test() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", 655);
        System.out.println(mapper.selectOne(wrapper));
    }
}