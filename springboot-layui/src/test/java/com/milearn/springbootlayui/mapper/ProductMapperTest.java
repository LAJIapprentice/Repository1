package com.milearn.springbootlayui.mapper;

import com.milearn.springbootlayui.vo.ProductBarVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ProductMapperTest {

    @Resource
    private ProductMapper mapper;

    @Test
    void test () {
        mapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void test2() {
        List<ProductBarVo> list = mapper.findAllProductBarVo();
    }
}