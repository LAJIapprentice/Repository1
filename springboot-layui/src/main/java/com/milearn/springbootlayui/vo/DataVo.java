package com.milearn.springbootlayui.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class DataVo<T> {

    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;

}
