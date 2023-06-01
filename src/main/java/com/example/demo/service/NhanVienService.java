package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import com.example.demo.model.request.CreateNhanVienRequest;
import com.example.demo.model.response.NhanVienResponse;
import jakarta.validation.Valid;

import java.util.List;

/**
 * @author thangncph26123
 */
public interface NhanVienService {

    List<NhanVien> getAll();

    List<NhanVienResponse> getAllCustomNhanVien();

    NhanVien create(@Valid CreateNhanVienRequest createNhanVienRequest);
}
