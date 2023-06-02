package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.model.request.CreateNhanVienRequest;
import com.example.demo.model.request.FindNhanVienRequest;
import com.example.demo.model.response.NhanVienResponse;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author thangncph26123
 */
@RestController
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/nhan-vien")
    public List<NhanVien> getAll() {
        return nhanVienService.getAll();
    }

    @GetMapping("/nhan-vien-custom")
//    @PostMapping thêm
//    @PutMapping sửa
//    @DeleteMapping xóa
    public ResponseEntity getAllNhanVien() {
        return new ResponseEntity(nhanVienService.getAllCustomNhanVien(), HttpStatus.OK);
    }

    // thêm
    @PostMapping("/nhan-vien/create")
    public ResponseEntity create(@RequestBody CreateNhanVienRequest createNhanVienRequest) {
        return new ResponseEntity(nhanVienService.create(createNhanVienRequest), HttpStatus.CREATED);
    }

    // số lượng phần tử trong 1 trang: size

    // trang hiện tại: pageNo

    // về nhà làm chức năng getAll tất cả các trường, getAll 1 vài trường, thêm mới 1 bản ghi

    @GetMapping("/nhan-vien/search")
    public ResponseEntity search(FindNhanVienRequest request) {
        return new ResponseEntity(nhanVienService.search(request), HttpStatus.OK);
    }
}
