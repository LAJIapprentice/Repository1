package com.milearn.springbootlayui.controller;

import com.milearn.springbootlayui.service.ProductService;
import com.milearn.springbootlayui.vo.BarVo;
import com.milearn.springbootlayui.vo.DataVo;
import com.milearn.springbootlayui.vo.PieVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping("/list")
    @ResponseBody
    public DataVo list(Integer page,Integer limit) {
        return productService.findData(page, limit);
    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        return url;
    }

    @RequestMapping("/barVo")
    @ResponseBody
    public BarVo getBarVo() {
        return productService.getBarVo();
    }


    @RequestMapping("/pieVo")
    @ResponseBody
    public List<PieVo> getPieVo() {
        return productService.getPieVo();
    }

}
