package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.model.request.CreateNhanVienRequest;
import com.example.demo.model.response.NhanVienResponse;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author thangncph26123
 */
@Service
@Validated
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public List<NhanVienResponse> getAllCustomNhanVien() {
        return nhanVienRepository.getAllNhanVien();
    }

    @Override
    public NhanVien create(@Valid CreateNhanVienRequest request) {
        String ngaySinhStr = request.getNgaySinh();
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinhStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NhanVien nhanVien = NhanVien.builder()
                .ma(request.getMa())
                .ten(request.getTen())
                .ngaySinh(date)
                .sdt(request.getSdt())
                .cuaHang(cuaHangRepository.findById(request.getIdCH()).get())
                .build();
        return nhanVienRepository.save(nhanVien);
    }
}
