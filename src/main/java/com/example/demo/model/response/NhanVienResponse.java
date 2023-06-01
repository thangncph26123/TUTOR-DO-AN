package com.example.demo.model.response;

import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

/**
 * @author thangncph26123
 */
public interface NhanVienResponse {

    @Value("#{target.id_nhan_vien}")
    UUID getId();

    @Value("#{target.ten_nhan_vien}")
    String getTenNhanVien();

    @Value("#{target.ten_cua_hang}")
    String getTenCuaHang();
}