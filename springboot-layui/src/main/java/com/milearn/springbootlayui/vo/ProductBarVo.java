package com.milearn.springbootlayui.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductBarVo {

    private String name;

    //@JsonProperty("value")
    private Integer count;

}
