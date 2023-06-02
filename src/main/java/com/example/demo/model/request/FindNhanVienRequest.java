package com.example.demo.model.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author thangncph26123
 */
@Getter
@Setter
public class FindNhanVienRequest {

    private String ma;

    private String ten;

    private String sdt;

    private Integer page;
}
