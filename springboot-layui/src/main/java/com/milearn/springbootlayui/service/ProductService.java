package com.milearn.springbootlayui.service;


import com.milearn.springbootlayui.vo.BarVo;
import com.milearn.springbootlayui.vo.DataVo;
import com.milearn.springbootlayui.vo.PieVo;
import com.milearn.springbootlayui.vo.ProductVo;

import java.util.List;

public interface ProductService {

    DataVo<ProductVo> findData(Integer page,Integer limit);
    BarVo getBarVo();

    List<PieVo> getPieVo();

}
