package com.milearn.springbootlayui.service;

import com.milearn.springbootlayui.vo.BarVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Resource
    private ProductService productService;

    @Test
    void findData() {
        //productService.findData(page, limit);
    }

    @Test
    void test() {
        BarVo barVo = productService.getBarVo();
        int i = 0;
    }

}