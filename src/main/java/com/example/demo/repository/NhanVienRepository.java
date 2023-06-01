package com.example.demo.repository;

import com.example.demo.entity.NhanVien;
import com.example.demo.model.response.NhanVienResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author thangncph26123
 */
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    @Query(value = """
            SELECT a.id as id_nhan_vien, a.ten as ten_nhan_vien, b.ten as ten_cua_hang FROM NhanVien a Join CuaHang b ON a.idCH = b.id
            """, nativeQuery = true)
    List<NhanVienResponse> getAllNhanVien();
}
