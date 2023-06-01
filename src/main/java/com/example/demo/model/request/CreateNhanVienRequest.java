package com.example.demo.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;


/**
 * @author thangncph26123
 */
@Getter
@Setter
public class CreateNhanVienRequest {

    @NotEmpty
    @Length(max = 20)
    private String ma;

    @NotEmpty
    @Length(max = 30)
    private String ten;

    @NotNull
    private String ngaySinh;

    @NotEmpty
    @Length(max = 30)
    private String sdt;

    private UUID idCH;
}
