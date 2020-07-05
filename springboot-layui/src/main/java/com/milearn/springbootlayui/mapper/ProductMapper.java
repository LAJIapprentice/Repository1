package com.milearn.springbootlayui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.milearn.springbootlayui.entity.Product;
import com.milearn.springbootlayui.vo.ProductBarVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {

    @Select("SELECT p.`name`,SUM(quantity) count FROM order_detail od,product p WHERE od.product_id = p.id GROUP BY product_id;")
    List<ProductBarVo> findAllProductBarVo();

}
